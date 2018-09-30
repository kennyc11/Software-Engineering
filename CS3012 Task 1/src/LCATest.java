import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {
	
	
	@Test
	public void testForEmptyTree() {
		LCA tree = new LCA();
		assertEquals(-1,tree.findLCA(0,0));
	}
	
	
}