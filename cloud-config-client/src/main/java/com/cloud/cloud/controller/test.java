package com.cloud.cloud.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {

	public static void main(String[] args) {
		
		ExecutorService fixThreadPool = Executors.newFixedThreadPool(3);
		for(int i=0;i<15;i++)
        {
            fixThreadPool.execute(new Runnable(){

				public void run() {
					try {
						System.out.println(Thread.currentThread().getName()+"正在被执行");
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
            	
            });
        }
//		fixThreadPool.shutdown();

	}

}
