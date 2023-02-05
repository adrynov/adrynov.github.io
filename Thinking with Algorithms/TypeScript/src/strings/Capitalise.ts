/**
 * Simple string manipulation.
 */


/**
 * Capitalizes the first letter of each word in the string.
 *
 * @param str String where each word is capitalized.
 */
export default function capitalise(str: string): string {
    return str.split(' ')
        .map(word => word.charAt(0).toUpperCase() + word.substring(1))
        .join(' ');
}
