import Stack from '.';

/**
 * Stack test.
 *
 * @group data
 * @group data/stack
 */
describe('Stack ', () => {
  test(' is a class', () => {
    expect(typeof Stack.prototype.constructor).toEqual('function');
  });

  test(' can add and remove items', () => {
    const stack = new Stack();

    stack.push(1);
    expect(stack.pop()).toEqual(1);

    stack.push(2);
    expect(stack.pop()).toEqual(2);
  });

  test(' follows FILO', () => {
    const stack = new Stack();

    stack.push(1);
    stack.push(2);
    stack.push(3);

    expect(stack.pop()).toEqual(3);
    expect(stack.pop()).toEqual(2);
    expect(stack.pop()).toEqual(1);
  });

  test(' peek() returns the top element', () => {
    const stack = new Stack();

    stack.push(1);
    stack.push(2);
    stack.push(3);

    expect(stack.peek()).toEqual(3);
    expect(stack.pop()).toEqual(3);
    expect(stack.peek()).toEqual(2);
    expect(stack.pop()).toEqual(2);
    expect(stack.peek()).toEqual(1);
    expect(stack.pop()).toEqual(1);
  });
});
