import java.util.*;
import java.io.*;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class GraphDrawer {
  public static void main(String[] args) throws FileNotFoundException {
    String fileName;
    if (args.length >=  1) {
      fileName = args[0];
    } else {
      Scanner in = new Scanner(System.in);
      System.out.print("Input file name (i.e. out/sample2.out): ");
      fileName = in.next();
    }
    File file = new File(fileName);
    Scanner input = new Scanner(file);
    List<Point> points = new ArrayList<>();
    List<Edge> edges = new ArrayList<>();

    int N = input.nextInt();
    int M = input.nextInt();
    int W = input.nextInt();
    int H = input.nextInt();

    for (int i = 0; i < N; i++) {
      Point newPoint = new Point(input.nextDouble(), input.nextDouble());
      points.add(newPoint);
    }
    for (int i = 0; i < M; i++) {
      Edge newEdge = new Edge(input.nextInt(), input.nextInt());
      edges.add(newEdge);
    }

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    Canvas myCanvas = new GraphCanvas(W, H, points, edges);
    frame.getContentPane().add(myCanvas);
    frame.pack();
    frame.setVisible(true);

  }

  private static class Point {
    double x;
    double y;
    Point(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }
  private static class Edge {
    int a;
    int b;
    Edge(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }

  private static class GraphCanvas extends Canvas {

    private int canvasWidth;
    private int canvasHeight;
    private List<Point> points;
    private List<Edge> edges;
    public GraphCanvas(int width, int height, List<Point> points, List<Edge> edges) {
      super();

      // TODO: validate inputs

      canvasWidth = width;
      canvasHeight = height;
      this.points = points;
      this.edges = edges;
    }

    public void paint(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      for (Edge e : edges) {
        Point p1 = points.get(e.a);
        Point p2 = points.get(e.b);
        g2.draw(new Line2D.Double(p1.x, p1.y, p2.x, p2.y));
      }
    }

    public Dimension getPreferredSize() {
      return new Dimension(canvasWidth, canvasHeight);
    }
  }
}
