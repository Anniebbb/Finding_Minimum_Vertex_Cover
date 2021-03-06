// Java Program to print Vertex Cover of a given undirected graph 
import java.io.*; 
import java.util.*; 
import java.util.LinkedList;
  
// This class represents an undirected graph using adjacency list 
class Graph 
{ 
    private int V;   // No. of vertices 
  
    // Array  of lists for Adjacency List Representation 
    private LinkedList<Integer> adj[]; 
  
    // Constructor 
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList<>(); 
    } 
  
    //Function to add an edge into the graph 
    void addEdge(int v, int w) 
    { 
        adj[v].add(w);  // Add w to v's list. 
        adj[w].add(v);  //Graph is undirected 
    } 
  
    // The function to print vertex cover 
    void printVertexCover() 
    {
		LinkedList<Integer> vertexCover = new LinkedList<>();
		ArrayList<Integer> PendentVertices = new ArrayList<>();
		for(int u=0;u<V;u++){
			int degree = adj[u].size();
			if(degree==1){
				PendentVertices.add(u);
			}
		}
		System.out.println(PendentVertices);
		while(PendentVertices.size()>0){
			Integer PVertex = PendentVertices.get(0);
			if(adj[PVertex].size() == 0) {
				PendentVertices.remove(PVertex);
				continue;
			}
			Integer adjVertex = adj[PVertex].get(0);
			System.out.println(PVertex);
			System.out.println(adjVertex);
			vertexCover.add(adjVertex);
			PendentVertices.remove(PVertex);
			if(PendentVertices.contains(adjVertex))
				PendentVertices.remove(adjVertex);
			for(int i=0;i<adj[adjVertex].size();i++){
				int vertex = adj[adjVertex].get(i);
				adj[vertex].remove(adjVertex);
				System.out.print(vertex);
			}
			adj[adjVertex].clear();
			System.out.println();
		}
		// Get Set of Maximum Degree Vertices
		while(true){
		int maxDegree = 0;
		ArrayList<Integer> maxDegreeVertices = new ArrayList<>();
        for (int u=0; u<V; u++) 
        { 
            int degree = adj[u].size();
			System.out.println(u);
			for(int i=0;i<degree;i++){
				System.out.print(adj[u].get(i));
			}
			System.out.println("Degree is: " + adj[u].size());
			if(degree > maxDegree){
				maxDegree = degree;
				maxDegreeVertices.clear();
				maxDegreeVertices.add(u);
			}
			else if(degree == maxDegree){
				maxDegreeVertices.add(u);
			}
        }
		System.out.println(maxDegreeVertices);
		if(maxDegree == 0)
			break;
		Integer chosenVertex = -1;
		for(int i=0;i<maxDegreeVertices.size();i++){
			if(maxDegree == 1){
				chosenVertex = maxDegreeVertices.get(i);
				break;
			}
			Set<Set<Integer>> edges1 = new HashSet<>();
			for(int j=0;j<adj[maxDegreeVertices.get(i)].size();j++){
				Set<Integer> e1 = new HashSet<>();
				e1.add(adj[maxDegreeVertices.get(i)].get(j));
				e1.add(maxDegreeVertices.get(i));
				edges1.add(e1);
			}
			Set<Set<Integer>> edgesU = new HashSet<>();
			for(int k=0; k<maxDegreeVertices.size();k++){
				if(k==i)
					continue;
				for(int l=0;l<adj[maxDegreeVertices.get(k)].size();l++){
					Set<Integer> e2 = new HashSet<>();
					e2.add(adj[maxDegreeVertices.get(k)].get(l));
					e2.add(maxDegreeVertices.get(k));
					if(!edgesU.contains(e2))
						edgesU.add(e2);
				}
			}
			Set<Set<Integer>> diff = new HashSet<>(edges1);
			diff.removeAll(edgesU);
			if(diff.size()>0){
				chosenVertex = maxDegreeVertices.get(i);
				System.out.println(edges1);
				System.out.println(edgesU);
				System.out.println(chosenVertex);
				break;
			}
			else{
				System.out.println(edges1);
				System.out.println(edgesU);
				System.out.println(chosenVertex);
			}
			if(i == (maxDegreeVertices.size()-1)){
				chosenVertex = maxDegreeVertices.get(0);
				System.out.println(chosenVertex);
				break;
			}
		}
		
		for(int a=0;a<adj[chosenVertex].size();a++){
			int vertex = adj[chosenVertex].get(a);
			adj[vertex].remove(chosenVertex);
		}
		adj[chosenVertex].clear();
		vertexCover.add(chosenVertex);
		}
		System.out.println(vertexCover);
    }
  
    // Driver method 
    public static void main(String args[]) 
    { 
        // Create a graph given in the above diagram 
        Graph g = new Graph(25); 
        /*g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 3); 
        g.addEdge(3, 4); 
        g.addEdge(4, 5); 
        g.addEdge(5, 6);*/
		
		
		/*g.addEdge(0,5);
		g.addEdge(2,5);
		g.addEdge(3,5);
		g.addEdge(4,5);
		g.addEdge(2,3);
		g.addEdge(3,4);
		g.addEdge(1,4);
		g.addEdge(1,6);*/
		
		/*g.addEdge(0,1);
		g.addEdge(1,4);
		g.addEdge(2,3);
		g.addEdge(3,4);
		g.addEdge(4,5);
		g.addEdge(5,6);
		g.addEdge(4,7);
		g.addEdge(7,8);*/
		
		/*g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,3);
		g.addEdge(1,4);
		g.addEdge(1,5);
		g.addEdge(1,6);
		g.addEdge(2,7);
		g.addEdge(2,8);
		g.addEdge(3,9);
		g.addEdge(4,10);
		g.addEdge(5,11);
		g.addEdge(5,12);
		g.addEdge(5,13);
		g.addEdge(6,14);
		g.addEdge(7,15);
		g.addEdge(8,16);*/
		
		/*g.addEdge(0,1);
		g.addEdge(0,4);
		g.addEdge(0,5);
		g.addEdge(1,2);
		g.addEdge(1,5);
		g.addEdge(1,6);
		g.addEdge(2,3);
		g.addEdge(2,6);
		g.addEdge(3,7);
		g.addEdge(4,5);
		g.addEdge(4,8);
		g.addEdge(5,6);
		g.addEdge(5,8);
		g.addEdge(5,9);
		g.addEdge(6,7);
		g.addEdge(6,10);
		g.addEdge(6,11);
		g.addEdge(8,9);
		g.addEdge(8,12);
		g.addEdge(9,10);
		g.addEdge(9,12);
		g.addEdge(9,13);
		g.addEdge(10,11);
		g.addEdge(10,13);
		g.addEdge(10,14);
		g.addEdge(11,15);
		g.addEdge(12,13);
		g.addEdge(12,16);
		g.addEdge(13,14);
		g.addEdge(13,17);
		g.addEdge(13,18);
		g.addEdge(14,15);
		g.addEdge(14,18);
		g.addEdge(15,19);
		g.addEdge(16,17);
		g.addEdge(16,20);
		g.addEdge(16,21);
		g.addEdge(17,18);
		g.addEdge(18,19);
		g.addEdge(18,22);
		g.addEdge(18,23);
		g.addEdge(18,24);
		g.addEdge(19,24);*/
		
		g.addEdge(0,6);
		g.addEdge(1,7);
		g.addEdge(2,8);
		g.addEdge(3,9);
		g.addEdge(4,10);
		g.addEdge(5,11);
		g.addEdge(6,7);
		g.addEdge(7,8);
		g.addEdge(8,9);
		g.addEdge(9,10);
		g.addEdge(10,11);
		g.addEdge(11,6);
		g.addEdge(6,13);
		g.addEdge(7,14);
		g.addEdge(8,15);
		g.addEdge(9,16);
		g.addEdge(10,17);
		g.addEdge(11,12);
		g.addEdge(13,19);
		g.addEdge(14,20);
		g.addEdge(15,21);
		g.addEdge(16,22);
		g.addEdge(17,23);
		g.addEdge(12,18);
		g.addEdge(19,20);
		g.addEdge(20,21);
		g.addEdge(21,22);
		g.addEdge(22,23);
		g.addEdge(23,18);
		g.addEdge(18,19);
		g.addEdge(18,24);
		g.addEdge(19,24);
		g.addEdge(20,24);
		g.addEdge(21,24);
		g.addEdge(22,24);
		g.addEdge(23,24);
		
        g.printVertexCover(); 
    } 
}