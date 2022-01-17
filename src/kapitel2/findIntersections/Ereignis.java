package kapitel2.findIntersections;

import java.awt.geom.Point2D;

public abstract class Ereignis implements Comparable<Ereignis> {
    Point2D p;

    @Override
    public int compareTo(Ereignis o) {
        return new Point2DCompareFirstYThenX().compare(p, o.p);
    }

    public Ereignis(Point2D p){
        this.p = p;
    }
}
