import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> map.get(o1) - map.get(o2)
        );

        for (int key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else {
                if (map.get(key) > map.get(priorityQueue.peek())) {
                    priorityQueue.remove();
                    priorityQueue.add(key);
                }
            }
        }

        LinkedList<Integer> result = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.remove());
        }

        return result;
    }
}