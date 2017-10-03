package com.hbg.otc.discounting.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author raghav.rampal
 *
 */
public class StandardRuleSetup implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer ruleNumber;
	private String ruleName;
	private Account account;
	private Product product;
	private Discount discount;
	private Boolean isQualified = false;
	private Boolean isWinner = false;
	private HashMap<Integer, Integer> qtyDiscountMap = new HashMap<Integer, Integer>();

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public Integer getRuleNumber() {
		return ruleNumber;
	}

	public void setRuleNumber(Integer ruleNumber) {
		this.ruleNumber = ruleNumber;
	}

	public Boolean getIsQualified() {
		return isQualified;
	}

	public void setIsQualified(Boolean isQualified) {
		this.isQualified = isQualified;
	}

	public Boolean getIsWinner() {
		return isWinner;
	}

	public void setIsWinner(Boolean isWinner) {
		this.isWinner = isWinner;
	}

	public HashMap<Integer, Integer> getQtyDiscountMap() {
		return qtyDiscountMap;
	}

	public void setQtyDiscountMap(HashMap<Integer, Integer> qtyDiscountMap) {
		this.qtyDiscountMap = qtyDiscountMap;
	}
	

}
