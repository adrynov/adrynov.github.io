import { swap } from "../array/utils";

/**
 * Sort an array using Bubble sort.
 * 
 * The algorithm compares two adjacent elements and swaps them if necessary.
 * Big-O: O(N^2) - not recommended
 * 
 * https://en.wikipedia.org/wiki/Bubble_sort
 */
export const bubbleSort = (input: number [] ) : number[] => {
    let done = false; // optimization trick

    for (let i = 0; i < input.length; i++) {
        done = true;

        for (let j = 0; j < input.length - i - 1; j++) {
          if (input[j] > input[j + 1]) {
            swap(input, j, j + 1);
            done = false; // we swapped numbers, continue
          }
        }
      }

      return input;

}