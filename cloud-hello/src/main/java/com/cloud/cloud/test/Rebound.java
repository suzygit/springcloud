package com.cloud.cloud.test;

import java.util.HashMap;
import java.util.Map;

public class Rebound {
	
	private static int a = 100;//总高度
	private static int num = 0;//初始反弹次数
	private static int b = 0;//反弹高度
	private static int c = 0;//反弹总米数
	
	public static int getB() {
		return b;
	}

	public static void setB(int b) {
		Rebound.b = b;
	}

	public static int getC() {
		return c;
	}

	public static void setC(int c) {
		Rebound.c = c;
	}

	public static Rebound res(int n){
		Rebound r = new Rebound();
		Map<String,Object> map = new HashMap<String,Object>();
		if(a !=0 && num<n){
			a=a/2;
			b=a;
			c=c+a*2+b;
			n--;
			res(n);
		}
		r.setB(b);
		r.setC(c);
		return r;
	}

	public static void main(String[] args) {
		Rebound r = res(2);
		System.out.println(r.getB()+" " +r.getC());
	}
	
	

}
