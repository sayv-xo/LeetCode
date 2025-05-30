from enum import Enum


class Direction(Enum):
  FORWARD = 0
  BACKWARD = 1


class Solution:
  def minimumJumps(self, forbidden: list[int], a: int, b: int, x: int) -> int:
    furthest = max(x + a + b, max(pos + a + b for pos in forbidden))
    seenForward = {pos for pos in forbidden}
    seenBackward = {pos for pos in forbidden}

    # (direction, position)
    q = collections.deque([(Direction.FORWARD, 0)])

    ans = 0
    while q:
      for _ in range(len(q)):
        dir, pos = q.popleft()
        if pos == x:
          return ans
        forward = pos + a
        backward = pos - b
        if forward <= furthest and forward not in seenForward:
          seenForward.add(forward)
          q.append((Direction.FORWARD, forward))
        # It cannot jump backward twice in a row.
        if dir == Direction.FORWARD and backward >= 0 and backward not in seenBackward:
          seenBackward.add(backward)
          q.append((Direction.BACKWARD, backward))
      ans += 1

    return -1
