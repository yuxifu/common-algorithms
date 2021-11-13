package com.f21a.algorithm.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class CourseScheduleIITest {
    /*
    Example 1:
    Input: numCourses = 2, prerequisites = [[1,0]]
    Output: [0,1]
    Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
    */
    @Test
    public void testCourseScheduleIIExample1() {
        int[] result = new CourseScheduleII().findOrder(2,
                new int[][]{{1, 0}});
        assertEquals(Arrays.asList(0, 1),
                Arrays.stream(result).boxed().collect(Collectors.toList()));
    }

    /*
    Example 2:
    Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
    Output: [0,2,1,3]
    Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
    So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
    */
    @Test
    public void testCourseScheduleIIExample2() {
        int[] result = new CourseScheduleII().findOrder(4,
                new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        assertEquals(Arrays.asList(0, 1, 2, 3),
                Arrays.stream(result).boxed().collect(Collectors.toList()));
    }

    /*
    Example 3:
    Input: numCourses = 1, prerequisites = []
    Output: [0]
     */
    @Test
    public void testCourseScheduleIIExample3() {
        int[] result = new CourseScheduleII().findOrder(1,
                new int[][]{});
        assertEquals(Arrays.asList(0),
                Arrays.stream(result).boxed().collect(Collectors.toList()));
    }

    // findOrder2

    @Test
    public void testCourseScheduleII2Example1() {
        int[] result = new CourseScheduleII().findOrder2(2,
                new int[][]{{1, 0}});
        assertEquals(Arrays.asList(0, 1),
                Arrays.stream(result).boxed().collect(Collectors.toList()));
    }

    @Test
    public void testCourseScheduleII2Example2() {
        int[] result = new CourseScheduleII().findOrder2(4,
                new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        assertEquals(Arrays.asList(0, 1, 2, 3),
                Arrays.stream(result).boxed().collect(Collectors.toList()));
    }

    @Test
    public void testCourseScheduleII2Example3() {
        int[] result = new CourseScheduleII().findOrder2(1,
                new int[][]{});
        assertEquals(Arrays.asList(0),
                Arrays.stream(result).boxed().collect(Collectors.toList()));
    }

    // findOrder3

    @Test
    public void testCourseScheduleII3Example1() {
        int[] result = new CourseScheduleII().findOrder3(2,
                new int[][]{{1, 0}});
        assertEquals(Arrays.asList(0, 1),
                Arrays.stream(result).boxed().collect(Collectors.toList()));
    }

    @Test
    public void testCourseScheduleII3Example2() {
        int[] result = new CourseScheduleII().findOrder3(4,
                new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        assertEquals(Arrays.asList(0, 1, 2, 3),
                Arrays.stream(result).boxed().collect(Collectors.toList()));
    }

    @Test
    public void testCourseScheduleII3Example3() {
        int[] result = new CourseScheduleII().findOrder3(1,
                new int[][]{});
        assertEquals(Arrays.asList(0),
                Arrays.stream(result).boxed().collect(Collectors.toList()));
    }
}
