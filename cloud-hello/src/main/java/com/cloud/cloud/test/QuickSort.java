package com.cloud.cloud.test;

public class QuickSort {
	
	public static void quickSort(int[] num,int low,int high){
		int temp;//基数
		int i,j;//哨兵
		int t;//临时变量
		if(low>high){
			return;
		}
		temp = num[low];//第一个元素作为基数
		//哨兵赋值
		i=low;
		j=high;
		//循环处理哨兵i,j
		while(i<j){
			//处理哨兵j
			while(temp<=num[j] && i<j){
				j--;
			}
			//处理哨兵i
			while(temp>=num[i] && i<j){
				i++;
			}
			//交换位置
			if(i<j){
				t=num[j];
				num[j]=num[i];
				num[i]=t;
			}
		}
		//基数未和哨兵i,j相同位交换  (开始以num[low]基数位)
		num[low] = num[i];
		num[i] = temp;
		//中位分割循环处理
		//处理分割左边
		quickSort(num,low,j-1);
		//处理分割右边
		quickSort(num,j+1,high);
		
	}
	
	
	

	public static void main(String[] args) {
		int[] num = {1,4,2,7,3,9,4,16,23,5,25,14};
		quickSort(num,0,num.length-1);
		System.out.println(num.length);
		for(int i=0;i<num.length;i++){
			System.out.println(num[i]);
		}
	}

}
