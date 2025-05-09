class Solution {
  public List<Integer> longestCommonSubsequence(int[][] arrays) {
    final int MAX = 100;
    List<Integer> ans = new ArrayList<>();
    int[] count = new int[MAX + 1];

    for (int[] array : arrays)
      for (final int a : array)
        if (++count[a] == arrays.length)
          ans.add(a);

    return ans;
  }
}
