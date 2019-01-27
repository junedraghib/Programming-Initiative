package Lec22;

import java.util.ArrayList;

public class GenericHeapClient {

	public static void main(String[] args) {
//		HeapGeneric<Car> heapg = new HeapGeneric<>();
//		Car[] cars = new Car[5];
//
//		cars[0] = new Car(100, 200, "Black");
//		cars[1] = new Car(1010, 201, "Grey");
//		cars[2] = new Car(102, 2002, "Magenta");
//		cars[3] = new Car(1030, 203, "Burgandi");
//		cars[4] = new Car(104, 2064, "Aqua");
//
//		for (int i = 0; i < cars.length; i++) {
//			heapg.add(cars[i]);
//		}
//
//		heapg.display();
//		while (!heapg.isEmpty()) {
//
//			System.out.println(heapg.remove());
//		}
		
//		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//		list.add(new ArrayList<>());
//		list.add(new ArrayList<>());
//		list.add(new ArrayList<>());
//		list.get(0).add(10);
//		list.get(0).add(20);
//		list.get(0).add(30);
//		list.get(0).add(40);
//		list.get(1).add(2);
//		list.get(1).add(3);
//		list.get(1).add(5);
//		list.get(1).add(7);
//		list.get(2).add(6);
//		list.get(2).add(15);
//		list.get(2).add(23);
//		list.get(2).add(50);
//		
//		System.out.println(ksortedmerge(list));
		
		int[] arr = {2,30,44,55,11,33,21,13};
		ArrayList<Integer> ans = kmaxofArray(arr, 3);
		System.out.println(ans);
		
		
	}

	public static class Pair implements Comparable<Pair> {
		int data;
		int listno;
		int idx;

		@Override
		public int compareTo(Pair o) {
			return o.data - this.data;
		}
	}

	public static ArrayList<Integer> ksortedmerge(ArrayList<ArrayList<Integer>> list) {
		ArrayList<Integer> ans = new ArrayList<>();
		HeapGeneric<Pair> heap = new HeapGeneric<>();

		for (int i = 0; i < list.size(); i++) {
			Pair np = new Pair();
			np.data = list.get(i).get(0);
			np.listno = i;
			np.idx = 0;

			heap.add(np);
		}

		while (!heap.isEmpty()) {

			Pair rp = heap.remove();
			ans.add(rp.data);
			rp.idx++;

			if (rp.idx < list.get(rp.listno).size()) {

				rp.data = list.get(rp.listno).get(rp.idx);
				heap.add(rp);
			}
		}

		return ans;
	}
	
	public static ArrayList<Integer> kmaxofArray(int[] arr, int k)
	{
		ArrayList<Integer> ans = new ArrayList<>();
		
		Heap heap = new Heap();
		
		for (int i = 0; i < arr.length; i++) {
			if (i < k) {
				heap.add(arr[i]);
			} else {
				if (heap.get() < arr[i]) {
					heap.remove();
					heap.add(arr[i]);
				}
			}
		}
		
		while (!heap.isEmpty()) {
			ans.add(heap.remove());
		}
		
		
		return ans;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
