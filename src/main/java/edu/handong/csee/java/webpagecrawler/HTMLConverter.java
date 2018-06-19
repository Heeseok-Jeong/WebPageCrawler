package edu.handong.csee.java.webpagecrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTMLConverter {
	String contentsOfFile;
	String url;
	
	public String getContentsOfFile() {
		return contentsOfFile;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public void mergeReadLine() {
		URL urls;
        HttpURLConnection conn;
        BufferedReader rd;
        String line;
        try {
            urls = new URL(url);
            conn = (HttpURLConnection) urls.openConnection();
            conn.setRequestMethod("GET");
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = rd.readLine()) != null) {
                contentsOfFile += line + "\n";
            }
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
       

	
//		try {
//			URL page = new URL(url);
//			DataInputStream dis = new DataInputStream(page.openStream());
//			String inputLine;
//			while ((inputLine = dis.readLine()) != null) {
//				contentsOfFile += inputLine + "\n";
//			}
//			dis.close();
//		} catch (MalformedURLException me) {
//			System.out.println("MalformedURLException: " + me);
//		} catch (IOException ioe) {
//			System.out.println("IOException: " + ioe);
//		}
	}
	
}
