public class Position {
    private double posOfYPoint;
    private double posOfXPoint;

    public double getX() {
        return posOfXPoint;
    }

    public double getY() {
        return posOfYPoint;
    }

    public Position(double xCoordinate, double yCoordinate) {
        posOfYPoint = yCoordinate;
        posOfXPoint = xCoordinate;
    }
}

