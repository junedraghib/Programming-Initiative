package Lec24_Graph;

import java.util.HashMap;

public class MyGraph {
	private class vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	HashMap<String, vertex> vtces = new HashMap<>();

	public int noOfVertex() {

		return vtces.size();

	}

	public boolean containsVertex(String vname) {
		return vtces.containsKey(vname);
	}

	public void addVertex(String vname) {
		vertex vtx = new vertex();
		vtces.put(vname, vtx);
	}

	public void removeVertex(String vname) {
		vertex vtx = vtces.get(vname);

		for (String str : vtx.nbrs.keySet()) {
			vertex nbvtx = vtces.get(str);
			nbvtx.nbrs.remove(vname);
		}

		vtces.remove(vname);
	}

	public int noOfEdges() {
		int edges = 0;

		for (String str : vtces.keySet()) {
			edges += vtces.get(str).nbrs.size();
		}

		return edges / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {

		vertex vertex1 = vtces.get(vname1);
		vertex vertex2 = vtces.get(vname2);

		if (vertex1 == null || vertex2 == null || !vertex1.nbrs.containsKey(vname2)) {
			return false;
		}

		return true;

	}
	
	public void addEdge(String vname1, String vname2, int cost) {
		vertex vertex1 = vtces.get(vname1);
		vertex vertex2 = vtces.get(vname2);
		
		if(vertex1 == null || vertex2 == null || vertex1.nbrs.containsKey(vname2)) {
			return; 
		}
		
		vertex1.nbrs.put(vname2, cost);
		vertex2.nbrs.put(vname1, cost);
	}
	
	public void removeEdge(String vname1, String vname2, int cost) {
		vertex vertex1 = vtces.get(vname1);
		vertex vertex2 = vtces.get(vname2);
		
		if(vertex1 == null || vertex2 == null || !vertex1.nbrs.containsKey(vname2)) {
			return; 
		}
		
		vertex1.nbrs.remove(vname2, cost);
		vertex2.nbrs.remove(vname1, cost);
	}
	
	public boolean hasPath(String src, String dst, HashMap<String, Boolean> processed) {
		
		//direct
		if(containsEdge(src, dst)) {
			return true;
		}
		
		processed.put(src, true);
		
		for(String nbr : vtces.get(src).nbrs.keySet()) {
			if(!processed.containsKey(nbr) && hasPath(nbr, dst, processed)) {
				return true;
			}
		}
		
		return false;
	}

	
	
}
