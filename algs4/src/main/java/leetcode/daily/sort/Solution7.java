package leetcode.daily.sort;

/**
 * Author: lsf Time: 11/18/20-8:17 PM
 */
public class Solution7 {

  public static void main(String[] args) {
    Solution7 solution7 = new Solution7();
    int[] gas = {3, 3, 4};
    int[] cost = {3, 4, 4};
    solution7.canCompleteCircuit(gas, cost);
  }

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int len = gas.length;
    int res = -1;
    for (int i = 0; i < len && res == -1; i++) {
      boolean[] visited = new boolean[len];
      int curIndex = i;
      int nextIndex = (i + 1) % len;
      int x = gas[i];
      while (true) {
        if (x < cost[curIndex] && !visited[nextIndex]) {
          // 到达不了下一个加油站
          break;
        } else if (x >= cost[curIndex] && !visited[nextIndex]) {
          visited[nextIndex] = true;
          x = x - cost[curIndex] + gas[nextIndex];
        } else if (x > cost[curIndex] && visited[nextIndex]) {
          res = i;
          break;
        }
        curIndex = nextIndex;
        nextIndex = (nextIndex + 1) % len;
      }
    }
    return res;
  }
}
