/**
 * String tests
 *
 * @group strings
 */

import capitalise from './Capitalise';
import { palindrome, reverseString1, reverseString2, reverseString3, reverseString5 } from './Reverse';

describe('capitalise() ', () => {
  test(' is a function', () => {
    expect(typeof capitalise).toEqual('function');
  });

  test(' capitalizes the first letter of each word in the sentence', () => {
    expect(capitalise('hello world from andrei')).toEqual('Hello World From Andrei');
    expect(capitalise(capitalise('a short sentence'))).toEqual('A Short Sentence');
    expect(capitalise('it is working!')).toEqual('It Is Working!');
  });
});

describe('reverse()', () => {
  test(' is a function', () => {
    expect(typeof reverseString1).toBe('function');
  });

  test(' method1 reverses a string', () => {
    expect(reverseString1('apple')).toEqual('elppa');
  });

  test(' method2 reverses a string', () => {
    expect(reverseString2('hola')).toEqual('aloh');
  });

  test(' reverses a string using concatenation', () => {
    expect(reverseString3('Hello World')).toBe('dlroW olleH');
  });

  test(' reverses a string using recursion', () => {
    expect(reverseString5('Hello World')).toBe('dlroW olleH');
  });
});

describe('palindrome() ', () => {
  test(' is a function', () => {
    expect(typeof palindrome).toEqual('function');
  });

  test(' finds palindromes', () => {
    expect(palindrome('aba')).toBeTruthy();
    expect(palindrome('1000000001')).toBeTruthy();
    expect(palindrome('pennep')).toBeTruthy();
  });

  test(' does not find palindromes', () => {
    expect(palindrome(' aba')).toBeFalsy();
    expect(palindrome('aba ')).toBeFalsy();
    expect(palindrome('greetings')).toBeFalsy();
    expect(palindrome('Fish hsif')).toBeFalsy();
  });
});
