/**
 * Search the array for the specified value value using Binary Search algorithm.
 *
 * @param array  Input array
 * @param targetValue  Number to search in the array
 *
 * @returns Index of the target value or -1 if the value is not found.
 */
export function binary_search(array: readonly number[], targetValue: number): number {
  let min = 0;
  let max = array.length - 1;

  // search iteratively
  while (min < max) {
    const middle = Math.round((min + max) / 2);

    if (array[middle] === targetValue) {
      // value exists
      return middle;
    } else if (array[middle] < targetValue) {
      min = middle + 1;
    } else {
      max = middle - 1;
    }
  }

  // value does not exist
  return -1;
}

/**
 * Search the array for a target value using Binary Search algorithm.
 *
 * Uses recursive approach.
 *
 * @param array  Input array
 * @param targetValue  Number to search in the array
 *
 * @returns Index of the target value or -1 if the value is not found.
 */
export function binarySearch(array: number[], target: number): number {
  const left = 0;
  const right = array.length - 1;

  return binary_search_recursive(array, target, left, right);
}

function binary_search_recursive(array: number[], target: number, left: number, right: number): number {
  // base case: value does not exist
  if (right < left) return -1;

  const middle = Math.round((left + right) / 2);

  if (array[middle] == target) return middle;

  if (array[middle] > target) {
    // target might be in the left part
    return binary_search_recursive(array, target, left, middle - 1);
  } else {
    // target might be in the right part
    return binary_search_recursive(array, target, middle + 1, right);
  }
}

/**
 * Locate the target value in the array using Linear Search.
 *
 * @param data  Input array
 * @param value  Element to find
 *
 * @returns Index of the element or -1 if not found.
 *
 * Time complexity: O(n)
 */
export function linear_search(data: number[], value: number): number {
  for (let guess = 0; guess < data.length; guess++) {
    if (data[guess] === value) {
      return guess; // found it!
    }
  }

  return -1;
}
