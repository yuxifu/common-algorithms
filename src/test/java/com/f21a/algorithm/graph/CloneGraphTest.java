package com.f21a.algorithm.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class CloneGraphTest {

    /*
    Example 1:
    Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
    Output: [[2,4],[1,3],[2,4],[1,3]]
    Explanation: There are 4 nodes in the graph.
    1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
    2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
    3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
    4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
     */
    @Test
    public void testCloneGraphExample1() {
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        UndirectedGraphNode node4 = new UndirectedGraphNode(4);

        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);

        UndirectedGraphNode clone = new CloneGraph().cloneGraph(node1);
        List<UndirectedGraphNode> clones = UndirectedGraphNode.traversal(clone);
        assertEquals(4, clones.size());
        assertEquals(Arrays.asList(2, 4), clones.get(0).neighbors.stream().map(i -> i.val).collect(Collectors.toList()));
        assertEquals(Arrays.asList(1, 3), clones.get(1).neighbors.stream().map(i -> i.val).collect(Collectors.toList()));
        assertEquals(Arrays.asList(2, 4), clones.get(2).neighbors.stream().map(i -> i.val).collect(Collectors.toList()));
        assertEquals(Arrays.asList(1, 3), clones.get(3).neighbors.stream().map(i -> i.val).collect(Collectors.toList()));
    }

    /*
    Example 2:
    Input: adjList = [[]]
    Output: [[]]
    Explanation: Note that the input contains one empty list. The graph consists of only one node
    with val = 1 and it does not have any neighbors.
     */
    @Test
    public void testCloneGraphExample2() {
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);

        UndirectedGraphNode clone = new CloneGraph().cloneGraph(node1);
        List<UndirectedGraphNode> clones = UndirectedGraphNode.traversal(clone);
        assertEquals(1, clones.size());
        assertEquals(0, clones.get(0).neighbors.size());
    }

    /*
    Example 3:
    Input: adjList = []
    Output: []
    Explanation: This an empty graph, it does not have any nodes.
     */
    @Test
    public void testCloneGraphExample3() {
        UndirectedGraphNode clone = new CloneGraph().cloneGraph(null);
        List<UndirectedGraphNode> clones = UndirectedGraphNode.traversal(clone);
        assertEquals(0, clones.size());
    }

    /*
    Example 4:
    Input: adjList = [[2],[1]]
    Output: [[2],[1]]
     */
    @Test
    public void testCloneGraphExample4() {
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);

        node1.neighbors = Arrays.asList(node2);
        node2.neighbors = Arrays.asList(node1);

        UndirectedGraphNode clone = new CloneGraph().cloneGraph(node1);
        List<UndirectedGraphNode> clones = UndirectedGraphNode.traversal(clone);
        assertEquals(2, clones.size());
        assertEquals(Arrays.asList(2), clones.get(0).neighbors.stream().map(i -> i.val).collect(Collectors.toList()));
        assertEquals(Arrays.asList(1), clones.get(1).neighbors.stream().map(i -> i.val).collect(Collectors.toList()));
    }

}
