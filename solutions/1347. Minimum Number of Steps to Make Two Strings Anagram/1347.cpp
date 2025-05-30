class Solution {
 public:
  int minSteps(string s, string t) {
    vector<int> count(26);

    for (const char c : s)
      ++count[c - 'a'];

    for (const char c : t)
      --count[c - 'a'];

    return accumulate(count.begin(), count.end(), 0, [](int acc, int c) {
      return acc + abs(c);
    }) / 2;
  }
};
