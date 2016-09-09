package me.kagami.jacksonstudy;


public class App {
	public static void main(String[] args) {
		int data[] = { 2,2 };
		
		int dp[] = new int[data.length];

		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (data[j] < data[i] && dp[j]+1>dp[i]) {
					dp[i] = dp[j]+1;
				}
			}
		}
		
		for (int i : dp) {
			System.out.println(i);
		}
	}
}
