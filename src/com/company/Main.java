package com.company;

public class Main {
    public static void main(String[] args) {
        AnimalThread rabbit = (new AnimalThread(" Кролик Никита ",1));
        rabbit.start();
        System.out.println("Старт...");

        AnimalThread turtle = (new AnimalThread(" Черепаха Виталя",2));
        turtle.start();
    }
}
class AnimalThread extends Thread {
    String Pol;
    int distanceThread ;
    final int distance = 11;

    AnimalThread(String Pol,int distanceThread){
        this.Pol = Pol;
        this.distanceThread = distanceThread;
    }
@Override
    public void run() {
    Thread.currentThread().setPriority(distanceThread);
    Thread.currentThread().setName(Pol);

    int timeToStep = 1000 / (Thread.currentThread().getPriority());
    for (int p = 0; p < distance; p++) {
        try {
            Thread.sleep(timeToStep);
            System.out.println(getName() + (" - ") + (p * 100) + " метров ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (p == distance / 2) {
            if (Thread.currentThread().getPriority() == 1) {
                Thread.currentThread().setPriority(10);
            } else {
                Thread.currentThread().setPriority(1);
            }
        }
    }
        System.out.println("«Финиш»");
        System.out.println("Победитель: Черепаха Виталя");
    }
    }