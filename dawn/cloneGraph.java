/*
133. Clone Graph

Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}


Test case format:

For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.



Example 1:
Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).

Example 2:
Input: adjList = [[]]
Output: [[]]
Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.

Example 3:
Input: adjList = []
Output: []
Explanation: This an empty graph, it does not have any nodes.

 */
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
        if(node == null){
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        return copy(node, map);
    }

    private Node copy(Node node, Map<Node, Node> map){
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node curr = new Node(node.val);
        map.put(node, curr);

        for(Node neighbor: node.neighbors){
            curr.neighbors.add(copy(neighbor, map));
        }
        return curr;
    }
}

/***
 * 이 문제는 node를 clone 하라는 문제이다.
 *
 * 여기서 이미 map에 key를 가지고 있다는건 복사본이 있다는 의미이기에 그럴 경우엔 그냥 이미 복사했으니, 그 복사본을 다시 써라는 말이다.
 * Node curr = new Node(node.val);
 * map.put(node, curr);
 * 이 부분은 노드를 복사하고, 나중에 재사용할 수 있도록 저장한다.
 * for(Node neighbor: node.neighbors){
 *             curr.neighbors.add(copy(neighbor, map));
 * }
 * 이웃들도 복사해서, 복사본 노드의 이웃 리스트에 추가 한다.
 */