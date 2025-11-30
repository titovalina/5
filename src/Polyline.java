package point;

import java.util.Arrays;

public class Polyline {
    public Point[] points;

    public Polyline(Point[] points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Линия " + Arrays.toString(points);
    }
}

