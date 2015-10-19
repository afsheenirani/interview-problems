package com.ai.linkedin;

import java.util.*;

public class NthLargest {
	public static Integer nthLargest(int n, List<Integer> list) {
		if(list.size() > 0){
			if(n > 0 && n <= list.size()) {
				Collections.sort(list);
				return(list.get(n));
			}
		}
		return(-1);
	}
	
//	public static void main(String[] args) {
//		List<Integer> list = new ArrayList<Integer>();
//		for(int i=0; i< 10; i++) {
//			list.add(i);
//		}
//		
//		for(int i=0; i< 10; i++) {			
//			Collections.shuffle(list);
//			System.out.println("NthLargest for i: " + (i+1) 
//					+ " and list: " + list.toString() 
//					+ " is: " + nthLargest(i, list)
//			);
//		}
//	}
}
