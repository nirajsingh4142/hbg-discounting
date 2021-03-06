package com.hbg.otc.discounting.util;

import com.hbg.otc.discounting.model.Account;
import com.hbg.otc.discounting.model.RuleSetup;

public class AccountBuilder {
	private OrderLineBuilder superBuilder;
	private RuleBuilder superRuleBuilder;
	private StandardRuleBuilder standardRuleBuilder;
	private final Account instance;

	public AccountBuilder(OrderLineBuilder superBuilder) {
		this.superBuilder = superBuilder;
		this.instance = new Account();
	}

	public AccountBuilder(RuleBuilder superRuleBuilder) {
		this.superRuleBuilder = superRuleBuilder;
		this.instance = new Account();
	}
	
	public AccountBuilder(StandardRuleBuilder standardRuleBuilder) {
		this.standardRuleBuilder = standardRuleBuilder;
		this.instance = new Account();
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
	
	public StandardRuleBuilder endStandardAccount(){
		return standardRuleBuilder;
	}

}
