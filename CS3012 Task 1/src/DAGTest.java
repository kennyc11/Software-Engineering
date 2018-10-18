import static org.junit.Assert.*;

import org.junit.Test;

public class DAGTest {

	//Following tests check Directed Graph class works correctly
	@Test
	public void testForDirectedGraph(){
		DAG test = new DAG(10);
		test.addEdge(1, 2);
		test.addEdge(1, 3);
		test.addEdge(3, 4);
		test.addEdge(4, 5);
		test.addEdge(4, 6);

		assertEquals("", 1, test.indegree(5));
		assertEquals("", 2, test.outdegree(6));
		assertEquals("Number of edges should be 5", 5, test.E());
		assertEquals("Number of vertices should be 10", 10, test.V());
		String ans = "[5, 6]";
		assertEquals("",ans, test.adj(4).toString());

	}
	
}
