package com.nit.hk.multithreading;

class Addition{
	
	private int x;
	private int y;
	
	public synchronized void add(int x, int y) {
		
		this.x = x;
		this.y = y;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int res = this.x + this.y;
		System.out.println(Thread.currentThread().getName()+": "+res);
	}
}

class Thread1 extends Thread{
	
	private Addition a;
	
	public Thread1(Addition a) {
		this.a=a;
	}
	@Override
	public void run() {
		a.add(50,60);
	}
}
class Thread2 extends Thread{
	
	private Addition a;
	
	public Thread2(Addition a) {
		this.a=a;
	}
	@Override
	public void run() {
		a.add(70,80);
	}
}

public class Synchronization {
	public static void main(String[] args) {
		
		Addition a1 = new Addition();
		
		Thread th1 = new Thread1(a1);
		Thread th2 = new Thread2(a1);
		
		th1.start();
		th2.start();
		
	}
}
