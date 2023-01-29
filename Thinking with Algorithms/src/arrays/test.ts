import { reverseArray } from './Simple';

/**
 * Simple array operations
 *
 * @group array
 */
describe('Arrays ', () => {
  test(' can be reversed', () => {
    expect(reverseArray([1, 2, 3, 4, 5, 6, 7])).toEqual([7, 6, 5, 4, 3, 2, 1]);
  });
});
