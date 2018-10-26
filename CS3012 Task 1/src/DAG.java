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
	
	public boolean isEmpty()
	{
		if(V == 0) return true;
		else return false;
	}
	
	//Adds a directed edge from v->w
	public void addEdge(int v, int w)
	{
		if((validateVertex(v)>0)&&(validateVertex(w)>0))
		{
			adj[v].add(w);
			indegree[w]++;
			E++;
		}
		else{
			System.out.println("Please enter vertices between 0 & n-1");
		}
	}
	public int validateVertex(int v) {
		if (v < 0 || v >= V)
			return -1;
		else
			return 1;
	}
	public int indegree(int v)
	{
		if(validateVertex(v) > 0) return indegree[v];
		else return -1;
	}

	public int outdegree(int v)
	{
		if(validateVertex(v) > 0) return adj[v].size();
		else return -1;
	}

	public Iterable<Integer> adj(int v)
	{
		if(V == 0) return null;
		else return adj[v];	
	}

	public boolean hasCycle() {

		return hasCycle;
	}

	public void findCycle(int v) {

		marked[v] = true;
		stack[v] = true;

		for (int w : adj(v)) {
			if(!marked[w]) {
				findCycle(w);
			} else if (stack[w]) {
				hasCycle = true;
				return;
			}
		}

		stack[v] = false;
	}
	public int findLCA(int v, int w){
		findCycle(0);
	
		if(hasCycle || validateVertex(v)<0||validateVertex(v)<0 || E==0 ){
			return -1;
		}

		DAG backwards = reverse();
		ArrayList<Integer> arr1 = backwards.BFS(v);
		ArrayList<Integer> arr2 = backwards.BFS(w);
		ArrayList<Integer> commonAncestors = new ArrayList<Integer>();
		boolean found = false;
		for(int i = 0; i<arr1.size(); i++){
			for(int t = 0; t<arr2.size(); t++){		
				if(arr1.get(i)==arr2.get(t)){
					commonAncestors.add(arr1.get(i));	
					found = true;
				}
			}
		}

		if(found)
			//Returns first Ancestor in list(LCA)
			return commonAncestors.get(0);
		else
			//No Ancestors found
			return -1;
	}
	// prints BFS traversal from a given source s
    public ArrayList<Integer> BFS(int v)
    {
        // Mark all the vertices as not visited(By default set as false)
        boolean visited[] = new boolean[V];
 
        LinkedList<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> order= new ArrayList<Integer>();
 
        visited[v]=true;
        queue.add(v);
        
 
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            v = queue.poll();           
            order.add(v);
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        
        return order;
        
    }
    
    public DAG reverse() {
        DAG reverse = new DAG(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }	
}

