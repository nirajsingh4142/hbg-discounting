package com.hbg.otc.discounting.util;

import java.util.Optional;

import com.hbg.otc.discounting.model.OrderLine;

public class OrderLineBuilder {
    
    private final OrderBuilder superBuilder;
    private final OrderLine instance;
    
    private Optional<ItemBuilder> itemBuilder = Optional.empty();
    private Optional<AccountBuilder> accountBuilder = Optional.empty();
    private Optional<ProductBuilder> productBuilder = Optional.empty();
    
    public OrderLineBuilder(OrderBuilder superBuilder) {
        this.superBuilder = superBuilder;
        
        this.instance = new OrderLine();
        this.instance.setQuantity(0);
    }
    
    public OrderLineBuilder withQuantity(int quantity){
        this.instance.setQuantity(quantity);
        return this;
    }
    
    public ItemBuilder withItem(){
        this.itemBuilder = Optional.of(new ItemBuilder(this));
        return this.itemBuilder.get();
    }
    
    public AccountBuilder withAccount(){
        this.accountBuilder = Optional.of(new AccountBuilder(this));
        return this.accountBuilder.get();
    }
    
    public ProductBuilder withProduct(){
        this.productBuilder = Optional.of(new ProductBuilder(this));
        return this.productBuilder.get();
    }
    
    public OrderLine build(){
        if (this.itemBuilder.isPresent()){
            this.instance.setItem(this.itemBuilder.get().build());
        }
        if (this.accountBuilder.isPresent()){
            this.instance.setAccount(this.accountBuilder.get().build());
        }
		if (this.productBuilder.isPresent()){
            this.instance.setProduct(this.productBuilder.get().build());
        }
        return this.instance;
    }
    
    public OrderBuilder end(){
        return superBuilder;
    }
    
}
