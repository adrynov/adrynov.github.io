/**
 * Sort an array using Insertion Sort
 *
 * Insertion Sort is a stable comparison sort algorithm with poor performance
 *
 * Big-O: O(N^2) - not recommended
 *
 * https://en.wikipedia.org/wiki/insertion_sort
 *
 * @param input Array of numbers
 * @returns Sorted array
 */
export const insertionSort = (arr: number[]): number[] => {
  for (let i = 1; i < arr.length; i++) {
    const current = arr[i];
    let j;

    for (j = i - 1; j >= 0 && arr[j] > current; j--) {
      arr[j + 1] = arr[j];
    }

    arr[j + 1] = current;
  }
  return arr;
};
