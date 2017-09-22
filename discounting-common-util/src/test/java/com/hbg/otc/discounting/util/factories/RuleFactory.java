package com.hbg.otc.discounting.util.factories;

import com.hbg.otc.discounting.model.Rules;
import com.hbg.otc.discounting.util.RuleBuilder;

public class RuleFactory {
    
    public static Rules getRuleSampleData() {
        
        return new RuleBuilder()
        	.withRuleName("Test rule for POC")
        	.withRuleNumber(1)
        	.withAccount()
            	.withAccountType("51")
            	.withAccountNumber(123)
            	.endAccount()
            .withProduct()
            	.withProductGroupCode("PB")
            	.withFamilyCode("")
            	.withIsbn(0)
            	.endProduct()
            .withDiscount()
            	.withPercentage(30.0)
            	.endDiscount()
            .withOffer()	
            	.withPriority(25)
            	.endOffer()
            .end()

        .build();
    }
    
}
