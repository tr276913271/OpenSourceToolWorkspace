package me.kagami.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class Main {
	public static CountDownLatch LATCH = new CountDownLatch(1);  
	@Test
	public void test() {
		ExecutorService service = Executors.newFixedThreadPool(6);
		
		service.submit(new AtomicLongRunnable());
		service.submit(new AtomicLongRunnable());
		service.submit(new AtomicLongRunnable());
		service.submit(new AtomicLongRunnable());
		service.submit(new AtomicLongRunnable());
		service.submit(new AtomicLongRunnable());
		LATCH.countDown();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(AtomicLongRunnable.count.get());
	}
	
}
