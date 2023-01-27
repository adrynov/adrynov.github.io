/**
 * Node of a Binary Tree.
 */
export class Node {
  /**
   * Left child.
   */
  left?: Node | null;

  /**
   * Right child.
   */
  right?: Node | null;

  constructor(public value: number) {
    this.left = null;
    this.right = null;
  }

  /**
   * Add a new node.
   *
   * @param value Value of the node to add.
   */
  addNode(node: Node) {
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

  removeNode(value: number): Node | null {
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
    //     if (val === this.value) {
    //       if (!this.left && !this.right) {
    //         return null
    //       } else {
    //         if (this.left) {
    //           const leftMax = maxVal(this.left)
    //           this.value = leftMax
    //           this.left = this.left.removeNode(leftMax)
    //         } else {
    //           const rightMin = minVal(this.right)
    //           this.value = rightMin
    //           this.right = this.right.removeNode(rightMin)
    //         }
    //       }
    //     } else if (val < this.value) {
    //       this.left = this.left && this.left.removeNode(val)
    //     } else if (val > this.value) {
    //       this.right = this.right && this.right.removeNode(val)
    //     }
    //     return this
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
 * Binary Search Tree (BST) is a data structure where each node has a maxium of two children.
 */
export class BinarySearchTree {
  /**
   * The root of the tree
   */
  root: Node | null;

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
    const node = new Node(value);

    if (this.root === null) {
      this.root = node;
    } else {
      this.root.addNode(node);
    }
  }

  /**
   * Find the maximum value in the tree.
   */
  max(node: Node): number {
    // this is the maxium value
    if (!node.right) {
      return node.value;
    }

    return this.max(node.right);
  }

  /**
   * Find the minimum value in the tree.
   */
  min(node: Node): number {
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

  traverseInorder(node?: Node | null) {
    if (!node) return;

    this.traverseInorder(node?.left);
    console.log(node.value);
    this.traverseInorder(node?.right);
  }
}

//---------------------------------------------

// class Tree

//   // Traverse Postorder
//   public void traversePostOrder(Node node) {
//   if (node != null) {
//     traversePostOrder(node.left);
//     traversePostOrder(node.right);
//     System.out.print(" " + node.key);
//   }
//   }

//   // Traverse Preorder
//   public void traversePreOrder(Node node) {
//   if (node != null) {
//     System.out.print(" " + node.key);
//     traversePreOrder(node.left);
//     traversePreOrder(node.right);
//   }
//   }
//   void postorder(Node node) {
//     if (node == null)
//       return;

//     // Traverse left
//     postorder(node.left);
//     // Traverse right
//     postorder(node.right);
//     // Traverse root
//     System.out.print(node.item + "->");
//     }

//     void inorder(Node node) {
//     if (node == null)
//       return;

//     // Traverse left
//     inorder(node.left);
//     // Traverse root
//     System.out.print(node.item + "->");
//     // Traverse right
//     inorder(node.right);
//     }

//     void preorder(Node node) {
//     if (node == null)
//       return;

//     // Traverse root
//     System.out.print(node.item + "->");
//     // Traverse left
//     preorder(node.left);
//     // Traverse right
//     preorder(node.right);
//     }

//     // Start by searching the root
//     Tree.prototype.search = function (val) {
//       const found = this.root.search(val)
//       if (found !== null) {
//         return found.value
//       }
//       // not found
//       return null
//     }
