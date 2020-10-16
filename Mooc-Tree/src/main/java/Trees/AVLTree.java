package Trees;

/**
 * Author: lsf Time: 5/23/20-10:43 PM
 */
public class AVLTree extends BinarySearchTree {

  private AVLNode root;

  @Override
  public AVLNode getRoot() {
    return root;
  }

  public void setRoot(AVLNode root) {
    this.root = root;
  }

  private int height(AVLNode n) {  // 获取给定结点的高度
    if (n == null) {
      return -1;
    }
    return n.height;
  }

  private void setBalance(AVLNode... ns) { // 更新结点的balance值
    for (AVLNode n : ns) {
      this.reHeight(n);
      n.balance = height(n.right) - height(n.left);
    }
  }

  private void reBalance(AVLNode n) {
    setBalance(n);

    if (n.balance == -2) {
      if (height(n.left.left) >= height(n.left.right)) {
        n = rotateRight(n);
      } else {
        n = rotateLeftThenRight(n);
      }
    } else if (n.balance == 2) {
      if (height(n.right.right) >= height(n.right.left)) {
        n = rotateLeft(n);
      } else {
        n = rotateRightThenLeft(n);
      }
    }

    if (n.parent != null) {
      reBalance(n.parent);    // 递归向上平衡结点
    } else {
      root = n;
    }
  }

  private void reHeight(AVLNode n) { // 重新计算结点高度(高度从 0 开始计算)
    if (n != null) {
      n.height = 1 + Math.max(height(n.left), height(n.right));
    }
  }

  // 旋转操作
  private AVLNode rotateLeft(AVLNode n) {
    AVLNode rt = n.right;     // rt 为原右子树

    n.right = rt.left;
    if (n.right != null) {
      n.right.parent = n;
    }

    rt.left = n;
    rt.parent = n.parent;
    n.parent = rt;

    if (rt.parent != null) {
      if (rt.parent.right == n) {
        rt.parent.right = rt;
      } else {
        rt.parent.left = rt;
      }
    }
    setBalance(n, rt);
    return rt;
  }

  private AVLNode rotateRight(AVLNode n) {
    AVLNode lt = n.left;

    n.left = lt.right;
    if (n.left != null) {
      n.left.parent = n;
    }

    lt.left = n;
    lt.parent = n.parent;
    n.parent = lt;

    if (lt.parent != null) {
      if (lt.parent.left == n) {
        lt.parent.left = lt;
      } else {
        lt.parent.right = lt;
      }
    }
    setBalance(n, lt);
    return lt;
  }

  private AVLNode rotateLeftThenRight(AVLNode n) {
    n.right = rotateLeft(n.left);
    return rotateRight(n);
  }

  private AVLNode rotateRightThenLeft(AVLNode n) {
    n.right = rotateRight(n.right);
    return rotateLeft(n);
  }

  public boolean insert(int key) {
    if (root == null) {
      root = new AVLNode(key, null);
    } else {
      AVLNode n = root;
      AVLNode parent;
      while (true) {
        if (n.getData() == key) { // 数值重复,返回false
          return false;
        }
        parent = n;
        boolean goLeft = n.getData() > key;
        n = goLeft ? n.left : n.right;
        if (n == null) {
          if (goLeft) {
            parent.left = new AVLNode(key, parent);
          } else {
            parent.right = new AVLNode(key, parent);
          }
          reBalance(parent);
          break;
        }
      }
    }
    return true;
  }

  public void delete(AVLNode n) {
    if (n.left == null && n.right == null) {
      if (n.parent == null) {
        root = null;
      } else {
        AVLNode parent = n.parent;
        if (n == parent.left) {
          parent.left = null;
        } else {
          parent.right = null;
        }
        reBalance(parent);
      }
      return;
    }
    if (n.left != null) {
      AVLNode child = n.left;
      child = this.FindMax(child);
      n.setData(child.getData());
      delete(child);
    }
  }

  public void avlDelete(int key) {
    if (root == null) {
      return;
    }
    AVLNode n = root;
    AVLNode child = root;
    while (child != null) {
      n = child;
      child = key >= n.getData()?n.right:n.left;
      if (key == n.getData()) {
        this.delete(n);
        return;
      }
    }
    return;
  }

  public AVLNode Find(int X) { // 查找效率取决于树的高度
    return this.Find(X, root);
  }

  public AVLNode Find(int X, AVLNode localRoot) { // 非递归式 迭代式
    while (localRoot != null) {
      if (X > localRoot.getData()) {
        localRoot = localRoot.right;
      } else if (X < localRoot.getData()) {
        localRoot = localRoot.left;
      } else if (X == localRoot.getData()) {
        return localRoot;
      }
    }
    return null;
  }

  public AVLNode FindMax(AVLNode root) {
    if (root != null) {
      while (root.left != null) {
        root = root.left;
      }
    }
    return root;
  }

  public AVLNode FindMin(AVLNode root) {
    if (root != null) {
      while (root.left != null) {
        root = root.left;
      }
    }
    return root;
  }

  public void createByArrays(int[] a) {
    for (int i : a) {
      this.insert(i);
    }
  }


  private class AVLNode extends BSTNode {

    private int balance;  // 平衡度 H(left) - H(right)
    private int height;   // 树高
    private AVLNode left, right, parent;

    public AVLNode() {

    }

    public AVLNode(BSTNode bn) {
      this(bn.getData(),new AVLNode(bn.left),new AVLNode(bn.right));
    }

    public AVLNode(int data, AVLNode left, AVLNode right) {
      super(data);
      this.left = left;
      this.right = right;
    }

    public AVLNode(int key, AVLNode parent) {
      super(key);
      this.parent = parent;
    }
  }
}
