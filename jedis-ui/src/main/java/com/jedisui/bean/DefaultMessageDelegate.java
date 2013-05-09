package com.jedisui.bean;

import java.io.Serializable;
import java.util.Map;

public class DefaultMessageDelegate implements MessageDelegate {

	public void handleMessage(String message) {
		System.out.println("recevied message : "+message);
	}

	public void handleMessage(Map message) {
		System.out.println("recevied message : "+message);
		// TODO Auto-generated method stub

	}

	public void handleMessage(byte[] message) {
		System.out.println("recevied message : "+message);
		// TODO Auto-generated method stub

	}

	public void handleMessage(Serializable message) {
		System.out.println("recevied message : "+message);
		// TODO Auto-generated method stub

	}

	public void handleMessage(Serializable message, String channel) {
		System.out.println(channel+"recevied message : "+message);
		// TODO Auto-generated method stub

	}

}
