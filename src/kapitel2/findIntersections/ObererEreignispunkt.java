package kapitel2.findIntersections;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class ObererEreignispunkt extends Ereignis{
    List<Line2D> segmente;

    public ObererEreignispunkt(Point2D p){
        super(p);
        segmente = new ArrayList<>();
    }
}
