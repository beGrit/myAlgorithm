package leetcode.daily;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Author: lsf Time: 9/7/20-9:21 AM
 */
public class Solution19 {

  public int[] topKFrequent(int[] nums, int k) {

    // 使用Hash表记录各个数字出现的频率
    Map<Integer, Integer> map = new HashMap<>();
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      Integer value = map.getOrDefault(nums[i], 0);
      map.put(nums[i], value + 1);
    }

    // 维护一个最小堆
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer t1, Integer t2) {
        return map.get(t1) - map.get(t2);
      }
    });
    for (Integer key : map.keySet()) {
      if (pq.size() < k) {
        pq.add(key);
      } else if (map.get(key) > map.get(pq.peek())) {
        pq.remove();
        pq.add(key);
      }
    }

    // 处理返回
    int[] res = new int[k];
    for (int i = res.length - 1; i >= 0; i--) {
      res[i] = pq.remove();
    }
    return res;
  }

  public int[] topKFrequentFunction2(int[] nums, int k) {
    List<Integer> res = new ArrayList();
    // 使用Hash表记录各个数字出现的频率
    Map<Integer, Integer> map = new HashMap<>();
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      Integer value = map.getOrDefault(nums[i], 0);
      map.put(nums[i], value + 1);
    }

    // 桶排序
    //桶排序
    //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
    List<Integer>[] list = new List[nums.length+1];
    for(int key : map.keySet()){
      // 获取出现的次数作为下标
      int i = map.get(key);
      if(list[i] == null){
        list[i] = new ArrayList();
      }
      list[i].add(key);
    }

    // 倒序遍历数组获取出现顺序从大到小的排列
    for(int i = list.length - 1;i >= 0 && res.size() < k;i--){
      if(list[i] == null) continue;
      res.addAll(list[i]);
    }

    
    return null;
  }
  public static void main(String[] args) {
    Solution19 solution19 = new Solution19();
    int[] nums = {1,1,1,2,2,3};
    solution19.topKFrequent(nums,2);
  }
}
