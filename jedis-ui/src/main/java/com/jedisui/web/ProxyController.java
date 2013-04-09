package com.jedisui.web;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ProxyController {
	
	@RequestMapping("proxy")
	public void proxy(String url,OutputStream os){
		try {
			System.out.println(Request.Get(url).execute().returnContent().asString());
			IOUtils.write(Request.Get(url).execute().returnContent().asString(), os);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		String r;
		try {
			r = Request.Get("http://118.142.39.93:8080/BetService.asmx?wsdl").execute().returnContent().asString();
			System.out.println(r);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("toproxy")
	public String toproxy(){
		return "proxy";
	}
}
