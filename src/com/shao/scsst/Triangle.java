package com.shao.scsst;


public class Triangle {
	private int a,b,c;
	public Triangle(int a,int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public int identify(){
		if (a+b<=c || b+c<=a || a+c<=b || a<=0 || b<=0 || c<=0){
			return -1;//input wrong
		}
		if (a==b || b==c || a==c){
			if (a==b && b==c){
				return 0;//equilateral
			}
			else{
				return 1;//isosceles
			}
		}
		else{
			return 2;//scalene
		}
	}
	
}
