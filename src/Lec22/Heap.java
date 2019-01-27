package Lec22;

import java.util.ArrayList;

public class Heap {
	
	private ArrayList<Integer> data = new ArrayList<>();
	
	//size
	public int size() {
		return this.data.size(); 
	}
	
	
	//add
	public void add(int item) {
		this.data.add(item);
		uphipify(this.size() - 1);
	}


	private void uphipify(int ci) {
		int pi = (ci - 1) / 2;
		
		if (this.data.get(ci) < this.data.get(pi)) {
			swap(pi, ci);
			uphipify(pi);
		}
		
	}


	private void swap(int pi, int ci) {
		
		int ith = this.data.get(pi);
		int jth = this.data.get(ci);
		
		this.data.set(ci, ith);
		this.data.set(pi, jth);
	}
	
	//remove
	public int remove() {
		
		swap(0, this.size() - 1);
		
		int rv = this.data.remove(this.data.size() - 1);
		downhepify(0);
		
		return rv;
	}


	private void downhepify(int pi) {
		int mini = pi;
		int lci = 2*pi + 1;
		int rci = 2*pi + 2;
		
		if (lci < this.data.size() && this.data.get(lci) < this.data.get(mini)) {
			mini = lci;
		}
		
		if (rci < this.data.size() && this.data.get(rci) < this.data.get(mini)) {
			mini = rci;
		}
		
		if (mini != pi) {
			swap(mini, pi) ;
			downhepify(mini);
		}
		
	}
	
	public void display() {
		System.out.println(this.data);
	}
	
	public boolean isEmpty() {
		return this.data.size() == 0;
	}
	
	public int get()
	{
		return this.data.get(0);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
