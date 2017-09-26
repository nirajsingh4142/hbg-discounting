package com.hbg.otc.discounting.business.rules.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.hbg.otc.discounting.BaseTest;
import com.hbg.otc.discounting.model.OrderLine;
import com.hbg.otc.discounting.model.RuleSetup;
import com.hbg.otc.discounting.util.factories.OrderFactory;
import com.hbg.otc.discounting.util.factories.RuleFactory;

public class RuleQualifierTest extends BaseTest {

	public static void main(String[] args) {
		System.out.println( "Bootstrapping the Rule Engine ..." );

		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession =  kContainer.newKieSession();
		List<RuleSetup> ruleSetupList = RuleFactory.getRuleSampleData();
		List<RuleSetup> rulesQualified;
		Integer maxPriority = 0;

		kSession.insert(ruleSetupList);

		for(RuleSetup setup : ruleSetupList) {
			kSession.insert(setup);
			kSession.insert(setup.getOffer());
		}

		//Generate Output
		System.out.println("---------------------------ORDER #1------------------------------");
		for(OrderLine orderLine :  OrderFactory.getOrderSampleData().getOrderLines()) {
			rulesQualified = new ArrayList<RuleSetup>();

			System.out.println("Order line: " + orderLine.getOrderLineId() + "\n");

			kSession.insert(orderLine);
			kSession.fireAllRules();
			for(RuleSetup setup : ruleSetupList) {
				if(setup.getIsQualified()) {
					rulesQualified.add(setup);
					System.out.println(setup.getRuleName() + " qualified with discount: " + setup.getDiscount().getPercentage() + "%");
					
					if(setup.getOffer().getPriority() > maxPriority) {
						maxPriority = setup.getOffer().getPriority();
					}
				}
				
				setup.setIsQualified(false);
			}
			System.out.println("---------------------------------------------------------");
			
			// Display winning rule
			for(RuleSetup setup : rulesQualified) {
				
				if(setup.getDefinePriority().equals("P1")) {
					System.out.println("Rule " + setup.getRuleNumber() + " wins with discount: " + setup.getDiscount().getPercentage() + "%");
					break;
				} else if(setup.getDefinePriority().equals("P2")) {
					System.out.println("Rule " + setup.getRuleNumber() + " wins with discount: " + setup.getDiscount().getPercentage() + "%");
					break;
				} else if(setup.getOffer().getPriority() == maxPriority) {
					System.out.println("Rule " + setup.getRuleNumber() + " wins with discount: " + setup.getDiscount().getPercentage() + "%");
				}
			}
			

			System.out.println("---------------------------------------------------------");
		}

	}

}
