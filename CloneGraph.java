import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class CloneGraph {

    public class Node {
        public int val;
        public List<Node> neighbors;
        
        public Node() {}
        
        public Node (int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }


    private Map<Node, Node> visited = new HashMap<Node, Node>();
    /**
     * DFS - using hashmap - hashmap has to be put outside the function
     * Time - O(n)
     * Space - O(n)
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        // If the node was already visited before, return the clone from the visited dictionary.
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a clone for the given node.
        // Note that we don't have vloned neightbors as of now, hence [].
        Node cloneNode = new Node(node.val, new ArrayList<Node>());
        // The key is original node and value being the clone node.
        visited.put(node, cloneNode);

        // Iterate through the neighbors to generate their clones 
        // and prepare a list of cloned neighbors to be added to the cloned node
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

    
}