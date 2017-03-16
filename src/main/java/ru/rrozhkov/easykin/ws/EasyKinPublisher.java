package ru.rrozhkov.easykin.ws;

import ru.rrozhkov.easykin.ws.auth.EasyKinAuthService;
import ru.rrozhkov.easykin.ws.task.EasyKinTaskService;

import javax.xml.ws.Endpoint;

public class EasyKinPublisher {
	public static void main(String[] args){
		System.out.println("Publish EasyKinService: http://172.31.46.6:8081/EasyKinService/");
		Endpoint.publish("http://172.31.46.6:8081/EasyKinService/", new EasyKinService());
		System.out.println("Publish EasyKinService: http://172.31.46.6:8081/EasyKinService/auth");
		Endpoint.publish("http://172.31.46.6:8081/EasyKinService/auth", new EasyKinAuthService());
		System.out.println("Publish EasyKinService: http://172.31.46.6:8081/EasyKinService/task");
		Endpoint.publish("http://172.31.46.6:8081/EasyKinService/task", new EasyKinTaskService());
	}
}