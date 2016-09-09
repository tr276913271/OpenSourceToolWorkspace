package me.kagami.junitstudy;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest {
	@Test
	public void testMock() {
		// 模拟对象
		ArrayList<String> list = mock(ArrayList.class);
		assertNull(list.get(0));
		// 模拟方法调用返回值
		when(list.get(0)).thenReturn("String");
		assertEquals("eq", list.get(0), "String");
		// 模拟方法调用抛出异常
		when(list.get(1)).thenThrow(new RuntimeException());
		try {
			list.get(1);
			fail("should have thrown an exception");
		} catch (Exception e) {
			assertTrue(true);
		}
		// 没有抛出异常的方法也可以抛出异常
		doThrow(new RuntimeException()).when(list).clear();
		try {
			list.clear();
			fail("should have thrown an exception");
		} catch (Exception e) {
			assertTrue(true);
		}
		// 模拟方法调用次数
		list.add("once");
		//表示是否执行了一次add("once")方法 ，注意其中times的参数和add方法的参数要和上面的方法调用一致，否则认为失败
		verify(list, times(1)).add("once");
		//是否调用了add("once")方法
		verify(list).add("once");
	}

	@Test
	public void testMock2() {
		ArrayList<String> list = mock(ArrayList.class);
		// 参数匹配,任意数值都返回“String”
		when(list.get(anyInt())).thenReturn("String");
		assertEquals("eq", list.get(1), "String");
		assertEquals("eq", list.get(2), "String");
		// 验证get任意数值，调用了两次调用了两次
		verify(list, times(2)).get(anyInt());

	}

	@Test
	public void testMock3() {
		ArrayList<String> list = mock(ArrayList.class);
		// 参数匹配,任意数值都返回“String”
		when(list.get(anyInt())).thenReturn("String");
		// 从未调用过
		verify(list, never()).get(anyInt());
		list.get(1);
		// 至少调用一次
		verify(list, atLeastOnce()).get(anyInt());
		list.get(1);
		// 至少调用2次
		verify(list, atLeast(2)).get(anyInt());
		verify(list, atMost(4)).get(anyInt());
	}

	@Test
	public void testException() {
		// 测试异常的方法
		try {
			// 抛出异常方法
			sortList(null);
			fail("should have thrown an exception");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	private void sortList(Object object) throws Exception {
		throw new Exception();
	}

	@Test
	public void testEqualsNullTrue() {
		assertEquals("出错了呦", "a", "a");
		Object object = null;
		assertNull(object);
		Object object1 = new Object();
		assertNotNull(object1);

		assertTrue(true);
		assertFalse(false);
	}

	@Test
	public void testAssertSame() {
		// 由此可见，string 是共同引用的
		Object object = new Object();
		Object object2 = new Object();
		String string = "a";
		String string2 = "a";
		assertNotSame(object, object2);
		assertSame(string, string2);
	}

	@Test
	public void testFloat() {
		assertEquals("", 3.33, 3.32, 0.1);
	}

	@Before
	public void before() {
		System.out.println("before");
	}

	@After
	public void after() {
		System.out.println("after");
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("bc");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("ac");
	}
}
