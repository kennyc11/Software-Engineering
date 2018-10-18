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
		assertEquals("", 2, test.outdegree(4));
		assertEquals("Number of edges should be 5", 5, test.E());
		assertEquals("Number of vertices should be 10", 10, test.V());
		String ans = "[5, 6]";
		assertEquals("",ans, test.adj(4).toString());

	}
	
	@Test
	public void testAddEdge(){
		DAG test4 = new DAG(5);
		//This edge should add
		test4.addEdge(0, 1);

		//This should print message to console and have no effect
		test4.addEdge(-2, -5);

		//This should not either as 9>5 
		test4.addEdge(3, 9);
		assertEquals("Number of edges should be 1", 1, test4.E());
	}

	@Test
	public void testinDegree(){
		DAG testInDegree = new DAG(5);
		testInDegree.addEdge(0, 1);
		testInDegree.addEdge(0, 2);
		testInDegree.addEdge(1, 2);

		assertEquals("", -1, testInDegree.indegree(-2));
		assertEquals("", 1, testInDegree.indegree(1));
		assertEquals("", 2, testInDegree.indegree(2));
	}
	@Test
	public void testOutDegree(){
		DAG testOutDegree = new DAG(5);
		testOutDegree.addEdge(0, 1);
		testOutDegree.addEdge(0, 2);
		testOutDegree.addEdge(1, 2);
		
		assertEquals("", -1, testOutDegree.outdegree(9));	
		assertEquals("", 2, testOutDegree.outdegree(0));	
		assertEquals("", 0, testOutDegree.outdegree(2));	
	}
}
