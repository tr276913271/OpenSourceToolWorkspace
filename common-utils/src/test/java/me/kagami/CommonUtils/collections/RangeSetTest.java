package me.kagami.CommonUtils.collections;

import org.junit.Test;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

public class RangeSetTest {
	@Test
	public void test() {
		//实现Comparable接口
		//大区间会合并小区间
		RangeSet<Integer> rangeSet = TreeRangeSet.create();
		rangeSet.add(Range.closed(1, 10));
		System.out.println("rangeSet:" + rangeSet);
		rangeSet.add(Range.closedOpen(11, 15));
		System.out.println("rangeSet:" + rangeSet);
		rangeSet.add(Range.open(15, 20));
		System.out.println("rangeSet:" + rangeSet);
		rangeSet.add(Range.openClosed(0, 0));
		System.out.println("rangeSet:" + rangeSet);
		rangeSet.remove(Range.open(5, 10));
		System.out.println("rangeSet:" + rangeSet);
		
		
		System.out.println(rangeSet.contains(15));
		
		//补集
		System.out.println(rangeSet.complement());
	}
}
