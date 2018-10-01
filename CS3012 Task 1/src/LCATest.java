import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {
	
	//Test empty tree
	@Test
	public void testForEmptyTree() {
		LCA tree = new LCA();
		assertEquals(-1,tree.findLCA(0,0));
	}
	
	//Test for existence of one Node
	@Test
	public void testForOneNode() {
		LCA oneNode = new LCA();
		oneNode.root = new Node(1);
		assertEquals("The lowest common ancestor of a tree with one node:",-1,oneNode.findLCA(1,0));
		
		LCA node = new LCA();
		node.root = new Node(12);
		assertEquals(-1,node.findLCA(12, 0));
	}
	
	
	//Test for the existence of two nodes
	@Test
	public void testForTwoNodes() {
		
		LCA twoNodes = new LCA();
		twoNodes.root = new Node(2);
		twoNodes.root.right = new Node(3);
		assertEquals("The lowest common ancestor of a tree with two nodes",-1,twoNodes.findLCA(2, 3));
		
	}
}