package Lec22;

import java.util.ArrayList;

public class HeapGeneric <T extends Comparable<T>>{

	private ArrayList<T> data = new ArrayList<>();

	// size
	public int size() {
		return this.data.size();
	}

	// add
	public void add(T item) {
		this.data.add(item);
		uphipify(this.size() - 1);
	}

	private void uphipify(int ci) {
		int pi = (ci - 1) / 2;

		if (this.isLarger(data.get(ci), data.get(pi)) > 0) {
			swap(pi, ci);
			uphipify(pi);
		}

	}

	private void swap(int pi, int ci) {

		T ith = this.data.get(pi);
		T jth = this.data.get(ci);

		this.data.set(ci, ith);
		this.data.set(pi, jth);
	}

	// remove
	public T remove() {

		swap(0, this.size() - 1);

		T rv = this.data.remove(this.data.size() - 1);
		downhepify(0);

		return rv;
	}

	private void downhepify(int pi) {
		int mini = pi;
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		if (lci < this.data.size() && this.isLarger(data.get(lci), data.get(mini)) > 0) {
			mini = lci;
		}

		if (rci < this.data.size() && this.isLarger(data.get(rci), data.get(mini)) > 0) {
			mini = rci;
		}

		if (mini != pi) {
			swap(mini, pi);
			downhepify(mini);
		}

	}

	public void display() {
		System.out.println(this.data);
	}

	public boolean isEmpty() {
		return this.data.size() == 0;
	}

	public T get() {
		return this.data.get(0);
	}
	
	private int isLarger(T o1, T o2) {
		return o1.compareTo(o2);
	}

}
