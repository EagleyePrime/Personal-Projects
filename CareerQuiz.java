import java.util.Scanner;

public class CareerQuiz {

    //These two arrays store the visual text that the user sees.
    private String[] questions;
    private String[] answers;

    private int[] userAnswers;   //Each index here corresponds with the question array's. More info below.
    /* How to use userAnswers:
    This array stores a number corresponding to whatever the number answer is for each question. There'll be a method
    that will check each element, and then based off of the number will increment the appropriate score.
     */

    private int academicScore;  //Overall general score.
    private int stemScore;  //How STEM inclined the student is.
    private int socialStudiesScore;   //How social studies inclined the student is.
    private int artScore;  //How artistically inclined the student is.
    private int technicalScore; //trade school
    private int businessScore;
    private int medicalScore;
    private int lawScore;

    private int userAge;

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);

        //while()

    }

    public CareerQuiz(boolean isActive) {
        if (isActive) {
            addBasicQuestions();
        }
        else {
            System.out.println("pretend you skipped the quiz and are on the website");
        }
    }


    //Used to put the basic questions inside the questions array.
    private static void addBasicQuestions() {

        questions = new String[999999]; //do not change the number
        questions[0] = "What is your age?"; //Will receive a number from user.
        questions[1] = "What is your current level of education?";
        questions[2] = "Are you planning to attend college or university?";
        questions[3] = "Which academic area are you most interested in?";
        questions[4] = "Which of the following best describes your academic achievement in school?";
        questions[5] = "Which academic area do you succeed most at in school?";
        questions[6] = "Which of the following careers interests you the most? Choose as many as needed";
    }

    //im still tryna figure out a good structure for how things are gonna work
    //by the end of tmrw we should have figured out the strucure even if its not coded yet then well have the
    //whole week to write everything


    //After the basic questions finish, the next questions that follow will be determined by how the user answered the basic questions.
    public static void addSpecificQuestions() {
        if (stemScore >= 5) {
            System.out.println("stem inclined");
        }
        else if(stemScore < 5) {
            System.out.println("less than 5");
        }
        else if() {
            System.out.println("you will like gambling.");
        }
    }
    //over and out lmaooooooooooo
//o7
    public static String[] getQArray() {
        return questions;
    }

    public static String[] getAnsArray() {
        return answers;
    }

    //saving this for later but it could be scrapped so who knows
    public static int[] getAnsIndex() {
        return userAnswers;
    }

    //Mock up
    public static void addScores() {
        for (int n: userAnswers) {

            if (n == 0) {
                academicScore++;
                stemScore++;
            }
            else if (n == 1) {
                academicScore += 2;
                socialStudiesScore++;
            }
            else if (n == 2) {
                academicScore += 3;
                artScore++;
            }
            else if (n == 3) {
                academicScore += 4;

            }

        }
    }


    //the question one is for storing the questions which is where we will pull from to display the text for it
    //the answer one is for displaying the answers

    /* talking area



    i thought of an idea where we have to arrange all of the answers the same way as in the first answer for every question is like the same subject
    like for example:
    1. what is your favorite subject?
    a. math
    b. computer science
    c. physics

    2. what is your favorite thing to do?
    a. adding numbers
    b. coding
    c. b

    yes exactly and then we put the score or whatever
    aight sounds good


    wait im thinking that like a lot ofstuff could just be printed in the main method?
   */
}