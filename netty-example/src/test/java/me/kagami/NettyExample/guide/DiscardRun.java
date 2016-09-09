package me.kagami.NettyExample.guide;

import org.junit.Test;

public class DiscardRun {
	@Test
	public void test() {
		try {
			new MyDiscardServer().runServer();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
