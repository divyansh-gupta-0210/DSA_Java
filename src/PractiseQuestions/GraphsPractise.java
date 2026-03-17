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
//        graphWeighted.addEdge(1,2,2);
//        graphWeighted.addEdge(1,3,3);
//        graphWeighted.addEdge(2,4,1);
//        graphWeighted.addEdge(3,4,4);
//        graphWeighted.addEdge(2,5,6);
//        graphWeighted.addEdge(4,5,3);
//        graphWeighted.displayGraph();
//        bfsGraphTraversal(graph);
//        dfsGraphTraversal(graph);
//        print(bfsDetectCycleInUndirectedGraph(cycleUndirectedGraph, cycleUndirectedGraph.adjList.size()));
//        print(bfsDetectCycleInUndirectedGraph(graph, graph.adjList.size()));
//        print(dfsDetectCycleInUndirectedGraph(graph, graph.adjList.size()));
//        print(dfsDetectCycleInUndirectedGraph(cycleUndirectedGraph, cycleUndirectedGraph.adjList.size()));

        GraphDirected graphDirected = new GraphDirected();
        graphDirected.addEdge(0,1);
        graphDirected.addEdge(1,2);
        graphDirected.addEdge(2,3);
        graphDirected.addEdge(3,4);
        graphDirected.addEdge(3,5);
        graphDirected.addEdge(5,6);
        graphDirected.addEdge(4,6);
        graphDirected.addEdge(6,7);
        graphDirected.addEdge(11,9);
        graphDirected.addEdge(9,10);
        graphDirected.addEdge(10,8);
        graphDirected.addEdge(8,9);
        graphDirected.addEdge(8,1);

        graphDirected.displayGraph();
        findEventualSafeNodes(graphDirected.adjList.size(), graphDirected);

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

    public static void topologicalSort(GraphDirected graphDirected, int size){
        int[] visited = new int[size+1];
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= size; i++){
            if(visited[i]==0){
                dfsTopological(i, visited, stack, graphDirected);
            }
        }
        while(!stack.isEmpty()){
            print(stack.pop() + " ");
        }
    }

    public static void dfsTopological(int node, int[] visited, Stack<Integer> st, GraphDirected graphDirected){
        visited[node] = 1;
        for(Integer it : graphDirected.adjList.get(node)){
            if(visited[it] == 0){
                dfsTopological(it, visited, st, graphDirected);
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

    public static boolean dfsCheckCycle(int node, int parent, Set<Integer> visited, HashMap<Integer, ArrayList<Integer>> map)
    {
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
