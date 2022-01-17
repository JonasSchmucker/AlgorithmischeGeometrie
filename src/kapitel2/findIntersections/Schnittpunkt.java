package kapitel2.findIntersections;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Schnittpunkt {
    Point2D punkt;
    List<Line2D> beteiligteSegmente;

    public Schnittpunkt(Point2D p){
        punkt = p;
        beteiligteSegmente = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Am Schnittpunkt "+ punkt +
                "treffen sich die Segmente: " + beteiligteSegmente;
    }

    public Schnittpunkt segmentHinzufuegen(Line2D s){
        beteiligteSegmente.add(s);
        return this;
    }
}
