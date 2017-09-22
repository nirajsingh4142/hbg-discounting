package com.hbg.otc.discounting.util;

import java.util.Optional;

import com.hbg.otc.discounting.model.Rules;

public class RuleBuilder {

	private final Rules instance;
	private Optional<AccountBuilder> accountBuilder = Optional.empty();
	private Optional<ProductBuilder> productBuilder = Optional.empty();
	private Optional<DiscountBuilder> discountBuilder = Optional.empty();
	private Optional<OfferBuilder> offerBuilder = Optional.empty();


	public RuleBuilder() {
		this.instance = new Rules();
	}

	public AccountBuilder withAccount(){
		this.accountBuilder = Optional.of(new AccountBuilder(this));
		return this.accountBuilder.get();
	}

	public ProductBuilder withProduct(){
		this.productBuilder = Optional.of(new ProductBuilder(this));
		return this.productBuilder.get();
	}

	public DiscountBuilder withDiscount(){
		this.discountBuilder = Optional.of(new DiscountBuilder(this));
		return this.discountBuilder.get();
	}

	public OfferBuilder withOffer(){
		this.offerBuilder = Optional.of(new OfferBuilder(this));
		return this.offerBuilder.get();
	}

	public Rules build(){
		if (this.accountBuilder.isPresent()){
            this.instance.setAccount(this.accountBuilder.get().build());
        }
		if (this.productBuilder.isPresent()){
            this.instance.setProduct(this.productBuilder.get().build());
        }
		if (this.discountBuilder.isPresent()){
            this.instance.setDiscount(this.discountBuilder.get().build());
        }
		if (this.offerBuilder.isPresent()){
            this.instance.setOffer(this.offerBuilder.get().build());
        }


		return this.instance;
	}

	public RuleBuilder end(){
		return this;
	}
}
