/**
 * 
 */
package com.hbg.otc.discounting.model;

import java.util.List;

/**
 * @author raghav.rampal
 *
 */
public class Offer {

	private Boolean hardcode;
	
	private Boolean overridenExplicitly;
	
	private Integer priority;
	
	private List<Terms> terms;

	public Boolean getHardcode() {
		return hardcode;
	}

	public void setHardcode(Boolean hardcode) {
		this.hardcode = hardcode;
	}

	public Boolean getOverridenExplicitly() {
		return overridenExplicitly;
	}

	public void setOverridenExplicitly(Boolean overridenExplicitly) {
		this.overridenExplicitly = overridenExplicitly;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public List<Terms> getTerms() {
		return terms;
	}

	public void setTerms(List<Terms> terms) {
		this.terms = terms;
	}
	
}
