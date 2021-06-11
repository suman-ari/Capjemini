package com.main;

import java.util.Arrays;
import java.util.Scanner;

/**
 * class to reverse the array elements
 * @author Suman
 *
 */
public class Reverse {
	
	/* method to reverse a input string in a character array */
	public static char[] reverse(String input)
	{
		/* assigning string to character array */
		char[] arr = input.toCharArray();
		
		System.out.println("array as per input "+Arrays.toString(arr));
		
		/* iterating till half of the array and swapping with character in the other half */
		for(int i = 0; i < Math.floor(arr.length/2); i++)
		{
			char temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		
		return arr;
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		/* taking string input */
		String input= in.next();
		
		char[] arr = reverse(input);
		
		System.out.println("reversed array "+Arrays.toString(arr));
		
		in.close();
	}

}
