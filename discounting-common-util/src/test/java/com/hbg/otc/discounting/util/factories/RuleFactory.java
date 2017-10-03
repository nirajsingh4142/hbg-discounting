package com.hbg.otc.discounting.util.factories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hbg.otc.discounting.model.RuleSetup;
import com.hbg.otc.discounting.util.RuleBuilder;

public class RuleFactory {
    
    public static List<RuleSetup> getRuleSampleData() {
        List<RuleSetup> ruleSetupList = new ArrayList<RuleSetup>();
        
        //Rule #1
        ruleSetupList.add( new RuleBuilder()
        	.withRuleName("Rule 1")
        	.withRuleNumber(1)
        	.withAccount()
            	.withAccountType("51")
            	.endAccount()
            .withProduct()
            	.withProductGroupCode("PB")
            	.endProduct()
            .withDiscount()
            	.withPercentage(30.0)
            	.endDiscount()
            .withOffer()	
            	.withPriority(25)
            	.endOffer()
            .end()
        .build());
        
        //Rule #2
        ruleSetupList.add( new RuleBuilder()
            	.withRuleName("Rule 2")
            	.withRuleNumber(2)
            	.withAccount()
                	.withAccountType("51")
                	.endAccount()
                .withProduct()
                	.withIsbn(111)
                	.endProduct()
                .withDiscount()
                	.withPercentage(40.0)
                	.endDiscount()
                .withOffer()	
                	.withPriority(25)
                	.withOverridenExplicitly(true)
                	.endOffer()
                .end()
            .build());
       
        //Rule #3
        ruleSetupList.add( new RuleBuilder()
            	.withRuleName("Rule 3")
            	.withRuleNumber(3)
            	.withAccount()
                	.withAccountNumber(123)
                	.endAccount()
                .withProduct()
                	.withFamilyCode("HB")
                	.endProduct()
                .withDiscount()
                	.withPercentage(60.0)
                	.endDiscount()
                .withOffer()	
                	.withPriority(25)
                	.withHardcode(true)
                	.endOffer()
                .end()
            .build());
        
        //Rule #4
        ruleSetupList.add( new RuleBuilder()
            	.withRuleName("Rule 4")
            	.withRuleNumber(4)
            	.withAccount()
                	.withAccountNumber(456)
                	.endAccount()
                .withProduct()
                	.withFamilyCode("HB")
                	.endProduct()
                .withDiscount()
                	.withPercentage(50.0)
                	.endDiscount()
                .withOffer()	
                	.withPriority(25)
                	.endOffer()
                .end()
            .build());
        
        //Rule #5
        ruleSetupList.add( new RuleBuilder()
            	.withRuleName("Rule 5")
            	.withRuleNumber(5)
            	.withAccount()
                	.withAccountNumber(456)
                	.endAccount()
                .withProduct()
                	.withIsbn(111)
                	.endProduct()
                .withDiscount()
                	.withPercentage(75.0)
                	.endDiscount()
                .withOffer()	
                	.withPriority(25)
                	.endOffer()
                .end()
            .build());
        
        //Rule #6
        ruleSetupList.add( new RuleBuilder()
            	.withRuleName("Rule 6")
            	.withRuleNumber(6)
            	.withAccount()
                	.withAccountType("51")
                	.endAccount()
                .withProduct()
                	.withProductGroupCode("PB")
                	.endProduct()
                .withDiscount()
                	.withPercentage(80.0)
                	.endDiscount()
                .withOffer()	
                	.withPriority(75)
                	.withTerms()
                		.withDays(120)
                		.endTerm()
                	.endOffer()
                .end()
            .build());

        return ruleSetupList;
        
    }
    
    //Example 9 - Set 2
    public static List<RuleSetup> getRuleSampleData2() {
        List<RuleSetup> ruleSetupList = new ArrayList<RuleSetup>();
        
        //Rule #7
        ruleSetupList.add( new RuleBuilder()
            	.withRuleName("Rule 7")
            	.withRuleNumber(7)
            	.withAccount()
                	.withAccountType("51")
                	.endAccount()
                .withProduct()
                	.withProductGroupCode("PB")
                	.endProduct()
                .withDiscount()
                	.withPercentage(50.0)
                	.endDiscount()
                .withOffer()	
                	.withPriority(75)
                	.withNewComboField(1)
                	.withTerms()
                		.withDays(120)
                		.endTerm()
                	.endOffer()
                .end()
            .build());
        
        //Rule #8
        ruleSetupList.add( new RuleBuilder()
            	.withRuleName("Rule 8")
            	.withRuleNumber(8)
            	.withAccount()
                	.withAccountType("51")
                	.endAccount()
                .withProduct()
                	.withFamilyCode("HB")
                	.endProduct()
                .withDiscount()
                	.withPercentage(60.0)
                	.endDiscount()
                .withOffer()	
                	.withPriority(75)
                	.withNewComboField(2)
                	.endOffer()
                .end()
            .build());
        
        //Rule #9
        ruleSetupList.add( new RuleBuilder()
            	.withRuleName("Rule 9")
            	.withRuleNumber(9)
            	.withAccount()
                	.withAccountType("51")
                	.endAccount()
                .withProduct()
                	.withProductGroupCode("PB")
                	.endProduct()
                .withDiscount()
                	.withPercentage(5.0)
                	.endDiscount()
                .withOffer()	
                	.withPriority(75)
                	.withNewComboField(2)
                	.withTerms()
                		.withDays(120)
                		.withChargeFreight(true)
                		.endTerm()
                	.endOffer()
                .end()
            .build());
        
        //Rule #10
        ruleSetupList.add( new RuleBuilder()
            	.withRuleName("Rule 10")
            	.withRuleNumber(10)
            	.withAccount()
                	.withAccountType("51")
                	.endAccount()
                .withProduct()
                	.withProductGroupCode("PB")
                	.withIsbn(333)
                	.endProduct()
                .withOffer()	
                	.withPriority(75)
                	.withNewComboField(2)
                	.withTerms()
                		.withFreeFreight(true)
                		.endTerm()
                	.endOffer()
                .end()
            .build());

        return ruleSetupList;
        
    }
    
    //Example 10
    public static List<RuleSetup> getRuleSampleData3() {
        List<RuleSetup> ruleSetupList = new ArrayList<RuleSetup>();
        HashMap<Integer, Integer> qtyDiscountMap11 = new HashMap<Integer, Integer>();
        qtyDiscountMap11.put(499, 60);
        qtyDiscountMap11.put(1000, 65);
        
        //Rule #11
        ruleSetupList.add( new RuleBuilder()
            	.withRuleName("Rule A1")
            	.withRuleNumber(11)
            	.withQtyDiscountMap(qtyDiscountMap11)
            	.withAccount()
                	.withAccountNumber(123)
                	.endAccount()
                .withProduct()
                	.withFamilyCode("HB")
                	.endProduct()
                .end()
            .build());
        
        //Rule 12.1
        HashMap<Integer, Integer> qtyDiscountMap12 = new HashMap<Integer, Integer>();
        qtyDiscountMap12.put(300, 60);
        qtyDiscountMap12.put(1000, 65);
        
        ruleSetupList.add( new RuleBuilder()
            	.withRuleName("Rule A2.1")
            	.withRuleNumber(121)
            	.withQtyDiscountMap(qtyDiscountMap12)
            	.withAccount()
                	.withAccountNumber(456)
                	.endAccount()
                .withProduct()
                	.withFamilyCode("HB")
                	.endProduct()
                .withOffer()	
                	.withTerms()
                		.withFreeFreight(true)
                		.endTerm()
                	.endOffer()
                .end()
            .build());
        
        //Rule 12.2
        ruleSetupList.add( new RuleBuilder()
            	.withRuleName("Rule A2.2")
            	.withRuleNumber(122)
            	.withAccount()
                	.withAccountNumber(456)
                	.endAccount()
                .withProduct()
                	.withFamilyCode("DP")
                	.endProduct()
                .withOffer()	
                	.withTerms()
                		.withFreeFreight(true)
                		.endTerm()
                	.endOffer()
                .end()
            .build());
        
        //Rule 13.1
        HashMap<Integer, Integer> qtyDiscountMap131 = new HashMap<Integer, Integer>();
        qtyDiscountMap131.put(300, 60);
        qtyDiscountMap131.put(1000, 65);
        
        ruleSetupList.add( new RuleBuilder()
            	.withRuleName("Rule A3.1")
            	.withRuleNumber(13)
            	.withQtyDiscountMap(qtyDiscountMap131)
            	.withAccount()
                	.withAccountNumber(789)
                	.endAccount()
                .withProduct()
                	.withFamilyCode("HB")
                	.endProduct()
                .end()
            .build());
        
        //Rule 13.2
        ruleSetupList.add( new RuleBuilder()
            	.withRuleName("Rule A3.2")
            	.withRuleNumber(132)
            	.withAccount()
                	.withAccountNumber(789)
                	.endAccount()
                .withProduct()
                	.withFamilyCode("DP")
                	.endProduct()
                .end()
            .build());
        
        //Rule 14
        HashMap<Integer, Integer> qtyDiscountMap14 = new HashMap<Integer, Integer>();
        qtyDiscountMap14.put(99, 40);
        qtyDiscountMap14.put(199, 45);
        qtyDiscountMap14.put(1000, 50);
        
        ruleSetupList.add( new RuleBuilder()
            	.withRuleName("Rule S1")
            	.withRuleNumber(14)
            	.withQtyDiscountMap(qtyDiscountMap14)
            	.withAccount()
                	.withAccountType("51")
                	.endAccount()
                .withProduct()
                	.withFamilyCode("HB")
                	.endProduct()
                .end()
            .build());
        
        //Rule 15
        HashMap<Integer, Integer> qtyDiscountMap15 = new HashMap<Integer, Integer>();
        qtyDiscountMap15.put(99, 45);
        qtyDiscountMap15.put(1000, 50);
        
        ruleSetupList.add( new RuleBuilder()
            	.withRuleName("Rule S2")
            	.withRuleNumber(14)
            	.withQtyDiscountMap(qtyDiscountMap15)
            	.withAccount()
                	.withAccountType("51")
                	.endAccount()
                .withProduct()
                	.withFamilyCode("DP")
                	.endProduct()
                .end()
            .build());
        
        //Rule 16
        HashMap<Integer, Integer> qtyDiscountMap16 = new HashMap<Integer, Integer>();
        qtyDiscountMap16.put(9, 60);
        qtyDiscountMap16.put(1000, 70);
        
        ruleSetupList.add( new RuleBuilder()
            	.withRuleName("Rule S3")
            	.withRuleNumber(14)
            	.withQtyDiscountMap(qtyDiscountMap16)
            	.withAccount()
                	.withAccountType("51")
                	.endAccount()
                .withProduct()
                	.withFamilyCode("TH")
                	.endProduct()
                .end()
            .build());
        
        	
        return ruleSetupList;
    }
    
}
