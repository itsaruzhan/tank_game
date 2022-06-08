import javafx.scene.layout.Pane;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Map extends Pane {
    char[][] matrixOrMapOfPlayer;
    Position xAndYOfStartingPoint;
    int numOfRowAndColumn;
    int sizeOfPane;
    int sizeOfEachWall;

    public Map(Scanner inp, int wH) throws InvalidMapException {
        sizeOfPane = wH;
        usingInputMap(inp);
    }
    public void usingInputMap(Scanner inp) throws InvalidMapException {
        numOfRowAndColumn = inp.nextInt();
        sizeOfEachWall = sizeOfPane / numOfRowAndColumn;
        if (numOfRowAndColumn == 0)
            throw new InvalidMapException("Map size can not be zero");
        matrixOrMapOfPlayer = new char[numOfRowAndColumn][numOfRowAndColumn];
        for (int row = 0; row < numOfRowAndColumn; row++) {
            for (int column = 0; column < numOfRowAndColumn; column++) {
                try {
                    char inputChar = inp.next().charAt(0);
                    if (inputChar == 'P') {

                        xAndYOfStartingPoint = new Position(column * sizeOfEachWall, row *sizeOfEachWall);
                    }else if (inputChar == 'B') {

                        getChildren().add(new MapWalls(column * sizeOfEachWall, row * sizeOfEachWall,"B", sizeOfEachWall));
                    } else if (inputChar == 'S') {

                        getChildren().add(new MapWalls(column * sizeOfEachWall, row * sizeOfEachWall,"S", sizeOfEachWall));
                    }  else if (inputChar == 'W') {

                        getChildren().add(new MapWalls(column * sizeOfEachWall, row * sizeOfEachWall,"W", sizeOfEachWall ));
                    } else if (inputChar == 'T') {

                        getChildren().add(new MapWalls(column * sizeOfEachWall, row * sizeOfEachWall,"T", sizeOfEachWall));
                    } else {
                        matrixOrMapOfPlayer[row][column] = inputChar;

                    }

                } catch (NoSuchElementException exception) {
                    throw new InvalidMapException("Not enough map elements");
                }
            }
        }
    }

    public Position getxAndYOfStartingPoint() {
        return xAndYOfStartingPoint;
    }

    public double getSize() {
        return sizeOfPane;
    }


}
