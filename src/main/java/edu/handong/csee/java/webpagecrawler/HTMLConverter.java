package edu.handong.csee.java.webpagecrawler;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
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

	void mergeReadLine() {
		try {
			URL page = new URL(url);
			DataInputStream dis = new DataInputStream(page.openStream());
			String inputLine;
			while ((inputLine = dis.readLine()) != null) {
				contentsOfFile += inputLine; //+ "\n";
			}
			dis.close();
		} catch (MalformedURLException me) {
			System.out.println("MalformedURLException: " + me);
		} catch (IOException ioe) {
			System.out.println("IOException: " + ioe);
		}
	}
	
}
