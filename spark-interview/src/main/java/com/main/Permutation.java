package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Class to show the permutations the contents of an array
 * @author Suman
 *
 */

public class Permutation {
	
	public static List<List<Integer>> list;
	
	/* method to implement permutation */
	public static void permute(int[] arr, int current_index)
	{
		if(current_index == arr.length)
		{
			List<Integer> combination = Arrays.stream(arr).boxed().collect(Collectors.toList());
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

	/* method to swap values */
	public static void swap(int[] arr, int j, int current_index) {
		int temp=arr[current_index];
		arr[current_index] = arr[j];
		arr[j]=temp;
		
	}

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);
		
		/* size of array from console input */
		int size = in.nextInt();

		/* array elements input from console */
		String input[] = in.next().split(",");
		
		List<Integer> inputList = Arrays.stream(input).map(n->Integer.parseInt(n)).collect(Collectors.toList());
		
		if (inputList.size() != size) {
			throw new Exception("array size does not match with number of input data");
		}
		
		/* converting to integer array */
		int[] arr = inputList.stream().mapToInt(i->i).toArray();
		
		list = new ArrayList<List<Integer>>();
		
		if(arr.length!=0)
		{
			permute(arr, 0);
		}
		
		System.out.println(list);
		
		in.close();
	}

}
