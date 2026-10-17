package com.nit.hk.multithreading;
/*
 * Below program shows threads execution based on their priority
 */
class MyThread17 extends Thread {
	
	@Override
	public void run() {
		String name = getName();
		for(int i=1; i<=20; i++) {
			System.out.println(name + " run  i: " + i);
		} 
	}
}

public class Test9 {
	
	public static void main(String[] args) {
		
		MyThread17 mt1 = new MyThread17();
		MyThread17 mt2 = new MyThread17();
		
		System.out.println("mt1 priority: "+ mt1.getPriority());
		System.out.println("mt2 priority: "+ mt2.getPriority());
		
		mt1.setPriority(7);
		mt2.setPriority(9);
		//mt2.setPriority(17);
		
		System.out.println("\n mt1 priority: "+ mt1.getPriority());
		System.out.println("mt2 priority: "+ mt2.getPriority());
			
		mt1.start();
		mt2.start();
		
/**/		
	}
}