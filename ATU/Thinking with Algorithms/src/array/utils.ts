/**
 * Swaps two numbers in the array.
 *
 * @param input Input array
 * @param a First number
 * @param b Second number
 */
function swap(input: number[], a: number, b: number) {
    const temp = input[b];
    input[b] = input[a];
    input[a] = temp;
  }

  /**
   * Generates an array of integers
   * 
   * @param size Total number of array elements from 0 to 100
   * @returns A random array of integers
   */
  function generateIntArray(size: number): number[] {
    return Array.from({ length: size }, () => Math.floor(Math.random() * 100));
  }

  export {
    generateIntArray,
    swap
  };


  