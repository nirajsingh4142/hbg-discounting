package com.hbg.otc.discounting.business.rules.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.hbg.otc.discounting.BaseTest;
import com.hbg.otc.discounting.model.OrderLine;
import com.hbg.otc.discounting.model.RuleSetup;
import com.hbg.otc.discounting.util.factories.OrderFactory;
import com.hbg.otc.discounting.util.factories.RuleFactory;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class OrderDiscountTest extends BaseTest {
	KieServices ks = KieServices.Factory.get();
	KieContainer kContainer = ks.getKieClasspathContainer();
	KieSession kSession =  kContainer.newKieSession();
	List<OrderLine> orderLineList = OrderFactory.getOrderSampleData().getOrderLines();
	List<RuleSetup> ruleSetupList = RuleFactory.getRuleSampleData();
	List<RuleSetup> rulesQualified = new ArrayList<RuleSetup>();

    @Test
    public void RuleTest1() {
    	
    	assertThat(getDiscount(kSession,ruleSetupList.get(0),orderLineList.get(0)),equalTo(0.0));
    	
    	}
    @Test
    public void RuleTest2() {
    	
    	    	assertThat(getDiscount(kSession,ruleSetupList.get(0),orderLineList.get(1)),equalTo(30.0));
    	}
    @Test
    public void RuleTest3() {
    	
    	assertThat(getDiscount(kSession,ruleSetupList.get(1),orderLineList.get(0)),equalTo(40.0));
    	}
    
    @Test
    public void RuleTest4() {
    	
    	assertThat(getDiscount(kSession,ruleSetupList.get(1),orderLineList.get(1)),equalTo(0.0));
    	
    	}
    
    @Test
    public void RuleTest5() {
    	
    	assertThat(getDiscount(kSession,ruleSetupList.get(2),orderLineList.get(0)),equalTo(60.0));
    	}
    
    @Test
    public void RuleTest6() {
    	
    	assertThat(getDiscount(kSession,ruleSetupList.get(2),orderLineList.get(1)),equalTo(60.0));
    	}
    
    @Test
    public void RuleTest7() {
    	
    	assertThat(getDiscount(kSession,ruleSetupList.get(3),orderLineList.get(0)),equalTo(0.0));
    	}
    
    @Test
    public void RuleTest8() {
    	
    	assertThat(getDiscount(kSession,ruleSetupList.get(3),orderLineList.get(1)),equalTo(0.0));
    	}
   
    
       private  double getDiscount(KieSession session,RuleSetup ruleObj,OrderLine orderObj) {
    	   
    	  double discPer=0.0;
    	  session.insert(orderObj);
    	  session.insert(ruleObj);
    	  session.fireAllRules();
    	  if(ruleObj.getIsQualified()) {
				discPer=ruleObj.getDiscount().getPercentage();
		}
    	  return discPer;
    }
} 
