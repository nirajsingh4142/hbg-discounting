package com.hbg.otc.discounting.business.rules.test;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.hbg.otc.discounting.BaseTest;
import com.hbg.otc.discounting.model.Coupon;
import com.hbg.otc.discounting.model.Customer;
import com.hbg.otc.discounting.model.Item;
import com.hbg.otc.discounting.model.Order;
import com.hbg.otc.discounting.util.factories.ModelFactory;

public class OrderDiscountTest extends BaseTest {

	public static void main(String[] args) {
		System.out.println( "Bootstrapping the Rule Engine ..." );

		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession =  kContainer.newKieSession();
		Order o = ModelFactory.getOrderWithFiveHighRangeItems();

		kSession.insert(o.getCustomer());

		kSession.insert(o.getOrderLines().get(0));
		kSession.insert(o.getOrderLines().get(1));
		kSession.insert(o.getOrderLines().get(2));
		kSession.insert(o.getOrderLines().get(3));
		kSession.insert(o.getOrderLines().get(4));
		kSession.insert(o.getOrderLines().get(0).getItem());
		kSession.insert(o.getOrderLines().get(1).getItem());
		kSession.insert(o.getOrderLines().get(2).getItem());
		kSession.insert(o.getOrderLines().get(3).getItem());
		kSession.insert(o.getOrderLines().get(4).getItem());
		kSession.insert(o);

		Collection<Coupon> coupons = getFactsFromKieSession(kSession, Coupon.class);

		int fired = kSession.fireAllRules();
		System.out.println( "Number of Rules executed = " + fired );
		System.out.println( "Customer Category = " + o.getCustomer().getCategory() );
		System.out.println( "Item Category 0 = " + o.getOrderLines().get(0).getItem().getCategory() );
		System.out.println( "Item Category 4 = " + o.getOrderLines().get(4).getItem().getCategory() );
		System.out.println( "Coupon size = " + coupons.size());

		System.out.println( "Discount = " + o.getDiscount().getPercentage() );
	}
}
