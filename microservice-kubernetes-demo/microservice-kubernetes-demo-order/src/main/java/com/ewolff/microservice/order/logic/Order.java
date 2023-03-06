package com.ewolff.microservice.order.logic;

import java.util.ArrayList;
import java.util.List;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.ewolff.microservice.order.clients.CatalogClient;

@DynamoDBTable(tableName = "orderkub")
public class Order {

	@DynamoDBHashKey
	private String id;
	@DynamoDBAttribute
	private String customerId;

	@DynamoDBAttribute
	private List<OrderLine> orderLine;

	@DynamoDBAttribute
	private int numberOfLines;

	public Order() {
		super();
		orderLine = new ArrayList<OrderLine>();
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public List<OrderLine> getOrderLine() {
		return orderLine;
	}

	public Order(String customerId) {
		super();
		this.customerId = customerId;
		this.orderLine = new ArrayList<OrderLine>();
	}

	public void setOrderLine(List<OrderLine> orderLine) {
		this.orderLine = orderLine;
	}

	public void addLine(int count, String itemId) {
		this.numberOfLines++;
		this.orderLine.add(new OrderLine(count, itemId));
	}

	public int getNumberOfLines() {
		return numberOfLines;
	}

	public double totalPrice(CatalogClient itemClient) {
		return orderLine.stream()
				.map((ol) -> ol.getCount() * itemClient.price(ol.getItemId()))
				.reduce(0.0, (d1, d2) -> d1 + d2);
	}

	public void setCustomer(String customerId) {
		this.customerId = customerId;
	}

	public void setNumberOfLines(int numberOfLines){
		this.numberOfLines = numberOfLines;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);

	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
}
