/**
 * Graph implementation using Adjacency List
 */
class Graph {
  /**
   * Nodes (vertices) containing data.
   */
  private nodes: any = {};

  /**
   * Adds a new value to the graph
   * @param value Node value
   */
  addNode(value: string) {
    // each node is referenced by it value
    this.nodes[value] = [];
  }

  /**
   * Connects two graph nodes.
   * @param node1 
   * @param node2 
   */
  addEdge(node1: string, node2: string) {
    if (this.hasNode(node1) && this.hasNode(node2)) {
      this.nodes[node1].push(node2);
      this.nodes[node2].push(node1);
    }
  }

  hasNode(node: string) {
    return typeof this.nodes[node] !== 'undefined';
  }

  /**
   * Outputs the graph contents.
   * @param output Output such as console
   */
  print(output = (value: string) => console.log(value)) {
    for (const key of Object.keys(this.nodes)) {
      const values = this.nodes[key];
      let vertex = ''
      for (const j of values) {
        vertex += j + ' '
      }
      output(key + ' -> ' + vertex)
    }
  }

  /**
   * Returns the number of nodes/vertices in the graph.
   */
   get totalNodes() : number {
    return Object.keys(this.nodes).length;
  }


  // /**
  //  * Prints the Breadth first traversal of the graph from source.
  //  * @param {number} source The source vertex to start BFS.
  //  */
  // bfs (source, output = value => console.log(value)) {
  //   const queue = [[source, 0]] // level of source is 0
  //   const visited = new Set()

  //   while (queue.length) {
  //     const [node, level] = queue.shift() // remove the front of the queue
  //     if (visited.has(node)) { // visited
  //       continue
  //     }

  //     visited.add(node)
  //     output(`Visited node ${node} at level ${level}.`)
  //     for (const next of this.adjacencyMap[node]) {
  //       queue.push([next, level + 1]) // level 1 more than current
  //     }
  //   }
  // }

  // /**
  //  * Prints the Depth first traversal of the graph from source.
  //  * @param {number} source The source vertex to start DFS.
  //  */
  // dfs (source, visited = new Set(), output = value => console.log(value)) {
  //   if (visited.has(source)) { // visited
  //     return
  //   }

  //   output(`Visited node ${source}`)
  //   visited.add(source)
  //   for (const neighbour of this.adjacencyMap[source]) {
  //     this.dfs(neighbour, visited, output)
  //   }
  // }
}

export default Graph;
