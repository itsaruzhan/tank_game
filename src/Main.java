import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends Application {
    Pane pane = new Pane();
    Bullet bullet;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws InvalidMapException, FileNotFoundException {
        pane.setStyle("-fx-background-color: black");
        Map map = new Map(new Scanner(new File("map.txt")), 600);
        MyPlayer myPlayer = new MyPlayer(map);
        pane.getChildren().addAll(myPlayer.getMyTank(),map);
        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("My Tank");
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT:
                    myPlayer.moveToTheRight();
                    break;
                case UP:
                    myPlayer.moveToTheUp();
                    break;
                case DOWN:
                    myPlayer.moveToTheDown();
                    break;
                case LEFT:
                    myPlayer.moveToTheLeft();
                    break;
                case SPACE:
                    bullet = new Bullet(map, myPlayer.getMyTank().getX(),myPlayer.getMyTank().getY(),(myPlayer.getMyTank().getRotate()));
            }
        });
        primaryStage.show();
    }
}
