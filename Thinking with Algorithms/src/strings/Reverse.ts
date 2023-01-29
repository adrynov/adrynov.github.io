/**
 * Reverses the given string.
 *
 * @param str Input string
 * @returns New string with the reversed order of characters
 */

export function reverseString1(str: string): string {
    let start = 0, end = str.length;

    const reversed = new Array(str.length);

    while (start <= end) {
        const temp = str[start];
        reversed[start] = str[end];
        reversed[end] = temp;

        start += 1;
        end -= 1;
    }

    return reversed.join('');
}

export function reverseString2(str: string): string {
    return str.split('').reverse().join('');
}

export function reverseString3(str: string): string {
    const reversed: string[] = [];

    for (let index = str.length - 1; index >= 0; index--) {
        reversed.push(str[index])
    }

    return reversed.join('');
}

export function reverseString4(str: string): string {
    let reversed = '';

    for (const character of str) {
        reversed = character + reversed;
    }

    return reversed;
}


/**
 * Reverses a string using recursion.
 */
export function reverseString5(str: string) : string {
    if (!str || str.length === 0) return "";
    if (str.length === 1) return str;

    return str.charAt(str.length - 1) + reverseString5(str.substring(0, str.length - 1));
}

/**
 * Given a string, return true if the string is a palindrome or false if it is not.
 * 
 * A palindromes is a string that forms the same word if it is reversed. 
 *  
 *  palindrome("abba") === true
 * palindrome("abcdefg") === false
 *
 * @param str
 */
export function palindrome(str: string): boolean {
    const reversed = str.split('').reverse().join('');
    return str === reversed;
}

