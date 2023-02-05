import { binary_search, binarySearch, linear_search } from './index';

/**
 * Test search algorithms.
 *
 * @group search
 * @group search/binary
 */
describe('Binary Search ', () => {
  test(' finds the prime number 67', () => {
    const primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97];

    const result = binary_search(primes, 67);
    expect(result).toEqual(18);
  });

  test(' recursively finds the prime number 67', () => {
    const primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97];

    const result = binarySearch(primes, 67);
    expect(result).toEqual(18);
  });
});

describe('Linear Search ', () => {
  test(' finds the prime number 67', () => {
    const primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97];

    const result = linear_search(primes, 67);
    expect(result).toEqual(18);
  });
});
