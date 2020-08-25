import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Random;
import javax.swing.Timer;


public class RaceTrack extends Application {

    int racecar_1 = 0;
    int racecar_2 = 0;
    int racecar_3 = 0;
    Thread thread_1;
    Thread thread_2;
    Thread thread_3;
    boolean continueRace = false;
    boolean run = true;
    Button start;
    Button pause;
    Button reset;
    String winner;
    Random random = new Random();  

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        stage.setTitle("Race Track");
        HBox hBox = new HBox();
        VBox vBox = new VBox();
        StackPane stackPane = new StackPane();
        StackPane stackPane_1 = new StackPane();
        StackPane stackPane_2 = new StackPane();
        StackPane stackPane_3 = new StackPane();

        // create race lines
        Shape line_1 = new Rectangle(460, 25);
        Shape line_2= new Rectangle(460, 25);
        Shape line_3 = new Rectangle(460, 25);

        // create racecar pics
        ImageView racecar1_pic = new ImageView(new Image("sportive-car.png"));
        ImageView racecar2_pic = new ImageView(new Image("sportive-car.png"));
        ImageView racecar3_pic = new ImageView(new Image("sportive-car.png"));

        // initialize buttons
        start = new Button("Start");
        pause = new Button("Pause");
        reset = new Button("Reset");

        hBox.setSpacing(10);
        vBox.setSpacing(35);
        stage.setResizable(false);
        hBox.getChildren().addAll(start, pause, reset);
        hBox.setAlignment(Pos.TOP_CENTER);

        // setup lines 
        line_1.setFill(Color.LIGHTGRAY);
        stackPane_1.setAlignment(Pos.CENTER_LEFT);
        stackPane_1.getChildren().addAll(line_1, racecar1_pic);
        line_2.setFill(Color.LIGHTGRAY);
        stackPane_2.setAlignment(Pos.CENTER_LEFT);
        stackPane_2.getChildren().addAll(line_2, racecar2_pic);
        line_3.setFill(Color.LIGHTGRAY);
        stackPane_3.setAlignment(Pos.CENTER_LEFT);
        stackPane_3.getChildren().addAll(line_3, racecar3_pic);

        // setup scene
        vBox.getChildren().addAll(hBox, stackPane_1, stackPane_2, stackPane_3);
        stackPane.getChildren().addAll(vBox);
        Scene scene = new Scene(stackPane, 500, 200);
        stage.setScene(scene);
        stage.show();

        // Pause button
        pause.setOnAction((event) -> {
             run = false;
        });

        // Reset button
        reset.setOnAction((event) ->{
            racecar_1 = 0;
            racecar_2 = 0;
            racecar_3 = 0;
            Platform.runLater(()->{
                racecar1_pic.setTranslateX(0);
                racecar2_pic.setTranslateX(0);
                racecar3_pic.setTranslateX(0);
            });
            run = false;
            continueRace = false;
        });

        // Start button
        start.setOnAction((event) -> {
            if(!continueRace){
                thread_1 = new Thread(new Runnable() {
                    // increments car by a random number between 0-10
                    @Override
                    public void run() {
                        run = true;
                        while(run){
                            int distance = random.nextInt(11);
                            racecar_1 += distance;
                            finished(); // checks if anyone finished
                            Platform.runLater(()->{
                                racecar1_pic.setTranslateX(racecar_1);
                            });
                            try {
                                Thread.sleep(50);
                            } 
                            catch (InterruptedException e) {}
                        }
                    }
                });
                thread_1.start();
                
                thread_2 = new Thread(new Runnable() {
                    // increments car by a random number between 0-10
                    @Override
                    public void run() {
                        run = true;
                        while(run){
                            int distance = random.nextInt(11);
                            racecar_2 += distance;
                            Platform.runLater(()->{
                                racecar2_pic.setTranslateX(racecar_2);
                            });
                            finished(); // checks if anyone finished
                            try {
                                Thread.sleep(50);
                            } 
                            catch (InterruptedException e) {}
                        }
                    }
                });
                thread_2.start();

                thread_3 = new Thread(new Runnable() {
                    // increments car by a random number between 0-10
                    @Override
                    public void run() {
                        run = true;
                        while(run){
                            int distance = random.nextInt(11);
                            racecar_3 += distance;
                            Platform.runLater(()->{
                                racecar3_pic.setTranslateX(racecar_3);
                            });
                            finished(); // checks if anyone finished
                            try {
                                Thread.sleep(50);
                            } 
                            catch (InterruptedException e) {}
                        }
                    }
                });
                thread_3.start();
            }
        });
    }

    // checks if any of the cars have finished
    public synchronized void finished(){
        if (racecar_1 >= 450 || racecar_2 >= 450 || racecar_3 >= 450) { // checks if any of the cars have a value >= 450
            if (racecar_1 >= 450 && racecar_1 > racecar_2 && racecar_1 > racecar_3) {  // checks which car won
                winner = "Jeff Tatar #1 car";
                Platform.runLater(() -> {
                    Win();
                });
            }

            else if (racecar_2 >= 450 && racecar_2 > racecar_1 && racecar_2 > racecar_3) {
                winner = "Bobby Bland #2 car";
                Platform.runLater(() -> {
                    Win();
                });
            }

            else if(racecar_3 >= 450 && racecar_3 > racecar_2 && racecar_3 > racecar_1) {
                winner = "Gary Gandolf #3 car";
                Platform.runLater(() -> {
                    Win();
                });
            }
            run = false;
            continueRace = true;
        }
    }

    // displays the winner in a pop up
    public void Win(){
        Stage window =  new Stage();
        Label label = new Label();
        VBox layout = new VBox();
        Button close = new Button("OK");

        label.setText(winner + " wins!");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Winner");
        window.setWidth(300);
        window.setHeight(200);
        close.setOnAction(event -> window.close());
        layout.getChildren().addAll(label, close);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}

