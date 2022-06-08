import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class Bullet extends ImageView {
    Map map;
    double angleOfImage;
    AnimationTimer animate;
    int speed = 5;

    public Bullet(Map map,double xPoint, double yPoint, double angleOfImage) {
        setImage(new Image(new File("images\\bullett.png").toURI().toString()));
        setFitHeight(30);
        setFitWidth(30);
        setX(xPoint);
        setY(yPoint);
        this.angleOfImage = angleOfImage;
        this.map = map;
        map.getChildren().add(this);
        animate = new AnimationTimer() {
            @Override
            public void handle(long now) {
                moveTheBullet();
            }
        };
        animate.start();


    }

    public boolean blockIntersects() {
        for (Node node :
                map.getChildren()) {
            if (node instanceof MapWalls && !((MapWalls) node).canFlyBlock && getBoundsInLocal().intersects(node.getBoundsInLocal())) {
                MapWalls blocks = (MapWalls) node;
                blocks.lifeCount();
                if (!blocks.stillLive()) {
                    map.getChildren().remove(node);
                }
                return true;
            }
        }
        return false;
    }

    public void moveTheBullet() {

        switch ((int) angleOfImage) {
            case 0:
                setY(getY() - speed);
                setRotate(90); //UP
                break;
            case 180:
                setY(getY() + speed);
                setRotate(270); //DOWN
                break;
            case 90:
                setX(getX() + speed);
                setRotate(180); //RIGHT
                break;
            case 270:
                setX(getX() - speed);
                setRotate(0);//LEFT
                break;
        }if (blockIntersects()) {
            map.getChildren().remove(this);
            animate.stop();
        }
    }
}
