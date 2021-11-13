package com.f21a.algorithm.graph;

import java.util.*;

/*
You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure
and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK".
If there are multiple valid itineraries, you should return the itinerary that has the smallest
lexical order when read as a single string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once
and only once.

Example 1:
Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]

Example 2:
Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is
larger in lexical order.

Constraints:

1 <= tickets.length <= 300
tickets[i].length == 2
fromi.length == 3
toi.length == 3
fromi and toi consist of uppercase English letters.
fromi != toi
 */

public class ReconstructItinerary {

    /*
    Explanation
    First keep going forward until you get stuck. That's a good main path already. Remaining
    tickets form cycles which are found on the way back and get merged into that main path.
    By writing down the path backwards when retreating from recursion, merging the cycles
    into the main path is easy - the end part of the path has already been written, the
    start part of the path hasn't been written yet, so just write down the cycle now and
    then keep backwards-writing the path.

    Example:
    enter image description here

    From JFK we first visit JFK -> A -> C -> D -> A. There we're stuck, so we write down A as
    the end of the route and retreat back to D. There we see the unused ticket to B and follow
    it: D -> B -> C -> JFK -> D. Then we're stuck again, retreat and write down the airports
    while doing so: Write down D before the already written A, then JFK before the D, etc.
    When we're back from our cycle at D, the written route is D -> B -> C -> JFK -> D -> A.
    Then we retreat further along the original path, prepending C, A and finally JFK to the
    route, ending up with the route JFK -> A -> C -> D -> B -> C -> JFK -> D -> A.
    */

    /*
    After reading leetcode.com/problems/reconstruct-itinerary/discuss/78768/Short-Ruby-Python-Java-C++/83576 comments,
    i finally understand this algs.

    Here is some points to understand this algs and hope it helps.

    1. In Eulerian paths, there must exist a start node(which is JFK in this problem) and a end node.
    2. End node can be start node or another node.
        end node is start node iff all nodes has even degree.
        end node is another node iff there is another odd degree node and start node has an odd degree.

    So, the algorithm is to find the end node first and delete the path to this node(backtrack),
    meanwhile using PriorityQueue to guarantee lexical order.
    Really amazing solution, I always don't know how to deal with Euler Path and know I begin to be
    some less confused.
     */

    // recursive
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        List<String> route = new LinkedList();

        for (List<String> ticket : tickets)
            targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue()).add(ticket.get(1));
        visit("JFK", targets, route);
        return route;
    }

    private void visit(String airport, Map<String, PriorityQueue<String>> targets, List<String> route) {
        while (targets.containsKey(airport) && !targets.get(airport).isEmpty())
            visit(targets.get(airport).poll(), targets, route);
        route.add(0, airport);
    }

    // Iterative version
    public List<String> findItinerary2(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (List<String> ticket : tickets)
            targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue()).add(ticket.get(1));
        List<String> route = new LinkedList();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
                stack.push(targets.get(stack.peek()).poll());
            route.add(0, stack.pop());
        }
        return route;
    }
}
