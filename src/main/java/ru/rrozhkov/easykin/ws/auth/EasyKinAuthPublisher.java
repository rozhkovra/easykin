package ru.rrozhkov.easykin.ws.auth;

import javax.xml.ws.Endpoint;

public class EasyKinAuthPublisher {
	public static void main(String[] args){
		System.out.println("Publish EasyKinService: http://172.31.46.6:8083/EasyKinAuthService/");
		Endpoint.publish("http://172.31.46.6:8083/EasyKinAuthService/", new EasyKinAuthService());
	}
}