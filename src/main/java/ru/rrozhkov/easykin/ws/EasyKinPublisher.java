package ru.rrozhkov.easykin.ws;

import javax.xml.ws.Endpoint;

public class EasyKinPublisher {
	public static void main(String[] args){
		System.out.println("Publish EasyKinService: http://localhost:8081/EasyKinService/");
		Endpoint.publish("http://localhost:8081/EasyKinService/", new EasyKinService());
	}
}