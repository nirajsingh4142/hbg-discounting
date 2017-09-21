package com.hbg.otc.discounting.model;

import java.io.Serializable;
import java.util.List;

public class OrderLine implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Item item;
    
    private Integer quantity;
    
    private Discount discount;
    
    private Account account;
    
    private Product product;
    
    private List<RuleQualifier> ruleQualifier = null;
    
    private Integer ruleWinner; 
    
    public OrderLine() {
    }
    
    public Item getItem() {
        return item;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void increaseDiscount(double increase) {
        if (discount == null) {
            discount = new Discount(0.0);
        }
        discount.setPercentage(discount.getPercentage() + increase);
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
    
    public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((item == null) ? 0 : item.hashCode());
        result = prime * result
                + ((quantity == null) ? 0 : quantity.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderLine other = (OrderLine) obj;
        if (item == null) {
            if (other.item != null)
                return false;
        } else if (!item.equals(other.item))
            return false;
        if (quantity == null) {
            if (other.quantity != null)
                return false;
        } else if (!quantity.equals(other.quantity))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OrderLine [item=" + item + ", quantity=" + quantity + ", discount=" + discount + "]";
    }

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<RuleQualifier> getRuleQualifier() {
		return ruleQualifier;
	}

	public void setRuleQualifier(List<RuleQualifier> ruleQualifier) {
		this.ruleQualifier = ruleQualifier;
	}

	public Integer getRuleWinner() {
		return ruleWinner;
	}

	public void setRuleWinner(Integer ruleWinner) {
		this.ruleWinner = ruleWinner;
	}

	
    
    

}
