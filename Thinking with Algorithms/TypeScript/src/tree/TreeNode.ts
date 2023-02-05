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
