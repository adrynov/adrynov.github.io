/**
 * Sort an array using Merge Sort.
 *
 * The algorithm divides the array into two halves which both sorted recursively until there is only one small sorted list left.
 * The sorted halves are merged together in sorted order.
 *
 * Big-O: O(N^2)
 *
 * https://en.wikipedia.org/wiki/merge_sort
 */
export const mergeSort = (input: number[]): number[] => {
  if (input.length < 2) return input;

  const middle = Math.floor(input.length / 2);
  const left = input.slice(0, middle);
  const right = input.slice(middle, input.length);

  return merge(mergeSort(left), mergeSort(right));
};

/**
 * Merge two sub-arrays
 * @param left Left array
 * @param right Right array
 * @returns 
 */
function merge(left: number[], right: number[]) {
  const results = [];
  let i = 0;
  let j = 0;

  // copy ordered elements
  while (i < left.length && j < right.length) {
    if (left[i] < right[j]) {
      results.push(left[i++]);
    } else {
      results.push(right[j++]);
    }
  }

  return results.concat(left.slice(i), right.slice(j));
}
