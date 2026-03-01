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
//        graph.addEdge(1,3);
//        graph.addEdge(2,5);
//        graph.addEdge(2,6);
//        graph.addEdge(3,4);
//        graph.addEdge(3,7);
//        graph.addEdge(8,4);
//        graph.addEdge(8,7);

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
        graphDirected.addEdge(1,2);
        graphDirected.addEdge(2,3);
        graphDirected.addEdge(3,4);
        graphDirected.addEdge(3,7);
        graphDirected.addEdge(4,5);
        graphDirected.addEdge(7,5);
        graphDirected.addEdge(5,6);
        graphDirected.addEdge(8,2);
        graphDirected.addEdge(8,9);
        graphDirected.addEdge(9,10);
        graphDirected.addEdge(10,8);

        graphDirected.displayGraph();
        print(dfsDetectCycleInDirectedGraph(graphDirected, graphDirected.adjList.size()));
        topologicalSort(graphDirected, graphDirected.adjList.size());
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
