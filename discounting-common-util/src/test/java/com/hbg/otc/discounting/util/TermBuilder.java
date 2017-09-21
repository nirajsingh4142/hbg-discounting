package com.hbg.otc.discounting.util;

import com.hbg.otc.discounting.model.Terms;

public class TermBuilder {
    private  RuleBuilder superRuleBuilder;
    private final Terms instance;

    public TermBuilder(RuleBuilder superRuleBuilder) {
        this.superRuleBuilder = superRuleBuilder;
        this.instance = new Terms();
        this.instance.setDays(0);
        this.instance.setFreeFreight(false);
        this.instance.setChargeFreight(false);
        this.instance.setReturnable(false);
    }
    
    public TermBuilder withDays(Integer days){
        this.instance.setDays(days);
        return this;
    }

    public TermBuilder withFreeFreight(Boolean freeFreight){
        this.instance.setFreeFreight(freeFreight);
        return this;
    }
    
    public TermBuilder withChargeFreight(Boolean chargeFreight){
        this.instance.setChargeFreight(chargeFreight);
        return this;
    }
    
    public TermBuilder withReturnable(Boolean returnable){
        this.instance.setReturnable(returnable);
        return this;
    }
    
    public RuleBuilder end(){
        return superRuleBuilder;
    } 
    
}
