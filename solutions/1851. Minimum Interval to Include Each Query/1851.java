class Solution {
  public int[] minInterval(int[][] intervals, int[] queries) {
    record T(int size, int right) {}
    int[] ans = new int[queries.length];
    Arrays.fill(ans, -1);
    Queue<T> minHeap = new PriorityQueue<T>(Comparator.comparingInt(T::size));
    Integer[] indices = new Integer[queries.length];

    for (int i = 0; i < queries.length; ++i)
      indices[i] = i;

    Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
    Arrays.sort(indices, Comparator.comparingInt(index -> queries[index]));

    int i = 0; // intervals' index
    for (final int index : indices) {
      while (i < intervals.length && intervals[i][0] <= queries[index]) {
        minHeap.offer(new T(intervals[i][1] - intervals[i][0] + 1, intervals[i][1]));
        ++i;
      }
      while (!minHeap.isEmpty() && minHeap.peek().right < queries[index])
        minHeap.poll();
      if (!minHeap.isEmpty())
        ans[index] = minHeap.peek().size;
    }

    return ans;
  }
}
