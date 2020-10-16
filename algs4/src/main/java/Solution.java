import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Author: lsf Time: 9/6/20-8:20 PM
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    Scanner sc = new Scanner(System.in);
    List list = new ArrayList<Integer>();
    while (sc.hasNext() == true) {
      list.add(sc.nextDouble());
    }
    int sum = solution.sum(list);
  }

  public void sum(String s) {
    String[] split = s.split(" ");
    List<String> list = Arrays.asList(split);
  }

  public int sum(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    return sum;
  }

  public int sum(List<Double> list) {
    int sum = 0;
    for (Double d : list) {
      sum += d;
    }
    return sum;
  }
}
