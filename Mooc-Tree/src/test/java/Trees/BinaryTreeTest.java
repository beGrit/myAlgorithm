package Trees;

import org.junit.Test;

/**
 * Author: lsf Time: 5/22/20-7:01 PM
 */
public class BinaryTreeTest {

  @Test
  public void recursionTraversal() {
  }

  @Test
  public void preOrderTraversal() {
  }

  @Test
  public void inOrderTraversal() {
  }

  @Test
  public void postOrderTraversal() {
  }

  @Test
  public void levelOrderTraversal() {
  }

  @Test
  public void postOrderGetHeight() {
  }

  @Test
  public void createByPreAndIn() {
  }

  @Test
  public void testCreateByPreAndIn() {
  }

  @Test
  public void unRecursionTraversal() {
    int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
    int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

    BinaryTree bt = new BinaryTree();
    bt = bt.createByPreAndIn(pre, in);
    bt.recursionTraversal("postOrder");
  }

  @Test
  public void test01() {
    int a = 10;
    if (true) {
      if (a < 7) {
        System.out.println("a < 7");
      } else if (a < 9) {
        System.out.println("a > 9");
      }
    } else {
      System.out.println("a < 1");
    }
  }
}