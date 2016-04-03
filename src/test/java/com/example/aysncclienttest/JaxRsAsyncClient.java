package com.example.aysncclienttest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;

public class JaxRsAsyncClient {

/*	static WebTarget target = ClientBuilder.newClient().target("http://www-verification.qantas.com.au/api/offers/airports/destinations");
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println(userAsync());
	}
	public static CompletableFuture<String> userAsync() {
		  CompletableFuture<String> completableFuture = new CompletableFuture<>();
		  target.request().async()
		      .get(new InvocationCallback<String>() {
		        @Override
		        public void completed(String String) {
		          completableFuture.complete(String);
		        }

		        @Override
		        public void failed(Throwable throwable) {
		          completableFuture.completeExceptionally(throwable);
		        }
		      });
		  return completableFuture;
	}*/
}
