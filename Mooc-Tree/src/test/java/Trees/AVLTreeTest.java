package Trees;

import org.junit.Test;

/**
 * Author: lsf Time: 5/24/20-8:45 AM
 */
public class AVLTreeTest {

  @Test
  public void insert() {
    AVLTree at = new AVLTree();
    at.createByArrays(new int[]{1,5,7,9,11,22});
    at.avlDelete(5);
    at.postOrderTraversal(at.getRoot());
  }

  @Test
  public void delete() {
  }

  @Test
  public void avlDelete() {
  }
}