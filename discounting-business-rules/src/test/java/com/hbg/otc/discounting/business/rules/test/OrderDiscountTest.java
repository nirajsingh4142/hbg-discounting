package com.hbg.otc.discounting.business.rules.test;

import java.util.Collection;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.hbg.otc.discounting.BaseTest;
import com.hbg.otc.discounting.model.OrderLine;
import com.hbg.otc.discounting.model.RuleQualifier;
import com.hbg.otc.discounting.model.RuleSetup;
import com.hbg.otc.discounting.util.factories.OrderFactory;
import com.hbg.otc.discounting.util.factories.RuleFactory;

public class OrderDiscountTest extends BaseTest {

	public static void main(String[] args) {
		System.out.println( "Bootstrapping the Rule Engine ..." );

		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession =  kContainer.newKieSession();
		List<OrderLine> orderLineList = OrderFactory.getOrderSampleData().getOrderLines();
		
		kSession.insert(OrderFactory.getOrderSampleData());
		
		for(RuleSetup setup : RuleFactory.getRuleSampleData()) {
			kSession.insert(setup);
		}

		kSession.fireAllRules();
		
		for(OrderLine orderLine :  orderLineList) {
			if(orderLine.getRuleQualifier()!=null) {
				for(RuleQualifier ruleQualified : orderLine.getRuleQualifier()) {
					System.out.println("Rule Qualified : ");
					System.out.println( "RuleNumber = " +  ruleQualified.getRuleNumber() + ", RuleName = '" + ruleQualified.getRuleName() + "'" );
				}
			}

		}

	}
}
