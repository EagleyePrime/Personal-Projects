import java.util.Scanner;

public class CareerQuiz {
    private Question[] questions;
    private String[] categories;
    private int[] scores;
    private Question[] specQuestions;   //List of special questions.

    public CareerQuiz(Question[] questions, String[] categories) {
        this.questions = questions;
        this.categories = categories;
        this.scores = new int[categories.length];
    }

    public static void main(String[] args) {
        String[] categories = {"STEM", "Art", "Technical", "Business", "Medical", "Law", "Social Studies"};
        Question[] questions = new Question[3]; //the length of this has to be the # of questions

//these three lines right here are one question each one should follow this format
        String[] q1Options = {"Math", "Drawing", "Building things", "Making money", "Treating injury", "Law", "Social"};
        String[] q1Categories = {"STEM", "Art", "Technical", "Business", "Medical", "Law", "Social Studies"};
        questions[0] = new Question("Which of these activities do you enjoy the most in school?", q1Options, q1Categories);
////////////////////
        String[] q2Options = {"Math", "Art", "Technical stuff (welding, woodworking, etc)", "Persuading others",
                "Helping others", "Reading and analyzing documents and/or literature", "History"};
        String[] q2Categories = {"STEM", "Art", "Technical", "Business", "Medical", "Law", "Social Studies"};
        questions[1] = new Question("Which of the following do you excel in?", q2Options, q2Categories);
        /*
        float userGPA = 0;     //User will answer with this.
        questions[2] = new Question("What's your weighted GPA (decimal points are allowed)?", userGPA);

         */
////////////////////
        String[] q3Options = {""};
        String[] q3Categories = {""};
        questions[2] = new Question("Which ", q3Options, q3Categories);
////////////////////
        String[] q4Options = {""};
        String[] q4Categories = {""};
        questions[3] = new Question("", q4Options, q4Categories);
////////////////////
        String[] q5Options = {""};
        String[] q5Categories = {""};
        questions[4] = new Question("", q5Options, q5Categories);




        CareerQuiz quiz = new CareerQuiz(questions, categories);
        quiz.takeQuiz();
    }


    public void takeQuiz() {
        Scanner user = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());

            if (question.isCustomAnswer()) {
                float gpa = user.nextFloat();
                System.out.println("GPA entered.");
            }
            else if (!question.isCustomAnswer()) {
                String[] options = question.getOptions();
                String[] questionCategories = question.getCategories();

                int optionNum = 1;
                for (int i = 0; i < options.length; i++) {
                    System.out.println(optionNum + " " + options[i]);
                    optionNum++;
                }
                System.out.println("Enter the option number");

                int answerIndex = user.nextInt() - 1;

                if (answerIndex >= 0 && answerIndex < options.length) {
                    String category = questionCategories[answerIndex];
                    for (int i = 0; i < categories.length; i++) {
                        if (categories[i].equals(category)) {
                            scores[i]++;
                            break;
                        }
                    }
                }
                else {
                    System.out.println("Invalid answer");
                }
            }

        }

        recommendCareer();
    }

    private int getScore(String category) {
        for(int i = 0; i < categories.length; i++) {
            if(categories[i].equals(category)) {
                return scores[i];
            }
        }
        return -1;
    }

    private void recommendCareer() {
        /*
        int maxScore = 0;
        String recommendedCategory = null;

        for(int i = 0; i < scores.length; i++) {
            if(scores[i] > maxScore) {
                //right now itll make you answer every question and see which category had the highest score
                maxScore = scores[i];
                recommendedCategory = categories[i];
            }
        }
        if(recommendedCategory != null) {
            System.out.println("Your recommended category is " + recommendedCategory);

            if(recommendedCategory.equals("STEM")){
                System.out.println("Here are steps to STEM careers");
            }
            else if(recommendedCategory.equals("Art")){
                System.out.println("Here are steps to an art career: ");
            }
            else if(recommendedCategory.equals("a")) {
                //keep doing this for each category
            }
        }
        else {
            //give a broad list of all careers since they got the same score in all
            System.out.println("Hello world");
        }
        */
        ///////////////////////////////////


        //returns the highest categories if multiple share the highest score
        String[] highestCategories = new String[7];
        int maxScore = 0;
        for(int i = 0; i < scores.length; i++) {
            if(scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }
        int highestFound = 0;
        for(int i = 0; i < scores.length && highestFound < 7; i++) {
            if(scores[i] == maxScore) {
                highestCategories[highestFound] = categories[i];
                highestFound++;
            }
        }
        for(int i = 0; i < highestFound; i++) {
            System.out.println("A recommended category for you is " + highestCategories[i]);
            switch (highestCategories[i]) {
                case "STEM" -> System.out.println("Here are steps to STEM careers");
                case "Art" -> System.out.println("Here are steps to an art career: ");
                case "Technical" -> System.out.println("Here are some steps to a technical career");
                case "Business" -> System.out.println("Here are some steps to a business career");
                case "Medical" -> System.out.println("Here are some steps to a medical career");
                case "Law" -> System.out.println("Here are some steps to a career in law");
                case "Social Studies" -> System.out.println("Here are some steps to a career in ...");
            }
        }
    }

    //If true, college can be in the career plan.
    private boolean isReadyForCollege(Question q) {
        float num = q.getNumber();
        //Weighted GPA
        if (num > 3.0 && num < 5.0) {
            return true;
        }
        return false;
    }
}

//this whole thing works only for the broad questions where each answer is a diff category
//might have to write another class for specific questions and then write methods for those specific questions
//but this format should work for questions like "which of the following subjects most interest you"

/*
Questions:
"What is your age?"; //Will receive a number from user.
"What is your current level of education?";
"What is your current/most recent GPA?"; //Will receive a number from user.
"Estimate your household income.";
"Are you planning to attend college or university?";
"Which academic area are you most interested in?";
"Which of the following best describes your academic achievement in school?";
"Which academic area do you succeed most at in school?";
"Which of the following careers interests you the most? Choose as many as needed";


        //STEM questions.
"What activity sounds most appealing to you?";
"";
"";
"";
transferQuestions(stemQ, 10);

        //Art questions.
"art q";
"";
"";
"";
transferQuestions(artQ, 14);

        //Technical questions
        questions[18] = "tech q";
        questions[19] = "";
        questions[20] = "";
        questions[21] = "";
        transferQuestions(techQ, 18);

        //Business questions
        questions[22] = "business q";
        questions[23] = "";
        questions[24] = "";
        questions[25] = "";
        transferQuestions(busQ, 22);

        //Medical questions
        questions[26] = "medical q";
        questions[27] = "";
        questions[28] = "";
        questions[29] = "";
        transferQuestions(medQ, 26);


 CATEGORIES:
    A1: Answer relating to STEM. (Rank 0)
    A2: Answer relating to art. (Rank 1)
    A3: Answer relating to tech. (Rank 2)
    A4: Answer relating to business. (you get the point)
    A5: Answer relating to medical field.
    A6: Answer relating to law.
    A7: Answer relating to social studies.
 */
