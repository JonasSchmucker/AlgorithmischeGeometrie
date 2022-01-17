package kapitel2.findIntersections;

import java.awt.geom.Line2D;
import java.util.Comparator;

public class Line2DCompareAtSweepLine implements Comparator<Line2D> {
    double sweepLineY;
    Line2D sweepLine;
    Point2DCompareFirstYThenX point2DCompareFirstYThenX;

    public Line2DCompareAtSweepLine(){
        point2DCompareFirstYThenX = new Point2DCompareFirstYThenX();
    }

    @Override
    public int compare(Line2D l1, Line2D l2) {
        return point2DCompareFirstYThenX.compare(FindIntersections.findeSchnittpunkt(sweepLine, l1).punkt, FindIntersections.findeSchnittpunkt(sweepLine, l2).punkt);
    }

    public void setSweepLineY(double sweepLineY){
        this.sweepLineY = sweepLineY;
        sweepLine = new Line2D.Double(Double.NEGATIVE_INFINITY, sweepLineY, Double.POSITIVE_INFINITY, sweepLineY);
    }
}
