package me.kagami.CommonUtils.collections;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * 每个有经验的Java程序员都在某处实现过Map<K, List<V>>或Map<K, Set<V>>，并且要忍受这个结构的笨拙。 Guava的
 * Multimap可以很容易地把一个键映射到多个值。 换句话说，Multimap是把键映射到任意多个值的一般方式。
 * 
 * @author Tian
 *
 */
public class MultimapTest {
	@Test
	public void test() {
		Multimap<String, Integer> scoreMultimap = ArrayListMultimap.create();
		for (int i = 10; i < 21; i++) {
			scoreMultimap.put("peida", 100 - i);
		}
		scoreMultimap.put("peida", 81);
		System.out.println("scoreMultimap:" + scoreMultimap.size());
		
		System.out.println(scoreMultimap.get("peida"));
		
		
//		keys用Multiset表示Multimap中的所有键，每个键重复出现的次数等于它映射的值的个数。
//		可以从这个Multiset中移除元素，但不能做添加操作；移除操作会反映到底层的Multimap。
		System.out.println("scoreMultimap:" + scoreMultimap.keys());
		//每删除一次，multmap中peida的个数就少1
		scoreMultimap.keys().remove("peida");
		System.out.println("scoreMultimap:" + scoreMultimap.keys());
		
//		Multimap.get(key)以集合形式返回键所对应的值视图，即使没有任何对应的值，也会返回空集合。
		System.out.println(scoreMultimap.get("aa").size());
		
		scoreMultimap.remove("peida", 80);
		System.out.println(scoreMultimap.get("peida"));
		//entries用Collection<Map.Entry<K, V>>返回Multimap中所有”键-单个值映射”——包括重复键。（对SetMultimap，返回的是Set）
		System.out.println(scoreMultimap.entries());
	}
}

