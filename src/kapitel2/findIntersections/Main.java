package kapitel2.findIntersections;


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
        List<Segment> S = new ArrayList<>();

        Point2DCompareFirstYThenX comparator = new Point2DCompareFirstYThenX();
        for(int datenpunkt = 0; datenpunkt < datenpunkte; datenpunkt++) {
            Point2D p1 = new Point2D.Double(sc.nextDouble(), sc.nextDouble());
            Point2D p2 = new Point2D.Double(sc.nextDouble(), sc.nextDouble());
            if(comparator.compare(p1, p2) > 0){
                S.add(new Segment(p1, p2));
            }
            else{
                S.add(new Segment(p2, p1));
            }
        }

        System.out.println(FindIntersections.findIntersections(S).toString());
    }
}