import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TreeTests {

  /**
   * Tests a left rotation involving the root node.
   */
  @Test
  public void bstLeftRotationAtRoot() {

    // Create a BST with a root and right child.
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    tree.insert(10);
    tree.insert(20);

    // Perform a left rotation at the root.
    tree.rotate(tree.root.getRight(), tree.root);

    // Verify the resulting tree structure.
    Assertions.assertEquals("[ 20, 10 ]", tree.root.toLevelOrderString());
  }

  /**
   * Tests a right rotation involving the root node.
   */
  @Test
  public void bstRightRotationAtRoot() {

    // Create a BST with a root and left child.
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    tree.insert(20);
    tree.insert(10);

    // Perform a right rotation at the root.
    tree.rotate(tree.root.getLeft(), tree.root);

    // Verify the resulting tree structure.
    Assertions.assertEquals("[ 10, 20 ]", tree.root.toLevelOrderString());
  }

  /**
   * Tests a rotation performed below the root node.
   */
  @Test
  public void bstRotationBelowRoot() {

    // Create a BST where the rotation occurs in a subtree.
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    tree.insert(30);
    tree.insert(10);
    tree.insert(20);

    // Rotate node 20 above node 10.
    tree.rotate(tree.root.getLeft().getRight(), tree.root.getLeft());

    // Verify the resulting structure.
    Assertions.assertEquals("[ 30, 20, 10 ]", tree.root.toLevelOrderString());
  }

  /**
   * Tests the right-right insertion case that requires
   * a single rotation in the red-black tree.
   */
  @Test
  public void rbtSimpleLineInsertion() {

    // Create a red-black tree.
    RedBlackTree<Integer> tree = new RedBlackTree<>();

    // Insert values that create a line configuration.
    tree.insert(1);
    tree.insert(2);
    tree.insert(3);

    // Verify balancing and coloring.
    Assertions.assertEquals("[ 2.b, 1.r, 3.r ]",
        tree.root.toLevelOrderString());
  }

  /**
   * Tests the recoloring case where the parent and aunt
   * of the inserted node are both red.
   */
  @Test
  public void rbtRecolorInsertion() {

    // Create a red-black tree.
    RedBlackTree<Integer> tree = new RedBlackTree<>();

    // Insert nodes that trigger recoloring.
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(1);

    // Verify colors after recoloring.
    Assertions.assertEquals("[ 10.b, 5.b, 15.b, 1.r ]",
        tree.root.toLevelOrderString());
  }

  /**
   * Tests the zig-zag insertion case that requires
   * a double rotation in the red-black tree.
   */
  @Test
  public void rbtZigZagInsertion() {

    // Create a red-black tree.
    RedBlackTree<Integer> tree = new RedBlackTree<>();

    // Insert nodes that create a zig-zag configuration.
    tree.insert(10);
    tree.insert(5);
    tree.insert(7);

    // Verify balancing and coloring.
    Assertions.assertEquals("[ 7.b, 5.r, 10.r ]",
        tree.root.toLevelOrderString());
  }
}
