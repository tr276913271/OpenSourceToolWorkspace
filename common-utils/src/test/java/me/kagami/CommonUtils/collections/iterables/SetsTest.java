package me.kagami.CommonUtils.collections.iterables;

import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

public class SetsTest {
	@Test
	public void test(){
		Set<Integer> set1 = Sets.newHashSet(1,2,3);
		Set<Integer> set2 = Sets.newHashSet(2,3,4);
		SetView<Integer> difference = Sets.difference(set2, set1);
		//结果：4   只找出与参数2不同的元素，不包括后面后前面没有的
		System.out.println(difference);
		
		SetView<Integer> union = Sets.union(set1, set2);
		//并集
		System.out.println(union);
		//交集
		SetView<Integer> intersection = Sets.intersection(set1, set2);
		System.out.println(intersection);
		//差集
		SetView<Integer> symmetricDifference = Sets.symmetricDifference(set1, set2);
		System.out.println(symmetricDifference);
		
		//求子集合
		Set<Set<Integer>> powerSet = Sets.powerSet(set1);
		for (Set<Integer> set : powerSet) {
			System.out.println(set);
		}
	}
}
