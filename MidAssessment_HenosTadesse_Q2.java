//Mid-term Assessment
//.....................................QUESTION-TWO...........................................................

// We will try to simulate traffic and traffic lights. Here is how we will implement the following program.


//.........................................TRAFFIC LIGHT SIMULATION................................................
package com.company;

//We import the java utility library.
import java.util.*;

//Here we have our main class name TrafficLights.
public class TrafficLights {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

// We will create our array lists for our car collection.
        ArrayList<String> Cars = new ArrayList<String>();

//  We will create an array list that hold our road as a collection in which the cars will use.
        ArrayList<String> road = new ArrayList<String>();

        // Collection for keep track the cars leaving the road
        ArrayList<String> out_cars = new ArrayList<String>();

//   We will use a for loop to generate 100 cars.
        for (int i = 1; Cars.size() < 100; i++) {
            String car_index = Integer.toString(i);
            String name = "car" + car_index;
            Cars.add(name);
        }
        // We created a random object so that the cars will enter the collection in a random order
        Random random = new Random();

        // We create a variable "in" to keep track off the cars are going to be added.
        int in = 0;


// Prints out a welcome message to our user.
        System.out.println(".................................WELCOME................................................\n" +
                "This is a Traffic Simulate Program, where we will demonstrate how an actual Traffic system light " +
                "operates using Java.\nI hope you will enjoy this!\n...............Initiate Start!!..................... ");

        // By using a while loop we will add the cars to the road randomly.
        boolean incoming_cars = true;
        while(incoming_cars) {
            String a = Cars.get(random.nextInt(Cars.size()));

            // We will check if a car has been already added to the road
            if (!road.contains(a)) {
                road.add(a);
                in++;
            }
            else if(in == 20) {
                System.out.println("A total of 20 cars has been added to the road");
                in = 0;
                continue;
            }

            // We must make sure the cars that will be out do not exceed more than 100.
            if(road.size() == 100) {
                Cars.clear();
                break;
            }
        }


// .......................The code for traffic light that will simulate the Lights...................................

        /*

    -->For this section of the program we will use a while loop for the Traffic Lights Starting with RED, GREEN and YELLOW.
    The lights will alternate in that order following specific time loop until all the cars go.

        */

        // Red light traffic section
        boolean red_light = true;
        while (red_light) {
            while (true) {
                Timer red = new Timer(); // The timer module to help keep the time
                int start_red = 0;
                int time_red = 20000; // We keep 20 seconds for red light
                red.schedule(new TimerTask() {
                    int counter = 0;

                    public void run() {
                        System.out.println("--> RED LIGHT ON = ALL CARS STOP!");
                        System.out.println("Only 20s left to go....\n");
                        counter++;

                        if (counter == 1) {
                            red.cancel();
                        }
                    }
                }, start_red, time_red);

                //We will use Thread.sleep exception to keep track of the time.
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                break;
            }

            // This will end the program if all the cars are gone from the collection.
            if (road.size() == 0) {
                break;
            }

            // Green light traffic Section
            boolean green_light = true;
            while (green_light) {
                Timer green = new Timer(); // The timer module to help keep the time
                int start_green = 0;
                int time_green = 1000; // This will allow moving a car per second until the timer ends
                green.schedule(new TimerTask() {
                    int counter = 0;

                    public void run() {
                        System.out.println("-->GREEN LIGHT ON = ALL CARS CAN GO!");
                        if (road.size() != 0) {
                            System.out.println(road.get(road.size() - 1) + " depart");
                            out_cars.add(road.get(road.size() - 1));
                            System.out.println();
                            road.remove(road.size() - 1);
                            counter++;
                        }

                        // The total cars to move are 30 cars since each second a car will be gone and the green light has 30 seconds
                        if (counter >= 30) {
                            green.cancel();
                        }
                    }
                }, start_green, time_green);

                // We will use Thread.sleep exception to keep track of the time.
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                break;
            }

            // This will end the program if all the cars are gone from the collection.
            if (road.size() == 0) {
                break;
            }

            // Yellow Light Traffic Section
            boolean yellow_light = true;
            while (yellow_light) {
                Timer yellow = new Timer();
                int start_yellow = 0;
                int time_yellow = 2000; // 2 seconds
                yellow.schedule(new TimerTask() {
                    int counter = 0;

                    public void run() {
                        System.out.println("-->YELLOW LIGHT ON = PlEASE SLOWDOWN!!!");
                        if (road.size() != 0) {
                            out_cars.add(road.get(road.size() - 1));
                            System.out.println(road.get(road.size() - 1) + " gone\n");
                            road.remove(road.size() - 1); // It will remove the cars that have already gone.
                            counter++;
                        }
                        // Five cars will only move  when the yellow light is turned on.
                        // As yellow a car goes every 2 seconds since the yellow light last for 10 seconds
                        if (counter >= 5) {
                            yellow.cancel();
                        }
                    }
                }, start_yellow, time_yellow);

                // We will use Thread.sleep exception to keep track of the time.
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                break;
            }
            // This will end the program if all the cars are gone from the collection.
            if (road.size() == 0) {
                break;
            }
        }

    }
}

//........................................THANK YOU!!!.................................................................