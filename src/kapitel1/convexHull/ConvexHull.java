package kapitel1.convexHull;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ConvexHull {

    /**
     * AlgorithmConvexHull(P)
     * @param punkte Eine Menge P von Punkten in R^2
     * @return Eine Liste L von Eckpunkten von CH(P) im Uhrzeigersinn
     *
     * Pseudocode:
     *  Sortiere die Punkte aufsteigend nach ihren x-Koordinaten, das Ergebnis sei eine Folge p1, p2, …, pn von Punkten;
     *  Füge p1, p2 in L_upper ein, der erste Punkt sei p1;
     *  for i := 3 to n do
     *      Hänge pi an Lupper an;
     *      while Lupper enthält mehr als zwei Punkte und die drei letzten Punkte beschreiben keine Rechtskurve do
     *          lösche den mittleren der letzten drei Punkte aus Lupper
     *      od
     *  od;
     *  Füge pn, pn-1 in Llower ein, der erste Punkt sei pn;
     *  for i := n-2 downto 1 do
     *      Hänge pi an Llower an;
     *      while Llower enthält mehr als zwei Punkte und die drei letzten Punkte beschreiben keine Rechtskurve do
     *          lösche den mittleren der letzten drei Punkte aus Llower
     *      od
     *  od;
     *  Entferne den ersten und letzten Punkt von Llower;
     *  Hänge Llower an Lupper an und nenne das Ergebnis L
     */
    public static List<Point2D> convexHull(List<Point2D> punkte) {
        // obere Kurve
        punkte.sort(new Point2DCompareFirstXThenY());
        List<Point2D> L_upper = new LinkedList<>();
        L_upper.add(punkte.get(0)); //Index startet bei 0
        L_upper.add(punkte.get(1)); //Index startet bei 0
        for(int i = 2; i < punkte.size(); i++){ //Index startet bei 0
            L_upper.add(punkte.get(i));
            while(L_upper.size() > 2 && !beschreibenRechtskurve(L_upper.get(L_upper.size() - 1), L_upper.get(L_upper.size() - 2), L_upper.get(L_upper.size() - 3))){ //Index startet bei 0
                L_upper.remove(L_upper.size() - 2);
            }
        }

        // untere Kurve
        List<Point2D> L_lower = new LinkedList<>();
        L_lower.add(punkte.get(punkte.size() - 1)); //Index startet bei 0
        L_lower.add(punkte.get(punkte.size() - 2)); //Index startet bei 0
        for(int i = punkte.size() - 3; i > -1; i--){
            L_lower.add(punkte.get(i));
            while(L_lower.size() > 2 && !beschreibenRechtskurve(L_lower.get(L_lower.size() - 1), L_lower.get(L_lower.size() - 2), L_lower.get(L_lower.size() - 3))){
                L_lower.remove(L_lower.size() - 2);
            }
        }

        L_lower.remove(L_lower.size() - 1);
        L_lower.remove(0);

        L_upper.addAll(L_lower);

        return L_upper;
    }

    private static boolean beschreibenRechtskurve(Point2D p1, Point2D p2, Point2D p3) {
        return istLinks(p1, p2,p3);
    }

    private static boolean istLinks(Point2D p, Point2D q, Point2D r){
        return ((q.getX() - p.getX()) * (r.getY() - p.getY()) - (q.getY() - p.getY()) * (r.getX() - p.getX())) > 0;
    }

    static class Point2DCompareFirstXThenY implements Comparator<Point2D> {

        public int compare(Point2D p1, Point2D p2) {
            if(p1.getX() > p2.getX()){
                return 1;
            }
            else if(p1.getX() < p2.getX()){
                return -1;
            }
            else{
                if(p1.getY() > p2.getY()){
                    return 1;
                }
                else if(p1.getY() < p2.getY()) {
                    return -1;
                }
            }
            return 0;
        }
    }
}
