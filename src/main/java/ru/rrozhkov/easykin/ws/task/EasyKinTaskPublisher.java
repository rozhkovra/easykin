package ru.rrozhkov.easykin.ws.task;

import javax.xml.ws.Endpoint;

public class EasyKinTaskPublisher {
	public static void main(String[] args){
		System.out.println("Publish EasyKinService: http://172.31.46.6:8082/EasyKinTaskService/");
		Endpoint.publish("http://172.31.46.6:8082/EasyKinTaskService/", new EasyKinTaskService());
	}
}