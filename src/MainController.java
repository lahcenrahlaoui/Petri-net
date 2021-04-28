import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class MainController implements Initializable {

    @FXML
    public static Label lblSalleAttente1;
    @FXML
    public static Label lblSalleAttente3;
    @FXML
    public Label lblSalleExamen;
    @FXML
    public Label lblMedecineDisponible;

    @FXML
    private static Label lblSalleAttente2;

    static Circle c  ;
    static float xC ;
    static float yC ;

    static Circle c1 = new Circle(5);
    static Circle c2 = new Circle(5);
    static Circle c3 = new Circle(5);
    static Circle c4 = new Circle(5);
    static Circle c5 = new Circle(5);

    static float xT1  = 155f , yT1  =  52f ;
    static float xT2  = 510f , yT2  =  52f ;
    static float xT3  = 888f , yT3  =  52f ;
    static float xT4  = 155f , yT4  = 255f ;
    static float xT5  = 510f , yT5  = 255f ;
    static float xT6  = 888f , yT6  = 255f ;
    static float xT7  =  80f , yT7  = 570f ;
    static float xT8  = 510f , yT8  = 570f ;
    static float xT9  = 888f , yT9  = 570f ;

    static float xP1  = 199f , yP1  = 156f ;
    static float xP2  = 549f , yP2  = 156f ;
    static float xP3  = 931f , yP3  = 156f ;
    static float xP4  =  58f , yP4  = 190f ;
    static float xP5  = 388f , yP5  = 190f ;
    static float xP6  = 798f , yP6  = 190f ;
    static float xP7  = 199f , yP7  = 391f ;
    static float xP8  = 549f , yP8  = 391f ;
    static float xP9  = 931f , yP9  = 391f ;
    static float xP10 = 388f , yP10 = 351f ;


    public static Label l1 = new Label("10");
    public static Label l2 = new Label("10");
    public static Label l3 = new Label("10");


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        c1.setCenterX(58f);
        c1.setCenterY(195f);
        c1.setStroke(Color.BLACK);
        c1.setFill(Color.BLACK);

        c2.setCenterX(388f);
        c2.setCenterY(190f);
        c2.setStroke(Color.BLACK);
        c2.setFill(Color.BLACK);

        c3.setCenterX(798f);
        c3.setCenterY(188f);
        c3.setStroke(Color.BLACK);
        c3.setFill(Color.BLACK);

        c4.setCenterX(392f);
        c4.setCenterY(354f);
        c4.setStroke(Color.BLACK);
        c4.setFill(Color.YELLOW);


        c5.setCenterX(379f);
        c5.setCenterY(347f);
        c5.setStroke(Color.BLACK);
        c5.setFill(Color.GREEN);

        xC1  = (float) c1.getCenterX() ;              yC1 = (float) c1.getCenterY()   ;
        xC2  = (float) c2.getCenterX() ;              yC2 = (float) c2.getCenterY()   ;
        xC3  = (float) c3.getCenterX() ;              yC3 = (float) c3.getCenterY()   ;
        xC4  = (float) c4.getCenterX() ;              yC4 = (float) c4.getCenterY()   ;
        xC5  = (float) c5.getCenterX() ;              yC5 = (float) c5.getCenterY()   ;

        l1.setLayoutX(188);
        l1.setLayoutY(141);
        l1.setFont(new Font("Arial", 20));

        l2.setLayoutX(539);
        l2.setLayoutY(141);
        l2.setFont(new Font("Arial", 20));

        l3.setLayoutX(923);
        l3.setLayoutY(141);
        l3.setFont(new Font("Arial", 20));


        anchorPane.getChildren().addAll(l1);
        anchorPane.getChildren().addAll(l2);
        anchorPane.getChildren().addAll(l3);

        anchorPane.getChildren().addAll(c1);
        anchorPane.getChildren().addAll(c2);
        anchorPane.getChildren().addAll(c3);
        anchorPane.getChildren().addAll(c4);
        anchorPane.getChildren().addAll(c5);

    }


    static float xC1  = (float) c1.getCenterX() , yC1 = (float) c1.getCenterY();
    static float xC2  = (float) c2.getCenterX() , yC2 = (float) c2.getCenterY();
    static float xC3  = (float) c3.getCenterX() , yC3 = (float) c3.getCenterY();
    static float xC4  = (float) c4.getCenterX() , yC4 = (float) c4.getCenterY();
    static float xC5  = (float) c5.getCenterX() , yC5 = (float) c5.getCenterY();






    @FXML
    private  AnchorPane anchorPane;


    public static void goTo(float a , float b , float x, float y, Circle c) throws InterruptedException {
        App.semaphore2.acquire();
        Path path = new Path();
        c.setCenterX(x);
        c.setCenterY(y);
        path.getElements().add(new MoveTo(a,b));
        path.getElements().add(new LineTo(x,y));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(1.5));
        pathTransition.setPath(path);
        pathTransition.setNode(c);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.play();
        App.semaphore2.release();
    }



    public static void goToT4() throws InterruptedException {
        Platform.runLater(() -> {l1.setText(String.valueOf( parseInt(l1.getText())-1 )); });


        goTo((float) c1.getCenterX(), (float) c1.getCenterY() , xT4+20f , yT4 + 5f , c1);
        App.semaphore3.release();

        if((c4.getCenterX() == xC4) && (c4.getCenterY() == yC4)) {
            c = c4 ;  xC =(float) c4.getCenterX() ; yC = (float) c4.getCenterY();
            goTo((float) c4.getCenterX(), (float) c4.getCenterY() , xT4+20f , yT4+5f , c4);

            Thread.sleep(2000);
            goTo((float) c1.getCenterX(), (float) c1.getCenterY() , xP7 , yP7 , c1);
            goTo((float) c4.getCenterX(), (float) c4.getCenterY() , xP7 , yP7 , c4);
            Thread.sleep(1500);
            goTo((float) c1.getCenterX(), (float) c1.getCenterY() , xT7 , yT7 , c1);
            goTo((float) c4.getCenterX(), (float) c4.getCenterY() , xT7 , yT7 , c4);
            Thread.sleep(1500);
            goTo((float) c1.getCenterX(), (float) c1.getCenterY() , xC1 , yC1 , c1);
            goTo((float) c4.getCenterX(), (float) c4.getCenterY() , xC4 , yC4 , c4);


        }
        else  if((c5.getCenterX() == xC5) && (c5.getCenterY() == yC5)) {
            c = c5;  xC =(float) c5.getCenterX() ; yC = (float) c5.getCenterY();
            goTo((float) c5.getCenterX(), (float) c5.getCenterY() , xT4 , yT4 , c5);

            Thread.sleep(2000);
            goTo((float) c1.getCenterX(), (float) c1.getCenterY() , xP7 , yP7 , c1);
            goTo((float) c5.getCenterX(), (float) c5.getCenterY() , xP7 , yP7 , c5);
            Thread.sleep(2000);
            goTo((float) c1.getCenterX(), (float) c1.getCenterY() , xT7 , yT7 , c1);
            goTo((float) c5.getCenterX(), (float) c5.getCenterY() , xT7 , yT7 , c5);
            Thread.sleep(1500);
            goTo((float) c1.getCenterX(), (float) c1.getCenterY() , xC1 , yC1 , c1);
            goTo((float) c5.getCenterX(), (float) c5.getCenterY() , xC5 , yC5 , c5);

        }

    }


    public static void goToT5() throws InterruptedException {
        Platform.runLater(() -> {l2.setText(String.valueOf( parseInt(l2.getText())-1 )); });

        goTo((float) c2.getCenterX(), (float) c2.getCenterY() , xT5 , yT5 , c2);
        if((c4.getCenterX() == xC4) && (c4.getCenterY() == yC4)) {
            c = c4 ;  xC =(float) c4.getCenterX() ; yC = (float) c4.getCenterY();
            goTo((float) c4.getCenterX(), (float) c4.getCenterY() , xT5 , yT5 , c4);

            Thread.sleep(2000);
            goTo((float) c2.getCenterX(), (float) c2.getCenterY() , xP8 , yP8 , c2);
            goTo((float) c4.getCenterX(), (float) c4.getCenterY() , xP8 , yP8 , c4);
            Thread.sleep(2000);
            goTo((float) c2.getCenterX(), (float) c2.getCenterY() , xT8 , yT8 , c2);
            goTo((float) c4.getCenterX(), (float) c4.getCenterY() , xT8 , yT8 , c4);
            Thread.sleep(1500);
            goTo((float) c2.getCenterX(), (float) c2.getCenterY() , xC2 , yC2 , c2);
            goTo((float) c4.getCenterX(), (float) c4.getCenterY() , xC4 , yC4 , c4);

        }
        else  if((c5.getCenterX() == xC5) && (c5.getCenterY() == yC5)) {
            c = c5;  xC =(float) c5.getCenterX() ; yC = (float) c5.getCenterY();
            goTo((float) c5.getCenterX(), (float) c5.getCenterY() , xT5 , yT5 , c5);

            Thread.sleep(2000);
            goTo((float) c2.getCenterX(), (float) c2.getCenterY() , xP8 , yP8 , c2);
            goTo((float) c5.getCenterX(), (float) c5.getCenterY() , xP8 , yP8 , c5);
            Thread.sleep(2000);
            goTo((float) c2.getCenterX(), (float) c2.getCenterY() , xT8 , yT8 , c2);
            goTo((float) c5.getCenterX(), (float) c5.getCenterY() , xT8 , yT8 , c5);
            Thread.sleep(1500);
            goTo((float) c2.getCenterX(), (float) c2.getCenterY() , xC2 , yC2 , c2);
            goTo((float) c5.getCenterX(), (float) c5.getCenterY() , xC5 , yC5 , c5);
        }

    }

    public static void goToT6() throws InterruptedException {
        Platform.runLater(() -> {l3.setText(String.valueOf( parseInt(l3.getText())-1 )); });

        goTo((float) c3.getCenterX(), (float) c3.getCenterY() , xT6 , yT6 , c3);
        if((c4.getCenterX() == xC4) && (c4.getCenterY() == yC4)) {
            c = c4 ;  xC =(float) c4.getCenterX() ; yC = (float) c4.getCenterY();
            goTo((float) c4.getCenterX(), (float) c4.getCenterY() , xT6 , yT6 , c4);

            Thread.sleep(2000);
            goTo((float) c3.getCenterX(), (float) c3.getCenterY() , xP9 , yP9 , c3);
            goTo((float) c4.getCenterX(), (float) c4.getCenterY() , xP9 , yP9 , c4);
            Thread.sleep(1500);
            goTo((float) c3.getCenterX(), (float) c3.getCenterY() , xT9 , yT9 , c3);
            goTo((float) c4.getCenterX(), (float) c4.getCenterY() , xT9 , yT9 , c4);
            Thread.sleep(1500);
            goTo((float) c3.getCenterX(), (float) c3.getCenterY() , xC3 , yC3 , c3);
            goTo((float) c4.getCenterX(), (float) c4.getCenterY() , xC4 , yC4 , c4);
        }
        else  if((c5.getCenterX() == xC5) && (c5.getCenterY() == yC5)) {
            c = c5;  xC =(float) c5.getCenterX() ; yC = (float) c5.getCenterY();
            goTo((float) c5.getCenterX(), (float) c5.getCenterY() , xT6 , yT6 , c5);

            Thread.sleep(2000);
            goTo((float) c3.getCenterX(), (float) c3.getCenterY() , xP9 , yP9 , c3);
            goTo((float) c5.getCenterX(), (float) c5.getCenterY() , xP9 , yP9 , c5);
            Thread.sleep(1500);
            goTo((float) c3.getCenterX(), (float) c3.getCenterY() , xT9 , yT9 , c3);
            goTo((float) c5.getCenterX(), (float) c5.getCenterY() , xT9 , yT9 , c5);
            Thread.sleep(1500);
            goTo((float) c3.getCenterX(), (float) c3.getCenterY() , xC3 , yC3 , c3);
            goTo((float) c5.getCenterX(), (float) c5.getCenterY() , xC5 , yC5 , c5);
        }

    }





    @FXML
    private void p1() throws InterruptedException {
        //System.out.println("[ p1 ,  p2 ,  p3 ,  m1 ,  m2 ,  m3 ,  s1 ,  s2 ,  s3 ,  s ] ");
        new Thread(new Patient(1)).start();
    }

    @FXML
    private void p2() {
        //System.out.println("[ p1 ,  p2 ,  p3 ,  m1 ,  m2 ,  m3 ,  s1 ,  s2 ,  s3 ,  s ] ");
        new Thread(new Patient(2)).start();
    }

    @FXML
    private void p3() {
        //System.out.println("[ p1 ,  p2 ,  p3 ,  m1 ,  m2 ,  m3 ,  s1 ,  s2 ,  s3 ,  s ] ");
        new Thread(new Patient(3)).start();
    }


}
