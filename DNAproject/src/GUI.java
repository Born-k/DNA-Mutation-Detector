import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.File;
import java.nio.file.Paths;
public class GUI extends Application{
    MediaPlayer mediaPlayer;
    MainScreen nm=new MainScreen();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        final int width =500;
        final int length = 700;
        Media musicFile = new Media(new File("resources/dna.mp4").toURI().toString());
        AudioClip sound = new AudioClip(Paths.get("resources/song.mp3").toUri().toString());
        sound.play();
        mediaPlayer=new MediaPlayer(musicFile);
        MediaView mediaView=new MediaView(mediaPlayer);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        VBox root = new VBox();
        root.getChildren().addAll(mediaView);
        mediaPlayer.play();
        stage.setTitle("----------------------DNA Mutation---------------");
        Scene scene = new Scene(root, width, length);
        scene.setFill(Color.valueOf("A9A9A9"));
        stage.setScene(scene);
        stage.show();
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent evt) {
                try {

                    sound.stop();
                    nm.start(stage);
                    mediaPlayer.stop();

                } catch (Exception e) {
                    System.out.println("Stage Not Show ");
                }


            }
        });
    }
}
