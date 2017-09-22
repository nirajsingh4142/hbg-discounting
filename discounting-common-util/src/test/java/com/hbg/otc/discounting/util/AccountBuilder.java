package com.hbg.otc.discounting.util;

import com.hbg.otc.discounting.model.Account;
import com.hbg.otc.discounting.model.Rules;

public class AccountBuilder {
    private OrderLineBuilder superBuilder;
    private RuleBuilder superRuleBuilder;
    private final Account instance;

    public AccountBuilder(OrderLineBuilder superBuilder) {
        this.superBuilder = superBuilder;
        
        this.instance = new Account();
        //default values
        this.instance.setAccountNumber(0);
        this.instance.setAccountType("");
        this.instance.setAccountGroup("");
        this.instance.setOrg("");
        this.instance.setDistributionChannel("");
        this.instance.setAccountTypeGroupCode("");
        this.instance.setDistributionCenter("");
    }
    
  public AccountBuilder(RuleBuilder superRuleBuilder) {
        this.superRuleBuilder = superRuleBuilder;
        
        this.instance = new Account();
        //default values
        this.instance.setAccountNumber(0);
        this.instance.setAccountType("");
        this.instance.setAccountGroup("");
        this.instance.setOrg("");
        this.instance.setDistributionChannel("");
        this.instance.setAccountTypeGroupCode("");
        this.instance.setDistributionCenter("");
    }
    public AccountBuilder withAccountNumber(Integer accountNumber){
        this.instance.setAccountNumber(accountNumber);
        return this;
    }
    
    public AccountBuilder withAccountType(String accountType){
        this.instance.setAccountType(accountType);
        return this;
    }
    
    public AccountBuilder withAccountGroup(String accountGroup){
        this.instance.setAccountGroup(accountGroup);
        return this;
    }
    
    public AccountBuilder withOrg(String org){
        this.instance.setOrg(org);
        return this;
    }
    
    public AccountBuilder withDistributionChannel(String distributionChannel){
        this.instance.setDistributionChannel(distributionChannel);
        return this;
    }
    
    public AccountBuilder withAccountTypeGroupCode(String accountTypeGroupCode){
        this.instance.setAccountTypeGroupCode(accountTypeGroupCode);
        return this;
    }
    
    public AccountBuilder withDistributionCenter(String distributionCenter){
        this.instance.setDistributionCenter(distributionCenter);
        return this;
    }
    
    
    public Account build(){
        return this.instance;
    }
    
    public OrderLineBuilder end(){
        return superBuilder;
    } 
    
    public RuleBuilder endAccount(){
        return superRuleBuilder;
    }

}
