package com.nit.hk.multithreading;
/*
 * Develop a program to print the state names of a custom thread
 */
class MyThread14 extends Thread {
	@Override
	public void run() {
		System.out.println("run start");
		System.out.println("In run  #3: "+ this.getState());
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("run end");
	}
}

class Test6 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("main start");
		
		MyThread14 mt1 = new MyThread14();
		System.out.println("In main #1: "+ mt1.getState());
		
		mt1.start();
		System.out.println("In main #2: "+ mt1.getState());
		
		Thread.sleep(2000);
		System.out.println("In main #4: "+ mt1.getState());
		
		Thread.sleep(7000);
		System.out.println("In main #5: "+ mt1.getState());
		
		System.out.println("main end");
	}
}