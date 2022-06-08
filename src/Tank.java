import javafx.scene.Node;
import javafx.scene.image.Image;
import java.io.File;

public class Tank extends MyPlayer {
    Map map;
    double speed = 3;
    double xPoint;
    double yPoint;

    public Tank(Map map,double widthAndHeightOfImage, double xPoint, double yPoint ) {
        super();
        setImage(new Image(new File("images\\tankkk.png").toURI().toString()));
        this.map = map;
        this.xPoint = xPoint;
        this.yPoint = yPoint;
        setX(xPoint);
        setY(yPoint);
        setFitHeight(widthAndHeightOfImage);
        setFitWidth(widthAndHeightOfImage);


    }
    public boolean canTheTankMove() {
        for (Node node :
                map.getChildren()
        ) {
            if (node instanceof MapWalls && !((MapWalls) node).canWalkBlock && intersects(node.getBoundsInLocal())) {
                return false;
            }

        }
        return true;

    }public void moveToTheRight() {
        setRotate(90);
        xPoint = xPoint + speed;
        setX(xPoint);
        if (!canTheTankMove() || xPoint + 1 > map.getSize()) {
            xPoint = xPoint - speed;
            setX(xPoint);
        }
    }
    public void moveToTheLeft() {
        setRotate(270);
        xPoint = xPoint - speed;
        setX(xPoint);
        if (!canTheTankMove() || xPoint - 1 <= 0) {
            xPoint = xPoint + speed;
            setX(xPoint);
            ;
        }
    }
    public void moveToTheUp() {
        setRotate(0);
        yPoint = yPoint - speed;
        setY(yPoint);
        if (!canTheTankMove() || yPoint - 1 <= 0) {
            yPoint = yPoint + speed;
            setY(yPoint);

        }
    }

    public void moveToTheDown() {
        setRotate(180);
        yPoint = yPoint + speed;
        setY(yPoint);
        if (!canTheTankMove() || yPoint + 1 > map.getSize()) {
            yPoint = yPoint - speed;
            setY(yPoint);

        }
    }




}


