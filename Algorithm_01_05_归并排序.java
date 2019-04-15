﻿package com.yu;

import java.util.Arrays;
import java.util.Random;

public class Algorithm_01_05_归并排序 {

	public static void main(String[] args) {
		int[] arr = generateRandomArray(10, 0, 10);
		System.out.println(Arrays.toString(arr));
		int[] afterSort = mergeSort(arr);
		System.out.println(Arrays.toString(afterSort));
		///////////////////////////////////////////////
		// 测试合并
		// int[] i = { 1, 3, 5 };
		// int[] j = { 2, 4, 6 };
		// int[] h = __merge(i, j);
		// System.out.println(Arrays.toString(h));
		///////////////////////////////////////////////
		// 测试分组
		// int[] arr = { 8, 10, 2, 8, 0 };
		// System.out.println(Arrays.toString(arr));
		// int length = arr.length;
		// int mid = length / 2;
		// int[] arr1 = new int[mid];
		// int[] arr2 = new int[length - mid];
		// System.arraycopy(arr, 0, arr1, 0, mid);
		// System.arraycopy(arr, mid, arr2, 0, length - mid);
		// System.out.println(Arrays.toString(arr1));
		// System.out.println(Arrays.toString(arr2));
	}

	

	
	public static int[] getArr2(int[] arr) {
		int length = arr.length;
		int mid = (0 + length) / 2;
		int[] arr2 = new int[length - mid];
		System.arraycopy(arr, mid, arr2, 0, length - mid);
		return arr2;
	}

	// 归并排序
	public static int[] mergeSort(int[] arr) {
		if (arr.length == 1) {
			return arr;
		}
		int[] arr1 = getArr1(arr);
		int[] arr2 = getArr2(arr);
		// 对拆分的arr1和arr2分别进行归并排序，然后将结果合并merge
		int[] arr1_return = mergeSort(arr1);
		int[] arr2_return = mergeSort(arr2);
		int[] arr_merge = merge(arr1_return, arr2_return);
		return arr_merge;
	}

	// 生成有n个元素的随机数组，随机范围为【RangeL，RangeR】
	public static int[] generateRandomArray(int n, int RangeL, int RangeR) {
		int[] arr = new int[n];
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			arr[i] = random.nextInt(RangeR - RangeL + 1) + RangeL;
		}
		return arr;
	}

}
