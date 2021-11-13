package com.f21a.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {
    public int val;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public UndirectedGraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public UndirectedGraphNode(int _val, ArrayList<UndirectedGraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public static List<UndirectedGraphNode> traversal(UndirectedGraphNode node) {
        List<UndirectedGraphNode> nodes = new ArrayList<>();
        if (node != null) {
            dfsTraversal(node, nodes);
        }
        return nodes;
    }

    public static void dfsTraversal(UndirectedGraphNode node, List<UndirectedGraphNode> nodes) {
        if (!nodes.contains(node)) {
            nodes.add(node);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                if (!nodes.contains(neighbor)) {
                    dfsTraversal(neighbor, nodes);
                }
            }
        }
    }
}
