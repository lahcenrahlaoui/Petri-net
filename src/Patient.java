import com.sun.tools.javac.Main;

import java.util.concurrent.Semaphore;

public class Patient implements  Runnable{
    int p ;
    public Patient(int p){
        this.p = p ;
    }

    @Override
    public void run() {


        try{
            App.semaphore.acquire();


            // patient  1
                if(p == 1 ) {
                    App.semaphore3.acquire();

                    if ((App.arr[0] > 0) && (App.arr[3] == 1) && (App.arr[9] > 0)) {
                        try {
                            App.arr[0]--;
                            App.p1Enter();

                            //  App.semaphore2.acquire();
                            MainController.goToT4();
                            //  App.semaphore2.release();

                            //               System.out.println(" patient 1 in the cabine ");
                            Thread.sleep(5000);
                            App.p1Sorte();
                            //               System.out.println(" patient 1 out the cabine ");


                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                        }
                    }
                }
                // patient 2
                if(p == 2)
                    if ( ( App.arr[1] > 0 ) && ( App.arr[4] == 1 ) && ( App.arr[9] > 0 )) {
                        try {
                            App.arr[1]-- ;
                            App.p2Enter();
                            MainController.goToT5();

                            //             System.out.println(" patient 2 in the cabine ");
                            Thread.sleep(5000);
                            App.p2Sorte();
                            //               System.out.println(" patient 2 out the cabine ");
                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                        }
                    }

                // patient 3
                if(p == 3)
                    if ( ( App.arr[2] > 0 ) && ( App.arr[5] == 1 ) && ( App.arr[9] > 0  )) {
                        try {
                            App.arr[2]-- ;
                            App.p3Enter();
                            MainController.goToT6();

                            //              System.out.println(" patient 3 in the cabine ");
                            Thread.sleep(5000);
                            App.p3Sorte();
                            //              System.out.println(" patient 3 out the cabine ");

                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                        }
                    }


            App.semaphore.release();

        }catch(Exception e){

        }


    }
}
