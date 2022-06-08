public class MyPlayer extends MapWalls implements Player {
    private Position positionAtThisTime;
    Tank myTank;
    private Map matrix;

    public MyPlayer(Map map) {
        setMatrix(map);
        myTank = new Tank(map,30,map.getxAndYOfStartingPoint().getX(),map.getxAndYOfStartingPoint().getY());
    }

    public MyPlayer() {
    }
    public Tank getMyTank(){
        return myTank;
    }

    @Override
    public Position getPosition() {
        return positionAtThisTime;
    }

    public void setMatrix(Map matrixOrMapOfPlayer) {
        matrix = matrixOrMapOfPlayer;
        positionAtThisTime = matrixOrMapOfPlayer.getxAndYOfStartingPoint();
    }
    public void moveToTheLeft() {
        myTank.moveToTheLeft();
    }

    public void moveToTheUp() {
        myTank.moveToTheUp();
    }

    public void moveToTheRight() {
        myTank.moveToTheRight();
    }

    public void moveToTheDown() {
        myTank.moveToTheDown();
    }


}
