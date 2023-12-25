package de.ait.homeworks61;

public class Main {
    public static void main(String[] args) {

        BartenderThread threadOne = new BartenderThread();
        BartenderThread threadTwo = new BartenderThread();
        BartenderThread threadThree = new BartenderThread();
        CoffeeMakerThread coffeeMakerThread = new CoffeeMakerThread();
        SommelierThread sommelierThread = new SommelierThread("Merlau 1920");
        sommelierThread.start();
        threadOne.start();
        threadTwo.start();
        threadThree.start();
        coffeeMakerThread.start();



    }
}
