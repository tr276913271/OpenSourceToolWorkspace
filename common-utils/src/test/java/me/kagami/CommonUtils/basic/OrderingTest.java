package me.kagami.CommonUtils.basic;

import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

public class OrderingTest {
	@Test
	public void test() {
		List<String> list = Lists.newArrayList();
		list.add("peida");
		list.add("jerry");
		list.add("harry");
		list.add("eva");
		list.add("jhon");
		list.add("neron");
		list.add(null);
		//对可排序类型做自然排序，如数字按大小，日期按先后排序
//		Ordering<String> naturalOrdering = Ordering.natural();
//		System.out.println(naturalOrdering.sortedCopy(list));
		
//		链式调用方法：通过链式调用，可以由给定的排序器衍生出其它排序器
		
		//使用当前排序器，但额外把null值排到最前面。
		Ordering<String> o2 = Ordering.natural().nullsFirst();
		System.out.println(o2.sortedCopy(list));
		//获取语义相反的排序器
		Ordering<String> o3 = Ordering.natural().nullsFirst().reverse();
		
		//运用排序器：Guava的排序器实现有若干操纵集合或元素值的方法
		System.out.println(o3.sortedCopy(list));
		//返回最小
		System.out.println(o3.min(list));
		
		
		//自定义
		Ordering.from(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return 0;
			}
		});
		
	}
}
