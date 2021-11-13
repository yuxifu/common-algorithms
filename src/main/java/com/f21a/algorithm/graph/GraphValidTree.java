package com.f21a.algorithm.graph;

import java.util.Arrays;

/*
You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list
of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai
and bi in the graph.

Return true if the edges of the given graph make up a valid tree, and false otherwise.

Example 1:
         0
       / | \
      1  2  3
      |
      4
Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
Output: true

Example 2:
      0-1-2
        |\|
        4 3
Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
Output: false

Constraints:
1 <= n <= 2000
0 <= edges.length <= 5000
edges[i].length == 2
0 <= ai, bi < n
ai != bi
There are no self-loops or repeated edges.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        // initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);

        // perform union find
        for (int[] edge : edges) {
            int x = find(nums, edge[0]);
            int y = find(nums, edge[1]);

            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;

            // union
            nums[x] = y;
        }

        return edges.length == n - 1;
    }

    private int find(int[] nums, int vertex) {
        if (nums[vertex] == -1) return vertex;
        nums[vertex] = find(nums, nums[vertex]);
        return nums[vertex];
    }
}
