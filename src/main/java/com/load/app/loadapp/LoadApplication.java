package com.load.app.loadapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class LoadApplication extends SpringBootServletInitializer {

	public static String payload;
	public static int count = 0;

	public static void main(String[] args) {
		SpringApplication.run(LoadApplication.class, args);
		payload = generateString();
	}

	public static String generateString(){
		StringBuilder a= new StringBuilder("{ \"querystoResponse\": { \"items\": [");
		for(int i= 0; i < 5000; i++){
			a.append("{ \"poNumber\": \"5500018304\", \"poItemNumber\": \"00010\", \"approvalStatus\": \"Waiting For Approval From Celcom\", \"shortText\": \"RCARD-RM 30-2IN1-GST B\", \"material\": \"000000000020008673\", \"supplyingPlant\": \"8000\", \"plant\": \"8202\", \"quantity\": \"2\", \"qtyGoodsIssue\": \"2\", \"qtyGoodsReceipts\": \"2\" },");
		}
		a.append("{ \"poNumber\": \"5500018304\", \"poItemNumber\": \"00010\", \"approvalStatus\": \"Waiting For Approval From Celcom\", \"shortText\": \"RCARD-RM 30-2IN1-GST B\", \"material\": \"000000000020008673\", \"supplyingPlant\": \"8000\", \"plant\": \"8202\", \"quantity\": \"2\", \"qtyGoodsIssue\": \"2\", \"qtyGoodsReceipts\": \"2\" }");
		a.append(" ] } }");
		return a.toString();
	}

}

