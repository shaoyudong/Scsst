package com.shao.scsst;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int a,b,c;
		System.out.println("Please input the sides of the triangle:");
		Scanner input = new Scanner(System.in);
		a = input.nextInt();
		b = input.nextInt();
		c = input.nextInt();
		Triangle triangle = new Triangle(a,b,c);
		int flag = triangle.identify();
		switch (flag){ 
		case -1:
			System.out.println("Your input is wrong!");break;
		case 0:
			System.out.println("It's equilateral");break;
		case 1:
			System.out.println("It's isosceles");break;
		case 2:
			System.out.println("It's scalene");break;
		default:
			break;
		}
	}

}
