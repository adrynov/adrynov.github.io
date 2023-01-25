/**
 * Test graphs
 *
 * @group data
 * @group data/graph
 */

import Graph from './index';

describe('Graph ', () => {
  const nodes = ['A', 'B', 'C', 'D', 'E', 'F'];

  let graph: Graph;

  /**
   * A - B - D
   * |      / \
   * C - - E - F
   *
   * DFS(Iterative): A-C-E-F-D-B
   * DFS(Recursive): A-B-D-E-C-F
   * BFS: A-B-C-D-E-F
   */
  const fullGraph: string[] = [
    'A -> B C ',
    'B -> A D ',
    'C -> A E ',
    'D -> B E F ',
    'E -> C D F ',
    'F -> D E '
  ];

  /**
   * Initialize a graph for each test 
   */
  beforeEach(() => {
    graph = new Graph();

    // add nodes (vertices)
    for (let i = 0; i < nodes.length; i++) {
      graph.addNode(nodes[i]);
    }

    // connect nodes
    graph.addEdge('A', 'B')
    graph.addEdge('A', 'C')
    graph.addEdge('B', 'D')
    graph.addEdge('C', 'E')
    graph.addEdge('D', 'E')
    graph.addEdge('D', 'F')
    graph.addEdge('E', 'F')

  });

  afterEach(() => {
    jest.restoreAllMocks();
  });

  test(' should construct', () => {
    expect(graph).not.toBeNull();
    // expect(Graph).toHaveBeenCalledTimes(1);
    // const functionNameMock = jest.fn();
    // jest.spyOn(Graph.prototype, "functionName").mockImplementation(functionNameMock);
    // jest.spyOn(Graph.prototype, 'constructor');
  });

  test(' adds a node', () => {
    //   const spy = jest.spyOn(video, 'play');
    const spy = jest.spyOn(graph, 'addNode');
    graph.addNode('H');

    expect(spy).toHaveBeenCalled();
    //   spy.mockReset();
    //   spy.mockRestore();
  });

  test(' creates adjacency lists', () => {
    const mockFn = jest.fn();
    graph.print(mockFn); // output the graph into the mock

    // expect 6 calls
    expect(mockFn.mock.calls.length).toEqual(graph.totalNodes);

    // get graph data
    const data = mockFn.mock.calls.map((v) => v[0]);
    expect(data).toEqual(fullGraph);
  });

});
