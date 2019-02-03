package Lec24_Graph;

public class GraphClient {

	public static void main(String[] args) {
		Graph graph = new Graph();

		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");

		graph.addEdge("A", "B", 10);
		graph.addEdge("A", "D", 20);
		graph.addEdge("B", "C", 5);
		graph.addEdge("C", "D", 3);
		graph.addEdge("D", "E", 1);
		graph.addEdge("E", "F", 2);
		graph.addEdge("F", "G", 30);
		graph.addEdge("E", "G", 50);

		graph.display();
		System.out.println(graph.noOfEdges());
		System.out.println(graph.noOfVertex());

		 graph.removeEdge("B", "C");
		// graph.removeEdge("F", "G");
		// graph.removeVertex("A");
		graph.display();

		// System.out.println(graph.hasPath("A", "F", new HashMap<>()));

	}

}
