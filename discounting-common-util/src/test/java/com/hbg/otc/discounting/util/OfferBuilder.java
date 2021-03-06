package com.hbg.otc.discounting.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hbg.otc.discounting.model.Offer;
import com.hbg.otc.discounting.model.Terms;

public class OfferBuilder {
	private Optional<TermBuilder> termBuilder = Optional.empty();
	private  RuleBuilder superRuleBuilder;
	private StandardRuleBuilder standardRuleBuilder;
    private final Offer instance;

    public OfferBuilder(RuleBuilder superRuleBuilder) {
        this.superRuleBuilder = superRuleBuilder;
        this.instance = new Offer();
    }
    
    public OfferBuilder(StandardRuleBuilder standardRuleBuilder) {
        this.standardRuleBuilder = standardRuleBuilder;
        this.instance = new Offer();
    }
    
    public OfferBuilder withPriority(Integer priority){
        this.instance.setPriority(priority);
        return this;
    }
    
    public OfferBuilder withNewComboField(Integer newComboField){
        this.instance.setNewComboField(newComboField);
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
    
    public TermBuilder withTerms(){
		this.termBuilder = Optional.of(new TermBuilder(this));
		return this.termBuilder.get();
	}
    
    public RuleBuilder endOffer(){
        return superRuleBuilder;
    } 
    
    public StandardRuleBuilder endStandardOffer(){
        return standardRuleBuilder;
    } 
    
    public Offer build(){
    	List<Terms> tempList = new ArrayList<Terms>();
    	if (this.termBuilder.isPresent()){
    		tempList.add(this.termBuilder.get().build());
        	this.instance.setTerms(tempList);
        }

    	
        return this.instance;
    }
    
}
