package com.yu;

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

	// 合并
	public static int[] merge(int[] arr1, int[] arr2) {
		int arr1_length = arr1.length;
		int arr2_length = arr2.length;
		int[] arr = new int[arr1_length + arr2_length];
		int i = 0;
		int j = 0;
		for (int h = 0; h < arr1_length + arr2_length; h++) {
			if (i == arr1_length && j == arr2_length) {
				break;
			} else if (i == arr1_length) {
				arr[h] = arr2[j];
				j++;
			} else if (j == arr2_length) {
				arr[h] = arr1[i];
				i++;
			} else if (arr1[i] < arr2[j]) {
				arr[h] = arr1[i];
				i++;
			} else {
				arr[h] = arr2[j];
				j++;
			}
		}
		return arr;
	}

	// 将arr拆成两个小的
	public static int[] getArr1(int[] arr) {
		int mid = (0 + arr.length) / 2;
		int[] arr1 = new int[mid];
		System.arraycopy(arr, 0, arr1, 0, mid);
		return arr1;
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
