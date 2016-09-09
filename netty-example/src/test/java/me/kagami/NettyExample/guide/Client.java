package me.kagami.NettyExample.guide;

import org.junit.Test;

public class Client {
	@Test
	public void test() {
		try {
			new MyTimeClient().runClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
