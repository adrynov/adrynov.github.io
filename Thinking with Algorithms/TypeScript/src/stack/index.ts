/**
 * Last-In First-Out data structure.
 */
class Stack<T> {
  private data: T[] = [];

  /**
   * Pushes the item to the top of the stack
   * @param item Item
   */
  push(item: T) {
    this.data.push(item);
  }

  /**
   * Removes the top item from the stack.
   *
   * @returns The top item.
   */
  pop(): T | undefined {
    return this.data.pop();
  }

  /**
   * Examines the top item without removing it.
   *
   * @returns The top item.
   */
  peek(): T | undefined {
    return this.data[this.data.length - 1];
  }
}

export default Stack;
