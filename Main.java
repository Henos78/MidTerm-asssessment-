//......................................QUESTION-ONE...............................................................



//..........................................MULTIPLE QUESTION TRIVIA PROGRAM ..........................................................

package com.company;

//We will import the Scanner utility library.
import java.util.Locale;
import java.util.Scanner;


//This is our main class in which our program will run.
public class Main {


    public static void main(String[] args) {

        //Here we will create our questions which include 5 questions and 5 answers each
        String questionOne = "As of today Mar 7, 2022,Who is the best player in the Premier league?\na. Cristiano Ronaldo" +
                "\nb. Sadio Mane\nc. Kevin Debruyne\nd. Mohamed Salah\ne. None";
        String questionTwo = "How many goals has Kylian Mbappe scored so far?(As of today Mar 7, 2022)\na.15\nb.20" +
                "\nc.14\nd.10\ne.17";
        String questionThree = "Which team has the most success throughout the champions league history?" +
                "\na. Manchester United\nb. FC Barcelona\nc. RealMadrid\nd. AC Milan\ne. Bayern Munich";
         String questionFour = "Who was the first African Player to win the Ballon d'or?\na. Samuel Eto\nb. Dider Drogba" +
                 "\nc. Emmanuel Kanu\nd. George Weah\ne. Jay Jay Okocha";
        String questionFive ="Which country won the African Cup of nations in 2017?\na. Senegal\nb. Cameroon\nc. Ghana" +
                "\nd. Egypt\ne. Nigeria";
        String questionSix = "Which year of the premier league season was Arsenal crowned as champions and named 'The Invincibles'?\n" +
                "a. 2004\nb. 2003\nc. 2006\nd. 2000\ne. 2002";

        // We will create our question objects here
        Questions[] questions = {
                new Questions(questionOne, "d"),
                new Questions(questionTwo, "c"),
                new Questions(questionThree, "c"),
                new Questions(questionFour,"d"),
                new Questions(questionFive,"b"),
                new Questions(questionSix,"a")
        };
        
      // We will call the takeQuiz function using the questions as a method.
        takeQuiz(questions);
    }

    // This is our Driver function in which the program is going to run
    public static void takeQuiz(Questions[] questions) {

        int grade = 0;     // we will initialize variable to store scores of every correct question by our user

        //We will use  scanner to allow user to take user input
        Scanner userName = new Scanner(System.in);
        Scanner userInput = new Scanner(System.in);
        Scanner playAgain = new Scanner(System.in);

        //The program will print a welcome message including the instructions on how to play the game.
        System.out.println("......................................WELCOME......................................\n" +
                "");
        System.out.println("Please enter your name: ");
        String name = userName.nextLine();
        System.out.println("--> Hello "+ name +", Welcome to the Multiple Question Trivia game!\n" +
                "...................................INSTRUCTIONS............................................\n" +
                "-->There are five random questions in this program. Each time you answer a question your score will be" +
                " displayed and you will be asked if you want to play again or not. If yes, you will continue playing the" +
                " game and If No, you will quit and your final score will be displayed.\n" +
                "--->Ready? Let's gooooooo! ");

        // We created a count_Questions variable to record the number of correct and incorrect answer by the user.
        int recordAnswer = 0;

        // We created a while loop which will enable the user to play the game until they decide to quit.
        while (true){

            //We used  a for loop to display the questions and to record the user answers.
            for (int i = 0; i < questions.length; i++) {
                recordAnswer  ++;

                // We created a variable to store our timer information.(To record how long our user takes to answer.)
                long startTime;
                double time;
                startTime = System.currentTimeMillis();
                for (long y=0; y<=100000; y++) {
                }

                // This displays the questions and allow our user to enter their answer.
                System.out.println(questions[i].quest);
                String answers = userInput.nextLine();

                // This will calculate the total time taken to answer each question.
                long endTime;
                endTime = System.currentTimeMillis();
                time = (endTime - startTime) / 1000.0;

                // We created a condition which enables us to make sure whether our user got the answer right or wrong.
                if (answers.equals(questions[i].answers)) {
                    grade++;

                    System.out.println("-->Congrats! You got this one right!"+" It took you "+time+" to answer this question.");
                }
                else {
                    System.out.println("-->Oops! You got this one wrong!"+" It It took you "+time+" to answer this question.");
                }

                // This will display the score for our user.
                System.out.println("--> Your score is " + grade + "/" + recordAnswer );

                //Here we will ask the user if they would like  to continue to play the game or not
                System.out.println(" Ready for more challenging questions? Would you like to play the game again? Type: (yes/no)");
                // This will convert the user input into lowercase.
                String userResponse = playAgain.nextLine().toLowerCase(Locale.ROOT);

                // We created a conditions that will be implemented based on the user choice.
                while(true){

                    //If the user types yes, the program resume and the user will continue playing
                    if (userResponse.equals("yes")){
                        break;
                    }
                    // If the user types no, the program will exit and display a final message.
                    else if(userResponse.equals("no")){
                        System.out.println("--> Thank you for playing the game, Be sure to stick around for more challenging questions next time around.");
                        System.out.println("-->Here is your final score: " + grade + "/" + recordAnswer );

                        System.out.println("...........................................THE END................................");
                        System.exit(0);
                    }
                }
            }
        }
    }
}


//....................................................THANK YOU!.....................................................