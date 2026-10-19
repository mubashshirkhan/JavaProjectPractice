package com.nit.hk.multithreading;

class Mythread20 extends Thread{

	@Override
	public void run() {
		
		System.out.println("In run #3: "+this.getState());
		try {
			Thread.sleep(5000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Run end");
		
	}
}
public class Test10 {
	public static void main(String[] args) throws InterruptedException {
		
		Mythread20 mt1 = new Mythread20();
		
		System.out.println("In main #1: "+mt1.getState());
		
		mt1.start();
		System.out.println("In main #2: "+mt1.getState());
		
		Thread.sleep(2000);
		System.out.println("In main #4: "+mt1.getState());
		
		Thread.sleep(7000);
		System.out.println("In main #5: "+mt1.getState());
		
		System.out.println("main end");
	}
}
