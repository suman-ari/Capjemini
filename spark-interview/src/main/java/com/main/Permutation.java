package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
	
	public static List<int[]> list;
	//public static int count = 0;
	
	public static void permute(int[] arr, int current_index)
	{
		if(current_index == arr.length)
		{
			int[] combination = new int[arr.length];
			for(int j=0; j< arr.length; j++)
			{
				combination[j]=arr[j];
			}
			
			//list[count]=combination;
			list.add(combination);
			//count++;
		}
		else
		{
			for(int j=current_index; j< arr.length; j++)
			{
				swap(arr,j,current_index);
				permute(arr,current_index+1);
				swap(arr,j,current_index);
			}
		}
	}

	public static void swap(int[] arr, int j, int current_index) {
		int temp=arr[current_index];
		arr[current_index] = arr[j];
		arr[j]=temp;
		
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4 };
		
		/*
		 * int factorial = 1;
		 * 
		 * for(int n=1;n<=arr.length;n++) { factorial = factorial*n; }
		 */
		
		//list = new int[factorial][];
		list = new ArrayList<int[]>();
		
		if(arr.length!=0)
		{
			permute(arr, 0);
		}
		
		System.out.print("[");
		
		
		
		for(int[] a: list)
		{
			System.out.print(Arrays.toString(a)+",");
		}
		System.out.print("]");
	}

}
