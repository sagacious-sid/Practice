import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphBFS {

	public static void main(String[] args) {
		//using adjacency list way of storing the graph
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addEdge("A", "B");
		graph.addEdge("B", "C");
		graph.addEdge("C", "D");
		graph.addEdge("C", "A");
		
		graph.printGraph(graph);
	}

}

class Graph{
	Map<Vertex, List<Vertex>> graph = new HashMap<Vertex, List<Vertex>>();
	
	public Graph() {
		
	}
	
	public Map<Vertex, List<Vertex>> getAdjacencyMap() {
		return graph;
	}
	
	public void addVertex(String label) {
		List<Vertex> valueList = new ArrayList<Vertex>();
		graph.putIfAbsent(new Vertex(label), valueList);
	}
	
	public void removeVertices(String label) {
		Vertex vertexToRemove = new Vertex(label);
		graph.values().stream().forEach(e ->e.remove(vertexToRemove));
		graph.remove(vertexToRemove);
	}
	
	public void addEdge(String label1, String label2) {
		Vertex vertex1 = new Vertex(label1);
		Vertex vertex2 = new Vertex(label2);
		graph.get(vertex1).add(vertex2);
	}
	
	public void printGraph(Graph graph) {
		Map<Vertex, List<Vertex>> graphRep = graph.getAdjacencyMap();
		graphRep.entrySet().stream().forEach(System.out::println);
		//How to print a value object in a map using streams
	}
}

class Vertex{
	String label;
	
	public Vertex(String label) {
		this.label = label;
	}
	
	public String getVertexValue() {
		return this.label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
	
	
}
