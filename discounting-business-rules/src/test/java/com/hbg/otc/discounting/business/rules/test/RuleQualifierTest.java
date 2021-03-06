package com.hbg.otc.discounting.business.rules.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.hbg.otc.discounting.BaseTest;
import com.hbg.otc.discounting.model.OrderLine;
import com.hbg.otc.discounting.model.RulePrecedence;
import com.hbg.otc.discounting.model.RuleSetup;
import com.hbg.otc.discounting.model.StandardRuleSetup;
import com.hbg.otc.discounting.model.Terms;
import com.hbg.otc.discounting.util.factories.OrderFactory;
import com.hbg.otc.discounting.util.factories.RuleFactory;
import com.hbg.otc.discounting.util.factories.RulePrecedenceBuilder;
import com.hbg.otc.discounting.util.factories.StandardRuleFactory;

public class RuleQualifierTest extends BaseTest {

	public static void main(String[] args) {
		System.out.println( "Bootstrapping the Rule Engine ..." );

		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession =  kContainer.newKieSession();
		
		//List<RuleSetup> ruleSetupList = RuleFactory.getRuleSampleData();
		List<RuleSetup> ruleSetupList = RuleFactory.getRuleSampleData3();
		List<StandardRuleSetup> standardRuleSetupList = StandardRuleFactory.getRuleSampleData();

		//List<OrderLine> orderLineList = OrderFactory.getOrderSampleData().getOrderLines();
		List<OrderLine> orderLineList = OrderFactory.getOrderSampleData4().getOrderLines();

		List<RuleSetup> rulesQualified;
		List<StandardRuleSetup> standardRulesQualified;
		
		List<String> priorityList;
		Integer maxPriority = 0;
		Double totalDiscount = 0.0;
		String winnerRules = "";
		String terms = "";

		List<RulePrecedence> rulePrecedences = RulePrecedenceBuilder.loadRulePrecedence();
		for(RulePrecedence precedences : rulePrecedences) {
			kSession.insert(precedences);
		}
		kSession.insert(ruleSetupList);
		kSession.insert(standardRuleSetupList);

		for(RuleSetup setup : ruleSetupList) {
			kSession.insert(setup);
			kSession.insert(setup.getOffer());
		}

		for(StandardRuleSetup setup : standardRuleSetupList) {
			kSession.insert(setup);
		}

		//Generate Output
		System.out.println("---------------------------ORDER #1------------------------------");
		for(OrderLine orderLine :  orderLineList) {
			rulesQualified = new ArrayList<RuleSetup>();
			standardRulesQualified = new ArrayList<StandardRuleSetup>();
			
			priorityList = new ArrayList<String>();

			System.out.println("Order line: " + orderLine.getOrderLineId() + "\n");

			kSession.insert(orderLine);
			kSession.fireAllRules();
			
			//Rule Setup
			for(RuleSetup setup : ruleSetupList) {
				if(setup.getIsQualified()) {
					
					//logic for quantity combining rules
					if(!setup.getQtyDiscountMap().isEmpty()) {
						System.out.println(setup.getRuleName() + " qualified with discount: " + 
								getDiscountOnBasisOfQty(orderLine.getQuantity(), setup.getQtyDiscountMap()) + "%");
					} else {
						if(setup.getDiscount()!=null) {
							System.out.println(setup.getRuleName() + " qualified with discount: " + setup.getDiscount().getPercentage() + "%");
						}else {
							System.out.println(setup.getRuleName() + " qualified with discount: 0%");
						}
					}
					
					priorityList.add(setup.getWinningPriority());
					rulesQualified.add(setup);

					if(setup.getOffer()!=null && setup.getOffer().getPriority()!=null && setup.getOffer().getPriority() > maxPriority) {
						maxPriority = setup.getOffer().getPriority();
					}
				}

				setup.setIsQualified(false);
			}

			//Standard
			for(StandardRuleSetup setup : standardRuleSetupList) {
				if(setup.getIsQualified()) {

					//logic for quantity combining rules
					if(!setup.getQtyDiscountMap().isEmpty()) {
						System.out.println(setup.getRuleName() + " qualified with discount: " + 
								getDiscountOnBasisOfQty(orderLine.getQuantity(), setup.getQtyDiscountMap()) + "%");
					} 

					else {
						standardRulesQualified.add(setup);
						if(setup.getDiscount()!=null) {
							System.out.println(setup.getRuleName() + " qualified with discount: " + setup.getDiscount().getPercentage() + "%");
						}else {
							System.out.println(setup.getRuleName() + " qualified with discount: 0%");
						}

					}
				}

				setup.setIsQualified(false);
			}

			System.out.println("----------------------------------------------------------------------------");

			//sorted list on basis of rule number
			sortListOnBasisOfRule(rulesQualified);

			for(RuleSetup setup : rulesQualified) {

				//Display winner with combo field parameters excluded
				if(setup.getQtyDiscountMap().isEmpty() && setup.getOffer().getNewComboField() == null) {
					if(setup.getWinningPriority().equals("P1")) {
						System.out.println("Rule " + setup.getRuleNumber() + " wins with discount: " + setup.getDiscount().getPercentage() + "%");
						break;

					} else if(!priorityList.contains("P1") && setup.getWinningPriority().equals("P2")) {
						System.out.println("Rule " + setup.getRuleNumber() + " wins with discount: " + setup.getDiscount().getPercentage() + "%");
						break;

					} else if(setup.getOffer().getPriority() == maxPriority) {
						System.out.println("Rule " + setup.getRuleNumber() + " wins with discount: " + setup.getDiscount().getPercentage() + "%");
						break;
					} 
				} 

				//Display winner with combo field parameters included
				else if(setup.getIsWinner()) {
					if(setup.getDiscount()!=null) {
						totalDiscount = totalDiscount + setup.getDiscount().getPercentage();
						winnerRules = winnerRules + ", " + setup.getRuleNumber();
					}

					for(Terms term : setup.getOffer().getTerms()) {
						if(term.getDays() != 0) {
							terms = " and Term " + term.getDays() + " days from Rule " + setup.getRuleNumber();
						}
						if(term.getFreeFreight()) {
							terms = "\n" + terms + "\n having free freight from Rule " + setup.getRuleNumber();
						}
					}
				}

			}
			
			if(!winnerRules.isEmpty()) {
				System.out.println("Rule " + winnerRules.substring(2) + " wins with discount: " + totalDiscount + "%" + terms);
			}

			System.out.println("----------------------------------------------------------------------------");
		}
	}

	private static void sortListOnBasisOfRule(List<RuleSetup> rulesQualified) {
		Collections.sort(rulesQualified, new Comparator<RuleSetup>(){
			public int compare(RuleSetup o1, RuleSetup o2){
				return o1.getRuleNumber() - o2.getRuleNumber();
			}
		});
	}

	private static Integer getDiscountOnBasisOfQty(Integer quantity, HashMap<Integer, Integer> map) {
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (quantity <= entry.getKey()) {
				return entry.getValue();
			}
		}

		return 0;
	}

}
