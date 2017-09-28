/**
 * 
 */
package com.hbg.otc.discounting.model;

/**
 * @author raghav.rampal
 *
 */
public class Terms {
	
	private Integer days;
	private Boolean freeFreight;
	private Boolean chargeFreight;
	
	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Boolean getFreeFreight() {
		return freeFreight;
	}

	public void setFreeFreight(Boolean freeFreight) {
		this.freeFreight = freeFreight;
	}

	public Boolean getChargeFreight() {
		return chargeFreight;
	}

	public void setChargeFreight(Boolean chargeFreight) {
		this.chargeFreight = chargeFreight;
	}

}
