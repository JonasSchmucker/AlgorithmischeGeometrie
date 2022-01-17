package kapitel2.findIntersections;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class FindIntersections {

    /**
     *
     * @param S Eine Menge S von Liniensegmenten im R^2
     * @return Die Menge von Schnittpunkten zwischen den Liniensegmenten in S,wobei jedem Schnittpunkt die beteiligten Segmente zugeodnet sind
     *
     * Pseudocode:
     *  Initialisiere die leere Ereigniskette Q;
     *  Füge alle Segmentendpunkte in Q ein. Wenn ein oberer Segmentpunkt eingefügt wird, werden die entsprechenden Segmente mit ihm gespeichert;
     *  Initialisiere die leere Statusstruktur T;
     *  while Q ist nicht leer do
     *      Finde den nächsten Ereignispunkt pin Q und lösche ihn aus Q;
     *      HandleEventPoint(p)
     *  od
     */
    public static List<Schnittpunkt> findIntersections(List<Line2D> S) {
        TreeSet<Ereignis> Q = new TreeSet<>();
        Line2DCompareAtSweepLine line2DCompareAtSweepLine = new Line2DCompareAtSweepLine();
        TreeSet<Line2D> T = new TreeSet<>(line2DCompareAtSweepLine);
        List<Schnittpunkt> schnittpunkte = new ArrayList<>();

        for (Line2D segment : S) {

        }

        return schnittpunkte;
    }

    private static void HandleEventPoint(Ereignis p, TreeSet<Ereignis> Q, TreeSet<Line2D> T, List<Schnittpunkt> schnittpunkte, Line2DCompareAtSweepLine line2DCompareAtSweepLine){
        if(p instanceof ObererEreignispunkt){
            ObererEreignispunkt obererEreignispunkt = (ObererEreignispunkt) p;
        }
        else if (p instanceof ObererEreignispunkt){}
    }

    /**
     *
     * @param s_l linkes Segment
     * @param s_r rechtes Segment
     * @param ereignis aktueller Punkt deer Sweep-Line
     *
     * Pseudocode:
     *  if s_l und s_r schneiden sich unter der SweepLine oder auf ihr, dann aber rechts von p, und der Schnittpunkt ist noch nicht in Q enthalten then
     *      Füge den Schnittpunkt als neuen Ereignispunkt zu Q hinzu
     *  fi
     */
    private static void FindEventPoint(Line2D s_l, Line2D s_r, Ereignis ereignis, TreeSet<Ereignis> Q){
        Schnittpunkt s = findeSchnittpunkt(s_l, s_r);
        if(s == null){
            return;
        }
        Point2DCompareFirstYThenX compareFirstYThenX = new Point2DCompareFirstYThenX();
        if(compareFirstYThenX.compare(s.punkt, ereignis.p) < 0){
            Ereignis neuesEreignis = new MittlererEreignispunkt(s.punkt, s);
            if(!Q.contains(neuesEreignis)){
                Q.add(neuesEreignis);
            }
        }
    }

    /**
     * Kopiert von: https://www.programcreek.com/java-api-examples/?class=java.awt.geom.Line2D&method=intersectsLine
     * @param s_l linkes Segment
     * @param s_r rechtes Segment
     * @return Schnittpunkt
     */
    public static Schnittpunkt findeSchnittpunkt(Line2D s_l, Line2D s_r) {
        if (s_l.intersectsLine(s_r)) {
            double x1 = s_r.getX1();
            double y1 = s_r.getY1();
            double x2 = s_r.getX2();
            double y2 = s_r.getY2();

            double xp1 = s_l.getX1();
            double yp1 = s_l.getY1();
            double xp2 = s_l.getX2();
            double yp2 = s_l.getY2();

            double y = 0;
            double x = 0;
            double dy = y2 - y1;
            double s = (x2 - x1) / dy;

            double dpy = yp2 - yp1;
            double sp = (xp2 - xp1) / dpy;

            if (y1 == y2) {
                if (dpy == 0) {
                    return null;
                }
                y = y1;
                x = xp1 + sp * (y - yp1);
            } else if (yp1 == yp2) {
                if (dy == 0) {
                    return null;
                }
                y = yp1;
                x = x1 + s * (y - y1);
            } else {
                if (dy == 0 || dpy == 0 || (s - sp) == 0) {
                    return null;
                }
                y = (xp1 - x1 + s * y1 - sp * yp1) / (s - sp);
                x = x1 + s * (y - y1);
            }

            return new Schnittpunkt(new Point2D.Double(x, y)).segmentHinzufuegen(s_l).segmentHinzufuegen(s_r);
        }

        return null;
    }
}
