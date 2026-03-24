package PractiseQuestions;

import java.util.*;

class PairGraph{
    int node;
    int parent;
    public PairGraph(int node, int parent){
        this.node = node;
        this.parent = parent;
    }
}

class PairGraphMinMultiplication{
    int num;
    int steps;
    public PairGraphMinMultiplication(int num, int steps){
        this.num = num;
        this.steps = steps;
    }
}

class PairIsland{
    int row;
    int col;
    public PairIsland(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class PairRottenOranges{
    int row;
    int col;
    int time;
    public PairRottenOranges(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class PairDijkstraPQ{
    int dist;
    int node;
    public PairDijkstraPQ(int dist, int node){
        this.dist = dist;
        this.node = node;
    }
}

class PairGraphWord{
    String firstWord;
    int level;
    public PairGraphWord(String firstWord, int level){
        this.firstWord = firstWord;
        this.level = level;
    }
}

class TupleGraph{
    int distance;
    int row;
    int col;
    public TupleGraph(int distance, int row, int col){
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}

class TupleGraphFlights{
    int stops;
    int node;
    int cost;
    public TupleGraphFlights(int stops, int node, int cost){
        this.cost = cost;
        this.node = node;
        this.stops = stops;
    }
}

class Graph{
    public HashMap<Integer, ArrayList<Integer>> adjList;

    public Graph(){
        adjList = new HashMap();
    }

    public void addVertex(int vertex){
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(int source, int destination){
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());
        adjList.get(source).add(destination);
        adjList.get(destination).add(source); // can be removed if it is a directed graph
    }

    public void displayGraph(){
        for(int vertex : adjList.keySet()){
            System.out.print(vertex + " -> ");
            for(int neighbour : adjList.get(vertex)){
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }
    }
}

class Edge{
    int destination;
    int weight;
    public Edge(int destination, int weight){
        this.destination = destination;
        this.weight = weight;
    }
}

class GraphWeighted{

    HashMap<Integer, ArrayList<Edge>> adjList;
    public GraphWeighted(){
        adjList = new HashMap<>();
    }

    public void addVertex(int vertex){
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(int source, int destination, int weight){
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());
        adjList.get(source).add(new Edge(destination, weight));
        adjList.get(destination).add(new Edge(source, weight));
    }

    public void displayGraph(){
        for(int vertex : adjList.keySet()){
            System.out.print(vertex + " -> ");
            for(Edge edge : adjList.get(vertex)){
                System.out.print("(" + edge.destination + ", weight=" + edge.weight + ") ");
            }
            System.out.println();
        }
    }
}

class GraphDirected{
    public HashMap<Integer, ArrayList<Integer>> adjList;
    public GraphDirected(){
        adjList = new HashMap<>();
    }

    public void addVertex(int source){
        adjList.putIfAbsent(source, new ArrayList<>());
    }

    public void addEdge(int source, int destination){
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());
        adjList.get(source).add(destination);
    }
    public void displayGraph(){
        for(int vertex : adjList.keySet()){
            System.out.print(vertex + " -> ");
            for(int neighbour : adjList.get(vertex)){
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }
    }
}

class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        for(int i = 0; i < n; i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;

        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        }
        else{
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }

    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
        else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
        System.out.println(parent + "\n" + size + "\n");
    }
}

class EdgeKruskal implements Comparable<EdgeKruskal>{
    int src, dest, weight;
    EdgeKruskal(int _src, int _dest, int _wt){
        this.src = _src; this.dest = _dest; this.weight = _wt;
    }
    public int compareTo(EdgeKruskal compareEdge){
        return this.weight - compareEdge.weight;
    }
}

public class GraphsPractise {

    public static void main(String[] args) {
//        Graph graph = new Graph();
//        graph.addEdge(1,2);
//        graph.addEdge(2,3);
//        graph.addEdge(2,6);
//        graph.addEdge(6,5);
//        graph.addEdge(5,4);
//        graph.addEdge(3,4);
//        graph.addEdge(4,7);
//        graph.addEdge(7,8);

//        isBipartiteBFS(graph.adjList.size(), graph);
//        isBipartiteDFS(graph.adjList.size(), graph);

//        Graph cycleUndirectedGraph = new Graph();
//        cycleUndirectedGraph.addEdge(1, 2);
//        cycleUndirectedGraph.addEdge(1, 3);
//        cycleUndirectedGraph.addEdge(3, 4);
//        cycleUndirectedGraph.addEdge(3, 6);
//        cycleUndirectedGraph.addEdge(2, 5);
//        cycleUndirectedGraph.addEdge(5, 7);
//        cycleUndirectedGraph.addEdge(6, 7);

//        graph.addEdge(1, 2);
//        graph.addEdge(1, 6);
//        graph.addEdge(2, 3);
//        graph.addEdge(2, 4);
//        graph.addEdge(4, 5);
//        graph.addEdge(7, 8);
//        graph.addEdge(6, 7);
//        graph.addEdge(6, 9);
//        graph.addEdge(5, 8);
//        graph.displayGraph();

//        GraphWeighted graphWeighted = new GraphWeighted();
//        graphWeighted.addEdge(0,1,2);
//        graphWeighted.addEdge(0,4,1);
//        graphWeighted.addEdge(1,2,3);
//        graphWeighted.addEdge(4,2,2);
//        graphWeighted.addEdge(4,5,4);
//        graphWeighted.addEdge(2,3,6);
//        graphWeighted.addEdge(5,3,1);
//        graphWeighted.displayGraph();

//        int[][] graphEdges = new int[][]{{0,1,2}, {0,4,1},{1,2,3},{4,2,2},{4,5,4},{2,3,6},{5,3,1}};
//        int n = 6; int m = 7;
//        shortestPathInDirectedGraph(n, m, graphEdges);

//        int[][] graphEdges = new int[][]{{0,1}, {0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
//        int n = 9, m = 10;
//        shortestPathInUndirectedGraph(n, m, graphEdges, 0);

//        String[] wordList = new String[]{"des", "der", "dfr", "dgt", "dfs"};
//        String startWord = "der"; String targetWord = "dfs";
//        wordLadderLength(startWord, targetWord, wordList);
//        wordLadderSequence(startWord, targetWord, wordList);

//        int v = 3, s = 0;
//        dijkstraAlgoPQ(v, s);
//        dijkstraAlgoSet(v, s);

//        int n = 5, m = 6;
//        int[][] edges = {{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}};
//        shortestPathInWeightedUndirectedGraph(n, m, edges);

//        int[] source = {0, 1};
//        int[] destination = {2,2};
//        int[][] grid = {
//                {1,1,1,1},
//                {1,1,0,1},
//                {1,1,1,1},
//                {1,1,0,0},
//                {1,0,0,1}
//        };
//        print(shortestPathInABinaryMaze(grid, source, destination));

//        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
//        print(pathWithMinimumEffort(heights));

//        int source = 0; int destination = 3; int k = 1; int n = 4;
//        int[][] flights = new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
//        print(cheapestFlightWithinKStops(n, flights,source, destination, k));
//        int start = 3, end = 75, mod = 100000;
//        int[] arr = {2, 5, 7};
//        print(minimumMultiplications(arr, start, end, mod));

//        int n = 7, m = 10;
//        int[][] edges = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
//        countPaths(n, edges);

//        int[][] edges = {{0,1,9}};
//        int s = 0;
//        int v = 2;
//        print(Arrays.toString(bellmanFordAlgo(edges, s, v)));

//        int[][] matrix = {{0,1,43},{1,0,6},{-1,-1,0}};
//        floydWarshallAlgo(matrix);

//        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
//        int n = 4, m = 4;
//        findCityWithThresholdFW(n, m, edges, 4);
//        findCityWithThresholdDij(n, m, edges, 4);

//        int[][] edges = {
//                {0, 1, 2},
//                {0, 3, 6},
//                {1, 2, 3},
//                {1, 3, 8},
//                {1, 4, 5},
//                {2, 4, 7},
//                {3, 4, 1}
//        };
//        minimumSpanningTree(5, edges);

//        bfsGraphTraversal(graph);
//        dfsGraphTraversal(graph);
//        print(bfsDetectCycleInUndirectedGraph(cycleUndirectedGraph, cycleUndirectedGraph.adjList.size()));
//        print(bfsDetectCycleInUndirectedGraph(graph, graph.adjList.size()));
//        print(dfsDetectCycleInUndirectedGraph(graph, graph.adjList.size()));
//        print(dfsDetectCycleInUndirectedGraph(cycleUndirectedGraph, cycleUndirectedGraph.adjList.size()));

//        GraphDirected graphDirected = new GraphDirected();
//        graphDirected.addEdge(0,1);
//        graphDirected.addEdge(1,2);
//        graphDirected.addEdge(2,3);
//        graphDirected.addEdge(3,4);
//        graphDirected.addEdge(3,5);
//        graphDirected.addEdge(5,6);
//        graphDirected.addEdge(4,6);
//        graphDirected.addEdge(6,7);
//        graphDirected.addEdge(11,9);
//        graphDirected.addEdge(9,10);
//        graphDirected.addEdge(10,8);
//        graphDirected.addEdge(8,9);
//        graphDirected.addEdge(8,1);

//        graphDirected.displayGraph();
//        findEventualSafeNodes(graphDirected.adjList.size(), graphDirected);
//        kahnsAlgorithmTopologicalSorting(graphDirected);
//        checkCycleInDirectedGraphBFS(graphDirected);
//        int[][] arr = new int[][]{{1,0},{2,1},{3,2}};
//        courseSchedular(arr);
//        findEventualSafeNodesTopologicalSort(graphDirected);

//        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
//        alienDictionaryTopo(dict, 4);

//        print(dfsDetectCycleInDirectedGraph(graphDirected, graphDirected.adjList.size()));
//        topologicalSort(graphDirected, graphDirected.adjList.size());
//        numberOfProvinces(graph);

//        int[][] area = new int[][]{{0,1,1,0},{0,1,1,0},{0,0,1,0},{0,0,0,0},{1,1,0,1}};
//        numberOfIslands(area);

//        int[][] grid = new int[][]{{1,1,1},{2,2,0},{2,2,2}};
//        floodFillAlgo(grid, 2, 0, 3);

//        int[][] basket = new int[][]{{0, 1, 2},{0, 1, 1},{2, 1, 1}};
//        rottenOranges(basket);

//        int[][] grid = new int[][]{{0,0,0},{0,1,0},{1,0,1}};
//        distanceOfNearestCellHaving1(grid);

//        char[][] grid = new char[][]{
//                {'X', 'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X', 'O'},
//                {'X', 'X', 'O', 'X', 'O'},
//                {'X', 'O', 'X', 'O', 'X'},
//                {'O', 'O', 'X', 'X', 'X'}};
//        replaceOWithX(grid);

//        int[][] grid = new int[][]{
//                {0,0,0,1,1},
//                {0,0,1,1,0},
//                {0,1,0,0,0},
//                {0,1,1,0,0},
//                {0,0,0,1,1},
//        };
//        numberOfEnclaves(grid);
//        int[][] grid = new int[][]{
//                {1,1,0,1,1},
//                {1,0,0,0,0},
//                {0,0,0,0,1},
//                {1,1,0,1,1}
//        };
//        numberOfDistinctIslands(grid);
//        numberOfDistinctIslandsBFS(grid);

//        DisjointSet ds = new DisjointSet(8);
//        ds.unionBySize(1,2);
//        ds.unionBySize(2,3);
//        ds.unionBySize(4,5);
//        ds.unionBySize(6,7);
//        ds.unionBySize(5,6);
//
//        if(ds.findUPar(3) == ds.findUPar(7)){
//            print("Same");
//        }
//        else{
//            print("No Same");
//        }
//        ds.unionBySize(3, 7);
//        if(ds.findUPar(3) == ds.findUPar(7)){
//            print("Same");
//        }
//        else{
//            print("No Same");
//        }

//        int[][] adjGraph = {{0,1,5},{1,2,3},{0,2,1}};
//        kruskalAlgoSpanningTree(3, adjGraph);

//        int[][] edges = {{1,0,1},{0,1,0},{1,0,1}};
//        numberOfProvincesDisjoinSet(edges, 3);
        int n = 4, m = 3;
        int[][] edges = {{0,1},{0,2},{1,2}};
        print(minimumOperationsNeededToMakeNetworkConnected(n,  m, edges));

    }

    public static int minimumOperationsNeededToMakeNetworkConnected(int n, int m, int[][] edges){
        DisjointSet ds = new DisjointSet(n);
        int cntExtras = 0;
        for(int i = 0; i < m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(ds.findUPar(u) == ds.findUPar(v)){
                cntExtras++;
            }
            else{
                ds.unionBySize(u, v);
            }
        }
        int cntC = 0;
        for(int i = 0; i < n; i++){
            if(ds.parent.get(i) == i){
                cntC++;
            }
        }
        int ans = cntC - 1;
        if(cntExtras >= ans){
            return ans;
        }
        return -1;
    }

    public static void numberOfProvincesDisjoinSet(int[][] edges, int v){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < v; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            for(int j = 0; j < edges[0].length; j++){
                if(edges[i][j] == 1 && i != j){
                    graph.get(i).add(j);
                }
            }
        }
        DisjointSet ds = new DisjointSet(v);
        for(int i = 0; i < v; i++){
            for(int neighbor : graph.get(i)){
                ds.unionBySize(i, neighbor);
            }
        }
        int cnt = 0;
        for(int i = 0; i < v; i++){
            if(ds.findUPar(i) == i){
                cnt++;
            }
        }
        print(cnt);
    }

    public static void kruskalAlgoSpanningTree(int n, int[][] edges){
        List<EdgeKruskal> edgeList = new ArrayList<>();
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            edgeList.add(new EdgeKruskal(u, v, w));
        }
        Collections.sort(edgeList);
        DisjointSet ds = new DisjointSet(n);
        int mstWt = 0;
        for(EdgeKruskal edge : edgeList){
            int u = edge.src;
            int v = edge.dest;
            int w = edge.weight;
            if(ds.findUPar(u) != ds.findUPar(v)){
                mstWt += w;
                ds.unionBySize(u, v);
            }
        }
        print(mstWt);
    }

    public static void minimumSpanningTree(int n, int[][] edges){
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }
        PriorityQueue<PairDijkstraPQ> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int[] vis = new int[n];
        pq.offer(new PairDijkstraPQ(0, 0));
        int sum = 0;
        while(!pq.isEmpty()){
            PairDijkstraPQ curr = pq.poll();
            int node = curr.node;
            int wt = curr.dist;
            if(vis[node] == 1){
                continue;
            }
            vis[node] = 1;
            sum += wt;
            for(Edge edge : graph.get(node)){
                int adjNode = edge.destination;
                int adjWt = edge.weight;
                if(vis[adjNode] == 0){
                    pq.offer(new PairDijkstraPQ(adjWt, adjNode));
                }
            }
        }
        print(sum);
    }

    public static void findCityWithThresholdDij(int n, int m, int[][] edges, int threshold){
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i = 0; i < edges.length; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }
        int cntCity = n;
        int cityNo = -1;
        for(int i = 0; i < n; i++){
            int[] dist = dijkstraAlgoToFindCityWithMinThreshold(n, graph, i);
            int count = 0;
            for(int j = 0; j < n; j++){
                if(dist[j] <= threshold){
                    count++;
                }
            }
            if(count <= cntCity){
                cntCity = count;
                cityNo = i;
            }
        }
        print(cityNo);
    }

    public static int[] dijkstraAlgoToFindCityWithMinThreshold(int n, ArrayList<ArrayList<Edge>> graph, int src){
        PriorityQueue<PairDijkstraPQ> priorityQueue = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int[] dist = new int[n];
        priorityQueue.offer(new PairDijkstraPQ(0, src));
        dist[src] = 0;
        while(!priorityQueue.isEmpty()){
            PairDijkstraPQ it = priorityQueue.poll();
            int dis = it.dist;
            int node = it.node;
            for(Edge iter : graph.get(node)){
                int adjNode = iter.destination;
                int edN = iter.weight;
                if(edN + dis < dist[adjNode]){
                    dist[adjNode] = edN + dis;
                    priorityQueue.offer(new PairDijkstraPQ(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }

    public static void findCityWithThresholdFW(int n, int m, int[][] edges, int threshold){
        int[][] distance = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            distance[u][v] = w;
            distance[v][u] = w;
        }
        for(int i = 0; i < n; i++){
            distance[i][i] = 0;
        }
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(distance[i][k] == Integer.MAX_VALUE || distance[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    else{
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }
        int cntCity = n;
        int cityNo = -1;
        for(int city = 0; city < n; city++){
            int cnt = 0;
            for(int adjCity = 0; adjCity < n; adjCity++){
                if(distance[city][adjCity] <= threshold){
                    cnt++;
                }
            }
            if(cnt <= cntCity){
                cntCity = cnt;
                cityNo = city;
            }
        }
        print(cityNo);
    }

    public static void floydWarshallAlgo(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = (int)(1e9);
                }
                if(i == j){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(matrix[i][i] < 0){
                print("Not possible");
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == (int)(1e9)){
                    matrix[i][j] = -1;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                print(matrix[i][j]);
            }
        }
    }

    public static int[] bellmanFordAlgo(int[][] edges, int s, int v){
        int[] dist = new int[v];
        Arrays.fill(dist, (int)(1e9));
        dist[s] = 0;

        for (int i = 0; i < v - 1; i++){
            for(int[] edge : edges){
                int u = edge[0];
                int vtx = edge[1];
                int wt = edge[2];
                if(dist[u] != (int)(1e9) && dist[u] + wt < dist[vtx]){
                    dist[vtx] = dist[u] + wt;
                }
            }
        }

        for(int[] edge : edges){
            int u = edge[0];
            int vtx = edge[1];
            int wt = edge[2];
            if(dist[u] != (int)(1e9) && dist[u] + wt < dist[vtx]){
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }

    public static void countPaths(int n, int[][] edges){
        ArrayList<ArrayList<Edge>> adjGraph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjGraph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adjGraph.get(edges[i][0]).add(new Edge(edges[i][1], edges[i][2]));
            adjGraph.get(edges[i][1]).add(new Edge(edges[i][0], edges[i][2]));
        }
        PriorityQueue<PairDijkstraPQ> priorityQueue = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        priorityQueue.offer(new PairDijkstraPQ(0, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, (int)(1e9));
        int[] ways = new int[n];
        dist[0] = 0;
        int mod = (int)(1e9) + 7;
        ways[0] = 1;

        while (!priorityQueue.isEmpty()){
            PairDijkstraPQ it = priorityQueue.poll();
            int dis = it.dist;
            int node = it.node;
            if(dis > dist[node]){
                continue;
            }
            for(Edge iter : adjGraph.get(node)){
                int adjNode = iter.destination;
                int edN = iter.weight;
                if(dis + edN < dist[adjNode]){
                    dist[adjNode] = dis + edN;
                    priorityQueue.add(new PairDijkstraPQ(dis + edN, adjNode));
                    ways[adjNode] = ways[node];
                }
                else if(dis + edN == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        print(ways[n-1] % mod);
    }

    public static int minimumMultiplications(int[] arr, int start, int end, int mod){
        Queue<PairGraphMinMultiplication> queue = new LinkedList<>();
        queue.offer(new PairGraphMinMultiplication(start, 0));
        int[] dist = new int[100000];
        Arrays.fill(dist, (int)(1e9));
        dist[start] = 0;
        while(!queue.isEmpty()){
            int node = queue.peek().num;
            int steps = queue.peek().steps;
            queue.poll();
            for(Integer it : arr){
                int num = (it * node) % mod;
                if(steps + 1 < dist[num]){
                    dist[num] = steps + 1;
                    if(num == end){
                        return steps + 1;
                    }
                    queue.offer(new PairGraphMinMultiplication(num, steps + 1));
                }
            }
        }
        return -1;
    }

    public static int cheapestFlightWithinKStops(int n, int[][] flights, int src, int des, int k){
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < flights.length; i++){
            adj.get(flights[i][0]).add(new Edge(flights[i][1], flights[i][2]));
        }
        Queue<TupleGraphFlights> queue = new LinkedList<>();

        queue.offer(new TupleGraphFlights(0, src, 0));
        int[] distance = new int[n];
        Arrays.fill(distance, (int)(1e9));
        distance[src] = 0;
        while(!queue.isEmpty()){
            TupleGraphFlights it = queue.poll();
            int stops = it.stops;
            int node = it.node;
            int cost = it.cost;
            if(stops > k){
                continue;
            }
            for(Edge iter : adj.get(node)){
                int adjNode = iter.destination;
                int edN = iter.weight;
                if(cost + edN < distance[adjNode] && stops <= k){
                    distance[adjNode] = cost + edN;
                    queue.offer(new TupleGraphFlights(stops + 1, adjNode, cost + edN));
                }
            }
        }
        if(distance[des] == (int)(1e9)){
            return -1;
        }
        else{
            return distance[des];
        }
    }

    public static int pathWithMinimumEffort(int[][] height){
        PriorityQueue<TupleGraph> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int n = height.length; int m = height[0].length;
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = (int)(1e9);
            }
        }
        dist[0][0] = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        pq.offer(new TupleGraph(0, 0, 0));
        while(!pq.isEmpty()){
            TupleGraph it = pq.poll();
            int diff = it.distance;
            int row = it.row;
            int col = it.col;
            if(row == n - 1 && col == m-1){
                return diff;
            }
            for(int i = 0; i < 4; i++){
                int newR = row + dr[i];
                int newC = col + dc[i];
                if(newR >= 0 && newC >= 0 && newR < n && newC < m){
                    int newEffort = Math.max(diff, Math.abs(height[row][col] - height[newR][newC]));
                    if(newEffort < dist[newR][newC]){
                        dist[newR][newC] = newEffort;
                        pq.offer(new TupleGraph(newEffort, newR, newC));
                    }
                }
            }
        }
        return 0;
    }

    public static int shortestPathInABinaryMaze(int[][] grid, int[] source, int[] destination){
        Queue<TupleGraph> queue = new LinkedList<>();
        int n = grid.length; int m = grid[0].length;
        int[][] dist = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = (int)(1e9);
            }
        }
        dist[source[0]][source[1]] = 0;
        queue.offer(new TupleGraph(0, source[0], source[1]));
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while(!queue.isEmpty()){
            TupleGraph it = queue.poll();
            int dis = it.distance;
            int r = it.row;
            int c = it.col;
            for(int i = 0; i < 4; i++){
                int newR = r + dr[i];
                int newC = c + dc[i];
                if(newR >= 0 && newC >= 0 && newC < m && newR < n && grid[newR][newC] == 1 && dis + 1 < dist[newR][newC]){
                    dist[newR][newC] = 1 + dis;
                    if(newR == destination[0] && newC == destination[1]){
                        return dis + 1;
                    }
                    queue.add(new TupleGraph(1 + dis, newR, newC));
                }
            }
        }
        return -1;
    }

    public static void shortestPathInWeightedUndirectedGraph(int n, int m, int[][] edges){
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            graph.get(edges[i][0]).add(new Edge(edges[i][1], edges[i][2]));
            graph.get(edges[i][1]).add(new Edge(edges[i][0], edges[i][2]));
        }
        PriorityQueue<PairDijkstraPQ> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        for(int i = 0; i <= n; i++){
            dist[i] = (int)(1e9);
            parent[i] = i;
        }
        dist[1] = 0;
        pq.add(new PairDijkstraPQ(0, 1));
        while(!pq.isEmpty()){
            PairDijkstraPQ it = pq.poll();
            int node = it.node;
            int dis = it.dist;
            for(Edge neighbours : graph.get(node)){
                int adjNode = neighbours.destination;
                int edN = neighbours.weight;
                if(dis + edN < dist[adjNode]){
                    dist[adjNode] = dis + edN;
                    pq.add(new PairDijkstraPQ(dis + edN, adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if(dist[n] == (int) (1e9)){
            path.add(-1);
            print(path);
        }
        int node = n;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        print(path);
    }

    public static void dijkstraAlgoSet(int v, int s){
        TreeSet<PairDijkstraPQ> set = new TreeSet<>((a, b) -> a.dist == b.dist ? a.node - b.node : a.dist - b.dist);
        int[] dist = new int[v];
        Arrays.fill(dist, (int)(1e9));
        dist[s] = 0;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // same graph
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(0, 1)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 4)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 2)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(1, 2)));

        set.add(new PairDijkstraPQ(0, s));
        while (!set.isEmpty()){
            PairDijkstraPQ pairDijkstraPQ = set.pollFirst();
            int dis = pairDijkstraPQ.dist;
            int node = pairDijkstraPQ.node;
            for(int i = 0; i < adj.get(node).size(); i++){
                int edgeNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);
                if(dis + edgeWeight < dist[edgeNode]){
                    if(dist[edgeNode] != (int)(1e9)){
                        set.remove(new PairDijkstraPQ(dist[edgeNode], edgeNode));
                    }
                    dist[edgeNode] = dis + edgeWeight;
                    set.add(new PairDijkstraPQ(dist[edgeNode], edgeNode));
                }
            }
        }
        print(Arrays.toString(dist));
    }

    public static void dijkstraAlgoPQ(int v, int s){
        PriorityQueue<PairDijkstraPQ> priorityQueue = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        int[] dist = new int[v];
        Arrays.fill(dist, (int)(1e9));
        dist[s] = 0;

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(0, 1)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 4)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 2)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(1, 2)));

        print(adj + "\n");
        priorityQueue.add(new PairDijkstraPQ(0, s));

        while(!priorityQueue.isEmpty()){
            PairDijkstraPQ current = priorityQueue.poll();
            int dis = current.dist;
            int node = current.node;
            if (dis > dist[node]) continue;
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);

                if (dis + edgeWeight < dist[edgeNode]) {
                    dist[edgeNode] = dis + edgeWeight;
                    priorityQueue.add(new PairDijkstraPQ(dist[edgeNode], edgeNode));
                }
            }
        }
        print(Arrays.toString(dist));
    }

    public static void wordLadderSequence(String startWord, String targetWord, String[] wordList){
        Set<String> st = new HashSet<>();
        int len = wordList.length;
        for(int i = 0; i < len; i++){
            st.add(wordList[i]);
        }
        Queue<ArrayList<String>> queue = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        queue.add(ls);

        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);

        int level = 0;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        while(!queue.isEmpty()){
            ArrayList<String> vec = queue.peek();
            queue.poll();
            if(vec.size() > level){
                level++;
                for(String it : usedOnLevel){
                    st.remove(it);
                }
            }
            String word = vec.get(vec.size()-1);
            if(word.equals(targetWord)){
                if(ans.isEmpty()){
                    ans.add(vec);
                }
                else if(ans.get(0).size()==vec.size()){
                    ans.add(vec);
                }
            }
            for(int i = 0; i < word.length(); i++){
                char[] replacedCharArray = word.toCharArray();
                for(char c = 'a'; c <= 'z'; c++){
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);
                    if(st.contains(replacedWord)){
                        vec.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(vec);
                        queue.add(temp);
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size()-1);
                    }
                }
            }
        }
        print(ans);
    }

    public static void wordLadderLength(String startWord, String targetWord, String[] wordList){
        Queue<PairGraphWord> queue = new LinkedList<>();
        queue.add(new PairGraphWord(startWord, 1));
        Set<String> st = new HashSet<>();
        int len = wordList.length;
        for(int i = 0; i < len; i++){
            st.add(wordList[i]);
        }
        st.remove(startWord);
        while(!queue.isEmpty()){
            String word = queue.peek().firstWord;
            int steps = queue.peek().level;
            queue.poll();
            if(word.equals(targetWord)){
                print(steps);
                break;
            }
            for(int i = 0; i < word.length(); i++){
                char[] replacedCharArray = word.toCharArray();
                for(char ch = 'a'; ch <= 'z'; ch++){
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        queue.add(new PairGraphWord(replacedWord, steps + 1));
                    }
                }
            }
        }
        print(0);
    }

    public static void shortestPathInUndirectedGraph(int n, int m, int[][] graphEdges, int src) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            graph.get(graphEdges[i][0]).add(graphEdges[i][1]);
            graph.get(graphEdges[i][1]).add(graphEdges[i][0]);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, (int)(10e9));
        dist[src] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.poll();
            for(Integer it : graph.get(node)){
                if(dist[node] + 1 < dist[it]){
                    dist[it] = 1 + dist[node];
                    queue.add(it);
                }
            }
        }
        print(Arrays.toString(dist));
    }

    public static void shortestPathInDirectedGraph(int n, int m, int[][] graphEdges){
        ArrayList<ArrayList<Edge>> adjGraph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ArrayList<Edge> temp = new ArrayList<>();
            adjGraph.add(temp);
        }
        for(int i = 0; i < m; i++){
            int u = graphEdges[i][0];
            int v = graphEdges[i][1];
            int w = graphEdges[i][2];
            adjGraph.get(u).add(new Edge(v, w));
        }
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                topoSortShortestPath(i, adjGraph, vis, st);
            }
        }
        int[] dist = new int[n];
        Arrays.fill(dist, (int)(10e9));
        dist[0] = 0;
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();
            for(int i = 0; i < adjGraph.get(node).size(); i++){
                int v = adjGraph.get(node).get(i).destination;
                int wt = adjGraph.get(node).get(i).weight;
                if(dist[node] + wt < dist[v]){
                    dist[v] = wt + dist[node];
                }
            }
        }
        print(Arrays.toString(dist));
    }

    public static void topoSortShortestPath(int node, ArrayList<ArrayList<Edge>> adjGraph, int[] vis, Stack<Integer> st){
        vis[node] = 1;
        for(int i = 0; i < adjGraph.get(node).size(); i++){
            int v = adjGraph.get(node).get(i).destination;
            if(vis[v] == 0){
                topoSortShortestPath(v, adjGraph, vis, st);
            }
        }
        st.add(node);
    }

    public static void alienDictionaryTopo(String[] dict, int numOfCharacters){
        GraphDirected graphDirected = new GraphDirected();
        for(int i = 0; i < dict.length-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());
            for(int ptr = 0; ptr < len; ptr++){
                if(s1.charAt(ptr) != s2.charAt(ptr)){
                    graphDirected.addEdge(s1.charAt(ptr) - 'a', s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        graphDirected.displayGraph();
        List<Integer> topo = alienTopoSort(graphDirected, numOfCharacters);
        String ans = "";
        for(int it : topo){
            ans += (char)(it + (int)'a');
        }
        print(ans);
    }

    public static List<Integer> alienTopoSort(GraphDirected graphDirected, int numOfChars){
        int size = graphDirected.adjList.size();
        int[] inDegree = new int[size];
        for(int i = 0; i < size; i++){
            for(Integer it : graphDirected.adjList.get(i)){
                inDegree[it]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < size; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.peek();
            ans.add(node);
            queue.poll();
            for(Integer it: graphDirected.adjList.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    queue.add(it);
                }
            }
        }
        return ans;
    }

    public static void findEventualSafeNodesTopologicalSort(GraphDirected graphDirected){
        GraphDirected reverseGraph = new GraphDirected();
        int size = graphDirected.adjList.size();
        int[] indegree = new int[size];
        for(int i = 0; i < size; i++){
            for(Integer it : graphDirected.adjList.get(i)){
                indegree[i]++;
                reverseGraph.addEdge(it, i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < size; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.peek();
            ans.add(node);
            queue.poll();
            for(Integer it : reverseGraph.adjList.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    queue.add(it);
                }
            }
        }
        print(ans);
    }

    public static void courseSchedular(int[][] arr){
        GraphDirected graphDirected = new GraphDirected();
        for(int[] i : arr){
            graphDirected.addEdge(i[0], i[1]);
        }
        int size = graphDirected.adjList.size();
        int[] indegree = new int[size];
        for(int i = 0; i < size; i++){
            for(Integer it : graphDirected.adjList.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < size; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.peek();
            ans.add(node);
            queue.poll();
            for(Integer it : graphDirected.adjList.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    queue.add(it);
                }
            }
        }
        if(ans.size() == size){
            print("false");
        }
        else{
            print(ans);
        }
    }

    public static void checkCycleInDirectedGraphBFS(GraphDirected graphDirected){
        int size = graphDirected.adjList.size();
        int[] inDegree = new int[size];
        for(int i = 0; i < size; i++){
            for(Integer it : graphDirected.adjList.get(i)){
                inDegree[it]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < size; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int cnt = 0;
        while(!queue.isEmpty()){
            int node = queue.peek();
            cnt++;
            queue.poll();
            for(Integer it: graphDirected.adjList.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    queue.add(it);
                }
            }
        }
        print(cnt == size);
    }

    public static void findEventualSafeNodes(int size, GraphDirected graphDirected){
        int[] vis = new int[size];
        int[] pathVis = new int[size];
        int[] check = new int[size];
        for(int i = 0; i < size; i++){
            if(vis[i] == 0){
                dfsEventualSafeNodes(i, graphDirected, vis, pathVis, check);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < size; i++){
            if(check[i] == 1){
                safeNodes.add(i);
            }
        }
        print(safeNodes);
    }

    public static boolean dfsEventualSafeNodes(int node, GraphDirected graphDirected, int[] vis, int[] pathVis, int[] check){
        vis[node] = 1; pathVis[node] = 1; check[node] = 0;
        for(Integer it: graphDirected.adjList.get(node)){
            if(vis[it] == 0){
                if(dfsEventualSafeNodes(it, graphDirected, vis, pathVis, check)){
                    return true;
                }
            }
            else if(pathVis[it] == 1){
                return true;
            }
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }

    public static void isBipartiteDFS(int V, Graph graph){
        int[] color = new int[V+1];
        for(int i = 1; i <= V; i++){
            color[i] = -1;
        }
        for(int i = 1; i <= V; i++){
            if(color[i] == -1){
                if(!checkIsBipartiteDFS(i, 0, color, graph)){
                    print("No");
                    break;
                }
            }
        }
        print("Yes");
    }

    public static boolean checkIsBipartiteDFS(int node, int col, int[] color, Graph graph){
        color[node] = col;
        for(Integer it : graph.adjList.get(node)){
            if(color[it] == -1){
                if(!checkIsBipartiteDFS(it, 1 - col, color, graph)){
                    return false;
                }
            }
            else if(color[it] == col){
                return false;
            }
        }
        return true;
    }

    public static void isBipartiteBFS(int V, Graph graph){
        int[] color = new int[V + 1];
        for(int i = 0; i < V; i++){
            color[i] = -1;
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 1; i < V; i++){
            if(color[i] == -1){
                if(!checkBipartiteBFS(i, V, adj, color, graph)){
                    System.out.println("No");
                    break;
                }
            }
        }
        print("Yes");
    }

    public static boolean checkBipartiteBFS(int start, int V, ArrayList<ArrayList<Integer>> adj, int[] color, Graph graph){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.poll();
            for(int it : graph.adjList.get(node)){
                if(color[it] == -1){
                    color[it] = 1 - color[node];
                    queue.add(it);
                }
                else if(color[it] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void numberOfDistinctIslandsBFS(int[][] grid){
        int n = grid.length; int m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String> pairs = numberOfDistinctIslandsUsingBFS(i, j, vis, grid);
                    set.add(pairs);
                }
            }
        }
        print(set.size());
    }

    public static ArrayList<String> numberOfDistinctIslandsUsingBFS(int row0, int col0, int[][] vis, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<String> shape = new ArrayList<>();
        queue.add(new int[]{row0, col0});
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0]; int col = cell[1];
            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = row + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = 1;
                    queue.add(new int[]{nrow, ncol});
                    shape.add((nrow - row0) + " " + (ncol - col0));
                }
            }
        }
        return shape;
    }

    public static void numberOfDistinctIslands(int[][] grid){
        int n = grid.length; int m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String> pairs = new ArrayList<>();
                    dfsNumberOfDistinctIslands(i, j, vis, grid, pairs, i, j);
                    set.add(pairs);
                }
            }
        }
        print(set.size());
    }

    public static void dfsNumberOfDistinctIslands(int row, int col, int[][] vis, int[][] grid,
                                                  ArrayList<String> pairs, int row0, int col0){

        vis[row][col] = 1;
        pairs.add(toString(row-row0, col-col0));
        int n = grid.length; int m = grid[0].length;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,-1,0,1};

        for(int i = 0; i < 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                dfsNumberOfDistinctIslands(nrow, ncol, vis, grid, pairs, row0, col0);
            }
        }
    }

    public static String toString(int r, int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    public static void numberOfEnclaves(int[][] grid){
        int n = grid.length; int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[] delRow = {-1,0,1,0}; int[] delCol = {0,1,0,-1};

        Queue<PairIsland> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n - 1 || j == m - 1){
                    if(grid[i][j] == 1){
                        queue.offer(new PairIsland(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            queue.poll();
            for(int i = 0; i < 4; i++){
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];
                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    queue.add(new PairIsland(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    cnt++;
                }
            }
        }
        print(cnt);

    }

    public static void replaceOWithX(char[][] grid){
        int n = grid.length; int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[] delRow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        for(int j = 0; j < m; j++){
            if(vis[0][j] == 0 && grid[0][j] == 'O'){
                dfsReplaceOWithX(0, j, vis, grid, delRow, delcol);
            }
            if(vis[n-1][j] == 0 && grid[n-1][j] == 'O'){
                dfsReplaceOWithX(n-1, j, vis, grid, delRow, delcol);
            }
        }

        for(int i = 0; i < n; i++){
            if(vis[i][0] == 0 && grid[i][0] == 'O'){
                dfsReplaceOWithX(i, 0, vis, grid, delRow, delcol);
            }
            if(vis[i][m-1] == 0 && grid[i][m-1] == 'O'){
                dfsReplaceOWithX(i, m-1, vis, grid, delRow, delcol);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 'O'){
                    grid[i][j] = 'X';
                }
            }
        }
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                print(grid[i][j] + " ");
            }
            print("\n");
        }
    }

    public static void dfsReplaceOWithX(int row, int col, int[][] vis, char[][] grid, int[] delRow, int[] delCol){
        vis[row][col] = 1;
        int n = grid.length; int m = grid[0].length;
        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 'O'){
                dfsReplaceOWithX(nRow, nCol, vis, grid, delRow, delCol);
            }
        }
    }

    public static void distanceOfNearestCellHaving1(int[][] grid){
        int[][] vis = new int[grid.length][grid[0].length];
        int[][] ans = new int[grid.length][grid[0].length];

        Queue<PairRottenOranges> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    queue.offer(new PairRottenOranges(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }
        int[] delRow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while(!queue.isEmpty()){
            int row = queue.peek().row; int col = queue.peek().col; int time = queue.peek().time;
            queue.poll();
            ans[row][col] = time;
            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delcol[i];
                if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    queue.offer(new PairRottenOranges(nrow, ncol, time+1));
                }
            }
        }
        for(int i = 0; i < ans.length; i++){
            for (int j = 0; j < ans[0].length; j++){
                print(ans[i][j] + " ");
            }
            print("\n");
        }
    }

    public static void rottenOranges(int[][] basket){
        int[][] vis = new int[basket.length][basket[0].length];
        Queue<PairRottenOranges> queue = new LinkedList<>();
        int cnt_fresh = 0;
        for(int i = 0; i < basket.length; i++){
            for(int j = 0; j < basket[0].length; j++){
                if(basket[i][j] == 2){
                    queue.add(new PairRottenOranges(i, j, 0));
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }
                if(basket[i][j] == 1){
                    cnt_fresh++;
                }
            }
        }

        int tm = 0;
        int[] down = {-1,0,1,0};
        int[] up = {0,1,0,-1};
        int cnt = 0;
        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            int t = queue.peek().time;
            tm = Math.max(tm, t);
            queue.poll();
            for(int i = 0; i < 4; i++){
                int nrow = r + down[i];
                int ncol = c + up[i];
                if(nrow >= 0 && nrow < basket.length && ncol >= 0 && ncol < basket[0].length && vis[nrow][ncol] == 0 && basket[nrow][ncol] == 1){
                    queue.add(new PairRottenOranges(nrow, ncol, t+1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }
        if(cnt != cnt_fresh){
            print("-1");
        }
        else{
            print(tm);
        }
    }

    public static void floodFillAlgo(int[][] grid, int sr, int sc, int newColor){
        int iniColor = grid[sr][sc];
        int[][] ans = grid;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        dfsFloodFill(sr, sc, ans, grid, newColor, delRow, delCol, iniColor);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans.length; j++){
                print(ans[i][j] + "");
            }
            print("\n");
        }
    }

    public static void dfsFloodFill(int row, int col, int[][] ans, int[][] grid,
                                    int newColor, int[] delRow, int[] delCol, int iniColor){

        ans[row][col] = newColor;
        int n = grid.length; int m = grid[0].length;
        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == iniColor && ans[nRow][nCol] != newColor){
                dfsFloodFill(nRow, nCol, ans, grid, newColor, delRow, delCol, iniColor);
            }
        }

    }

    public static void numberOfIslands(int[][] area){
        int[][] vis = new int[area.length][area[0].length];
        int c = 0;
        for(int row = 0; row < area.length; row++){
            for(int col= 0; col < area[row].length; col++){
                if(vis[row][col] == 0 && area[row][col] == 1){
                    c++;
                    bfsNumberOfIslands(row, col, vis, area);
                }
            }
        }
        print(c);
    }

    public static void bfsNumberOfIslands(int i, int j, int[][] vis, int[][] grid){
        vis[i][j] = 1;
        Queue<PairIsland> queue = new LinkedList<>();
        queue.add(new PairIsland(i, j));
        int n = grid.length;
        int m = grid[0].length;
        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.poll();
            for(int delRow = -1; delRow <= 1; delRow++){
                for(int delcol = -1; delcol <= 1; delcol++){
                    int nrow = row + delRow;
                    int ncol = col + delcol;
                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                        vis[nrow][ncol] = 1;
                        queue.add(new PairIsland(nrow, ncol));
                    }
                }
            }
        }
    }

    public static void numberOfProvinces(Graph graph){
        int[] vis = new int[graph.adjList.size()+1];
        int c = 0;

        for(int i = 1; i <= graph.adjList.size(); i++){
            if(vis[i] == 0){
                c++;
                dfsNumberOfProvinces(i, vis, graph);
            }
        }
        print(c);
    }

    public static void dfsNumberOfProvinces(int node, int[] vis, Graph graph){
        vis[node] = 1;
        for(Integer it : graph.adjList.get(node)){
            if(vis[it] == 0){
                dfsNumberOfProvinces(it, vis, graph);
            }
        }
    }

    public static void kahnsAlgorithmTopologicalSorting(GraphDirected graphDirected){
        int size = graphDirected.adjList.size();
        int[] indegree = new int[size+1];

        for(int i = 0; i < size; i++){
            for(Integer it : graphDirected.adjList.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < size; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int[] topoSort = new int[size];
        int i = 0;
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.poll();
            topoSort[i++] = node;

            for(Integer it : graphDirected.adjList.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    queue.add(it);
                }
            }
        }
        print(Arrays.toString(topoSort));
    }

    public static void topologicalSort(GraphDirected graphDirected, int size){
        int[] visited = new int[size+1];
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= size; i++){
            if(visited[i]==0){
                dfsTopologicalDFS(i, visited, stack, graphDirected);
            }
        }
        while(!stack.isEmpty()){
            print(stack.pop() + " ");
        }
    }

    public static void dfsTopologicalDFS(int node, int[] visited, Stack<Integer> st, GraphDirected graphDirected){
        visited[node] = 1;
        for(Integer it : graphDirected.adjList.get(node)){
            if(visited[it] == 0){
                dfsTopologicalDFS(it, visited, st, graphDirected);
            }
        }
        st.add(node);
    }

    public static boolean dfsDetectCycleInDirectedGraph(GraphDirected graphDirected, int size){
        int[] visited = new int[size+1];
        int[] pathVisited = new int[size+1];
        for (int i = 1; i <= size; i++){
            if(visited[i] == 0){
                if(dfsCheckDirectedGraph(i, graphDirected, visited, pathVisited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfsCheckDirectedGraph(int node, GraphDirected graphDirected, int[] visited, int[] pathVisited){
        visited[node] = 1;
        pathVisited[node] = 1;
        for(Integer it : graphDirected.adjList.get(node)){
            if(visited[it] == 0){
                if(dfsCheckDirectedGraph(it, graphDirected, visited, pathVisited)){
                    return true;
                }
            }
            else if(pathVisited[it] == 1){
                return true;
            }
        }
        pathVisited[node] = 0;
        return false;
    }

    public static boolean dfsDetectCycleInUndirectedGraph(Graph graph, int size){
        Set<Integer> visited = new HashSet<>();
        for(Integer node : graph.adjList.keySet()){
            if(!visited.contains(node)){
                if(dfsCheckCycle(node, -1, visited, graph.adjList)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfsCheckCycle(int node, int parent, Set<Integer> visited, HashMap<Integer, ArrayList<Integer>> map) {
        visited.add(node);
        for(Integer neighbor : map.get(node)){
            if(!visited.contains(neighbor)){
                if(dfsCheckCycle(neighbor, node, visited, map)){
                    return true;
                }
            }
            else if(neighbor != parent){
                return true;
            }
        }
        return false;
    }

    public static boolean bfsDetectCycleInUndirectedGraph(Graph cycleUndirectedGraph, int size){
        boolean[] vis = new boolean[size+1];
        for(int i = 0; i < size; i++){
            vis[i] = false;
        }
        for(int i = 1; i <= size; i++){
            if(!vis[i]){
                if(checkCycleBFS(i, cycleUndirectedGraph, vis)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkCycleBFS(int source, Graph graph, boolean[] vis){
        vis[source] = true;
        Queue<PairGraph> queue = new LinkedList<>();
        queue.offer(new PairGraph(source, -1));

        while(!queue.isEmpty()){
            int node = queue.peek().node;
            int parent = queue.peek().parent;
            queue.poll();
            for(Integer neighbor : graph.adjList.get(node)){
                if(!vis[neighbor]){
                    vis[neighbor] = true;
                    queue.offer(new PairGraph(neighbor, node));
                }
                else if(parent != neighbor){
                    return true;
                }
            }
        }
        return false;
    }

    public static void dfsGraphTraversal(Graph graph){
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[graph.adjList.size() + 1];
        vis[1] = true;
        dfs(1, vis, graph, ans);
        print(ans);
    }

    public static void dfs(int node, boolean[] vis, Graph graph, ArrayList<Integer> ans){
        vis[node] = true;
        ans.add(node);
        for(Integer it : graph.adjList.get(node)){
            if(!vis[it]){
                dfs(it, vis, graph, ans);
            }
        }
    }

    public static void bfsGraphTraversal(Graph graph){
        boolean[] vis = new boolean[graph.adjList.size() + 1];
        HashMap<Integer, ArrayList<Integer>> map = graph.adjList;
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(3);
        vis[3] = true;
        while (!queue.isEmpty()){
            Integer node = queue.poll();
            ans.add(node);
            for(Integer it : map.get(node)){
                if(!vis[it]){
                    vis[it] = true;
                    queue.add(it);
                }
            }
        }
        print(ans);
    }

    public static void print(Object object){
        System.out.print(object + " ");
    }

}
