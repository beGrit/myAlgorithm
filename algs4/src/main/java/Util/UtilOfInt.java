package Util;

import java.util.Arrays;

/**
 * Author: lsf Time: 11/10/20-4:34 PM
 */
public class UtilOfInt {
  public Integer[] intToInteger_Array(int[] nums) {
    Integer[] integers1 = Arrays.stream(nums).boxed().toArray(Integer[]::new);
    return integers1;
  }
}
