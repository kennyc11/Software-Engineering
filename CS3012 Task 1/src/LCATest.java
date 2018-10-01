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
		assertEquals("The lowest common ancestor of a tree with two nodes",2,twoNodes.findLCA(2, 3));
		
	}
	
	//Test for tree size 7
	@Test
	public void treeSize() {
		
		LCA treeSizeSeven = new LCA();
		treeSizeSeven.root = new Node(1);
		treeSizeSeven.root.right = new Node(2);
		treeSizeSeven.root.left = new Node(3);
		treeSizeSeven.root.right.right = new Node(4);
		treeSizeSeven.root.right.left = new Node(5);
		treeSizeSeven.root.left.right = new Node(6);
		treeSizeSeven.root.left.left = new Node(7);
		
		assertEquals("LCA (1,2)",1,treeSizeSeven.findLCA(1,2));
		assertEquals("LCA (4,6)",1,treeSizeSeven.findLCA(4,6));
		
	}
}