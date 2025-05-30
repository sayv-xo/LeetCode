class Solution {
  public int concatenatedBinary(int n) {
    final int MOD = 1_000_000_007;
    long ans = 0;
    int numberOfBits = 0;

    for (int i = 1; i <= n; ++i) {
      if (Integer.bitCount(i) == 1)
        ++numberOfBits;
      ans = ((ans << numberOfBits) % MOD + i) % MOD;
    }

    return (int) ans;
  }
}
