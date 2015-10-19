package com.ai.linkedin;

import java.util.*;
import com.ai.linkedin.*;

/**
* Given a nested list of integers, returns the sum of all integers 
* in the list weighted by their reversed depth.
* 
* For example, given the list {{1,1},2,{1,1}} the deepest level is 2. 
* Thus the function should return 8 
* (four 1's with weight 1, one 2 with weight 2)
* 
* Given the list {1,{4,{6}}} the function should return 17 
* (one 1 with weight 3, one 4 with weight 2, and one 6 with weight 1)
*/

public class NestedMath implements NestedInteger{
	List<NestedInteger> list;
	Integer i;
	
	public NestedMath(Integer i) {
		this.list = null;
		this.i = i;
	}
	
	public NestedMath(List<NestedInteger> list) {
		this.i = null;
		this.list = list;
	}
	
	/** @return true if this NestedInteger holds a single integer, rather than a nested list */
	@Override
	public boolean isInteger() {
	   if(i == null)
		   return(false);
	   
	   return(true);
	}

	/** @return the single integer that this NestedInteger holds, if it holds a single integer
	* Return null if this NestedInteger holds a nested list */
	@Override
	public Integer getInteger() {
		if(isInteger())
			return(i);
		
		return(null);
	}

	/** @return the nested list that this NestedInteger holds, if it holds a nested list
	* Return null if this NestedInteger holds a single integer */
	@Override
	public List<NestedInteger> getList() {
		if(!isInteger())
			return(list);
		
		return(null);
	}
	
	private static int maxDepth = 0;
	private static int currDepth = 0;
	
	public static void calcMaxDepth(List<NestedInteger> input, int depth) {
		if(depth > maxDepth) 
			maxDepth = depth;
		
		for(NestedInteger ni: input) {
			if(!ni.isInteger()) {
				calcMaxDepth(ni.getList(),depth+1);
			}
		}
	}
	
	public static int reverseDepthSum(List<NestedInteger> input) {
		int sum = 0;
		
		// First calculate the max depth
		if(maxDepth == 0)
			calcMaxDepth(input, 1);
		
		for(NestedInteger ni: input) {
			if(ni.isInteger()) {
				sum += ni.getInteger().intValue() * (maxDepth - currDepth);
			}
			else {
				++currDepth;
				sum += reverseDepthSum(ni.getList());
				--currDepth;
			}
		}
		
		return(sum);
	}
	
//	public static void main(String[] args) {
//		NestedInteger ni1 = new NestedMath(1);
//		NestedInteger ni2 = new NestedMath(2);
//		List<NestedInteger> ones = new ArrayList<NestedInteger>();
//		ones.add(ni1);
//		ones.add(ni1);
//		NestedInteger niOne = new NestedMath(ones);
//		
//		List<NestedInteger> input = new ArrayList<NestedInteger>();
//		input.add(niOne);
//		input.add(ni2);
//		input.add(niOne);
//		
//		System.out.println(reverseDepthSum(input));
//	}
}
