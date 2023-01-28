import { arrayBuffer } from 'stream/consumers';
import { swap } from './utils';

/**
 * Reverses an array.
 *
 * @param input Array of elements
 * @returns Inverted array
 */
export const reverseArray = (input: any[]): any[] => {
  for (let left = 0, right = input.length - 1; left < input.length / 2; left++, right--) {
    swap(input, left, right);
  }

  return input;
};
