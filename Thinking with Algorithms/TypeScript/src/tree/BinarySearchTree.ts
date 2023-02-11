import { TreeNode } from './TreeNode';

/**
 * Binary Search Tree (BST) is a binary tree that adds the constraint of order.
 *
 * Items to the left are less than the parent. Items to the right are greater than the parent.
 * The left child is smaller than the right child.
 *
 *  Worst search time: O(n)
 *      6
 *   4     8
 * 0  5      19
 *
 */
export class BinarySearchTree {
  /**
   * The root of the tree
   */
  root: TreeNode | null;

  constructor() {
    this.root = null;
  }

  search(value: number) {
    //     const found = this.root.search(val)
    //     if (found !== null) {
    //       return found.value
    //     }
    //     // not found
    //     return null
  }

  /**
   * Add a new value to the Binary Search Tree
   * @param value Value to insert into BST
   */
  insert(value: number) {
    const node = new TreeNode(value);

    if (this.root === null) {
      this.root = node;
    } else {
      this.root.addNode(node);
    }
  }

  /**
   * Find the maximum value in the tree.
   */
  max(node: TreeNode): number {
    // this is the maxium value
    if (!node.right) {
      return node.value;
    }

    return this.max(node.right);
  }

  /**
   * Find the minimum value in the tree.
   */
  min(node: TreeNode): number {
    // this is the minimum value
    if (!node.left) {
      return node.value;
    }

    return this.min(node.left);
  }

  /**
   * Remove a value from the tree.
   * @param value Value to remove from BST
   */
  remove(value: number) {
    this.root = this.root && this.root.removeNode(value);
  }

  /**
   * In-order traversal:
   * - visit all the nodes in the left subtree
   * - visit the root
   * - visit all the nodes in the right subtree
   */
  traverse() {
    // empty tree
    if (!this.root) return;

    this.root.visit();
  }

  traverseInOrder(node?: TreeNode | null) {
    if (!node) return;

    this.traverseInOrder(node?.left);
    console.log(node.value);
    this.traverseInOrder(node?.right);
  }
}
