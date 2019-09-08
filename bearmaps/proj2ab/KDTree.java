
package bearmaps.proj2ab;

import java.util.List;
import bearmaps.proj2ab.Point;

public class KDTree {
    private Node root;
    List<Point> myPoints;
    double bestDist = 100000000;
    Point bestPoint;

    public class Node {
        private Point p;
        private boolean orientation;
        private Node left, right;

        public Node(Point newPoint) {
            p = newPoint;
        }
    }

    public KDTree(List<Point> points) {
        myPoints = points;
        boolean orientation = true;

        for (int i = 0; i < points.size(); i++) {
            add(new Node(points.get(i)));

        }

    }

    private static double dist(double x1, double x2, double y1, double y2) {
        return Math.pow(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2), .5);
    }

    private void nearestHelper(double x, double y, Node newPoint) {
        double currentDist = 0;
        double perpenDickLength = 0;

        if (newPoint == null) {
            return;
        }

        if (newPoint != null) {
            currentDist = dist(x, newPoint.p.getX(), y, newPoint.p.getY());

            if (currentDist < bestDist) {
                bestDist = currentDist;
                bestPoint = newPoint.p;
            }
        }

        Node goodSide;
        Node badSide;

        if (newPoint.orientation) { // this is vertical
            if (newPoint.p.getX() > x) {
                goodSide = newPoint.left;
                badSide = newPoint.right;
            } else {
                goodSide = newPoint.right;
                badSide = newPoint.left;
            }
        } else {
            if (newPoint.p.getY() > y) {
                goodSide = newPoint.left;
                badSide = newPoint.right;
            } else {
                goodSide = newPoint.right;
                badSide = newPoint.left;
            }
        }

        nearestHelper(x, y, goodSide);

        if (newPoint.orientation) {
            perpenDickLength = Math.abs(x - newPoint.p.getX());
            if (perpenDickLength < bestDist) {
                nearestHelper(x, y, badSide);
            }
        } else {
            perpenDickLength = Math.abs(y - newPoint.p.getY());
            if (perpenDickLength < bestDist) {
                nearestHelper(x, y, badSide);
            }
        }
    }


    public Point nearest(double x, double y) {
        Point temp;
        nearestHelper(x, y, root);
        temp = bestPoint;
        bestPoint = null;
        bestDist = 100000000;
        return temp;
    }


    public void add(Node n) {
        if (n == null) {
            throw new IllegalArgumentException("it's null, bitch!");
        }
        root = add(root, n);

    }

    private Node add(Node roott, Node n) {
        if (n == null) {
            throw new IllegalArgumentException("it's null, bitch");
        }

        if (roott == null) {
            roott = n;
            roott.orientation = true;
            return roott;
        }

        if (n.p.equals(roott.p)) {
            return roott;
        }


        if (roott.orientation) {
            if (n.p.getX() < roott.p.getX()) {
                if (roott.left == null) {
                    roott.left = n;
                    n.orientation = !roott.orientation;
                }
                roott.left = add(roott.left, n);
            }

            if (n.p.getX() >= roott.p.getX()) {
                if (roott.right == null) {
                    roott.right = n;
                    n.orientation = !roott.orientation;
                }
                roott.right = add(roott.right, n);
            }
        } else {

            if (n.p.getY() < roott.p.getY()) {
                if (roott.left == null) {
                    roott.left = n;
                    n.orientation = !roott.orientation;
                }

                roott.left = add(roott.left, n);
            }

            if (n.p.getY() >= roott.p.getY()) {
                if (roott.right == null) {
                    roott.right = n;
                    n.orientation = !roott.orientation;
                }
                roott.right = add(roott.right, n);
            }
        }

        return roott;
    }

}
