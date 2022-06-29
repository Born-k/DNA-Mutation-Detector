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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class Calc {
    MainScreen mainScreen = new MainScreen();
    Image image=new Image("file:resources/b.jpg");
    Image image1=new Image("file:resources/home.png");
    Image image2=new Image("file:resources/exit.png");
    ImageView back=new ImageView(image);
    ImageView newback = new ImageView(image1);
    ImageView exit = new ImageView(image2);
    Group root=new Group(back);
    Button button1 = new Button("EXIT");
    Button button2 = new Button("");
    String notdisorder = "No genetic \n   disorder found";
    Font font = new Font("Tahoma", 20);


    public void calculation(Stage stage,String dnasequence){

        int cag=0,cgg=0,ctg=0,gaa=0;
        String disorder="";
        for(int i=0;i<dnasequence.length();i++)
        {
            if((i+2)<=dnasequence.length()-1) {
                if (dnasequence.charAt(i) == 'C' && dnasequence.charAt(i + 1) == 'A' && dnasequence.charAt(i + 2) == 'G') {
                    cag++;
                }
                if (dnasequence.charAt(i) == 'C' && dnasequence.charAt(i + 1) == 'G' && dnasequence.charAt(i + 2) == 'G') {
                    cgg++;
                }
                if (dnasequence.charAt(i) == 'C' && dnasequence.charAt(i + 1) == 'T' && dnasequence.charAt(i + 2) == 'G') {
                    ctg++;
                }
                if (dnasequence.charAt(i) == 'G' && dnasequence.charAt(i + 1) == 'A' && dnasequence.charAt(i + 2) == 'A') {
                    gaa++;
                }
            }
        }
        if(cag>=40 && cag<=62)
        {
            disorder="Spinal and bulbar \n  muscular atrophy";
        }
        if(cgg>=50 && cgg<=1500)
        {
            disorder="Fragile-X \n  syndrome";
        }
        if(cgg>=100 && cgg<=1000)
        {
            disorder="Jacobsen \n   syndrome";
        }
        if(cag>=21 && cag<=130)
        {
            disorder="Spinocerebellar \nataxia";
        }
        if(cag>=37 && cag<=220)
        {
            disorder="Autosomal dominant \n  cerebellar \n ataxia";
        }
        if(ctg>=44 && ctg<=3000)
        {
            disorder="Myotonic \n  dystrophy";
        }
        if(cag>=37 && cag<=121)
        {
            disorder="Huntington \n  disease";
        }
        if(gaa>=200 && gaa<=900)
        {
            disorder="Friedreich\n   ataxia";
        }
        if(cag>=49 && cag<=75)
        {
            disorder="Dentatorubal-\n  pallidoluysian \n    atrophy";
        }


        System.out.println(cag+" "+cgg+" "+ctg+" "+gaa);

//        TextField output1 = new TextField();
        Text output1= new Text();
        Text tm = new Text();
        tm.setScaleX(2.5);
        tm.setScaleY(2);
        tm.setLayoutX(150);
        tm.setLayoutY(210);
        tm.setFont(font);
        tm.setFill(Color.BLACK);
        tm.setStroke(Color.WHITE);


//        Text tm1 = new Text();
//        tm1.setScaleX(2.5);
//        tm1.setScaleY(2);
//        tm1.setLayoutX(190);
//        tm1.setLayoutY(220);
//        tm1.setFont(font);
//        tm1.setText("Disorder not Found:");

        output1.setScaleX(2.5);
        output1.setScaleY(2);
        output1.setLayoutX(190);
        output1.setLayoutY(270);
        output1.setFont(font);
        output1.setFill(Color.WHITE);
        output1.setStroke(Color.SILVER);
        output1.setStrokeWidth(0.7);
        output1.setStyle("-fx-text-fill: #0000ff");

        if(disorder == ""){
//            System.out.println(notdisorder);
//            tm.setText("Disorder Not Found:");
            output1.setText(notdisorder);
        }
        else {
            tm.setText("Disorder Found:");
            output1.setText(disorder);
//            System.out.println(disorder);
        }
        exit.setScaleX(0.16);
        exit.setScaleY(0.16);
        exit.setLayoutX(180);
        exit.setLayoutY(440);



        exit.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent evt) {
//                mainScreen.start(stage);
                Platform.exit();
            }
        });

        newback.setScaleX(0.03);
        newback.setScaleY(0.03);
        newback.setLayoutX(-830);
        newback.setLayoutY(-220);
//        root.getChildren().addAll(output1,button1,tm);
        newback.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent evt) {
                mainScreen.start(stage);

            }
        });

        root.getChildren().addAll(output1,exit,tm,newback);
        stage.setTitle("-------------------------DNA Mutaion-----------------------");
        Scene scene = new Scene(root, 500, 700);
//        System.out.println(dnasequence);
        scene.setFill(Color.valueOf("A9A9A9"));
        stage.setScene(scene);
        stage.show();
    }
}
