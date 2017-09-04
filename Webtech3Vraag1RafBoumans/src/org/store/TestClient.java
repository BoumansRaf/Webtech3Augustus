package org.store;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

public class TestClient{

    public static void main(String[] args) {
        Product p = new Product("Raf", "Borgerhout", "25/11/2017", "Gameboy", "1");
        Product p2 = new Product("Raf", "Borgerhout", "25/11/2018", "Gameboy ADV", "1");
        String filename = "C:\\Users\\Raf\\Documents\\Webtech\\Java\\Webtech3Vraag1RafBoumans\\catalogue.txt";
        Products ps = new Products(filename);
        try {

            URL url = new URL("http://localhost:8182/store/products");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/xml");

            String input = Products.buildXML(ps.getArr());
             

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
