package com.hbg.otc.discounting.util.factories;

import java.util.ArrayList;
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
                		.withReturnable(true)
                		.endTerm()
                	.endOffer()
                .end()
            .build());

        return ruleSetupList;
        
    }
    
}
