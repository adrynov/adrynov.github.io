# Algorithms

My small collection of data structures and algorithms for educational purposes.

There are many more resources on algorithms such as [The Algorithms](https://github.com/TheAlgorithms)
 and [Awesome Algorithms](A curated list of awesome places to learn and/or practice algorithms).

## Features

This section contains algorithms in the following categories:

* Binary Search, Linear Search 
* Bubble Sort
* 

The section showcases the following data structures:

* Graph
* Queue
* Stack
* Tree

## Configuration

Have have Node.js 10+ installed.

Install NPM packages: `npm i` or `yarn`


## Testing

To run all tests, execute: `npm run test` or `yarn test`

Run a specific test group: 

```bash
npm run test --group=search/binary
yarn test --group=data/stack
```

To run multiple groups:

```
// execute tests in the unit/bar and unit/foo groups
yarn test -- --group=unit/bar --group=unit/foo

// execute tests in the unit group (including unit/bar and unit/foo groups)
yarn test -- --group=unit
```

## Resources

https://www.toptal.com/developers/sorting-algorithms/bubble-sort