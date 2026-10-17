package com.nit.hk.multithreading;

class MyThread3 implements Runnable
{
	@Override
	public void run(){
		
		for(int i = 20; i>=1; i++){
			
			System.out.println("run i: "+i);
		}
	}
}

class  Test001
{
	public static void main(String[] args) 
		
	{
		MyThread2 th1 = new MyThread2();
		
		Thread t1 = new Thread(th1);
		t1.start();
		
		for(int i =1; i<=20; i++){
			
			System.out.println("main i: "+i);
		}
	}
		
}
