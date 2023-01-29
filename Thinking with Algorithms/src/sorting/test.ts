import { generateIntArray } from '../arrays/utils';

import { bubbleSort } from './BubbleSort';
import { insertionSort } from './InsertionSort';
import { mergeSort } from './MergeSort';

/**
 * Test sorting algorithms.
 *
 * @group sort
 */
describe('Sort an array', () => {
  // let input: number[] = [];
  // let clone: number[] = [];

  // beforeEach(() => {
  //     input = generateIntArray(10);
  //     clone = [...input];
  // });

  test(' with Bubble Sort', () => {
    const input = [2, 5, 8, 1, 4];
    expect(bubbleSort(input)).toEqual([1, 2, 4, 5, 8]);
  });

  test(' with Insertion Sort', () => {
    const input = [12, 31, 25, 8, 32, 17];
    expect(insertionSort(input)).toEqual([8, 12, 17, 25, 31, 32]);
  });

  test(' with Merge Sort', () => {
    expect(mergeSort([])).toEqual([]);
    expect(mergeSort([12, 11, 15, 10, 9, 1, 2, 3, 13, 14, 4, 5, 6, 7, 8])).toEqual([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]);
  });
});