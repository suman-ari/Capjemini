package com.main;

//import jnr.ffi.annotations.In;

import java.util.*;
import java.util.stream.Collectors;

public class Permute_All_List_Numbers {


    public static <T> List<List<T>> getPermutations(List<T> es){

        List<List<T>> permutations = new ArrayList<List<T>>();

        if(es.isEmpty()){
            return permutations;
        }

        // We add the first element
        permutations.add(new ArrayList<T>(Arrays.asList(es.get(0))));

        // Then, for all elements e in es (except from the first)
        for (int i = 1, len = es.size(); i < len; i++) {
            T e = es.get(i);

            // We take remove each list l from 'permutations'
            for (int j = permutations.size() - 1; j >= 0; j--) {
                List<T> l = permutations.remove(j);

                // And adds a copy of l, with e inserted at index k for each position k in l
                for (int k = l.size(); k >= 0; k--) {
                    ArrayList<T> ts2 = new ArrayList<>(l);
                    ts2.add(k, e);
                    permutations.add(ts2);
                }
            }
        }
        return permutations;
    }
    public static void main(String args[]) {
        int[] numbers = {1, 9, 4, 3};
        List<Integer> array = Arrays.stream(numbers).boxed().collect(Collectors.toList());
       List<List<Integer>> copy =  getPermutations(array);
        System.out.println(copy);
    }
}
