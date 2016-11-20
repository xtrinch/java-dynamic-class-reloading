package com.javaclassloadingexample;

public class MyStaticClass {
	public static int myNumber = 8;
	public int myInstanceNumber = -6;
	public static void printANumber() {
		System.out.println("My number is: " + myNumber);
	}
	public void printAnInstanceNumber() {
		System.out.println("My number is: " + myInstanceNumber);
	}
}
