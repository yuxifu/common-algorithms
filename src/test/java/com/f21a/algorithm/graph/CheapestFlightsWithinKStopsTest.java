package com.f21a.algorithm.graph;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CheapestFlightsWithinKStopsTest {
    /*
    Example 1:
    Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
    Output: 200
    Explanation: The graph is shown.
    The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
    */
    @Test
    public void testReconstructItineraryExample1() {
        int[][] flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int result = new CheapestFlightsWithinKStops().findCheapestPrice(3, flights,
                0, 2, 1);
        assertEquals(200, result);
    }

    /*
    Example 2:
    Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
    Output: 500
    Explanation: The graph is shown.
    The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
    */
    @Test
    public void testReconstructItineraryExample2() {
        int[][] flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int result = new CheapestFlightsWithinKStops().findCheapestPrice(3, flights,
                0, 2, 0);
        assertEquals(500, result);
    }
}
