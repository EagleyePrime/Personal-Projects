//This Class stores all the text for questions and answers, calculates academic subject scores, and determines a plan.

public class CareerQuiz {

    //These two arrays store the visual text that the user sees.
    private static String[] questions;
    private static String[] answers;

    //Specialized question and answer text. This helps categorize all the questions and answers.
    private static String[] stemQ;
    private static String[] artQ;
    private static String[] techQ;
    private static String[] busQ;
    private static String[] medQ;
    private static String[] lawQ;
    private static String[] socialQ;

    private static String[] stemA;
    private static String[] artA;
    private static String[] techA;
    private static String[] busA;
    private static String[] medA;
    private static String[] lawA;
    private static String[] socialA;

    private static int[] userAnswers;   //Each index here corresponds with the question array's. More info below.
    /* How to use userAnswers:
    This array stores a number, called a rank, corresponding to whatever the number answer is for each question. There'll be a method
    that will check each rank, and then based off of the number rank will increment the appropriate score.
     */

    //The index of the next open spot in the questions array.
    private static int openIndex;

    private static int academicScore;  //Overall general score. This indicates college-preparedness.
    private static int stemScore;  //How STEM inclined the student is.
    private static int artScore;  //How artistically inclined the student is.
    private static int technicalScore; //trade school
    private static int businessScore;
    private static int medicalScore;
    private static int lawScore;
    private static int socialStudiesScore;   //How social studies inclined the student is.

    //Collected user information.
    private static int userAge;
    private static float gpa;


//The dark below.


    public CareerQuiz(boolean isActive) {
        academicScore = 0;
        stemScore = 0;
        artScore = 0;
        technicalScore = 0;
        businessScore = 0;
        medicalScore = 0;
        lawScore = 0;
        socialStudiesScore = 0;



        if (isActive) {
            addQuestions();
        }
        else {
            System.out.println("pretend you skipped the quiz and are on the website");
        }
    }

    public static String getNextQuestion() {
        if(stemScore > 5 && stemScore < 10) {
            return questions[7];
        }
        if(stemScore > 10 && stemScore < 15) {
            return "";
        }
        if(stemScore >= 15) {
            return "";
        }

        if(artScore > 5 && artScore < 10) {
            return "";
        }
        if(artScore > 10) {
            return "";
        }

        if(technicalScore > 5 && technicalScore < 10) {
            return "";
        }
        if(technicalScore > 10) {
            return "";
        }

        if(businessScore > 5 && businessScore < 10) {
            return "";
        }
        if(businessScore > 10) {
            return "";
        }

        if(medicalScore > 5 && medicalScore < 10) {
            return "";
        }
        if(medicalScore > 10) {
            return "";
        }

        if(lawScore > 5 && lawScore < 10) {
            return "";
        }
        if(lawScore > 10) {
            return "";
        }

        if(socialStudiesScore > 5 && socialStudiesScore < 10) {
            return "";
        }
        if(socialStudiesScore > 10) {
            return "";
        }

        return "";
    }

    //Used to initialize and put basic questions into the questions array. This is the master list of every single question.
    public static void addQuestions() {

        questions = new String[999];
        //Basic questions.
        questions[0] = "What is your age?"; //Will receive a number from user.
        questions[1] = "What is your current level of education?";
        questions[2] = "What is your current/most recent GPA?"; //Will receive a number from user.
        questions[3] = "Estimate your household income.";
        questions[4] = "Are you planning to attend college or university?";
        questions[5] = "Which academic area are you most interested in?";
        questions[6] = "Which of the following best describes your academic achievement in school?";
        questions[7] = "Which academic area do you succeed most at in school?";
        questions[8] = "Which of the following careers interests you the most? Choose as many as needed";
        questions[9] = "";

        //STEM questions.
        questions[10] = "What activity sounds most appealing to you?";
        questions[11] = "";
        questions[12] = "";
        questions[13] = "";

        //Art questions.
        questions[14] = "art q";
        questions[15] = "";
        questions[16] = "";
        questions[17] = "";

        //Technical questions
        questions[18] = "tech q";
        questions[19] = "";
        questions[20] = "";
        questions[21] = "";

        //Business questions
        questions[22] = "business q";
        questions[23] = "";
        questions[24] = "";
        questions[25] = "";

        //Medical questions
        questions[26] = "medical q";
        questions[27] = "";
        questions[28] = "";
        questions[29] = "";

        //Law questions
        questions[30] = "law q";
        questions[31] = "";
        questions[32] = "";
        questions[33] = "";

        //Social studies questions
        questions[34] = "social q";
        questions[35] = "";
        questions[36] = "";
        questions[37] = "";
    }



    //Collects the answer the user gave.
    public static void getUserAnswer(int choiceNum){
        incrementScore(choiceNum);
    }
    /*
    //After the basic questions finish, the next questions that follow will be determined by how the user answered the basic questions.
    public static void addSpecificQuestions() {
        if (stemScore >= 5) {
            System.out.println("stem inclined");
        }
        else if(stemScore < 5) {
            System.out.println("less than 5");
        }
        else {
            System.out.println("you will like gambling.");
        }
    }
    */


    //if we never end up using these anywhere except in this class, change these three getters to private
    public static String[] getQArray() {
        return questions;
    }

    public static String[] getAnsArray() {
        return answers;
    }

    //saving this for later but it could be scrapped so who knows
    public static int[] getAnsRank() {
        return userAnswers;
    }

    //Developer testing tool.
    public static void setScore(int num, String scoreType) {
        if (scoreType.equals("Academic")) {
            academicScore = num;
        }
        else if (scoreType.equals("Art")) {
            artScore = num;
        }
        else if (scoreType.equals("Tech")) {
            technicalScore = num;
        }
        else if (scoreType.equals("Business")) {
            businessScore = num;
        }
        else if (scoreType.equals("Medical")) {
            medicalScore = num;
        }
        else if (scoreType.equals("Law")) {
            lawScore = num;
        }
        else if (scoreType.equals("Social")) {
            socialStudiesScore = num;
        }
    }

    /*
    Format of basic questions:
    Q: Question goes here.
    A1: Answer relating to STEM. (Rank 0)
    A2: Answer relating to art. (Rank 1)
    A3: Answer relating to tech. (Rank 2)
    A4: Answer relating to business. (you get the point)
    A5: Answer relating to medical field.
    A6: Answer relating to law.
    A7: Answer relating to social studies.
     */
    //Call this method after the set of basic questions is finished, and then after the specialized questions are finished.
    public static int[] sumScores(boolean isBasic) {
        if (isBasic){
            int[] total = new int[7];
            for (int i = 0; i < 9; i++) {
                //Indices 0 and 2 are questions that require user input.
                if (i == 0) {
                    //will implement later
                }
                else if (i == 2) {
                    //will implement later
                }
                else {
                    incrementScore(userAnswers[i]);
                }
            }
            return total;
        }
        else {
            int[] total = new int[100];
            return total;
        }
    }

    //we will determine score weighting later
    private static void incrementScore(int rank) {
        if (rank == 0) {
            academicScore++;
            //stemScore++;
        }
        else if (rank == 1) {
            academicScore++;
            //artScore++;
        }
        else if (rank == 2) {
            academicScore++;
            //technicalScore++;
        }
        else if (rank == 3) {
            academicScore++;
            //businessScore++;
        }
        else if (rank == 4) {
            academicScore++;
            //medicalScore++;
        }
        else if (rank == 5) {
            academicScore++;
            //lawScore++;
        }
        else if (rank == 6) {
            academicScore++;
            //socialStudiesScore++;
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


   */
}