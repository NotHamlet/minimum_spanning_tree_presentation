# Demo for Programming Team Practice 03/29/17
  We will construct a Euclidean Minimum Spanning Tree over the given set of Cartesian Points.
  This is defined as the set of line segments that form a connected graph over the given points, minimal with respect to total segment length.

## Input
  1. A line containing a single integer, N - the number of points in the system
  2. A line containing integers W and H
  3. N lines, representing points, each containing two nonnegative real numbers x and y, such that x ≤ W and y ≤ H - the coordinates of the point

## Output
  1. A line containing two integers, N and M - the number of points in the system and the number of edges in the graph
  2. A line containing integers W and H
  3. N lines, representing points, each containing two nonnegative real numbers x and y, such that x ≤ W and y ≤ H -- the coordinates of the point
  4. M lines, representing edges, each containing two integers A and B -– the indices of the two points connected by the edge

## Testing
  In order to test your outputs, compile and run the provide java program, `GraphDrawer`:  
  ```
  javac GraphDrawer
  java GraphDrawer sample1.out
  ```
  This program has limited error-handling, so make sure your output files are formatted correctly!
