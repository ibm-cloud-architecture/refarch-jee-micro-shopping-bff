package com.ibm.casepcconfig5.microservice.cbbean;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.MalformedURLException;
import java.io.IOException;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;

import java.net.URL;


@ApplicationScoped
public class CircuitBreakerBean {
	
	private int counterCustomerService = 0;
	private int counterProductService = 0;

	@CircuitBreaker(successThreshold = 5, requestVolumeThreshold = 4, failureRatio=0.75,delay = 10000)
	public HttpURLConnection invokeCategoryService(String urlStr, String authString, String type) throws MalformedURLException, IOException{
		
		HttpURLConnection conn = null;
		
		try {
			counterProductService++;
			System.out.println("counterProductService : " + counterProductService);
			URL url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn = setRequestProperty(conn, authString, type);
			
			conn.connect();
			
		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException");
			throw e;
		} catch (IOException e) {
			System.out.println("IOException");
			throw e;
		}
			
		return conn;
	}
	
	@CircuitBreaker(successThreshold = 5, requestVolumeThreshold = 4, failureRatio=0.75,delay = 10000)
	public HttpURLConnection invokeCustomerService(String urlStr, String authString, String type) throws MalformedURLException, IOException{
		
		HttpURLConnection conn = null;
		
		try {
			counterCustomerService++;
			System.out.println("counterCustomerService : " + counterCustomerService);
			URL url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn = setRequestProperty(conn, authString, type);
			
			conn.connect();
			
		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException");
			throw e;
		} catch (IOException e) {
			System.out.println("IOException");
			throw e;
		}
			
		return conn;
	}
	
	
	private HttpURLConnection setRequestProperty(HttpURLConnection conn, String authString, String type)
			throws ProtocolException {
		conn.setRequestProperty("authorization", authString);
		conn.setRequestMethod(type);
		conn.setRequestProperty("Accept", "application/json");
		if (!"GET".equals(type) && !"DELETE".equals(type)) {
			conn.setRequestProperty("Content-Type", "application/json");
		}
		return conn;
	}
	
}
