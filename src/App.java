import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.Semaphore;

public class App extends Application {

    public static Semaphore semaphore = new Semaphore(2);
    public static Semaphore semaphore2 = new Semaphore(1);

    public static Semaphore semaphore3 = new Semaphore(1);




    public static int x = 10 , y = 10 , z  = 10 ;
    public static int m1 = 1 , m2 = 1 , m3 = 1 ;
    public static int s1 = 0 , s2 = 0 , s3 = 0 ;
    public static int s = 2 ;
    public static int arr[] = { x , y , z , m1 , m2 , m3 , s1 , s2 , s3 , s };


    // p1
    public static void p1Enter(){
        arr[3]-- ;
        arr[6]++ ;
        arr[9]-- ;
        printv();
    }
    public static void p1Sorte(){
        arr[3]++ ;
        arr[6]-- ;
        arr[9]++ ;
        printv();
    }

    // p2

    public static void p2Enter(){
        arr[4]-- ;
        arr[7]++ ;
        arr[9]--;
        printv();
    }
    public static void p2Sorte(){
        arr[4]++ ;
        arr[7]-- ;
        arr[9]++ ;
        printv();
    }


    // p3

    public static void p3Enter(){

        arr[5]-- ;
        arr[8]++ ;
        arr[9]-- ;
        printv();

    }
    public static void p3Sorte(){

        arr[5]++ ;
        arr[8]-- ;
        arr[9]++ ;
        printv();

    }

    public static void printv(){
        System.out.print(" [ " + arr[0] );
        for (int i = 1 ; i< arr.length ; i++)
            System.out.print("  |  " + arr[i]);
        System.out.println(" ] ");
        System.out.println("___________________________________________________________");
    }





    @Override
    public void start(Stage stage) {



        try {
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            stage.setScene(new Scene(root));
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

        stage.setTitle("RDP Cabine");
        stage.show();
    }

    public static void main(String[] args) {

        System.out.println(" [ p1 |  p2 |  p3 |  m1 |  m2 |  m3 |  s1 |  s2 |  s3 |  s ] ");

        Application.launch(args);
    }
}
