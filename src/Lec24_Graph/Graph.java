package Lec24_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, Vertex> vtces = new HashMap<>();

	public int noOfVertex() {
		return vtces.size();

	}

	public boolean containsVertex(String vname) {
		return vtces.containsKey(vname);
	}

	public void addVertex(String vname) {

		Vertex vtx = new Vertex();
		vtces.put(vname, vtx);

	}

	public void removeVertex(String vname) {

		Vertex vtx = vtces.get(vname);

		for (String nbr : vtx.nbrs.keySet()) {

			Vertex nbrvtx = vtces.get(nbr);
			nbrvtx.nbrs.remove(vname);

		}

		vtces.remove(vname);
	}

	public int noOfEdges() {

		int sum = 0;

		for (String key : vtces.keySet()) {
			Vertex vtx = vtces.get(key);
			sum += vtx.nbrs.size();
		}

		return sum / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}

		return true;

	}

	public void addEdge(String vname1, String vname2, int cost) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);

	}

	public void removeEdge(String vname1, String vname2) {

		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}

		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);

	}

	public void display() {

		System.out.println("--------------------");
		for (String key : vtces.keySet()) {

			Vertex vtx = vtces.get(key);

			String str = key + " -> " + vtx.nbrs;
			System.out.println(str);
		}
		System.out.println("--------------------");
	}

	public boolean hasPath(String src, String dst, HashMap<String, Boolean> processed) {

		processed.put(src, true);

		// self work
		if (containsEdge(src, dst)) {
			return true;
		}

		Vertex vtx = vtces.get(src);

		for (String nbr : vtx.nbrs.keySet()) {

			if (!processed.containsKey(nbr) && hasPath(nbr, dst, processed)) {
				return true;
			}
		}

		return false;
	}

	// BFS : Breath First Search returns shortest path between source and
	// destination

	private class PairBFS {
		String name;
		String psfr;
		String color;
	}

	public boolean BFS(String src, String dest) {

		LinkedList<PairBFS> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		// make a new pair
		PairBFS np = new PairBFS();
		np.name = src;
		np.psfr = src;

		queue.addLast(np);

		while (!queue.isEmpty()) {
			PairBFS rp = queue.removeFirst();

			if (processed.containsKey(rp.name)) {
				continue;
			}

			processed.put(rp.name, true);

			// direct
			if (containsEdge(rp.name, dest)) {
				return true;
			}

			for (String nbr : this.vtces.get(rp.name).nbrs.keySet()) {

				if (!processed.containsKey(nbr)) {
					PairBFS nnp = new PairBFS();
					nnp.name = nbr;
					nnp.psfr = rp.psfr + nbr;
					queue.addLast(nnp);
				}

			}
		}

		return false;

	}

	public boolean DFS(String src, String dest) {

		LinkedList<PairBFS> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		// make a new pair
		PairBFS np = new PairBFS();
		np.name = src;
		np.psfr = src;

		stack.addFirst(np);

		while (!stack.isEmpty()) {
			PairBFS rp = stack.removeFirst();
			if (processed.containsKey(rp.name)) {
				continue;
			}
			processed.put(rp.name, true);

			// direct
			if (containsEdge(rp.name, dest)) {
				return true;
			}

			for (String nbr : this.vtces.get(rp.name).nbrs.keySet()) {

				if (!processed.containsKey(nbr)) {
					PairBFS nnp = new PairBFS();
					nnp.name = nbr;
					nnp.psfr = rp.psfr + nbr;
					stack.addFirst(nnp);
				}

			}
		}

		return false;

	}

	public void BFT() {

		LinkedList<PairBFS> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		// make a new pair
		for (String vtx : this.vtces.keySet()) {

			if (processed.containsKey(vtx)) {
				continue;
			}

			PairBFS np = new PairBFS();
			np.name = vtx;
			np.psfr = vtx;

			queue.addLast(np);

			while (!queue.isEmpty()) {
				PairBFS rp = queue.removeFirst();

				if (processed.containsKey(rp.name)) {
					continue;
				}

				processed.put(rp.name, true);

				System.out.println(rp.name + " via " + rp.psfr);

				for (String nbr : this.vtces.get(rp.name).nbrs.keySet()) {

					if (!processed.containsKey(nbr)) {
						PairBFS nnp = new PairBFS();
						nnp.name = nbr;
						nnp.psfr = rp.psfr + nbr;
						queue.addLast(nnp);
					}

				}
			}
		}

	}

	public void DFT() {

		LinkedList<PairBFS> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		// make a new pair
		for (String vtx : this.vtces.keySet()) {

			if (processed.containsKey(vtx)) {
				continue;
			}

			PairBFS np = new PairBFS();
			np.name = vtx;
			np.psfr = vtx;

			stack.addFirst(np);

			while (!stack.isEmpty()) {
				PairBFS rp = stack.removeFirst();

				if (processed.containsKey(rp.name)) {
					continue;
				}

				processed.put(rp.name, true);

				System.out.println(rp.name + " via " + rp.psfr);

				for (String nbr : this.vtces.get(rp.name).nbrs.keySet()) {

					if (!processed.containsKey(nbr)) {
						PairBFS nnp = new PairBFS();
						nnp.name = nbr;
						nnp.psfr = rp.psfr + nbr;
						stack.addFirst(nnp);
					}

				}
			}
		}

	}

	public boolean isConnected() {

		int flag = 0;

		LinkedList<PairBFS> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		// make a new pair
		for (String vtx : this.vtces.keySet()) {

			if (processed.containsKey(vtx)) {
				continue;
			}

			flag++;

			PairBFS np = new PairBFS();
			np.name = vtx;
			np.psfr = vtx;

			queue.addLast(np);

			while (!queue.isEmpty()) {
				PairBFS rp = queue.removeFirst();

				if (processed.containsKey(rp.name)) {
					continue;
				}

				processed.put(rp.name, true);

				for (String nbr : this.vtces.get(rp.name).nbrs.keySet()) {

					if (!processed.containsKey(nbr)) {
						PairBFS nnp = new PairBFS();
						nnp.name = nbr;
						nnp.psfr = rp.psfr + nbr;
						queue.addLast(nnp);
					}

				}
			}
		}

		return flag == 1;

	}

	public boolean isCyclic() {

		LinkedList<PairBFS> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		// make a new pair
		for (String vtx : this.vtces.keySet()) {

			if (processed.containsKey(vtx)) {
				return true;
			}

			PairBFS np = new PairBFS();
			np.name = vtx;
			np.psfr = vtx;

			queue.addLast(np);

			while (!queue.isEmpty()) {
				PairBFS rp = queue.removeFirst();

				if (processed.containsKey(rp.name)) {
					return true;
				}

				processed.put(rp.name, true);

				for (String nbr : this.vtces.get(rp.name).nbrs.keySet()) {

					if (!processed.containsKey(nbr)) {
						PairBFS nnp = new PairBFS();
						nnp.name = nbr;
						nnp.psfr = rp.psfr + nbr;
						queue.addLast(nnp);
					}

				}
			}
		}

		return false;

	}

	public boolean isTree() {
		return isConnected() && !isCyclic();
	}

	public ArrayList<ArrayList<String>> getCC() {

		LinkedList<PairBFS> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		// make a new pair
		for (String vtx : this.vtces.keySet()) {

			if (processed.containsKey(vtx)) {
				continue;
			}

			PairBFS np = new PairBFS();
			np.name = vtx;
			np.psfr = vtx;

			queue.addLast(np);
			ArrayList<String> component = new ArrayList<>();
			while (!queue.isEmpty()) {
				PairBFS rp = queue.removeFirst();

				if (processed.containsKey(rp.name)) {
					continue;
				}
				component.add(rp.name);
				processed.put(rp.name, true);

				for (String nbr : this.vtces.get(rp.name).nbrs.keySet()) {

					if (!processed.containsKey(nbr)) {
						PairBFS nnp = new PairBFS();
						nnp.name = nbr;
						nnp.psfr = rp.psfr + nbr;
						queue.addLast(nnp);
					}

				}
			}
			ans.add(component);
		}
		return ans;
	}
	
	public boolean isBipartite() {

		LinkedList<PairBFS> queue = new LinkedList<>();
		HashMap<String, String> processed = new HashMap<>();

		// make a new pair
		for (String vtx : this.vtces.keySet()) {

			if (processed.containsKey(vtx)) {
				continue;
			}

			PairBFS np = new PairBFS();
			np.name = vtx;
			np.psfr = vtx;
			np.color = "r";

			queue.addLast(np);

			while (!queue.isEmpty()) {
				PairBFS rp = queue.removeFirst();

				if (processed.containsKey(rp.name)) {
					String oc = processed.get(rp.name);
					String nc = rp.color;
					
					if(!oc.equals(nc)) {
						return false;
					}
				}
				
				
				processed.put(rp.name, rp.color);

				for (String nbr : this.vtces.get(rp.name).nbrs.keySet()) {

					if (!processed.containsKey(nbr)) {
						PairBFS nnp = new PairBFS();
						nnp.name = nbr;
						nnp.psfr = rp.psfr + nbr;
						nnp.color = (processed.get(rp.name) == "r")? "g" : "r";
						queue.addLast(nnp);
					}

				}
			}
		}
		return true;
	}

}
