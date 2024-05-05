import java.util.*;

public class Dijkstra {

    public static Dictionary[] dijkstra(Graph g, Vertex startingVertex) {
        Dictionary<String, Integer> distances = new Hashtable<>();
        Dictionary<String, Vertex> previous = new Hashtable<>();
        PriorityQueue<QueueObject> queue = new PriorityQueue<QueueObject>();

        queue.add(new QueueObject(startingVertex, 0));

        for (Vertex v : g.getVertices()) {
            if (v != startingVertex) {
                distances.put(v.getData(), Integer.MAX_VALUE);
            }
            previous.put(v.getData(), new Vertex("Null"));
        }

        distances.put(startingVertex.getData(), 0);

        while (queue.size() != 0) {
            Vertex current = queue.poll().vertex;
            for (Edge e : current.getEdges()) {
                Integer alternative = distances.get(current.getData()) + e.getWeight();
                String neighborValue = e.getEnd().getData();
                if (alternative < distances.get(neighborValue)) {
                    distances.put(neighborValue, alternative);
                    previous.put(neighborValue, current);
                    queue.add(new QueueObject(e.getEnd(), distances.get(neighborValue)));
                }
            }
        }
        return new Dictionary[]{distances, previous};
    }

    public static String shortestPathBetween(Graph g, Vertex startingVertex, Vertex targetVertex) {
        Dictionary[] dijkstraDictionaries = dijkstra(g, startingVertex);
        Dictionary<String, Integer> distances = dijkstraDictionaries[0];
        Dictionary<String, Vertex> previous = dijkstraDictionaries[1];

        Integer distance = distances.get(targetVertex.getData());
        StringBuilder shortestPath = new StringBuilder();
        shortestPath.append("Shortest Distance between ").append(startingVertex.getData()).append(" and ").append(targetVertex.getData()).append(": ").append(distance).append("\n");

        ArrayList<Vertex> path = new ArrayList<>();
        Vertex v = targetVertex;

        while (!v.getData().equals("Null")) {
            path.add(0, v);
            v = previous.get(v.getData());
        }

        shortestPath.append("Shortest Path: ");
        for (Vertex pathVertex : path) {
            shortestPath.append(pathVertex.getData()).append(" -> ");
        }
        shortestPath.delete(shortestPath.length() - 4, shortestPath.length()); // Remove the last " -> "

        return shortestPath.toString();
    }

}