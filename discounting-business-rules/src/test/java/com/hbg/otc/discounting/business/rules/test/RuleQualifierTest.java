package com.hbg.otc.discounting.business.rules.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.hbg.otc.discounting.BaseTest;
import com.hbg.otc.discounting.model.OrderLine;
import com.hbg.otc.discounting.model.RulePrecedence;
import com.hbg.otc.discounting.model.RuleSetup;
import com.hbg.otc.discounting.model.Terms;
import com.hbg.otc.discounting.util.factories.OrderFactory;
import com.hbg.otc.discounting.util.factories.RuleFactory;
import com.hbg.otc.discounting.util.factories.RulePrecedenceBuilder;

public class RuleQualifierTest extends BaseTest {

	public static void main(String[] args) {
		System.out.println( "Bootstrapping the Rule Engine ..." );

		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession =  kContainer.newKieSession();
		List<RuleSetup> ruleSetupList = RuleFactory.getRuleSampleData();
		//List<RuleSetup> ruleSetupList = RuleFactory.getRuleSampleData2();

		List<OrderLine> orderLineList = OrderFactory.getOrderSampleData().getOrderLines();
		//List<OrderLine> orderLineList = OrderFactory.getOrderSampleData2().getOrderLines();

		List<RuleSetup> rulesQualified;
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

		for(RuleSetup setup : ruleSetupList) {
			kSession.insert(setup);
			kSession.insert(setup.getOffer());
		}

		//Generate Output
		System.out.println("---------------------------ORDER #1------------------------------");
		for(OrderLine orderLine :  orderLineList) {
			rulesQualified = new ArrayList<RuleSetup>();
			priorityList = new ArrayList<String>();

			System.out.println("Order line: " + orderLine.getOrderLineId() + "\n");

			kSession.insert(orderLine);
			kSession.fireAllRules();
			for(RuleSetup setup : ruleSetupList) {
				if(setup.getIsQualified()) {
					priorityList.add(setup.getWinningPriority());
					rulesQualified.add(setup);
					if(setup.getDiscount()!=null) {
						System.out.println(setup.getRuleName() + " qualified with discount: " + setup.getDiscount().getPercentage() + "%");
					}else {
						System.out.println(setup.getRuleName() + " qualified with discount: 0%");
					}

					if(setup.getOffer().getPriority() > maxPriority) {
						maxPriority = setup.getOffer().getPriority();
					}
				}

				setup.setIsQualified(false);
			}

			System.out.println("----------------------------------------------------------------------------");

			//sorted list on basis of rule number
			sortListOnBasisOfRule(rulesQualified);

			for(RuleSetup setup : rulesQualified) {

				//Display winner with combo field parameters excluded
				if(setup.getOffer().getNewComboField() == null) {
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
							terms = " and Term " + term.getDays() + " days";
						}
						if(term.getFreeFreight()) {
							terms = terms + " having free freight.";
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

}
