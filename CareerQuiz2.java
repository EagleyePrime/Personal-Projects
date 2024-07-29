//Jaden's version

/*


import java.util.Scanner;
public class CareerQuiz2 {
    private Question[] questions;
    private String[] categories;
    private int[] scores;

    //
    public CareerQuiz(Question[] questions, String[] categories) {
        this.questions = questions;
        this.categories = categories;
        this.scores = new int[categories.length];
    }


    public void takeQuiz() {
        Scanner user = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            String[] questionCategories = question.getCategories();

            int optionNum = 1;
            for (int i = 0; i < options.length; i++) {
                System.out.println(optionNum + " " + options[i]);
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

        recommendCareer();
    }
    
    public static void main(String[] args) {
        String[] categories = {"STEM", "Art", "Technical", "Business", "Medical", "Law", "Social Studies"};
        Question[] questions = new Question[999];

//these three lines right here are one question each one should follow this format
        String[] q1options = {"Math", "Drawing", "Building things", "Making money", "Treating injury", "Law", "Social"};
        String[] q1categories = {"STEM", "Art", "Technical", "Business", "Medical", "Law", "Social Studies"};
        questions[0] = new Question("Which of these activities do you enjoy the most in school?", q1options, q1categories);
////////////////////
        
        
        
        
        
        
        CareerQuiz quiz = new CareerQuiz(questions, categories);
        quiz.takeQuiz();
    }

    private void recommendCareer() {
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
            else if(recommendedCategory.equals("")) {
                //keep doing this for each category
            }
        }
        else {
            //give a broad list of all careers since they got the same score in all

        }
    }

}
//this whole thing works only for the broad questions where each answer is a diff category
//might have to write another class for specific questions and then write methods for those specific questions
//but this format should work for questions like "which of the following subjects most interest you"


remove this 
*/



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
