package kapitel2.findIntersections;

import java.awt.geom.Point2D;
import java.util.Comparator;

public class Point2DCompareFirstYThenX implements Comparator<Point2D> {

    public int compare(Point2D p1, Point2D p2) {
        if(p1.getY() > p2.getY()){
            return 1;
        }
        else if(p1.getY() < p2.getY()){
            return -1;
        }
        else{
            if(p1.getX() > p2.getX()){
                return 1;
            }
            else if(p1.getX() < p2.getX()) {
                return -1;
            }
        }
        return 0;
    }
}