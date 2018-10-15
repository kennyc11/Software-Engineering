import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DAG {
	private int V;           // number of vertices in this digraph
	private int E;                 // number of edges in this digraph
	private ArrayList<Integer>[] adj;    // adj[v] = adjacency list for vertex v
	private int[] indegree;        // indegree[v] = indegree of vertex v
	private boolean marked[];		//Boolean List to track visited vertices
	private boolean hasCycle;		//True if cycle in graph
	private boolean stack[];		//Order that vertices were visited


	public DAG(int V)
	{
		if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.V = V;
		this.E = 0;
		indegree = new int[V];
		marked = new boolean[V];
		stack = new boolean[V];
		adj = (ArrayList<Integer>[]) new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Integer>();
		}              
	}
	//Returns current vertex
	public int V() {
		return V;	
	}
	
	public int E() {
        return E;
    }
}