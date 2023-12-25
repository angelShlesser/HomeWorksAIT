package de.ait.homeworks60;

public class MyTask  implements Runnable{
    @Override
    public void run() {
        for (int i=1; i<=5; i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            }
            catch (IllegalArgumentException exception){
                System.out.println("ERROR " + exception.getMessage());
            }
            catch (InterruptedException exception) {
                System.out.println("ERROR " + exception.getMessage());
            }
            catch (Exception exception){
                System.out.println("ERROR " + exception.getMessage());
            }
        }
    }
}
