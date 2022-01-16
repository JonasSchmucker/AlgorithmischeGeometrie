package kapitel1.slowConvexHull;

import java.awt.geom.Point2D;
import java.io.*;
import java.util.*;

public class Main {
    static Scanner sc;

    static final String KAPITEL = "kapitel1";

    /**
     * Output: [Point2D.Double[2.345, 5.12432], Point2D.Double[1.43534, 6.43664], Point2D.Double[0.3453, 9.54645], Point2D.Double[15.6537, 8.456546], Point2D.Double[8.456456, 1.564654], Point2D.Double[6.345634, 0.54546]]
     * @param args
     */
    public static void main(String[] args) {
        try {
            sc = new Scanner(
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(
                                            "src/" + KAPITEL  + "/input.txt"
                                    )
                            )
                    )
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        int datenpunkte = 0;
        datenpunkte = sc.nextInt();
        List<Point2D> P = new ArrayList<>();
        for(int datenpunkt = 0; datenpunkt < datenpunkte; datenpunkt++) {
            P.add(new Point2D.Double(sc.nextDouble(), sc.nextDouble()));
        }

        System.out.println(SlowConvexHull.slowConvexHull(P).toString());
    }
}
