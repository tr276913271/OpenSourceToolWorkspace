package me.kagami.CommonUtils.collections.iterables;

import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;

public class MultisetsTest {
	@Test
	public void test() {
		Multiset<String> superMultiset = HashMultiset.create();
		Multiset<String> subMultiset = HashMultiset.create();
		
		superMultiset.add("a");
		superMultiset.add("a");
		superMultiset.add("a");
		superMultiset.add("a");
		superMultiset.add("b");
		superMultiset.add("b");
		superMultiset.add("b");
		
		subMultiset.add("a");
		subMultiset.add("b");
		subMultiset.add("b");
		//Returns true if subMultiset.count(o) <= superMultiset.count(o) for all o.
		System.out.println(Multisets.containsOccurrences(superMultiset, subMultiset));
		
		
		//大集合中删除小集合
//		Multisets.removeOccurrences(superMultiset, subMultiset);
//		System.out.println(superMultiset);
		
		//交集 
		System.out.println(Multisets.intersection(superMultiset, subMultiset));
		//返回Multiset的不可变拷贝，并将元素按重复出现的次数做降序排列
		System.out.println(Multisets.copyHighestCountFirst(superMultiset));
		
	}

}
