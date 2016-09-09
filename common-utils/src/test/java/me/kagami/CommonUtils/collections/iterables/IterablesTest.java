package me.kagami.CommonUtils.collections.iterables;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class IterablesTest {
	@Test
	public void test() {
		List<String> list = Lists.newArrayList();

		list.add("f");
		list.add("b");
		list.add("a");
		list.add("c");
		list.add("a");
		list.add("d");
		List<Integer> list2 = Lists.newArrayList();
		list2.add(1);
		list2.add(2);
		list2.add(31);
		list2.add(14);

		// //串联多个iterables的懒视图*
		// Iterable<? extends Object> concat = Iterables.concat(list,list2);
		//
		// for (Iterator iterator = concat.iterator(); iterator.hasNext();) {
		// Object integer = iterator.next();
		// System.out.println(integer);
		// //会删掉原来的东西
		// iterator.remove();
		// }

		// 返回对象在iterable中出现的次数
		System.out.println(Iterables.frequency(list, "a"));

		// 把iterable按指定大小分割，得到的子集都不能进行修改操作
		Iterable<List<String>> partition = Iterables.partition(list, 2);
		for (List<String> list3 : partition) {
			// [f, b][a, c][a, d]
			System.out.println(list3);

		}

		
//		FluentIterable 是guava集合类中常用的一个类，主要用于过滤、转换集合中的数据；
//		FluentIterable 是一个抽象类，实现了Iterable接口，大多数方法都返回FluentIterable对象，这也是guava的思想之一。
		FluentIterable<String> filter = FluentIterable.from(list).filter(new Predicate<String>() {
			public boolean apply(String str) {
				return str.equals("a");
			}
		});
		for (String string : filter) {
			System.out.println(string);
		}
	}

}
