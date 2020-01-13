package com.lti.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	@Id
	@Column(name="order_id")
	private int orderId;
	@Column(name="order_date")
	private Date orderDate;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="order_product",
			   joinColumns={@JoinColumn(name="order_id")},
			   inverseJoinColumns={@JoinColumn(name="product_id")}	)
	private List<Products> products = new ArrayList<Products>();

	public Orders() {
		
	}
	public Orders(int orderId, Date orderDate, List<Products> products) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.products = products;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	
}
