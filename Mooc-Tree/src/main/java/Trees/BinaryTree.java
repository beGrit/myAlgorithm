package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author: lsf Time: 5/22/20-1:50 PM
 */
public class BinaryTree {

  protected Node root;

  public BinaryTree() {
    this.root = null;
  }

  public static void main(String[] args) {
    int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
    int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

    BinaryTree bt = new BinaryTree();
    bt = bt.createByPreAndIn(pre, in);
    bt.preOrderTraversal(bt.getRoot());
    bt.inOrderTraversal(bt.getRoot());
    System.out.println();
    bt.postOrderTraversal(bt.getRoot());
  }

  /*
  public BinaryTree CreateBinaryTree() {
    return null;
  }
  */

  public Boolean isEmpty(BinaryTree BT) {
    return root.equals(null);
  }

  /*
   * 常用的遍历方法
   * */
  // Recursion 递归方式
  public void recursionTraversal(String s) {
    if (s.equals("preOrder")) {
      this.preOrderTraversal(root);
    } else if (s.equals("inOrder")) {
      this.inOrderTraversal(root);
    } else if (s.equals("postOrder")) {
      this.postOrderTraversal(root);
    }
  }

  public void preOrderTraversal(Node localRoot) { // 遍历
    if (localRoot != null) {
      System.out.print(localRoot.data + " ");
      preOrderTraversal(localRoot.left);
      preOrderTraversal(localRoot.right);
    }
  }

  public void inOrderTraversal(Node localRoot) { // 中序遍历
    if (localRoot != null) {
      inOrderTraversal(localRoot.left);
      System.out.print(localRoot.data + " ");
      inOrderTraversal(localRoot.right);
    }
  }

  public void postOrderTraversal(Node localRoot) { // 后序遍历
    if (localRoot != null) {
      postOrderTraversal(localRoot.left);
      postOrderTraversal(localRoot.right);
      System.out.print(localRoot.data + " ");
    }
  }

  // 非递归 方式(使用 数据结构:栈)

  public void unRecursionTraversal(String s) {
    if (s.equals("preOrder")) {
      this.preOrderTraversalNoRecursion();
    } else if (s.equals("inOrder")) {
      this.inOrderTraversalNoRecursion();
    } else if (s.equals("postOrder")) {
      this.postOrderTraversalNoRecursion();
    }
  }

  private void preOrderTraversalNoRecursion() {
    Stack<Node> S = new Stack<Node>();
    Node n = this.getRoot();
    while (n != null || !S.isEmpty()) {
      while (n != null) {
        System.out.println(n.getData());
        S.push(n);
        n = n.left;
      }
      if (S.isEmpty()) {
        n = S.pop();
        n = n.right;
      }
    }
  }

  private void inOrderTraversalNoRecursion() { // 非递归方式
    Stack<Node> S = new Stack<Node>();
    Node n = this.getRoot();
    while (n != null || !S.isEmpty()) {
      while (n != null) { // 若结点非空,则不停压栈 (第一次遇到x结点)
        S.push(n);
        n = n.left;     // 深度搜索左子树
      }
      if (!S.isEmpty()) { // 若遇到空结点,且栈非空(即需要转向遍历) (第二次遇到x结点)
        n = S.pop();
        System.out.println(n.getData());
        n = n.right;
      }
    }
  }

  private void postOrderTraversalNoRecursion() {
    this.postOrderTraversalNoRecursionS1();
  }

  private void postOrderTraversalNoRecursionS1() { // 方法1
    Node pre = null, top = null, curr = null;
    Stack<Node> S = new Stack<Node>();
    S.push(getRoot());
    while (!S.isEmpty()) {
      top = S.peek();
      if (pre == null || pre.left == top || pre.right == top) {
        if (top.left == null && top.right == null) {
          curr = S.pop();
          System.out.print(curr.getData() + " ");
        }
        if (top.left != null) {
          S.push(top.left);
        } else if (top.right != null) {
          S.push(top.right);
        }
      } else if (pre == top.left) {
        if (top.right != null) {
          S.push(top.right);
        } else if (top.right == null) {
          curr = S.pop();
          System.out.print(curr.getData() + " ");
        }
      } else if (pre == top.right) {
        curr = S.pop();
        System.out.print(curr.getData() + " ");
      } else {
        System.out.println(curr.getData() + " ");
      }
      pre = top;
    }
  }

  private void postOrderTraversalNoRecursionS1_plus() { // 方法1(代码冗余重构版本 -- 单输出口)
    Node pre = null, top = null, curr = null;
    Stack<Node> S = new Stack<Node>();
    S.push(getRoot());
    while (!S.isEmpty()) {
      top = S.peek();
      if (pre == null || pre.left == top || pre.right == top) {
        if (top.left != null) {
          S.push(top.left);
        } else if (top.right != null) {
          S.push(top.right);
        }
      } else if (pre == top.left) {
        if (top.right != null) {
          S.push(top.right);
        }
      } else { // else if (top == pre || pre == top.right)
        curr = S.pop();
        System.out.print(curr.getData() + " ");
      }
      pre = top;
    }
  }

  private void postOrderTraversalNoRecursionS2() { // 标记法

  }

  private void postOrderTraversalNoRecursionS3() { // 双栈法

  }

  // 广度优先(层次)遍历 实现
  public void levelOrderTraversal(Node localRoot) { // 层次遍历
    Queue<Node> Q = new LinkedList<Node>();
    Q.add(localRoot);
    while (Q.isEmpty() != true) {
      localRoot = Q.remove();
      System.out.println(localRoot);
      if (localRoot.left != null) {
        Q.add(localRoot.left);
      }
      if (localRoot.right != null) {
        Q.add(localRoot.right);
      }
    }
  }

  public int postOrderGetHeight(Node localRoot) {
    if (localRoot != null) {
      int leftHeight = postOrderGetHeight(localRoot.left);
      int rightHeight = postOrderGetHeight(localRoot.right);
      int maxH = leftHeight > rightHeight ? leftHeight : rightHeight;
      return maxH + 1;
    } else {
      return 0;
    }
  }

  /*
   * Create by pre/in orderTraversal string
   * 1)create sub tree By pre order
   * 2)get subRoot By level order
   * */
  public BinaryTree createByPreAndIn(int[] pre, int[] in) {
    BinaryTree bt;
    bt = new BinaryTree();
    bt.root = this.createByPreAndIn(pre, 0, pre.length - 1, in, 0, in.length - 1);
    return bt;
  }

  public Node createByPreAndIn(int[] pres, int preStart, int preEnd, int[] in, int inStart,
      int inEnd) {
    int rootIndex = -1, rootValue;
    int leftLength, rightLength;
    Node root = new Node();
// 反射
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

  public Node getRoot() {
    return root;
  }

  public void setRoot(Node root) {
    this.root = root;
  }

  class Node {

    public int data;
    public Node left;
    public Node right;

    public Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }

    public Node(int data) {
      this.data = data;
    }

    public Node() {
      this.data = 0;
      this.left = null;
      this.right = null;
    }

    public int getData() {
      return data;
    }

    public void setData(int data) {
      this.data = data;
    }
  }

}
