package com.hbg.otc.discounting.business.rules.test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.hbg.otc.discounting.BaseTest;
import com.hbg.otc.discounting.model.Order;
import com.hbg.otc.discounting.model.OrderLine;
import com.hbg.otc.discounting.model.RuleSetup;
import com.hbg.otc.discounting.util.factories.OrderFactory;
import com.hbg.otc.discounting.util.factories.RuleFactory;

public class OrderDiscountTest extends BaseTest {

	public static void main(String[] args) {
		System.out.println( "Bootstrapping the Rule Engine ..." );

		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession =  kContainer.newKieSession();
		Order o = OrderFactory.getOrderSampleData();
		
		kSession.insert(o.getOrderLines().get(0));
		kSession.insert(o.getOrderLines().get(0).getAccount());
		kSession.insert(o.getOrderLines().get(0).getProduct());
		kSession.insert(o.getOrderLines().get(0).getItem());
		
		kSession.insert(o.getOrderLines().get(1));
		kSession.insert(o.getOrderLines().get(1).getAccount());
		kSession.insert(o.getOrderLines().get(1).getProduct());
		kSession.insert(o.getOrderLines().get(1).getItem());
		
		kSession.insert(o);
		
		RuleSetup rule =RuleFactory.getRuleSampleData();
		kSession.insert(rule.getAccount());
		kSession.insert(rule.getDiscount());
		kSession.insert(rule.getProduct());
		kSession.insert(rule.getOffer());
		kSession.insert(rule);
		
		//int fired = kSession.fireAllRules();

		System.out.println("Rule Qualified : ");
		System.out.println( "RuleNumber = " +  rule.getRuleNumber() + ", RuleName = '" + rule.getRuleName() + "'" );

	}
}
