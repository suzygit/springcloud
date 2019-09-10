package com.cloud.cloud.test;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {95,85,12,52,64,74,105,502,4,7,6,1,74,60,141,19,34,45,59};
		BubbleSort(arr);
		System.out.println(arr[0]);
	}
	//一次排序可以确定两个值，正向扫描找到最大值交换到最后，反向扫描找到最小值交换到最前面
	public static void BubbleSort(int arr[])
	{
		int i = 0;
		int j = 0;
		int n = 0;//同时找最大值的最小需要两个下标遍历
		int flag = 0;
		int pos = 0;//用来记录最后一次交换的位置
		int k = arr.length - 1;
		for (i = 0; i < arr.length - 1; i++)//确定排序趟数
		{
			pos = 0;
			flag = 0;
			//正向寻找最大值
			for (j = n; j < k; j++)//确定比较次数
			{
				if (arr[j]>arr[j + 1])
				{
					//交换
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					flag = 1;//加入标记
					pos = j;//交换元素，记录最后一次交换的位置
				}
			}
			if (flag == 0)//如果没有交换过元素，则已经有序,直接结束
			{
				return;
			}
			k = pos;//下一次比较到记录位置即可
			//反向寻找最小值
			for (j = k; j > n; j--)
			{
				if(arr[j]<arr[j-1]){
					int tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
					flag = 1;
				}
			}
			n++;
			if (flag == 0)//如果没有交换过元素，则已经有序,直接结束
			{
				return;
			}
		}
	}

}
