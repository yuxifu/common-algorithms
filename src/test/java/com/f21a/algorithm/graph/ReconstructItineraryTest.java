package com.f21a.algorithm.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class ReconstructItineraryTest {
    @Test
    public void testReconstructItineraryExample1() {
        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("MUC", "LHR"),
                Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"),
                Arrays.asList("LHR", "SFO")
        );
        List<String> result = new ReconstructItinerary().findItinerary(tickets);
        assertEquals(Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC"), result);
    }

    @Test
    public void testReconstructItineraryExample2() {
        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"),
                Arrays.asList("ATL", "JFK"),
                Arrays.asList("ATL", "SFO")
        );
        List<String> result = new ReconstructItinerary().findItinerary(tickets);
        assertEquals(Arrays.asList("JFK", "ATL", "JFK", "SFO", "ATL", "SFO"), result);
    }
}
