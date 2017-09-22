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
    
}
