package com.nit.hk.multithreading;

import java.util.Scanner;

public class Example {
	public static void m1() {
		System.out.println("M1 ex starts");
		System.out.println("M1 ex ends");
	} 
	public static void m2() {
		
		System.out.println("M2 ex starts");
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter Your name: ");
		String name = scn.nextLine();
		System.out.println("Name is"+name);
		System.out.println("M2 ex ends");
		
		scn.close();
	}
	public static void m3() {
		System.out.println("M3 ex starts");
		System.out.println("M3 ex ends");
	}
	
}  
