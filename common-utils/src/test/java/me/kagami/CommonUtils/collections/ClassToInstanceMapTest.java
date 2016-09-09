package me.kagami.CommonUtils.collections;

import org.junit.Test;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
/**
 * ClassToInstanceMap是一种特殊的Map：它的键是类型，而值是符合键所指类型的对象。
 * @author Tian
 *
 */
public class ClassToInstanceMapTest {
	@Test
	public void test(){
		ClassToInstanceMap<Number> map =MutableClassToInstanceMap.create();
		map.put(Integer.class, 3);
		map.put(Long.class, 5L);
		
		System.out.println(map.get(Integer.class));
	}
}
