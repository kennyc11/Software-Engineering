import java.util.ArrayList;
import java.util.List;
 
class Node {
    int data;
    Node left, right;
 
    Node(int value) {
        data = value;
        left = right = null;
    }
}
 
 
public class LCA 
{

	
}

private int findLCAInternal(Node root, int n1, int n2) {
	 
    if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
        return -1;
    }

    int i;
    for (i = 0; i < path1.size() && i < path2.size(); i++) {
        if (!path1.get(i).equals(path2.get(i)))
            break;
    }

    return path1.get(i-1);
}