package Trees;

import org.junit.Test;

/**
 * Author: lsf Time: 5/22/20-7:02 PM
 */
public class BinarySearchTreeTest {


  @Test
  public void find() {
//    this.bst.Find(15);
  }

  @Test
  public void testFind() {
  }

  @Test
  public void findMax() {
  }

  @Test
  public void testFindMax() {
  }

  @Test
  public void findMin() {
    BinarySearchTree bst = new BinarySearchTree();
    int[] pre = {30, 15, 41, 33, 35, 34, 50};
    int[] in = {15, 30, 34, 33, 35, 41, 50};
    bst = bst.createByPreAndIn(pre, in);
    System.out.println(bst.FindMin().getData());
  }

  @Test
  public void testFindMin() {
  }

  @Test
  public void delete() {
  }

  @Test
  public void testDelete() {
  }
}