package org.store;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Products {
private ArrayList<Product> arr;
private String catalogue;
public Products( String catalogue) {
	this.arr = new ArrayList<Product>();
	this.catalogue = catalogue;
	Product p = new Product("Raf", "Borgerhout", "25/11/2017", "Gameboy", "1");
	arr.add(p);
}
public ArrayList<Product> getArr() {
	return arr;
}
public void setArr(ArrayList<Product> arr) {
	this.arr = arr;
}
public String getCatalogue() {
	return catalogue;
}
public void setCatalogue(String catalogue) {
	this.catalogue = catalogue;
}

public static String buildXML(ArrayList<Product> arr){
	String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><products>";
	for (int i = 0; i < arr.size(); ++i){
		Product p = arr.get(i);
		
		xml +=  Product.buildXML(p);
		
	}
	xml += "</products>";
	return xml;
}

private void writeFile(String data)
{
    try (Writer writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(catalogue), "utf-8"))) {
        writer.write(data);
    } catch(Exception ex)
    {
        ex.printStackTrace();
    }
}

public void updateFile(ArrayList<Product> arr)
{
    writeFile(Products.buildXML(arr));
}
}
