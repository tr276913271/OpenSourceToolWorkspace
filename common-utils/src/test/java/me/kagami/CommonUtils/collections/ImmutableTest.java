package me.kagami.CommonUtils.collections;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
/**
 * 所有Guava不可变集合的实现都不接受null值。
 * @author Tian
 *
 */
public class ImmutableTest {
	public static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of("red", "orange", "yellow", "green", "blue", "purple");
	
	@Test
	public void test() {
		//所有不可变集合都有一个asList()方法提供ImmutableList视图，来帮助你用列表形式方便地读取集合元素
		System.out.println(COLOR_NAMES.asList().toString());
		
		List<String> temp = new ArrayList<>();
		temp.add("a");
		temp.add("b");
		temp.add("c");
		ImmutableList<String> list = ImmutableList.copyOf(temp);
		temp.add("e");
		System.out.println(list);
		//不可变的有序集
		ImmutableSortedSet< Integer> set = ImmutableSortedSet.of(3,1,4,6,5,9,7);
		System.out.println(set.asList());
		System.out.println(set.asList().get(2));
	}
}
