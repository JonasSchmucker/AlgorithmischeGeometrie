package kapitel2.findIntersections;


import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.*;
import java.util.*;

public class Main {
    static Scanner sc;

    static final String KAPITEL = "kapitel2";
    static final String ALGORITHMUS = "findIntersections";

    public static void main(String[] args) {
        try {
            sc = new Scanner(
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(
                                            "src/" + KAPITEL  + "/" + ALGORITHMUS + "/input.txt"
                                    )
                            )
                    )
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        int datenpunkte = 0;
        datenpunkte = sc.nextInt();
        List<Line2D> S = new ArrayList<>();

        Point2DCompareFirstYThenX comparator = new Point2DCompareFirstYThenX();
        for(int datenpunkt = 0; datenpunkt < datenpunkte; datenpunkt++) {
            Point2D p1 = new Point2D.Double(sc.nextDouble(), sc.nextDouble());
            Point2D p2 = new Point2D.Double(sc.nextDouble(), sc.nextDouble());
            if(comparator.compare(p1, p2) > 0){
                S.add(new Line2D.Double(p1, p2));
            }
            else{
                S.add(new Line2D.Double(p2, p1));
            }
        }

        // testFindeSchnittpunkt();
        testLine2DCompareAtSweepLine();

        System.out.println(FindIntersections.findIntersections(S).toString());
    }

    private static void testFindeSchnittpunkt(){
        Line2D line1 = new Line2D.Double(new Point2D.Double(1.0, 0.0), new Point2D.Double(0.0, 1.0));
        Line2D line2 = new Line2D.Double(new Point2D.Double(1.0, 1.0), new Point2D.Double(0.0, 0.0));

        Line2D line3 = new Line2D.Double(new Point2D.Double(1.0, 0.0), new Point2D.Double(0.0, 1.0));
        Line2D line4 = new Line2D.Double(new Point2D.Double(2.0, 2.0), new Point2D.Double(1.0, 1.0));

        System.out.println(FindIntersections.findeSchnittpunkt(line1, line2));
        System.out.println(FindIntersections.findeSchnittpunkt(line3, line4));
    }

    private static void testLine2DCompareAtSweepLine(){
        Line2DCompareAtSweepLine line2DCompareAtSweepLine = new Line2DCompareAtSweepLine();

        Line2D line1 = new Line2D.Double(new Point2D.Double(1.0, 0.0), new Point2D.Double(0.0, 1.0));
        Line2D line2 = new Line2D.Double(new Point2D.Double(1.0, 1.0), new Point2D.Double(0.0, 0.0));

        line2DCompareAtSweepLine.setSweepLineY(0.7); // line1 und line2 scheiden bei y = 0.5

        System.out.println(line2DCompareAtSweepLine.compare(line1, line2));

        line2DCompareAtSweepLine.setSweepLineY(0.3); // line1 und line2 scheiden bei y = 0.5

        System.out.println(line2DCompareAtSweepLine.compare(line1, line2));
    }
}