import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
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


    /**
     * BFS - using queue and hashmap both within function
     * Time - O(n)
     * Space - O(n)
     * @param node
     * @return
     */
    public Node cloneGraph1(Node node) {
        if (node == null) {
            return node;
        }

        // Hashmap tp save the visited node ant it's respective clone
        // as key and value respectively. This helps to avoid cycles.
        HashMap<Node, Node> visited = new HashMap<Node, Node>();

        // Put the first node in the queue
        Queue<Node> q = new LinkedList<Node>();
        q.offer(node);

        // Clone the node and put it in the visited dictionary.
        visited.put(node, new Node(node.val, new ArrayList<Node>()));

        // Start BFS traversal
        while (!q.isEmpty()) {
            // Pop a node ("n") from the front.
            Node n = q.poll();
            
            // Iterate through all the neighbors of the node "n"
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Clone the neighbor and put in the visited, if not present already
                    visited.put(neighbor, new Node(neighbor.val , new ArrayList<Node>()));
                    // Add the newly encountered node to the queue
                    q.offer(neighbor);
                }
                // Add the clone of the neighbor to the neighbors of the clone node "n"
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        // Return the clone of the node from visited.
        return visited.get(node);
    }
}