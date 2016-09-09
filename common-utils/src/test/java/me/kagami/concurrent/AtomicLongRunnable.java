package me.kagami.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicLongRunnable implements Runnable {
//	public static int count;
	public static AtomicInteger count = new AtomicInteger(0);
	@Override
	public void run() {
		try {
			Main.LATCH.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 300; i++) {
//			count++;
			count.incrementAndGet();
		}
	}

}
