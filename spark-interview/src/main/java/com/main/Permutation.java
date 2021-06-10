package com.main;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	
	public static List<List<Integer>> list;
	
	public static void permute(int[] arr, int current_index)
	{
		if(current_index == arr.length)
		{
			List<Integer> combination = new ArrayList<Integer>();
			for(int j=0; j< arr.length; j++)
			{
				combination.add(j,arr[j]);
			}
			
			list.add(combination);
			
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
		
		list = new ArrayList<List<Integer>>();
		
		if(arr.length!=0)
		{
			permute(arr, 0);
		}
		
		System.out.println(list);
	}

}
