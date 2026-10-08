/*
Definition for a Node.
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
        Map<Node, Node> seen = new HashMap<>();  

        return dfs(node, seen);
    }

    private Node dfs(Node curr, Map<Node, Node> seen) {
        if (seen.containsKey(curr)) {
            return seen.get(curr);
        }

        if (curr == null) {
            return curr;
        }

        Node copy = new Node(curr.val, new ArrayList<>());
        seen.put(curr, copy);

        List<Node> neighbors = curr.neighbors;

        List<Node> copyNeighbors = new ArrayList<>();

        for (int i = 0; i < neighbors.size(); i++) {
            copyNeighbors.add(dfs(neighbors.get(i), seen));
        }

        copy.neighbors = copyNeighbors;

        return copy;
    }
}