package org.nantesjug.java7.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinMain {

	public static void main(String[] args) {

		ForkJoinCalculator c = new ForkJoinCalculator(Data.BIG_LIST);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(c);

		System.out.println("Result : " + c.getResult());

	}

}
