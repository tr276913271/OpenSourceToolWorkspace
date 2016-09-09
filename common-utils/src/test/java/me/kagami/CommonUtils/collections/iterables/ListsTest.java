package me.kagami.CommonUtils.collections.iterables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class ListsTest {
	@Test
	public void test() {
		//转换为list集合，没啥卵用，JDK Arrays有类似功能
		Integer[] is = new Integer[]{1,2,3};
		List<Integer> asList = Lists.asList(1, is);
		System.out.println(asList);
		asList = Arrays.asList(is);
		System.out.println(asList);
		
		
		//笛卡尔积
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(2);
		List<Integer> l2 = new ArrayList<>();
		l2.add(3);
		l2.add(4);
		List<List<Integer>> cartesianProduct = Lists.cartesianProduct(l1,l2);
		System.out.println(cartesianProduct);
		
		
		List<Integer> countDown = Lists.reverse(l1); // {2, 1}

	}
}
