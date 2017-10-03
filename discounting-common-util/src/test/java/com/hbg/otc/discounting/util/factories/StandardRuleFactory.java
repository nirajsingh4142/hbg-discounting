package com.hbg.otc.discounting.util.factories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hbg.otc.discounting.model.StandardRuleSetup;
import com.hbg.otc.discounting.util.StandardRuleBuilder;


public class StandardRuleFactory {
    
    public static List<StandardRuleSetup> getRuleSampleData() {
    	List<StandardRuleSetup> ruleSetupList = new ArrayList<StandardRuleSetup>();
    	
    	//Rule 14
        HashMap<Integer, Integer> qtyDiscountMap14 = new HashMap<Integer, Integer>();
        qtyDiscountMap14.put(99, 40);
        qtyDiscountMap14.put(199, 45);
        qtyDiscountMap14.put(1000, 50);
        
        ruleSetupList.add( new StandardRuleBuilder()
            	.withRuleName("Rule S1")
            	.withRuleNumber(14)
            	.withQtyDiscountMap(qtyDiscountMap14)
            	.withAccount()
                	.withAccountType("51")
                	.endStandardAccount()
                .withProduct()
                	.withFamilyCode("HB")
                	.endStandardProduct()
                .end()
            .build());
        
        //Rule 15
        HashMap<Integer, Integer> qtyDiscountMap15 = new HashMap<Integer, Integer>();
        qtyDiscountMap15.put(99, 45);
        qtyDiscountMap15.put(1000, 50);
        
        ruleSetupList.add( new StandardRuleBuilder()
            	.withRuleName("Rule S2")
            	.withRuleNumber(14)
            	.withQtyDiscountMap(qtyDiscountMap15)
            	.withAccount()
                	.withAccountType("51")
                	.endStandardAccount()
                .withProduct()
                	.withFamilyCode("DP")
                	.endStandardProduct()
                .end()
            .build());
        
        //Rule 16
        HashMap<Integer, Integer> qtyDiscountMap16 = new HashMap<Integer, Integer>();
        qtyDiscountMap16.put(9, 60);
        qtyDiscountMap16.put(1000, 70);
        
        ruleSetupList.add( new StandardRuleBuilder()
            	.withRuleName("Rule S3")
            	.withRuleNumber(14)
            	.withQtyDiscountMap(qtyDiscountMap16)
            	.withAccount()
                	.withAccountType("51")
                	.endStandardAccount()
                .withProduct()
                	.withFamilyCode("TH")
                	.endStandardProduct()
                .end()
            .build());
        
        	
        return ruleSetupList;
    }
    
}
