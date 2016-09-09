package me.kagami.CommonUtils.collections.iterables;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimaps;
import com.google.common.primitives.Ints;

public class MultimapsTest {
	@Test
	public void test() {
		ImmutableSet<String> digits = ImmutableSet.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
		Function<String, Integer> lengthFunction = new Function<String, Integer>() {
		    public Integer apply(String string) {
		        return string.length();
		    }
		};
		//返回索引，类似于Maps.uniqueIndex，但是可以1对多
		ImmutableListMultimap<Integer, String> digitsByLength= Multimaps.index(digits, lengthFunction);
		System.out.println(digitsByLength);
		
		
		//ImmutableMultimap有翻转方法
		System.out.println(digitsByLength.inverse());
		//类似的，其他的multimaps有类似方法翻转
		ArrayListMultimap<String, Integer> multimap = ArrayListMultimap.create();
		multimap.putAll("b", Ints.asList(2, 4, 6));
		multimap.putAll("a", Ints.asList(4, 2, 1));
		multimap.putAll("c", Ints.asList(2, 5, 3));
		System.out.println(multimap);
		ArrayListMultimap<Integer, String> inverse = Multimaps.invertFrom(multimap, ArrayListMultimap.create());
		System.out.println(inverse);
	}
}
