public interface Player {
    void setMatrix(Map matrixOrMapOfPlayer);
    Position getPosition();
    void moveToTheDown();
    void moveToTheRight();
    void moveToTheUp();
    void moveToTheLeft();

}