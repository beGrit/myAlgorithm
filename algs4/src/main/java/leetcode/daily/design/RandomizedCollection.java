package leetcode.daily.design;

import java.util.Random;

/**
 * Author: lsf Time: 10/31/20-9:25 AM
 */
class RandomizedCollection {

  private Integer[] indexes;
  private Integer[] values;
  private int capacity;
  private int curSize;

  /** Initialize your data structure here. */
  public RandomizedCollection() {

  }

  /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
  public boolean insert(int val) {
    boolean res = true;
    if (curSize >= capacity/2) {
      resize(2 * capacity);
    }
    int hash = hash(val);
    // 线性探测
    while (true) {
      if (values[hash] == val) { // 存在冲突且冲突位置有重复元素
        res = false;
      }
      if (values[hash] == null) {
        values[hash] = val;
        curSize++;
        indexes[curSize - 1] = hash;
        break;
      } else {
        hash = (hash + 1) % capacity;
      }
    }
    return res;
  }

  /** Removes a value from the collection. Returns true if the collection contained the specified element. */
  public boolean remove(int val) {
    if (!contains(val)) {
      return false;
    }
    int i = hash(val);
    while (values[i] != val) {
      i = (i + 1) % capacity;
    }
    return false;
  }

  public boolean contains(int val) {
    boolean res = false;
    return res;
  }
  /** Get a random element from the collection. */
  public int getRandom() {
    Random random = new Random();
    int index = random.nextInt(indexes.length);
    return values[indexes[index]];
  }

  private int hash(Integer num) {
    return num % capacity;
//    return (num.hashCode() & 0x7fffffff) % capacity;
  }

  private void resize(int newCapacity) {

  }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
