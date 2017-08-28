package rahul;
import java.util.*;
import java.util.LinkedList;

public class BcGraph{
 private int V;   // No. of vertices

 // Lists for Adjacency List
 private LinkedList<Integer> adj[];

 int time = 0;
 public static final int NIL = -1;

 public BcGraph(int v)
 {
     V = v;
     adj = new LinkedList[v];
     for (int i=0; i<v; ++i)
         adj[i] = new LinkedList();
 }

 //Adding an edge into the graph
 public void addEdge(int v, int w)
 {
     adj[v].add(w);  //Undirected Graph.
     adj[w].add(v);
 }


 public boolean isLinkedUtil(int u, boolean visited[], int disc[],int low[],
                  int parent[])
 {

     // Count of children
     int children = 0;

     // Visited Node
     visited[u] = true;
     
     disc[u] = low[u] = ++time;

     // Adjacent Vertices
     Iterator<Integer> i = adj[u].iterator();
     while (i.hasNext())
     {
         int v = i.next();  // v current adjacent of u

         if (!visited[v])
         {
             children++;
             parent[v] = u;

             if (isLinkedUtil(v, visited, disc, low, parent))
                 return true;

             // Check connection to an ancestors of u
             low[u]  = Math.min(low[u], low[v]);

             if (parent[u] == NIL && children > 1)
                 return true;

             // Low value of its child is more than discovery value of u.
             if (parent[u] != NIL && low[v] >= disc[u])
                 return true;
         }

         // Update low value of u for parent function calls.
         else if (v != parent[u])
             low[u]  = Math.min(low[u], disc[v]);
     }
     return false;
 }

 // Returns true if graph is Connected, else False
 public boolean isLinked()
 {
     // Mark vertices not visited
     boolean marked[] = new boolean[V];
     int dic[] = new int[V];
     int low[] = new int[V];
     int par[] = new int[V];

     for (int i = 0; i < V; i++)
     {
         par[i] = NIL;
         marked[i] = false;
     }

     if (isLinkedUtil(0, marked, dic, low, par) == true)
         return false;

     // Graph connected or not.
     for (int i = 0; i < V; i++)
         if (marked[i] == false)
             return false;

     return true;
 }
}