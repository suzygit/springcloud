package com.cloud.cloud.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueHelper {
	
	private static final Integer maxQueueSize = 1000;
	private static BlockingQueue blockingQueue = new LinkedBlockingQueue(maxQueueSize);
	private static ExecutorService threadPool = Executors.newCachedThreadPool();

	public static BlockingQueue getBlockingQueue(){
		if(blockingQueue == null){
			blockingQueue = new LinkedBlockingQueue(maxQueueSize);
		}
		return blockingQueue;
	}
	
	public static void requestQueue(Object object){
		if(blockingQueue != null && blockingQueue.size()< maxQueueSize ){
			if(blockingQueue.offer(object)){
				
			}
		}
	}
	
	
}
