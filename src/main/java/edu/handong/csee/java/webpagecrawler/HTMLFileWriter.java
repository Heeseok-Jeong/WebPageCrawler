package edu.handong.csee.java.webpagecrawler;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class HTMLFileWriter {
	private String savePath;
	private String html;

	public HTMLFileWriter(String savePath) {
		this.savePath = savePath;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public void writeHtml() {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(savePath), "UTF8"));
			bw.write(html); 
			bw.close();
		} catch (IOException e) {
			System.err.println(e); // 에러가 있다면 메시지 출력
			System.exit(1);
		}
	}
}

