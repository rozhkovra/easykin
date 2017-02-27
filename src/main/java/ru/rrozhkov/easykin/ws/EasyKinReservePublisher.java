package ru.rrozhkov.easykin.ws;

import javax.xml.ws.Endpoint;

public class EasyKinReservePublisher {
	public static void main(String[] args){
		System.out.println("Publish EasyKinService: http://172.31.46.6:8082/EasyKinService/");
		Endpoint.publish("http://172.31.46.6:8082/EasyKinService/", new EasyKinService());
	}
}