/**
 * A Binary Tree node.
 * 
 * Nodes contain data and also links to the sibling nodes
 */
export class TreeNode {
  /**
   * Left child.
   */
  left?: TreeNode | null;

  /**
   * Right child.
   */
  right?: TreeNode | null;

  constructor(public value: number) {
    this.left = null;
    this.right = null;
  }

  /**
   * Add a new node.
   *
   * @param value Value of the node to add.
   */
  addNode(node: TreeNode) {
    // add to left branch
    if (node.value < this.value) {
      if (this.left === null) {
        this.left = node; // new node
      } else {
        this.left?.addNode(node);
      }
    }

    // add to right branch
    else {
      if (this.right === null) {
        this.right = node;
      } else {
        this.right?.addNode(node);
      }
    }
  }

  /**
   * Search for the node presence.
   *
   * @param value Number to search for.
   * @returns True if there is a node with the given value.
   */
  find(value: number): boolean {
    if (value === this.value) return true;

    this.left?.find(value);

    if (value < this.value && this.left !== null) {
      return this.left?.find(value) || false;
    } else if (value > this.value && this.right !== null) {
      return this.right?.find(value) || false;
    }

    return false;
  }

  removeNode(value: number): TreeNode | null {
    // find the value in the right branch
    if (value > this.value) {
      this.right = this.right && this.right.removeNode(value);
    }

    // find the value in the left branch
    else if (value < this.value) {
      this.left = this.left && this.left.removeNode(value);
    }

    // values are equal
    else if (value === this.value) {
      if (!this.left && !this.right) {
        return null;
      }
    }

    return this;
  }

  /**
   * Visit direct children of the node
   */
  visit() {
    this.left?.visit(); // visit left
    console.log(this.value);
    this.right?.visit(); // visit right
  }
}

/**
 * Binary Search Tree (BST) is a data structure where each node has a maximum of two children.
 * 
 * The left child is usually smaller than the right child.
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
