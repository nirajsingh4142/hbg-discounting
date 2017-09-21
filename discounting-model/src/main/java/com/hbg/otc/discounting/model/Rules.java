/**
 * 
 */
package com.hbg.otc.discounting.model;

/**
 * @author raghav.rampal
 *
 */
public class Rules {

	private Account account;

	private Product product;

	private Discount discount;

	private Offer offer;

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

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	

}
