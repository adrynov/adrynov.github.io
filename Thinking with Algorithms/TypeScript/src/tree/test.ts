import { BinarySearchTree, TreeNode } from './BinarySearchTree';

/**
 * Stack test.
 *
 * @group data
 * @group data/tree
 */
describe('Binary Tree ', () => {
  test(' is a class', () => {
    expect(typeof BinarySearchTree.prototype.constructor).toEqual('function');
  });

  test(' has nodes', () => {
    const tree = new BinarySearchTree();

    // root
    tree.insert(2);

    // root children
    tree.insert(76);
    tree.insert(21);

    // expect(tree.root?.left?.value).toEqual(21);
    // expect(tree.root?.right?.value).toEqual(76);

    // third level
    tree.insert(82);
    tree.insert(52);
    tree.insert(18);
    tree.insert(27);

    // leaves
    tree.insert(49);
    tree.insert(30);
    tree.insert(12);
    tree.insert(20);
    tree.insert(30);
    tree.insert(49);
    tree.insert(63);
    tree.insert(91);
  });
});
