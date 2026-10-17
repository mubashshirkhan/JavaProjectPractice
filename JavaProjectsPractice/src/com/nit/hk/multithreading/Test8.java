package com.nit.hk.multithreading;
/**
 * Thread execution algorithms 
 * 	1. Thread scheduling
 *  2. Thread priority
 *  
 */


class MyThread16 extends Thread {
	@Override
	public void run() {
		for(int i=1; i<=20; i++) {
			System.out.println("run  i: " + i);
		}
	}
}

public class Test8{
	public static void main(String[] args) {
		
		MyThread16 mt1 = new MyThread16();
		mt1.start();
		
		for(int i=1; i<=20; i++) {
			System.out.println("main i: "+ i);
		}
		
	}
}