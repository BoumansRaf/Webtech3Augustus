package org.store;

public class Product {
	private String customerName;
	private String  address;
	private String date;
	private String productname;
	private String amount;
	public Product(String customerName, String address, String date, String productname, String amount) {
		super();
		this.customerName = customerName;
		this.address = address;
		this.date = date;
		this.productname = productname;
		this.amount = amount;
	}
	
	public static String buildXML(Product p){
		String xml = "";
		xml += "<product customername=\"" + p.customerName + "\" address=\"";
		xml +=  p.address + "\" date=\"" + p.date + "\" productname=\"" + p.productname + "\"";
		xml += " amount=\"" + p.amount + "\" >";
		return xml;
	}
	
	
}
