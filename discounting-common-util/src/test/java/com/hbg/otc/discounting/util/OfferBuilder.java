package com.hbg.otc.discounting.util;

import java.util.ArrayList;

import com.hbg.otc.discounting.model.Offer;
import com.hbg.otc.discounting.model.Terms;

public class OfferBuilder {
    private  RuleBuilder superRuleBuilder;
    private final Offer instance;

    public OfferBuilder(RuleBuilder superRuleBuilder) {
        this.superRuleBuilder = superRuleBuilder;
        this.instance = new Offer();
        this.instance.setPriority(0);
        this.instance.setTerms(new ArrayList<>());
        this.instance.setOverridenExplicitly(false);
        this.instance.setHardcode(false);
    }
    
    public OfferBuilder withPriority(Integer priority){
        this.instance.setPriority(priority);
        return this;
    }

    public OfferBuilder withHardcode(Boolean hardcode){
        this.instance.setHardcode(hardcode);
        return this;
    }
    
    public OfferBuilder withOverridenExplicitly(Boolean overridenExplicitly){
        this.instance.setOverridenExplicitly(overridenExplicitly);
        return this;
    }
    
    public OfferBuilder withTerms(ArrayList<Terms> terms){
        this.instance.setTerms(terms);
        return this;
    }
    
    public RuleBuilder end(){
        return superRuleBuilder;
    } 
    
}
