export class Node<T> {
  data: T;
  next?: Node<T> | null;

  constructor(data: T);
}

export interface ILinkedList<T> {
  /**
   * Adds a node to the beginning of the list.
   */
  addFirst(value: T): ILinkedList<T>;

  /**
   * Adds a node to the end of the list.
   */
  addLast(value: T): ILinkedList<T>;

  /**
   * Checks whether the list is empty.
   */
  isEmpty(): boolean;

  /**
   * Deletes the node by its value.
   *
   * @param value {T} Value of the node to delete.
   * @returns True if the node was deleted
   */
  deleteNode(value: T): boolean;

  /**
   * Returns the node at the specified index.
   */
  getAt(index: number): Node<T> | null;

  // /**
  //  * Returns the index of the node; returns -1 if not found
  //  *
  //  * @param node List node to find
  //  *  @returns The index of the node or -1.
  //  */
  // indexOf(node: Node<T>): number;
  // /**
  //  * Inserts a new node at the index.
  //  *
  //  * @param index The node will be inserted at this index
  //  * @param element Node to insert
  //  */
  // insertAt(index: number, element: Node<T>): ILinkedList<T>;

  /**
   * Removes the node at the the specified index.
   *
   * @param index {number} The node index
   * @returns Removed node.
   */
  removeAt(index: number): Node<T> | null;

  /**
   * Removes the first node.
   *
   * @returns Removed node.
   */
  removeFirst(): Node<T> | null;

  /**
   * Removes the last node.
   *
   * @returns Removed node.
   */
  removeLast(): Node<T> | null;

  // traverse(): T[];

  /**
   * Returns the number of nodes in the list.
   */
  size(): number;

  // search(comparator: (data: T) => boolean): Node<T> | null;

  /**
   * Empties the list.
   */
  clear(): void;
}
