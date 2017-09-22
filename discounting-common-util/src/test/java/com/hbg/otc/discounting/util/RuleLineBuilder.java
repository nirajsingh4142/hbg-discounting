package com.hbg.otc.discounting.util;

import java.util.Optional;

import com.hbg.otc.discounting.model.OrderLine;
import com.hbg.otc.discounting.model.RuleSetup;

public class RuleLineBuilder {
    
    private RuleBuilder superBuilder;
    
    private Optional<AccountBuilder> accountBuilder = Optional.empty();
    private Optional<ProductBuilder> productBuilder = Optional.empty();
    
    
    public AccountBuilder withAccount(){
        this.accountBuilder = Optional.of(new AccountBuilder(superBuilder));
        return this.accountBuilder.get();
    }
    
    public ProductBuilder withProduct(){
        this.productBuilder = Optional.of(new ProductBuilder(superBuilder));
        return this.productBuilder.get();
    }
    
    public RuleBuilder end(){
        return superBuilder;
    }
    
}
