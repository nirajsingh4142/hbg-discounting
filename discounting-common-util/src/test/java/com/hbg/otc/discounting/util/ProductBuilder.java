package com.hbg.otc.discounting.util;

import com.hbg.otc.discounting.model.Product;

public class ProductBuilder {
    private  OrderLineBuilder superBuilder;
    private  RuleBuilder superRuleBuilder;
    private final Product instance;

    public ProductBuilder(OrderLineBuilder superBuilder) {
        this.superBuilder = superBuilder;
        this.instance = new Product();
    }
    
    public ProductBuilder(RuleBuilder superRuleBuilder) {
        this.superRuleBuilder = superRuleBuilder;
        this.instance = new Product();
    }
    
    public ProductBuilder withMassProductGroupCode(String massProductGroupCode){
        this.instance.setMassProductGroupCode(massProductGroupCode);
        return this;
    }
    
    public ProductBuilder withProductGroupCode(String productGroupCode){
        this.instance.setProductGroupCode(productGroupCode);
        return this;
    }
    
    public ProductBuilder withFamilyCode(String familyCode){
        this.instance.setFamilyCode(familyCode);
        return this;
    }
    
    public ProductBuilder withIsbn(Integer isbn){
        this.instance.setIsbn(isbn);
        return this;
    }
    
    public ProductBuilder withOfferCode(Integer offerCode){
        this.instance.setOfferCode(offerCode);
        return this;
    }
    
    public Product build(){
        return this.instance;
    }
    
    public OrderLineBuilder end(){
        return superBuilder;
    } 
    
    public RuleBuilder endProduct(){
        return superRuleBuilder;
    } 

}
