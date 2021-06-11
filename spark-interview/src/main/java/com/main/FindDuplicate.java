package com.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * class to find duplicate value in an array
 * @author Suman
 *
 */
public class FindDuplicate {
	
	/* method to find duplicate entry in an integer array */
	public static int duplicate(List<Integer> list,int size) throws Exception
	{
		int result = -1;
		/* checking size of array, if does not match then throw exception */
		if (list.size() != size) {
			throw new Exception("array size does not match with number of input data");
		} else {
			/* Sorting integer list */
			Collections.sort(list);
			
			/* if two consecutive numbers are same then break out and print the value */
			for(int i=0;i<list.size()-1;i++)
			{
				if(list.get(i) == list.get(i+1))
				{
					result =  list.get(i);
					break;
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);
		
		/* size of array from console input */
		int size = in.nextInt();

		/* array elements input from console */
		String input[] = in.next().split(",");
		
		/* converting array to List of integers */
		List<Integer> list = Arrays.stream(input).map(n -> Integer.parseInt(n)).collect(Collectors.toList());

		/* calling function to find the duplicate value */
		int value = duplicate(list,size);
		if(value!=-1)
			System.out.println(value);
		
		in.close();
	}

}
