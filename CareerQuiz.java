import java.util.Scanner;

public class CareerQuiz {
    private Question[] questions;
    private static Question[] specQuestions;   //List of special questions.
    private static String[] categories;
    private static String[] specCategories;    //List of special categories.
    private static int[] scores;
    private static int[] specScores;

    private static String[] finalChoices;   //Used solely for displaying the plan path.
    private static String[] idealFields;
    private static boolean readyForCollege;



    public CareerQuiz(Question[] questions, String[] categories) {
        this.questions = questions;
        this.categories = categories;
        scores = new int[categories.length];
    }



    public static void main(String[] args) {

        //Quiz set up.
        String[] defaultCategories = {"STEM", "Art", "Technical", "Business", "Medical", "Law", "Social Studies"};
        Question[] questions = new Question[5]; //the length of this has to be the # of questions

//these three lines right here are one question each one should follow this format
        //Q1
        String[] q1Options = {"Math", "Drawing", "Building things", "Making money", "Treating injury", "Law", "Social"};
        questions[0] = new Question("Which of these activities do you enjoy the most in school?", q1Options, defaultCategories);
////////////////////
        //Q2
        String[] q2Options = {"Math", "Art", "Technical stuff (welding, woodworking, etc)", "Persuading others",
                "Helping others", "Reading and analyzing documents and/or literature", "History"};
        questions[1] = new Question("Which of the following do you excel in?", q2Options, defaultCategories);
////////////////////
        //Q3
        String[] q3Options = {"Help create an Iron Man suit", "Chisel a giant statue", "Help fix a vehicle",
                "Close a multi-million dollar deal", "Cure patients of cancer", "Solve a huge criminal case",
                "Help restore a historical site"};
        questions[2] = new Question("Which of the following projects would you most likely partake in?", q3Options, defaultCategories);
////////////////////
        //Q4
        String[] q4Options = {"Inside a classroom", "Inside a studio", "Outside at a construction site", "Inside an office",
                "Inside a hospital", "Inside a law firm", "At a significantly historical site"};
        questions[3] = new Question("Which environment most suits you?", q4Options, defaultCategories);
////////////////////
        //Q5
        float userGPA = 0;     //User will answer with this.
        questions[4] = new Question("What's your weighted GPA (decimal points are allowed; 4.0 scale)?", userGPA);
        readyForCollege = isReadyForCollege(questions[4]);
        if (readyForCollege) {
            System.out.println("You are ready for college level work"); //testing
        }

//////////////////////////////////////////////////
        CareerQuiz firstHalf = new CareerQuiz(questions, defaultCategories);
        firstHalf.takeQuiz();
        recommendField();
//////////////////////////////////////////////////
        Scanner user = new Scanner(System.in);
        System.out.println("Please enter the exact characters as displayed in the quotation marks for further questions.");
        String userChoice = user.nextLine();
        setSpecialQ(userChoice);

        CareerQuiz secondHalf = new CareerQuiz(specQuestions, specCategories);
        secondHalf.takeQuiz();
        recommendCareer();

        recommendPlan();
    }


    public void takeQuiz() {
        Scanner user = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());

            if (question.isCustomAnswer()) {
                float gpa = user.nextFloat();
                System.out.println("GPA entered.");
            }
            else {
                String[] options = question.getOptions();
                String[] questionCategories = question.getCategories();

                //Displays answers for question.
                int optionNum = 1;
                for (int i = 0; i < options.length; i++) {
                    System.out.println(optionNum + ". " + options[i]);
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
                } else {
                    System.out.println("Invalid answer");
                }
            }

        }
    }

    //Can recommend more than one field if the scores are equal.
    private static void recommendField() {

        //returns the highest categories if multiple share the highest score; if not returns highest
        String[] highestCategories = new String[7];
        int maxScore = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }
        int highestFound = 0;
        for (int i = 0; i < scores.length && highestFound < 7; i++) {
            if (scores[i] == maxScore) {
                highestCategories[highestFound] = categories[i];
                highestFound++;
            }
        }
        for (int i = 0; i < highestFound; i++) {
            System.out.println("A recommended category for you is " + highestCategories[i]);
            switch (highestCategories[i]) {
                case "STEM" -> System.out.println("Info about STEM");
                case "Art" -> System.out.println("Info about Art");
                case "Technical" -> System.out.println("Info about technical careers");
                case "Business" -> System.out.println("Info about business");
                case "Medical" -> System.out.println("Info about med careers");
                case "Law" -> System.out.println("Info about law careers");
                case "Social Studies" -> System.out.println("Info about social studies");
            }
        }


    }

    private static void recommendCareer() {
        String[] highestCareers = new String[4]; //4 possible careers within each category
        int maxScore = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }
        int highestFound = 0;
        for (int i = 0; i < scores.length && highestFound < 7; i++) {
            if (scores[i] == maxScore) {
                highestCareers[highestFound] = categories[i];
                highestFound++;
            }
        }
        finalChoices = new String[4];
        for(int i = 0; i < highestFound; i++) {
            System.out.println("A recommended career for you is " + highestCareers[i]);
            switch (highestCareers[i]) {
                //STEM careers
                case "Science" -> finalChoices[i] = "Research scientist"; //Science related
                case "Technology" -> finalChoices[i] = "Software developer"; //Technology related
                case "Engineering" -> finalChoices[i] = "Engineer"; //Engineering related
                case "Math" -> finalChoices[i] = "Data scientist";
                //Art careers
                case "Art" -> finalChoices[i] = "Painter"; //Traditional art (drawing, painting, sculpting)
                case "Digital" -> finalChoices[i] = "Graphic designer"; //Digital art related
                case "Animation" -> finalChoices[i] = "Pixar Animator"; //Animation related
                case "Literature" -> finalChoices[i] = "Writer"; //Literature related
                //Trade careers
                case "Application" -> finalChoices[i] = "Electrician"; //Useful application related
                case "Technological" -> finalChoices[i] = "Technician";    //Something that uses technology in their job, but not as advanced as engineer
                case "Helpful" -> finalChoices[i] = "Carpenter";    //Helpfulness or some job that benefits the community
                case "Labor" -> finalChoices[i] = "Construction Worker";    //Hard labor related
                //Business careers
                case "Communication" -> finalChoices[i] = "Human resources manager";    //Communication related
                case "Finance" -> finalChoices[i] = "Finance Analyst";    //Finance related
                case "Advertisement" -> finalChoices[i] = "Marketing manager";    //Advertisement related
                case "Leadership" -> finalChoices[i] = "Operations manager";    //Leadership related
                //Medical Careers
                case "Lifesaver" -> finalChoices[i] = "Emergency Medical Technician (First responder)";    //Lifesaver
                case "Pharmaceutical" -> finalChoices[i] = "Pharmacist";    //Pharmaceutical related
                case "Precision" -> finalChoices[i] = "Doctor/surgeon";    //Needs precision to perform their job
                case "Cool" -> finalChoices[i] = "Nurse";    //Job that requires coolness under pressure
                //Law careers
                case "Judgemental" -> finalChoices[i] = "Judge";    //Judgemental related
                case "Defense" -> finalChoices[i] = "Lawyer";    //Enjoys defending people
                case "Ethical" -> finalChoices[i] = "Legal Consultant";  //Enjoys talking
                case "Enforcement" -> finalChoices[i] = "Police officer";    //Enforcer of rules
                //Social Studies Careers
                case "Analytical" -> finalChoices[i] = "Sociologist"; //Studies human behavior
                case "Historical" -> finalChoices[i] = "Historian";   //Likes history stuff
                case "Studious" -> finalChoices[i] = "Anthropologist"; //studies human culture past old stuff
                case "Earth" -> finalChoices[i] = "Geographer";  //Enjoys Earth's natural features; watches national geographic

                case "my glorious king" -> System.out.println("Alan 'Mander' Kraut");

            }
        }

        if (finalChoices.length > 1) {
            System.out.println("The careers recommended for you are:");
            for (int i = 0; i < finalChoices.length; i++) {
                System.out.println((i + 1) + ". " + finalChoices[i]);
            }
        }
        else {
            System.out.println("The career recommended for you is:\n1. " + finalChoices[0]);
        }
    }

    //Not finished. Should be placed in a loop so the user can see all available paths.
    private static void recommendPlan() {
        System.out.println("Based on how you took the quiz, this is the plan you should have: ");
        if (readyForCollege) {
            System.out.println("1. Graduate high school with a GPA of at least a weighted 3.0.");
            switch(idealFields[0]){ //idealFields should also be used in a loop
                case "STEM" -> {
                    System.out.println("2. Find and attend a college/university.");
                    System.out.println("3. Look out for and obtain a scholarship/grant.");
                    System.out.println("4. Obtain an internship and/or a job relating to your major.");
                }
                case "Art" -> {
                    System.out.println("2. Find and attend an art school.");
                    System.out.println("3. Look out for and obtain a scholarship/grant.");
                    System.out.println("4. Obtain an internship and/or a job at a studio.");
                }
                case "Technology" -> {
                    System.out.println("2. Find and attend a trade school.");
                    System.out.println("3. Look out for and obtain a scholarship/grant.");
                    System.out.println("4. Obtain and internship and/or a job anywhere that is hiring skilled labor.");
                }
                case "Business" -> {
                    System.out.println("2. Find and attend a business school.");
                    System.out.println("3. Look out for and obtain a scholarship/grant.");
                    System.out.println("4. Obtain and internship and/or a job at a business. Preferably a leadership role.");
                }
                case "Medical" -> {
                    System.out.println("2. Find and attend a medical school.");
                    System.out.println("3. Look out for and obtain a scholarship/grant.");
                    System.out.println("4. Obtain an internship and/or a job at a hospital.");
                }
                case "Law" -> {
                    System.out.println("2. Find and attend a law school.");
                    System.out.println("3. Look out for and obtain a scholarship/grant.");
                    System.out.println("4. Obtain and internship and/or a job at a law firm.");
                }
                case "Social Studies" -> {
                    System.out.println("2. Find and attend a college/university.");
                    System.out.println("3. Look out for and obtain a scholarship/grant.");
                    System.out.println("4. Obtain and internship and/or a job relating to your major.");
                }

            }

        }
        else {
            switch(idealFields[0]) {
                case "STEM" -> {
                    System.out.println("2. Find and attend a community college.");
                    System.out.println("3. Look out for and obtain a scholarship/grant.");
                    System.out.println("4. Obtain an internship and/or a job relating to your major.");
                }
                case "Art" -> {
                    System.out.println("2. Find and attend an art school.");
                    System.out.println("3. Look out for and obtain a scholarship/grant.");
                    System.out.println("4. Obtain an internship and/or a job at a studio.");
                }
                case "Technology" -> {
                    System.out.println("2. Find and attend a trade school.");
                    System.out.println("3. Look out for and obtain a scholarship/grant.");
                    System.out.println("4. Obtain and internship and/or a job anywhere that is hiring skilled labor.");
                }
                case "Business" -> {
                    System.out.println("2. Find and attend a business school.");
                    System.out.println("3. Look out for and obtain a scholarship/grant.");
                    System.out.println("4. Obtain and internship and/or a job at a business. Preferably a leadership role.");
                }
                case "Medical" -> {
                    System.out.println("2. Find and attend a medical school.");
                    System.out.println("3. Look out for and obtain a scholarship/grant.");
                    System.out.println("4. Obtain an internship and/or a job at a hospital.");
                }
                case "Law" -> {
                    System.out.println("2. Find and attend a law school.");
                    System.out.println("3. Look out for and obtain a scholarship/grant.");
                    System.out.println("4. Obtain and internship and/or a job at a law firm.");
                }
                case "Social Studies" -> {
                    System.out.println("2. Find and attend a college/university.");
                    System.out.println("3. Look out for and obtain a scholarship/grant.");
                    System.out.println("4. Obtain and internship and/or a job relating to your major.");
                }
            }
        }
    }

    //Based on the results of the basic questions, this method will pick and show the specialized questions.
    //The recommendedCareers array is the array that stores the fields of study that the user received.
    private static void setSpecialQ(String specializedCategory) {
        if (specializedCategory.equals("STEM")) {
            specQuestions = getSTEMQ();
        }
        else if (specializedCategory.equals("Art")) {
            specQuestions = getArtQ();
        }
        else if (specializedCategory.equals("Technical")) {
            specQuestions = getTechQ();
        }
        else if (specializedCategory.equals("Business")) {
            specQuestions = getBusQ();
        }
        else if (specializedCategory.equals("Medical")) {
            specQuestions = getMedQ();
        }
        else if (specializedCategory.equals("Law")) {
            specQuestions = getLawQ();
        }
        else if (specializedCategory.equals("Social Studies")) {
            specQuestions = getSocStudQ();
        }
    }

    private static Question[] getSTEMQ() {
        Question[] stemQ = new Question[1];
        //Enjoys scientific advancement and labs, creating technology, designing and creating, and applying math skills.
        String[] stem = {"Science", "Technology", "Engineering", "Math"};
        specCategories = stem;

        //Q1
        String[] q1Options = {"I like lab experiments", "I like working with computers",
                "I like designing and making things", "I like solving equations"};
        stemQ[0] = new Question("Which of these closely represent you?",q1Options, specCategories);

        return stemQ;
    }

    private static Question[] getArtQ() {
        Question[] artQ = new Question[1];
        //Enjoys traditional art (drawing, painting, sculpting, etc.), digital art, animation/film, and poetry/writing.
        String[] art = {"Art", "Digital", "Animation", "Literature"};
        specCategories = art;

        //Q1
        String[] q1Options = {"I like drawing or painting", "I like drawing digitally",
                "I like making flip-books", "I like coming up with stories"};
        artQ[0] = new Question("Which of these closely represent you?", q1Options, specCategories);

        return artQ;
    }

    private static Question[] getTechQ() {
        Question[] techQ = new Question[1];
        //Enjoys applying knowledge, tool/technology use, impacting the community, and intensive labor.
        String[] tech = {"Application", "Technological", "Helpful", "Labor"};
        specCategories = tech;

        //Q1
        String[] q1Options = {"I like applying my knowledge to real life", "I like using technology to aid me",
                "I like to help others in my community", "I like to perform menial, but rewarding, tasks"};
        techQ[0] = new Question("Which of these closely represent you?", q1Options, specCategories);


        return techQ;
    }

    private static Question[] getBusQ() {
        Question[] busQ = new Question[1];
        //Enjoys communicating/networking with clients, dealing with money, selling products, and managing a business/people.
        String[] bus = {"Communication", "Finance", "Advertisement", "Leadership"};
        specCategories = bus;
        //Q1
        String[] q1Options = {"I would like to form a community", "I want to be rich",
                "I am good at persuading others", "I like to manage people"};
        busQ[0] = new Question("Which of these closely represent you?", q1Options, specCategories);


        return busQ;
    }

    private static Question[] getMedQ() {
        Question[] medQ = new Question[1];
        //Enjoys saving lives, advancing medicine, performing surgery, and able to handle extreme situations.
        String[] med = {"Lifesaver", "Pharmaceutical", "Precision", "Cool"};
        specCategories = med;
        //Q1
        String[] q1Options = {"I would aid a disabled person", "I want to innovate in medicine",
                "I am okay with performing life saving surgery", ""};


        return medQ;
    }

    private static Question[] getLawQ() {
        Question[] lawQ = new Question[1];
        String[] law = {"Judgemental", "Defense", "Ethical", "Enforcement"};
        specCategories = law;
        //Q1
        String[] q1Options = {""};

        return lawQ;
    }

    private static Question[] getSocStudQ() {
        Question[] socStudQ = new Question[1];
        String[] socStud = {"Analytical", "Historical", "Studious", "Earth"};
        specCategories = socStud;
        //Q1
        String[] q1Options = {""};

        return socStudQ;
    }

    //If true, college can be included in the career plan.
    private static boolean isReadyForCollege(Question q) {
        float num = q.getNumber();
        //Weighted GPA
        return num >= 3.0 && num <= 5.0;  //We need both conditions.
    }
}