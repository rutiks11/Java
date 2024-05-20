package com.app.entities;

public class Doctor {
	int did;
	String name;
	Speciality sp;

	public Doctor(int did, String name, Speciality sp) {
		super();
		this.did = did;
		this.name = name;
		this.sp = sp;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Speciality getSp() {
		return sp;
	}

	public void setSp(Speciality sp) {
		this.sp = sp;
	} 
	
	@Override
	public String toString() {
		return "Doctor [did=" + did + ", name=" + name + ", sp=" + sp + "]";
	}
}
