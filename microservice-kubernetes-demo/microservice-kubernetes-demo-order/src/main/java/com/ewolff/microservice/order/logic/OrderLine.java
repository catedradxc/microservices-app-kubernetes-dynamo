package com.ewolff.microservice.order.logic;



import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@DynamoDBDocument
public class OrderLine {

	@DynamoDBAttribute
	private int count;

	@DynamoDBAttribute
	private String itemId;

	@DynamoDBHashKey
	private String id;

	public void setCount(int count) {
		this.count = count;
	}

	public void setItemId(String item) {
		this.itemId = item;
	}

	public OrderLine() {
	}

	public OrderLine(int count, String item) {
		this.count = count;
		this.itemId = item;
	}

	public int getCount() {
		return count;
	}

	public String getItemId() {
		return itemId;
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
