package com.sbs.edu.mvc.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getFormImage")
public class GetImageController extends HttpServlet { 
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		System.out.println("hihihihihihihihi~~~~~ ");
		String formPath = "C:\\Users\\01030\\OneDrive\\바탕 화면\\image";
		String baseImgPath = "skull.jpg";	
		String target = baseImgPath + "\\" + formPath; 
		System.out.println("aaaa : \\" + formPath);

		try {
			File imgFile = new File(target);
			
			if(imgFile.exists()) {
				FileInputStream ifo = new FileInputStream(imgFile);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				int readlength = 0;
				String testStr = "";
				
				while((readlength = ifo.read(buf)) != -1) {
					baos.write(buf,0,readlength);
					testStr += buf;
				}
				
				byte[] imgbuf = null;
				imgbuf = baos.toByteArray();
				
				baos.close();
				ifo.close(); 
				
				int length = imgbuf.length;
				
				OutputStream out = response.getOutputStream();
				out.write(imgbuf,0,length);
				out.close();
			} 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
