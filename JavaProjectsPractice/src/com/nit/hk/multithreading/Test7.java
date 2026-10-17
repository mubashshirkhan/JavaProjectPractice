package com.nit.hk.multithreading;
/**
 * - isAlive()
 * 	- it returns true, if the thread is live
 *  - else returns false
 *   
 *  - after start() method call, and 
 *    before run() method completed 
 *    the thread is called live thread 
 *  
 *  - when thread is in 
 *  	RUNNABLE, T_W, W and Blocked 
 *    states it is called live thread
 *    
 *  - when thread is in 
 *  	NEW and TERMINATED 
 *    states it is called not live thread
 *    
 * Below program explains above points   
 */

class MyThread15 extends Thread {
	@Override
	public void run() {
		System.out.println("In run  #3: "+ this.getState() + "\t\t" + this.isAlive());
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) { }
	}
}

public class Test7 {
	public static void main(String[] args) throws InterruptedException {
		MyThread15 mt  = new MyThread15();
		System.out.println("In main #1 : "+ mt.getState() + "\t\t\t" + mt.isAlive());
		
		mt.start();
		System.out.println("In main #2 : "+ mt.getState() + "\t\t" + mt.isAlive());

		Thread.sleep(2000);
		System.out.println("In main #4 : "+ mt.getState() + "\t" + mt.isAlive());

		Thread.sleep(7000);
		System.out.println("In main #5 : "+ mt.getState() + "\t\t" + mt.isAlive());
	}
}