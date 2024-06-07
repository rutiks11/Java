package com.pet.core;

public class Order {
	// orderId=1, petId=101, quantity=5, status=PLACED
	private int oid;
	private int ppetid;
	private int qty;
	private Status status;
	private static int idgenerator;
	
	static 
	{
		idgenerator=1000;
	}

	public Order() {
		super();
	}

	public Order(int ppetid, int qty, Status status) {
		super();
		this.oid = ++idgenerator;
		this.ppetid = ppetid;
		this.qty = qty;
		this.status = status;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getPpetid() {
		return ppetid;
	}

	public void setPpetid(int ppetid) {
		this.ppetid = ppetid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", ppetid=" + ppetid + ", qty=" + qty + ", status=" + status + "]";
	}
	
	
	
}
