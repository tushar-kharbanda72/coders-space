import java.util.*;
public class ArticulationPoints{
	
	public Set<Vertex<Integer>> getArtculationPoints(Graph<Integer> g){
		int timer = 0 ;
		Vertex<Integer> root = g.getAllVertexes().iterator().next();
		Map<Vertex<Integer>, Integer> start = new HashMap<>();
		Map<Vertex<Integer>, Integer> low = new HashMap<>();
		Set<Vertex<Integer>> visited = new HashSet<>();
		Set<Vertex<Integer>> articulationPoints = new HashSet<>();


		dfs(root, articulationPoints, start, low, visited, null, timer);
		return articulationPoints;
	}

	private void dfs(Vertex<Integer> vert, Set<Vertex<Integer>> articulationPoints, Map<Vertex<Integer>, Integer> start, Map<Vertex<Integer>, Integer> low,
					 Set<Vertex<Integer>> visited, Vertex<Integer> parent, int timer){
		visited.add(vert);
		start.put(vert, timer);
		low.put(vert, timer);
		timer++;
		int childCount = 0;
		boolean isArticulationPoint = false;
		for(Vertex<Integer> v: vert.getAdjacentVertexes()){
			if(vert.equals(parent)){
				continue;
			}

			if(!visited.contains(v)){
				dfs(v, articulationPoints, start, low, visited, vert, timer);
				childCount++;

				if(start.get(vert) <= low.get(v)){
					isArticulationPoint = true;
				}else{
					low.put(vert, Math.min(low.get(vert), low.get(v)));
				}

			}else{
				low.put(vert, Math.min(low.get(vert), start.get(v)));
			}
		}

		if(parent == null && childCount >= 2 || parent != null && isArticulationPoint){
			articulationPoints.add(vert);
		}
	}




	public static void main(String[] args){
		Graph<Integer> g = new Graph<Integer>(false);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(1, 3);
		g.addEdge(3, 4);

		ArticulationPoints ob = new ArticulationPoints();
		Set<Vertex<Integer>> articulationPoints = ob.getArtculationPoints(g);
		System.out.println(articulationPoints.size());
		articulationPoints.forEach(points -> System.out.println(points.getId()));
	}
}