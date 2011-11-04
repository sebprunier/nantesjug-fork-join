package org.nantesjug.java7.forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class ForkJoinCalculator extends RecursiveAction {

	private static final long serialVersionUID = -9181212554873539763L;

	private List<Integer> data;
	private Integer result = 0;

	public ForkJoinCalculator(List<Integer> data) {
		this.data = data;
	}

	@Override
	protected void compute() {
		// if (my portion of the work is small enough)
		// do the work directly
		int size = data.size();
		if (size == 1) {
			result = data.get(0);
			return;
		}

		// else
		// split my work into two pieces
		ForkJoinCalculator c1 = new ForkJoinCalculator(data.subList(0, size / 2));
		ForkJoinCalculator c2 = new ForkJoinCalculator(data.subList(size / 2, size));
		// invoke the two pieces and wait for the results
		invokeAll(c1, c2);
		result += c1.result;
		result += c2.result;
	}

	public Integer getResult() {
		return result;
	}
}
