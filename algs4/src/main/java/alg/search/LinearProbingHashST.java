package alg.search;

import org.omg.CORBA.Object;

/**
 * Author: lsf Time: 8/19/20-4:46 PM
 */
public class LinearProbingHashST<Key, Value> {
  // current size
  private int n;
  // capacity
  private int m;
  private Key[] keys;
  private Value[] vals;

  public LinearProbingHashST(int capacity) {
    this.m = capacity;
    this.n = 0;
    keys = (Key[]) new Object[m];
    vals = (Value[]) new Object[m];
  }

  public int size() {
    return n;
  }

  public boolean isEmpty() {
    return n==0;
  }

  private int hash(Key key) {
    return (key.hashCode() & 0x7fffffff) % m;
  }

  private void resize(int newCapacity) {
    LinearProbingHashST<Key,Value> temp = new LinearProbingHashST<Key, Value>(newCapacity);
    for (int i = 0; i < this.m; i++) {
      if(keys[i] != null) {
        temp.put(keys[i],vals[i]);
      }
    }
    keys = temp.keys;
    vals = temp.vals;
    m = temp.m;
  }

  public boolean contains(Key key) {
    assert key!=null;
    return get(key) != null;
  }

  public Value get(Key key) {
    int hash = hash(key);
    while (true) {
      if (keys[hash] == key) {
        return vals[hash];
      } else {
        // 线性探测
        int x = hash;
        while (keys[x] != null) {
          if (keys[x] == key) {
            return vals[x];
          }
        }
      }
    }
//    return null;
  }

  public int getPosition(Key key) {
    return 0;
  }

  public void delete(Key key) {
    if (contains(key)) {
      int hash = hash(key);
//      if ()
    }
  }

  public void put(Key key,Value value) {
    assert key != null;

    if (value == null) {

    }

    if (n >= m/2) {
      resize(2 * m);
    }

    int i = 0;
    int hash = hash(key);
    int rehash = 1;

    // 线性探测
    while (true) {
      if (keys[hash] == null) {
        keys[hash] = key;
        vals[hash] = value;
        n++;
        break;
      } else {
        i++;
        hash = (hash + 1) % m;
      }
    }

  }
}
