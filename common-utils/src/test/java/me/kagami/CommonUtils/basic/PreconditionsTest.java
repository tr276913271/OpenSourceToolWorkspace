package me.kagami.CommonUtils.basic;

import static com.google.common.base.Preconditions.*;

import org.junit.Test;
import static junit.framework.Assert.*;
/**
 * Guava在Preconditions类中提供了若干前置条件判断的实用方法，我们强烈建议在Eclipse中静态导入这些方法。
 * 
 * @author Tian
 *
 */
public class PreconditionsTest {
	@Test
	public void test() {
		try {
			//检查boolean是否为true，用来检查传递给方法的参数。
			checkArgument(-1 >= 0, "Argument was %s but expected nonnegative", -1);
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			checkArgument(2 < 1, "Expected i < j, but %s > %s", 2, 1);
		} catch (Exception e) {
			assertTrue(true);
		}
		
		try {
			//检查index作为索引值对某个列表、字符串或数组是否有效。index>=0 && index<size *
			checkElementIndex(2,1);
		} catch (Exception e) {
			assertTrue(true);
		}
		
		try {
			//检查[start, end]表示的位置范围对某个列表、字符串或数组是否有效*
			checkPositionIndexes(1, 2, 4);
		} catch (Exception e) {
			assertTrue(true);
		}
		//参数2，最大值只能为4
		checkPositionIndexes(1, 4, 4);
//		checkNotNull(T)
	}
}
