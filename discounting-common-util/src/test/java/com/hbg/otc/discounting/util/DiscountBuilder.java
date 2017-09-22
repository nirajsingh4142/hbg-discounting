package com.hbg.otc.discounting.util;

import com.hbg.otc.discounting.model.Discount;
import com.hbg.otc.discounting.model.Product;

public class DiscountBuilder {
    private  RuleBuilder superRuleBuilder;
    private final Discount instance;

    public DiscountBuilder(RuleBuilder superRuleBuilder) {
        this.superRuleBuilder = superRuleBuilder;
        this.instance = new Discount();
        this.instance.setPercentage(0.0);
    }
    
    public DiscountBuilder withPercentage(Double percentage){
        this.instance.setPercentage(percentage);
        return this;
    }
    
    public RuleBuilder endDiscount(){
        return superRuleBuilder;
    } 
    
    public Discount build(){
        return this.instance;
    }
    
}
