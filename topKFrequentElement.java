/*
 * Given an integer array nums and an integer k, return the k most 
 * frequent elements. You may return the answer in any order.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFrequentElement {
    public int[] freqElements(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : arr) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            heap.add(entry);
            if (heap.size() > k) {
                heap.poll(); // remove least frequent
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll().getKey();
        }
        return result;
    }
}
