//TC:O(V+E)
//SC:O(V+E)
// DFS solution
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
	public Node cloneGraph(Node node) {
		Map<Node, Node> visited = new HashMap<>();
        return clone(node, visited);

	}
	public Node clone(Node node, Map<Node, Node> visited) {
		if (node == null) {
			return node;
		}

		if (visited.containsKey(node)) {
			return visited.get(node);
		}
		
		Node cloneNode = new Node(node.val, new ArrayList<>());
		visited.put(node, cloneNode);
		
		for(Node n : node.neighbors) {
			cloneNode.neighbors.add(clone(n, visited));
		}
		
		return cloneNode;
	}
}
