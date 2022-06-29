import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainScreen  {

    public void start(Stage stage){
        Image image1=new Image("file:resources/dna.png");
        ImageView back=new ImageView(image1);
        Group root=new Group(back);

        Calc cal=new Calc();
        Image image=new Image("file:resources/submit.png");
        ImageView submit=new ImageView(image);
        submit.setLayoutX(20);
        submit.setLayoutY(270);
        submit.setScaleY(0.4);
        submit.setScaleX(0.4);
        Text text=new Text();
        text.setText(" Enter DNA Sequence :");
        text.setX(18);
        text.setY(220);
        text.setFill(Color.WHITE);
        text.setStrokeWidth(0.4);
        text.setStroke(Color.GOLD);
        text.setFont(Font.loadFont("file:resources/1.otf", 34));
        TextField dnasequence = new TextField();
        dnasequence.setScaleX(2.5);
        dnasequence.setScaleY(2);
        dnasequence.setLayoutX(190);
        dnasequence.setLayoutY(270);
        dnasequence.setStyle("-fx-text-fill: #0000ff");
        root.getChildren().addAll(dnasequence,text,submit);

        submit.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent evt) {
                String dna=dnasequence.getText();
                cal.calculation(stage,dna);
            }
        });

        stage.setTitle("---------------------DNA Mutaion-------------------");
        Scene scene = new Scene(root, 500, 700);
        scene.setFill(Color.valueOf("A9A9A9"));
        stage.setScene(scene);
        stage.show();
    }
}
