package com.hbg.otc.discounting.util.factories;

import com.hbg.otc.discounting.model.Rules;
import com.hbg.otc.discounting.util.RuleBuilder;

public class RuleFactory {
    
    public static Rules getRuleSampleData() {
        
        return new RuleBuilder()
        	.withAccount()
            	.withAccountType("51")
            	.withAccountNumber(0)
            .endRule()
            .withProduct()
            	.withProductGroupCode("PB")
            	.withFamilyCode("")
            	.withIsbn(0)
            .endProduct()
            .withDiscount()
            	.withPercentage(30.0)
            	.end()
            .withOffer()	
            	.withPriority(25)
            	 .end()
            .end()

        .build();
    }
    
}