package leetcode.primary.sortAndSearch;

/**
 * Author: lsf Time: 9/12/20-9:01 PM
 */
public class Solution2 {
  public int firstBadVersion(int n) {
    /**
     * 方法一:二分查找
     */
    int left = 1;
    int right = n;
    int mid = 1;
    while (left <= right) {
      mid = (left + right) / 2;
      if (isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return isBadVersion(mid) ? mid : mid+1;
  }

  public boolean isBadVersion(int version) {
    return false;
  }
}
