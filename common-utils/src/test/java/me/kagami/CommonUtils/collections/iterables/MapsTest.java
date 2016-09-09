package me.kagami.CommonUtils.collections.iterables;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

public class MapsTest {
	@Test
	public void test() {
		// 通常针对的场景是：有一组对象，它们在某个属性上分别有独一无二的值，而我们希望能够按照这个属性值查找对象
		// 译者注：这个方法返回一个Map，键为Function返回的属性值，值为Iterable中相应的元素，因此我们可以反复用这个Map进行查找操作。
		List<String> list = Lists.newArrayList("a", "bb", "ccc");
		ImmutableMap<Integer, String> index = Maps.uniqueIndex(list, new Function<String, Integer>() {
			public Integer apply(String string) {
				return string.length();
			}
		});
		// Function提供的函数必需让list中的值生成的key是唯一的，如果不是唯一的，会抛出异常
		System.out.println(index.get(3));// ccc
	}

	// 用来比较两个Map以获取所有不同点。该方法返回MapDifference对象，把不同点的维恩图分解为：
	@Test
	public void difference() {
		// entriesInCommon() 两个Map中都有的映射项，包括匹配的键与值
		// entriesDiffering()
		// 键相同但是值不同值映射项。返回的Map的值类型为MapDifference.ValueDifference，以表示左右两个不同的值
		// entriesOnlyOnLeft() 键只存在于左边Map的映射项
		// entriesOnlyOnRight() 键只存在于右边Map的映射项

		Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
		Map<String, Integer> right = ImmutableMap.of("a", 4, "b", 2, "d", 5);
		MapDifference<String, Integer> diff = Maps.difference(left, right);

		System.out.println(diff.entriesInCommon()); // {"b" => 2}
		System.out.println(diff.entriesDiffering());// {a=(1, 4)}
		System.out.println(diff.entriesOnlyOnLeft());// {"c" => 3}
		System.out.println(diff.entriesOnlyOnRight());// {"d" => 5}
	}

	@Test
	public void test3() {
		Map<String, Integer> fromMap = ImmutableMap.of("a", 1, "b", 2, "c", 3);
		System.out.println(Maps.filterValues(fromMap, new Predicate<Integer>() {
			public boolean apply(Integer input) {
				// 过滤Map中value值为假的元素
				return input==2;
			}
		}));
	}
}
