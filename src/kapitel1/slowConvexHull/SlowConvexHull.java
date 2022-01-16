package kapitel1.slowConvexHull;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SlowConvexHull {

    /**
     * Algorithm SlowConvexHull(P)
     * Komplexität: O(n^3)
     * @param punkte Eine Menge P von Punkten in R^2
     * @return Eine Liste L von Eckpunkten von CH(P) im Uhrzeigersinn
     *
     * Pseudocode:
     *  for all geordneten Paare (p,q)∈P×P, p≠q do
     *      gültig := true;
     *      for allPunkte r∈P\{p,q} do
     *          if r liegt links durch die gerichtete Linie von p nach q then
     *              gültig := false
     *          fi
     *      od;
     *      if gültig then
     *          füge die gerichtete Segment [p,q] zu E hinzu
     *      fi
     *  od;
     *  Erstelle L aus E
     */
    static List<Point2D> slowConvexHull(List<Point2D> punkte){
        List<Strecke> E = new LinkedList<>();
        for (Point2D p: punkte){
            for (Point2D q: punkte){
                if(!p.equals(q)){
                    boolean gueltig = true;
                    for (Point2D r: punkte) {
                        if((!r.equals(p)) && (!r.equals(q))){
                            if(istLinks(p, q, r)){
                                gueltig = false;
                            }
                        }
                    }
                    if(gueltig){
                        E.add(new Strecke(p, q));
                    }
                }
            }
        }
        List<Point2D> L = new ArrayList<>();
        Strecke s = E.get(0);
        while(!E.isEmpty()) {
            L.add(s.start);
            E.remove(s);
            for (Strecke s2 : E) {
                if (s.end == s2.start) {
                    s = s2;
                    break;
                }
            }
        }

        return L;
    }

    private static boolean istLinks(Point2D p, Point2D q, Point2D r){
        return ((q.getX() - p.getX()) * (r.getY() - p.getY()) - (q.getY() - p.getY()) * (r.getX() - p.getX())) > 0;
    }

    static class Strecke{
        Point2D start, end;

        public Strecke(Point2D p, Point2D q){
            start = p;
            end = q;
        }

        public String toString(){
            return "Segment von " + start.toString() + " nach " + end.toString();
        }
    }
}
