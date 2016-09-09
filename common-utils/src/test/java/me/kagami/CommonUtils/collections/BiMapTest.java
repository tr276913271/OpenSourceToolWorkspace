package me.kagami.CommonUtils.collections;

import org.junit.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
/**
 * 1v1映射
 * @author Tian
 *
 */
public class BiMapTest {
	@Test
	public void test(){
		BiMap<String, Integer> userId = HashBiMap.create();
		userId.put("a", 1);
		userId.put("b", 2);
		
//		userId.put("c",	2); 异常
//		强制替换
		userId.forcePut("c", 2);
		//翻转
		System.out.println(userId.inverse().get(1));
		System.out.println(userId);
		
	}
}
