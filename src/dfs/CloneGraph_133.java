package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph_133 {
    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    private HashMap<Integer,Node> map = new HashMap<>();
    private Node clonenode(Node node,HashMap<Integer,Node> map){
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }
        Node newnode = new Node(node.val,new ArrayList<Node>());
        map.put(newnode.val,newnode);
        for(Node neighbor:node.neighbors){
            newnode.neighbors.add(clonenode(neighbor,map));
        }
        return newnode;

    }
    public Node cloneGraph(Node node,HashMap<Integer,Node> map) {
        return clonenode(node,map);
    }


}
