package com.hbg.otc.discounting.business.rules.test;

import java.util.ArrayList;
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
		List<OrderLine> orderLineList = OrderFactory.getOrderSampleData().getOrderLines();
		List<RuleSetup> ruleSetupList = RuleFactory.getRuleSampleData();
		List<RuleSetup> rulesQualified = new ArrayList<RuleSetup>();;

		for(RuleSetup setup : ruleSetupList) {
			kSession.insert(setup);
		}

		//Generate Output
		System.out.println("---------------------------ORDER #1------------------------------");
		for(OrderLine orderLine :  orderLineList) {
			System.out.println("Order line: " + orderLine.getOrderLineId() + "\n");
			
			kSession.insert(orderLine);
			kSession.fireAllRules();
			for(RuleSetup setup : ruleSetupList) {
				if(setup.getIsQualified()) {
					rulesQualified.add(setup);
					System.out.println(setup.getRuleName() + " qualified with discount: " + setup.getDiscount().getPercentage());
				}
				
				setup.setIsQualified(false);
			}
			
			System.out.println("---------------------------------------------------------");
		}
		
	}
	
	public void checkWinningRule(List<RuleSetup> rulesQualified) {
		for(RuleSetup rule : rulesQualified) {
			if(rule.getOffer()!=null && rule.getOffer().getHardcode()
					&& !rule.getOffer().getOverridenExplicitly()) {
				//`Return this rule
			} else if(rule.getOffer().getOverridenExplicitly()) {
				// Override this rule
			}
			
		}
	}

}
