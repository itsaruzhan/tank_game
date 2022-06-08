import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

public class MapWalls extends ImageView {
    boolean canWalkBlock = false;
    boolean canBrickBlock = false;
    boolean canFlyBlock = false;
    int life = 4;
    public MapWalls(double x, double y,String blockName, double size){
        setFitHeight(size);
        setFitWidth(size);
        setX(x);
        setY(y);

        switch (blockName){
            case "W":
                canFlyBlock = true;
                setImage(new Image(new File("images\\water.png").toURI().toString()));
                break;
            case "S":
                setImage(new Image(new File("images\\steelWall.png").toURI().toString()));
                break;
            case "B":
                canBrickBlock = true;
                setImage(new Image(new File("images\\brickWall.png").toURI().toString()));

                break;
            case "T":
                canWalkBlock = true;
                canFlyBlock = true;
                setImage(new Image(new File("images\\tree.png").toURI().toString()));
                break;
        }

    }
    public void lifeCount(){
        if(life == 3)
            setImage(new Image(new File("images\\broken1.png").toURI().toString()));
        if(life == 2)
            setImage(new Image(new File("images\\broken2.png").toURI().toString()));

        if(canBrickBlock && !canFlyBlock)
            life--;
    }

    public boolean stillLive(){
        if(life>0){
            return true;
        }
        return false;
    }

    public MapWalls(){}

}
