package com.f21a.algorithm.priorityqueue;

/*
Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:
1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is
the array's size.
 */

import java.util.*;

public class TopKFrequentElements {

    // bucket sort: use an array to save numbers into different bucket whose index is the frequency
    // O(nums.length) time because we iterate nums to create the frequency map and then do a bucket sort.
    // O(nums.length) space because of the array we use for bucket sort, also all numbers could be distinct
    // and in this case the HashMap would have one entry for each element.
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int currNum : nums) {
            freqMap.put(currNum, freqMap.getOrDefault(currNum, 0) + 1);
        }

        // Number of occurrences of all elements must be in [0, nums.length].
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : freqMap.keySet()) {
            if (buckets[freqMap.get(key)] == null) {
                buckets[freqMap.get(key)] = new ArrayList<>();
            }
            buckets[freqMap.get(key)].add(key);
        }

        // In case we want to return less than k elements, k could be greater than the number of
        // distinct elements in nums.
        int[] result = new int[Math.min(freqMap.size(), k)];
        int resIdx = 0;
        for (int i = buckets.length - 1; i >= 0; --i) {
            // Because we only initialized buckets that we inserted elements into, empty buckets are null values.
            if (buckets[i] == null) continue;
            for (int currNum : buckets[i]) {
                result[resIdx++] = currNum;
                if (resIdx == result.length) return result;
            }
        }
        return result;
    }

    // use maxHeap. Put entry into maxHeap so we can always poll a number with largest frequency
    // A PriorityQueue is used when the objects are supposed to be processed based on the priority.
    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }

    // use treeMap. Use frequency as the key so we can get all frequencies in order
    // TreeMap is a map implementation that keeps its entries sorted according to the natural ordering of its
    // keys or better still using a comparator if provided by the user at construction time.
    public List<Integer> topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (!freqMap.containsKey(freq)) {
                freqMap.put(freq, new LinkedList<>());
            }
            freqMap.get(freq).add(num);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }
}
