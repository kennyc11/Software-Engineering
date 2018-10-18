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
	
	@Test(expected=Exception.class)
	public void exceptionTest(){
		//Can't make a directed graph with less than 0 vertices
		DAG exception = new DAG(-2);
	}
	
	//Following tests check Directed ACYCLIC Graph class works correctly
		@Test
		public void testsForCycle(){
				DAG cyclic = new DAG(20);
				boolean cyclical = true;
				cyclic.addEdge(0, 1);
				cyclic.addEdge(1, 2);
				cyclic.addEdge(2, 0);
				cyclic.addEdge(2, 3);
				cyclic.addEdge(3, 4);
				
				//Parameter is first vertex
				cyclic.findCycle(2);
				
				//Cycle from 2-0
				assertTrue(cyclic.hasCycle());
				
				assertEquals("",cyclical,cyclic.hasCycle());
		}
		
		@Test
		public void testForAcyclicGraph(){
				DAG acyclic = new DAG(20);
				acyclic.addEdge(0, 1);
				acyclic.addEdge(1, 2);
				acyclic.addEdge(2, 3);
				//Parameter is first vertex
				acyclic.findCycle(0);
				assertFalse(acyclic.hasCycle());
		}
		
		//Following tests check the LCA function for a DAG graph
		@Test
		public void testLCA(){
			DAG LCA = new DAG(10);
			
			LCA.addEdge(0, 1);
			LCA.addEdge(1, 2);
			LCA.addEdge(1, 3);
			LCA.addEdge(2, 5);
			LCA.addEdge(3, 4);
			LCA.addEdge(4, 6);
			LCA.addEdge(5, 6);
			LCA.addEdge(6, 8);
			LCA.addEdge(5, 7);
			LCA.addEdge(7, 8);
			
			assertEquals("", 3, LCA.findLCA(3, 4));
			assertEquals("", 7, LCA.findLCA(8, 7));
			assertEquals("", 6, LCA.findLCA(6, 8));
		}
		
		@Test
		public void testLCAForNoCommonAncestors(){
			DAG LCA2 = new DAG(11);
			LCA2.addEdge(0, 1);
			LCA2.addEdge(0, 2);
			LCA2.addEdge(1, 2);
			LCA2.addEdge(2, 3);
			LCA2.addEdge(3, 4);
			LCA2.addEdge(1, 5);
			LCA2.addEdge(3, 5);
			
			//Check it works ok
			assertEquals("", 0, LCA2.findLCA(3, 1));
			assertEquals("", 2, LCA2.findLCA(3, 2));
			assertEquals("", 3, LCA2.findLCA(4, 5));
			assertEquals("", 3, LCA2.findLCA(3, 5));
			assertEquals("", 1, LCA2.findLCA(1, 4));
	
			//Check for no common ancestors
			assertEquals("", -1, LCA2.findLCA(7, 3));
		}
		
		@Test
		public void testLCAForSameVertex(){
			DAG LCA3 = new DAG(11);
			LCA3.addEdge(0, 1);
			LCA3.addEdge(0, 2);
			LCA3.addEdge(1, 2);
			
			assertEquals("", 2, LCA3.findLCA(2, 2));
			assertEquals("", 1, LCA3.findLCA(1, 1));
		}
		@Test
		public void testLCAForNonDAG(){
			DAG LCA4 = new DAG(11);
			LCA4.addEdge(0, 1);
			LCA4.addEdge(0, 2);
			LCA4.addEdge(2, 3);
			LCA4.addEdge(3, 0);
			LCA4.addEdge(3, 4);
			
			//Should return -1 if graph is not a DAG
			assertEquals("", -1, LCA4.findLCA(2, 3));
			assertEquals("", -1, LCA4.findLCA(3, 4));
			assertEquals("", -1, LCA4.findLCA(1, 2));
			assertEquals("", -1, LCA4.findLCA(0, 3));
			assertEquals("", -1, LCA4.findLCA(1, 3));

		}
		
		@Test
		public void testLCAForEmptyDAG(){
			DAG LCA5 = new DAG(5);
			assertEquals("", -1, LCA5.findLCA(0, 2));
			assertEquals("", -1, LCA5.findLCA(0, 0));
			assertEquals("", -1, LCA5.findLCA(0, 3));
			
		}
				
}
