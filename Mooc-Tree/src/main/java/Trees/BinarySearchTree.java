package Trees;

/**
 * Author: lsf Time: 5/22/20-5:29 PM
 */
public class BinarySearchTree extends BinaryTree { // Binary Search Tree

  protected BSTNode root;

  public BinarySearchTree() {
  }

  @Override
  public BSTNode getRoot() {
    return root;
  }

  @Override
  public BinarySearchTree createByPreAndIn(int[] pre, int[] in) {
    BinarySearchTree bt;
    bt = new BinarySearchTree();
    bt.root = this.createByPreAndIn(pre, 0, pre.length - 1, in, 0, in.length - 1);
    return bt;
  }

  @Override
  public BSTNode createByPreAndIn(int[] pres, int preStart, int preEnd, int[] in, int inStart,
      int inEnd) {
    int rootIndex = -1, rootValue;
    int leftLength, rightLength;
    BSTNode root = new BSTNode();
    rootValue = pres[preStart];
    root.setData(rootValue);

    if (preStart == preEnd && inStart == inEnd) { // 叶结点
      return root;
    }

    for (int i = inStart; i <= inEnd; i++) { // 寻找 root 在中序遍历序列中的位置
      if (in[i] == rootValue) {
        rootIndex = i;
        break;
      }
    }

    leftLength = rootIndex - inStart;
    rightLength = inEnd - rootIndex;
    if (leftLength > 0) { // 递归构造左子树
      root.left = createByPreAndIn(pres, preStart + 1, preStart + leftLength, in, inStart,
          rootIndex - 1);
    }
    if (rightLength > 0) { // 递归构造右子树
      root.right = createByPreAndIn(pres, preStart + 1 + leftLength, preEnd, in, rootIndex + 1,
          inEnd);
    }
    return root;
  }

  //  查找操作
  public BSTNode Find(int X) { // 查找效率取决于树的高度
    return this.Find(X, this.getRoot());
  }

  public BSTNode Find(int X, BSTNode localRoot) { // 非递归式 迭代式
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

  public BSTNode FindMax(BSTNode root) {
    if (root != null) {
      while (root.right != null) {
        root = root.right;
      }
    }
    return root;
  }

  public BSTNode FindMax() {
    return this.FindMax(root);
  }

  public BSTNode FindMin(BSTNode root) {
    if (root != null) {
      while (root.left != null) {
        root = root.left;
      }
    }
    return root;
  }

  public BSTNode FindMin() {
    return this.FindMin(root);
  }

  //  插入/删除 操作
  public BSTNode delete(int X,BSTNode m) {
    BSTNode n = m;
    BSTNode res = null,tmp = null;
    while (n != null) {
      if (X > this.getRoot().getData()) {
        n = n.right;
      } else if (X < this.getRoot().getData()) {
        n = n.left;
      } else if (X == this.getRoot().getData()) {
        if (n.left != null && n.right !=null) {
          tmp = this.FindMin(n.right);
          n.setData(tmp.data);
          res = delete(tmp.data,n.right);
        } else {
          tmp = n;
          res = n;
          if ( n.left == null ) {
            n = n.right;
          } else if ( n.right == null) {
            n = n.left;
          }
          tmp = null;
        }
      }
    }
    return res;
  }

  public BSTNode delete(int X) {
    return delete(X,root);
  }

  class BSTNode extends Node {

    public int index;
    public BSTNode left;
    public BSTNode right;

    public BSTNode(int data, BSTNode left, BSTNode right) {
      super(data);
      this.left = left;
      this.right = right;
    }

    public BSTNode() {
      super();
    }

    public BSTNode(int key) {
      super(key);
    }

    @Override
    public int getData() {
      return super.getData();
    }

    @Override
    public void setData(int data) {
      super.setData(data);
    }
  }

}
