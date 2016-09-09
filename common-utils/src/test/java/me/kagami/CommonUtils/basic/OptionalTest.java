package me.kagami.CommonUtils.basic;

import org.junit.Test;

import com.google.common.base.Optional;

import me.kagami.CommonUtils.TestBean;

import static junit.framework.Assert.*;

/**
 * Guava用Optional<T>表示可能为null的T类型引用;
 * 
 * 使用Optional除了赋予null语义，增加了可读性，最大的优点在于它是一种傻瓜式的防护。
 * Optional迫使你积极思考引用缺失的情况，因为你必须显式地从Optional获取引用。 直接使用null很容易让人忘掉某些情形。
 * 
 * JDK 中java.util.Optional和这个类有类似功能
 * 
 * @author Tian
 *
 */
public class OptionalTest {
	private TestBean bean = new TestBean();
	private TestBean bean2 = new TestBean();

	@Test
	public void test() {
		bean.setId(1);
		bean2.setId(2);

		try {
			// 创建指定引用的Optional实例，若引用为null则快速失败
			Optional.of(null);
		} catch (Exception e) {
			assertTrue(true);
		}
		Optional<TestBean> optional = Optional.of(bean);
		// 看里面是不是null
		assertTrue(optional.isPresent());
		// 返回Optional所包含的引用，若引用缺失，则抛出java.lang.IllegalStateException
		assertTrue(optional.get().getId() == 1);
		// 创建null的Optional
		optional = Optional.absent();
		assertFalse(optional.isPresent());
		try {
			// 返回Optional所包含的引用，若引用缺失，则抛出java.lang.IllegalStateException
			optional.get();
		} catch (Exception e) {
			assertTrue(true);
		}
		// 返回Optional所包含的引用，若引用缺失，返回null
		assertTrue(optional.orNull() == null);
		// 返回Optional所包含的引用，若引用缺失，返回指定的值
		assertTrue(optional.or(bean2).getId() == 2);
	}
}
