import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 *
 * @author Kelli
 */
public class racingCars extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setStyle("-fx-background-color: slateblue;");
      
        //Adding my race car
        ImageView imageView = new ImageView("image/tardis.png");
        pane.getChildren().addAll(imageView);
        
        //Adding header
        HBox headerBox = new HBox();
        headerBox.setAlignment(Pos.TOP_CENTER);
        Text header = new Text(20,20, "The Amazing Racing Tardis!");
        header.setFont(Font.font("Ariel", FontWeight.BOLD, FontPosture.ITALIC,25));
        
        headerBox.getChildren().add(header);
        
        //Creating an Hbox to hold my button and key stroke directions
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos. CENTER);
        
        //Start Button
        Button btnStart = new Button("Pause/Resume");
        
        //Key stroke directions
        Text UPDirections = new Text(12,12, "\nPress your UP arrow to make me go faster!");
        UPDirections.setFont(Font.font("Ariel", FontWeight.NORMAL, FontPosture.REGULAR,9));
        
        Text DownDirections = new Text(12,12, "\nPress your DOWN arrow to make me go Slow!");
        DownDirections.setFont(Font.font("Ariel", FontWeight.NORMAL, FontPosture.REGULAR,9));
        
        hBox.getChildren().addAll(btnStart, UPDirections, DownDirections);
        
        //Setting the BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);
        borderPane.setTop(headerBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);
        
        //Creating a path for the T.A.R.D.I.S. to follow
        PathTransition pt = new PathTransition(Duration.millis(20000), new Line(-100,25,200,25),imageView);
        pt.setCycleCount(5);
        pt.play();        
        
        //these state ment controls the pathTransition when the buttons are pressed
        btnStart.setOnMousePressed( e -> {pt.pause();});
        btnStart.setOnMouseReleased(e -> {pt.play();});
        
         //Creating the scene
        Scene scene = new Scene (borderPane, 500, 300);
       
        primaryStage.setTitle("Racing T.A.R.D.I.S.");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //This is for the increase and decrease in speed when Up and Down Key is pressed
        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.UP){
                pt.setRate(2);
            }
            else if (e.getCode() == KeyCode.DOWN){
                pt.setRate(.5);
            }
        });
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
