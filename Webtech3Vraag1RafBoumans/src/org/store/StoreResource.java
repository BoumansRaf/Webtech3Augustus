package org.store;


import org.restlet.data.Status;

import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;


public class StoreResource extends ServerResource {
	static String filename = "C:\\Users\\Raf\\Documents\\Webtech\\Java\\Webtech3Vraag1RafBoumans\\catalogue.txt";
   public static Products p = new Products(filename);

    @Get("txt")
    public String doGet() {
    
        return Products.buildXML(p.getArr());
    }

    @Post("txt")
    public String doPost(Products p) {

         String xml = Products.buildXML(p.getArr());
         return xml;

        
    }
}