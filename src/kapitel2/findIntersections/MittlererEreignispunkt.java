package kapitel2.findIntersections;

import java.awt.geom.Point2D;

public class MittlererEreignispunkt extends Ereignis{
    Schnittpunkt schnittpunkt;
    public MittlererEreignispunkt(Point2D p, Schnittpunkt schnittpunkt) {
        super(p);
        this.schnittpunkt = schnittpunkt;
    }
}
