package com.hbg.otc.discounting.util.factories;

import com.hbg.otc.discounting.model.Order;
import com.hbg.otc.discounting.util.OrderBuilder;

public class OrderFactory {
    
    public static Order getOrderSampleData() {
        
        return new OrderBuilder()
            .newLine()
                .withOrderLineId(1)
                .withItem()
                    .withCost(20.0)
                .end()
                .withAccount()
                	.withAccountNumber(456)
                .end()
                .withProduct()
                	.withIsbn(111)
                	.withProductGroupCode("HC")
                	.withOfferCode(6)
                .end()
                .withQuantity(100)
                .end()
            .end()
            .newLine()
            	.withOrderLineId(2)
            	.withItem()
	                .withCost(20.0)
	            .end()
	            .withAccount()
	            	.withAccountNumber(456)
	            .end()
	            .withProduct()
	            	.withIsbn(222)
	            	.withProductGroupCode("PB")
	            	.withOfferCode(6)
	            .end()
	            .withQuantity(200)
	            .end()
	        .end()
        .build();
    }
    
}
