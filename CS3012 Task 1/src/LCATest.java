import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	//Test empty tree
	@Test
	public void testForEmptyTree() {
		LCA tree = new LCA();
		assertEquals(-1,tree.findLCA(0,0));
	}

	//Test for existence of one node in tree
	@Test
	public void testOneNode() {
		LCA oneNode = new LCA();
		oneNode.root = new Node(1);
		assertEquals("The lowest common ancestor of a tree with one node:",-1,oneNode.findLCA(1,0));

		LCA node = new LCA();
		node.root = new Node(12);
		assertEquals(-1,node.findLCA(12, 0));
	}


	//Test for the existence of two nodes in tree
	@Test
	public void testTwoNodes() {

		LCA twoNodes = new LCA();
		twoNodes.root = new Node(2);
		twoNodes.root.right = new Node(3);
		assertEquals("The lowest common ancestor of a tree with two nodes",2,twoNodes.findLCA(2, 3));

	}

	//Test for tree size 7
	@Test
	public void testTreeSizeSeven() {

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
		assertEquals("LCA(6,7)",3,treeSizeSeven.findLCA(6,7));
		assertEquals("LCA(5,7)",1,treeSizeSeven.findLCA(5,7));
		assertEquals("LCA(4,5)",2,treeSizeSeven.findLCA(4,5));
		
	}

	//Test for nodes that don't exist
	@Test
	public void testNonExistentNode() {

		LCA nonExistentNode = new LCA();
		nonExistentNode.root = new Node(5);
		nonExistentNode.root.left = new Node(8);
		nonExistentNode.root.left.right = new Node(9);
		nonExistentNode.root.right = new Node(12);
		nonExistentNode.root.right.right = new Node(13);
		nonExistentNode.root.right.left = new Node(17);

		assertEquals("LCA(12,17)",12,nonExistentNode.findLCA(12, 17));
		
		assertEquals("LCA(12,21)",-1,nonExistentNode.findLCA(12, 21));
		assertEquals("LCA(32,17)",-1,nonExistentNode.findLCA(32, 17));


	}

	//Test for same nodes
	@Test
	public void testSameNode() {

		LCA sameNode = new LCA();
		sameNode.root = new Node(5);
		sameNode.root.right = new Node(5);
		sameNode.root.right.right = new Node(5);
		sameNode.root.left = new Node(5);
		sameNode.root.left.left = new Node(5);
		
		assertEquals("LCA(5,5)",5,sameNode.findLCA(5, 5));

	}
	
	//Testing when one node is ancestor of other nodes
	@Test
	public void testAncestor() {
		
		LCA ancestor = new LCA();
		ancestor.root = new Node(5);
		ancestor.root.right = new Node(12);
		ancestor.root.right.right = new Node(3);
		ancestor.root.left = new Node(19);
		ancestor.root.left.left = new Node(9);
		ancestor.root.left.right = new Node(17);
		ancestor.root.right.left = new Node(15);
		
		assertEquals("LCA(3,15)",12,ancestor.findLCA(3, 12));
		assertEquals("LCA(9,19)",19,ancestor.findLCA(9, 19));
		assertEquals("LCA(5,17)",5,ancestor.findLCA(5,17));
		
	}
}