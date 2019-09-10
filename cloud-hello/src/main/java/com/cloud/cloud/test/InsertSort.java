package com.cloud.cloud.test;

public class InsertSort {
	
	public void insertSort(int[] num){
		int i,j;//i有序 j无序
		int temp;//需要插入的元素
		int n = num.length;
		for(i=1;i<n;i++){
			j = i;
			temp=num[i];
			for(;j>0 && temp<num[j-1];j--){
				num[j] = num[j-1];
			}
		}
	}

	public static void main(String[] args) {
		
	}

}
