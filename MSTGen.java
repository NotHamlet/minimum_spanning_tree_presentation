import java.util.*;

public class MSTGen {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int W = in.nextInt();
    int H = in.nextInt();

    Point points[] = new Point[N];
    for (int i = 0; i < N; i++) {
      double x = in.nextDouble();
      double y = in.nextDouble();
      points[i] = new Point(x,y);
    }

    List<Edge> edges = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      for (int j = i+1; j < N; j++) {
        double weight = points[i].distanceTo(points[j]);
        Edge newEdge = new Edge(i,j,weight);
        edges.add(newEdge);
      }
    }

    Collections.sort(edges);
    List<Edge> mst = new ArrayList<>();
    UnionFind uf = new UnionFind(N);

    for (Edge e : edges) {
      if (mst.size() == N-1) {
        break;
      }
      if (uf.find(e.a) != uf.find(e.b)) {
        mst.add(e);
        uf.union(e.a, e.b);
      }
    }


    // Print out a nice file
    System.out.printf("%d %d\n", N, mst.size());
    System.out.printf("%d %d\n", W, H);
    for (Point p : points) {
      System.out.printf("%f %f%n", p.x, p.y);
    }
    for (Edge e : mst) {
      System.out.printf("%d %d%n", e.a, e.b);
    }
  }

  private static class Point {
    double x, y;
    Point (double xVal, double yVal) {
      x = xVal;
      y = yVal;
    }
    public double distanceTo(Point other) {
      double dx = other.x-this.x;
      double dy = other.y-this.y;
      return Math.sqrt(dx*dx + dy*dy);
    }
  }

  private static class Edge implements Comparable<Edge> {
    int a, b;
    double weight;
    public Edge(int aVal, int bVal, double weightVal) {
      a = aVal;
      b = bVal;
      weight = weightVal;
    }
    public int compareTo(Edge other) {
      if (this.weight < other.weight) return -1;
      if (this.weight > other.weight) return 1;
      return 0;
    }
  }

  private static class UnionFind {
    int parent[];
    int rank[];

    public UnionFind(int N) {
      parent = new int[N];
      rank = new int[N];
      for (int i = 0; i < N; i++) {
        parent[i] = i;
        rank[i] = 0;
      }
    }

    public int find(int a) {
      if (parent[a] != a) {
        parent[a] = find(parent[a]);
      }
      return parent[a];
    }

    public void union(int a, int b) {
      int aRoot = find(a);
      int bRoot = find(b);

      if (aRoot==bRoot) return;

      if (rank[aRoot] < rank[bRoot]) {
        parent[aRoot] = bRoot;
      } else if (rank[bRoot] < rank[aRoot]) {
        parent[bRoot] = aRoot;
      } else {
        parent[bRoot] = aRoot;
        rank[aRoot]++;
      }
    }
  }
}
