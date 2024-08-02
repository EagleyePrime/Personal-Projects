import java.util.Scanner;

public class CareerQuiz {
    private Question[] questions;
    private static Question[] specQuestions;   //List of special questions.
    private static String[] categories;
    private static String[] specCategories;    //List of special categories.
    private static int[] scores;

    private static String[] finalChoices;   //Used solely for displaying the plan path.
    private static String[] idealFields;
    private static boolean readyForCollege;
    private static float gpa;

    private static String userChoice;

    public CareerQuiz(Question[] questions, String[] categories) {
        this.questions = questions;
        this.categories = categories;
        scores = new int[categories.length];
    }

    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        //Quiz set up.
        String[] defaultCategories = {"STEM", "Art", "Technical", "Business", "Medical", "Law", "Social Studies"};
        Question[] questions = new Question[5]; //the length of this has to be the # of questions

//these three lines right here are one question each one should follow this format
        //Q1
        String[] q1Options = {"Math", "Drawing", "Construction", "Dealing with Money", "Aid", "Law", "Social"};
        questions[0] = new Question("Which of these subjects do you enjoy the most?", q1Options, defaultCategories);
////////////////////
        //Q2
        String[] q2Options = {"Math", "Art", "Technical stuff (welding, woodworking, etc)", "Persuading others",
                "Helping others", "Reading and analyzing documents and/or literature", "History"};
        questions[1] = new Question("Which of the following do you excel in?", q2Options, defaultCategories);
////////////////////
        //Q3
        String[] q3Options = {"Code something", "Chisel a giant statue", "Help fix a vehicle",
                "Close a multi-million dollar deal", "Cure patients of cancer", "Solve a huge criminal case",
                "Help restore a historical site"};
        questions[2] = new Question("Which of the following projects would you want to partake in?", q3Options, defaultCategories);
////////////////////
        //Q4
        String[] q4Options = {"Inside a workshop/lab", "Inside a studio", "Outside at a construction site", "Inside an office",
                "Inside a hospital", "Inside a law firm", "At a significantly historical site"};
        questions[3] = new Question("Which environment most suits you?", q4Options, defaultCategories);
////////////////////
        //Q5
        String[] q5Options = {"Critical thinking", "Creativity", "Physical tasks", "Helpfulness", "Morals", "Historical Knowledge"};
        questions[4] = new Question("Which of the following categories are you the strongest in?", q5Options, defaultCategories);

//////////////////////////////////////////////////
        CareerQuiz firstHalf = new CareerQuiz(questions, defaultCategories);
        firstHalf.takeQuiz();
        recommendField();
/////////////////////////////////////////////////
        System.out.println("Which category would you like to go in depth on? Please type the exact characters of the career field as shown.");
        userChoice = user.nextLine();
        setSpecialQ(userChoice);

        CareerQuiz secondHalf = new CareerQuiz(specQuestions, specCategories);
        secondHalf.takeQuiz();
        recommendCareer();

        System.out.println("Enter your GPA (grade point average) (decimal points allowed) (up to 5.0) (above 0.0)");
        gpa = user.nextFloat();

        recommendPlan();
    }

    public void takeQuiz() {
        Scanner user = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());

            if (question.isCustomAnswer()) {
                float gpa = user.nextFloat();
                System.out.println("GPA entered.");
            } else {
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
            System.out.println("A recommended category for you is '" + highestCategories[i] + "'");
            System.out.println("Here is a brief overview of the " + highestCategories[i] + " field:");
            switch (highestCategories[i]) {
                case "STEM" -> System.out.println("STEM careers encompass a wide range of professions in science, technology, engineering, and math. These careers involve solving complex problems, conducting research, and innovation.");
                case "Art" -> System.out.println("Art is a field for those with a passion for creativity. From 2D pencil art, to entire 3D animated films, there is limitless possibility on what you can accomplish.");
                case "Technical" -> System.out.println("Technical/trade careers are hands-on professions that require specialized skills and training. These careers often involve working with tools, machinery, and technology to build, repair, or maintain different structures and systems.");
                case "Business" -> System.out.println("Business is a competitive field that requires people skills and lots of connections. This is for those who are motivated by money and making long lasting friendships.");
                case "Medical" -> System.out.println("Medical careers are tough, but incredibly rewarding. Everything you do in this field can affect another person's life for the better. There are countless opportunities ranging from first responder emergency medical technicians, all the way to brain surgeons.");
                case "Law" -> System.out.println("Law careers include a wide range of professions, all of which are dedicated to upholding justice, interpreting laws, and representing clients in legal matters.");
                case "Social Studies" -> System.out.println("Social studies careers involve developing an understanding of human society, behavior, and interactions.");
            }
        }

    }

    /*
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
        for(int i = 0; i < highestFound; i++) {
            System.out.print("A recommended career for you is ");
            switch (highestCareers[i]) { //write plan in the print statements?
                //STEM careers
                case "Science" -> System.out.println("Research scientist"); //Science related
                case "Technology" -> System.out.println("Software developer"); //Technology related
                case "Engineering" -> System.out.println("Engineer"); //Engineering related
                case "Math" -> System.out.println("Data scientist");
                //Art careers
                case "Art" -> System.out.println("Painter"); //Traditional art (drawing, painting, sculpting)
                case "Digital" -> System.out.println("Graphic designer"); //Digital art related
                case "Animation" -> System.out.println("Pixar Animator"); //Animation related
                case "Literature" -> System.out.println("Writer"); //Literature related
                //Trade careers
                case "Application" -> System.out.println("Electrician"); //Useful application related
                case "Technological" -> System.out.println("Technician");    //Something that uses technology in their job, but not as advanced as engineer
                case "Helpful" -> System.out.println("Carpenter");    //Helpfulness or some job that benefits the community
                case "Labor" -> System.out.println("Construction Worker");    //Hard labor related
                //Business careers
                case "Communication" -> System.out.println("Human resources manager");    //Communication related
                case "Finance" -> System.out.println("Finance Analyst");    //Finance related
                case "Advertisement" -> System.out.println("Marketing manager");    //Advertisement related
                case "Leadership" -> System.out.println("Operations manager");    //Leadership related
                //Medical Careers
                case "Lifesaver" -> System.out.println("Emergency Medical Technician (First responder)");    //Lifesaver
                case "Pharmaceutical" -> System.out.println("Pharmacist");    //Pharmaceutical related
                case "Precision" -> System.out.println("Doctor/surgeon");    //Needs precision to perform their job
                case "Cool" -> System.out.println("Nurse");    //Job that requires coolness under pressure
                //Law careers
                case "Judgemental" -> System.out.println("Judge");    //Judgemental related
                case "Defense" -> System.out.println("Lawyer");    //Enjoys defending people
                case "Ethical" -> System.out.println("Legal Consultant");  //Enjoys talking
                case "Enforcement" -> System.out.println("Police officer");    //Enforcer of rules
                //Social Studies Careers
                case "Analytical" -> System.out.println("Sociologist"); //Studies human behavior
                case "Historical" -> System.out.println("Historian");   //Likes history stuff
                case "Studious" -> System.out.println("Anthropologist"); //studies human culture past old stuff
                case "Earth" -> System.out.println("Geographer");  //Enjoys Earth's natural features;

            }
        }
    }
    */

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
            switch (highestCareers[i]) {
                //STEM careers
                case "Science" -> finalChoices[i] = "Research scientist"; //Science related
                case "Technology" -> finalChoices[i] = "Software developer"; //Technology related
                case "Engineering" -> finalChoices[i] = "Engineer"; //Engineering related
                case "Math" -> finalChoices[i] = "Data scientist";      //Crunching numbers
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
                case "Ethical" -> finalChoices[i] = "Legal Consultant";  //Discusses laws
                case "Enforcement" -> finalChoices[i] = "Police officer";    //Enforcer of rules
                //Social Studies Careers
                case "Analytical" -> finalChoices[i] = "Sociologist"; //Studies human behavior
                case "Historical" -> finalChoices[i] = "Historian";   //Likes history stuff
                case "Studious" -> finalChoices[i] = "Anthropologist"; //studies human culture/past
                case "Earth" -> finalChoices[i] = "Geographer";  //Enjoys Earth's natural features;
            }
        }

        int count = 0;
        for(String s : finalChoices){
            if(s != null) {
                count++;
            }
        }

        if (count > 1) {
            System.out.println("The careers recommended for you are:");
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + finalChoices[i]);
            }
        }
        else {
            System.out.println("The career recommended for you is:\n1. " + finalChoices[0]);
        }
    }

    private static void recommendPlan() {
        System.out.println("Based on how you took the quiz, this is the plan you should have: ");
        if (isReadyForCollege(gpa)) {
            System.out.println("1. Graduate high school with a GPA of at least a weighted 3.0.");
            switch(userChoice){
                case "STEM" -> {
                    System.out.println("2. Find and attend a college/university, ideally majoring in the career or as closely as possible.");
                    System.out.println("3. Look out for and obtain a scholarship/grant(s).");
                    System.out.println("4. Obtain an internship and/or a job relating to your major.");
                    //wait lemme run it just to make sure oops
                }
                case "Art" -> {
                    System.out.println("2. Find and attend an art school.");
                    System.out.println("3. Look out for and obtain a scholarship/grant.");
                    System.out.println("4. Obtain an internship and/or a job at a studio.");
                    System.out.println("5. Drop a masterpiece.");
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
            System.out.println("1. Graduate high school with a GPA of at least a weighted 2.0.");
            switch(userChoice) {
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
        Question[] stemQ = new Question[3];
        //Enjoys scientific advancement and labs, creating technology, designing and creating, and applying math skills.
        String[] stem = {"Science", "Technology", "Engineering", "Math"};
        specCategories = stem;

        //Q1
        String[] q1Options = {"I like lab experiments", "I like working with computers",
                "I like designing and making things", "I like solving equations"};
        stemQ[0] = new Question("Which of these closely represent you?",q1Options, specCategories);

        //Q2
        String[] q2Options = {"I am interested in the study of biology and chemistry", "Working with computers and coding interests me",
                "Im interested in the design and making of physical systems and structures, like buildings, cars, etc...",
                "I am interested in the theoretical side of things and enjoy doing mathematics"};
        stemQ[1] = new Question("Which of these interest you the most?", q2Options, specCategories);

        //Q3
        String[] q3Options = {"Conducting experiments to see how plants grow", "Building an app",
                "Creating a blueprint for a bridge", "Solving complicated puzzles using logic"};
        stemQ[2] = new Question("Which activity would you enjoy the most?", q3Options, specCategories);

        return stemQ;
    }

    private static Question[] getArtQ() {
        Question[] artQ = new Question[3];
        //Enjoys traditional art (drawing, painting, sculpting, etc.), digital art, animation/film, and poetry/writing.
        String[] art = {"Art", "Digital", "Animation", "Literature"};
        specCategories = art;

        //Q1
        String[] q1Options = {"I like drawing or painting", "I like drawing digitally",
                "I like making flip-books", "I like coming up with stories"};
        artQ[0] = new Question("Which of these closely represent you?", q1Options, specCategories);

        //Q2
        String[] q2Options = {"Painting a landscape using oil paints on canvas", "Designing a website interface",
                "Bringing a character to life in a 2d or 3d animated video", "Writing a captivating novel"};
        artQ[1] = new Question("Which project would you be most excited to work on?", q2Options, specCategories);

        //Q3
        String[] q3Options = {"Sculpting a figure from clay", "Creating a digital art piece to share",
                "Developing an animated TV series with characters and a story",
                "Composing a poem or writing an essay about a topic you are passionate about"};
        artQ[2] = new Question("How would you like to express your creative side?", q3Options, specCategories);

        return artQ;
    }

    private static Question[] getTechQ() {
        Question[] techQ = new Question[3];
        //Enjoys applying knowledge, tool/technology use, impacting the community, and intensive labor.
        String[] tech = {"Application", "Technological", "Helpful", "Labor"};
        specCategories = tech;

        //Q1
        String[] q1Options = {"I like applying my knowledge to real life", "I like using technology to aid others",
                "I like to help others in my community", "I like to perform menial, but rewarding, tasks"};
        techQ[0] = new Question("Which of these closely represent you?", q1Options, specCategories);

        //Q2
        String[] q2Options = {"Installing electrical equipment/appliances", "Troubleshooting and repairing equipment",
                "Assisting in setting up a new home", "Building a home"};
        techQ[1] = new Question("Which type of project would you enjoy working on the most?", q2Options, specCategories);

        //Q3
        String[] q3Options = {"Installing and monitoring power systems", "Fixing equipment/machinery in a workshop",
                "Helping someone with home repairs/maintenance tasks",
                "Doing manual labor and/or operating heavy machinery to build a structure"};
        techQ[2] = new Question("How would you like to spend your workday?", q3Options, specCategories);
        
        return techQ;
    }

    private static Question[] getBusQ() {
        Question[] busQ = new Question[3];
        //Enjoys communicating/networking with clients, dealing with money, selling products, and managing a business/people.
        String[] bus = {"Communication", "Finance", "Advertisement", "Leadership"};
        specCategories = bus;
        //Q1
        String[] q1Options = {"I would like to form a community", "I want to grow a company's finances",
                "I am good at persuading others", "I like to manage and lead teams"};
        busQ[0] = new Question("Which of these closely represent you?", q1Options, specCategories);

        //Q2
        String[] q2Options = {"Building strong relationships with clients and partners",
                "Managing a company's finances to ensure its growth",
                "Creating advertisements to resonate with an audience and sell a product",
                "Inspiring and directing a team towards business objectives"};
        busQ[1] = new Question("How would you like to make an impact in your career?", q2Options, specCategories);

        //Q3
        String[] q3Options = {"Organizing a conference to share ideas", "creating a budget plan to maximize a business's profitability",
                "Developing a marketing strategy to promote a product", "Mentoring and guiding a team to reach their goals"};
        busQ[2] = new Question("Which of these projects would you rather take on?", q3Options, specCategories);

        return busQ;
    }

    private static Question[] getMedQ() {
        Question[] medQ = new Question[3];
        //Enjoys saving lives, advancing medicine, performing surgery/diagnoses, and helpful
        String[] med = {"Lifesaver", "Pharmaceutical", "Precision", "Supportive"};
        specCategories = med;
        //Q1
        String[] q1Options = {"I would aid a person in an emergency", "I want to innovate in medicine",
                "Diagnosing patients and/or performing surgery", "I want to offer care to patients"};
        medQ[0] = new Question("Which are you most comfortable with?", q1Options, specCategories);

        //Q2
        String[] q2Options = {"Providing immediate life saving care at an emergency scene", "Working with medications",
                "Finding out a patients condition", "Delivering supplies to patients in the hospital/assisting doctors"};
        medQ[1] = new Question("Which type of medical work appeals to you the most?", q2Options, specCategories);
        //Q3
        String[] q3Options = {"Being at the emergency scene", "Ensuring patients have the right medications",
                "Diagnosing patients and/or performing medical procedures", "Monitoring a patients condition and providing care"};
        medQ[2] = new Question("How would you prefer to contribute to patient care?", q3Options, specCategories);

        return medQ;
    }

    private static Question[] getLawQ() {
        Question[] lawQ = new Question[3];
        String[] law = {"Judgemental", "Defense", "Ethical", "Enforcement"};
        specCategories = law;
        //Q1
        String[] q1Options = {"Unbiased decision making", "Defending the innocent",
                "People over profits", "Preventing crime"};
        lawQ[0] = new Question("Which do you prefer doing?", q1Options, specCategories);

        //Q2
        String[] q2Options = {"I can make big decisions", "I am willing to defend someone no matter the cost",
        "I want to help people follow the rules", "I want to keep peace within the community"};
        lawQ[1] = new Question("Which of the following describe you best?", q2Options, specCategories);

        //Q3
        String[] q3Options = {"My decisions will impact how others view me and my organization", "I could potentially be defending a criminal",
        "I want to discuss legal boundaries with people", "I am willing to risk my life to uphold the rules"};
        lawQ[2] = new Question("Which of these are you most comfortable with?", q3Options, specCategories);

        return lawQ;
    }


    private static Question[] getSocStudQ() {
        Question[] socStudQ = new Question[3];
        String[] socStud = {"Analytical", "Historical", "Studious", "Earth"};
        specCategories = socStud;
        //Q1
        String[] q1Options = {"Analyzing human relationships", "Investigating the causes of historical events",
                "Studying the cultural practices of an indigenous community", "Mapping climate change around the world"};
        socStudQ[0] = new Question("Which research project interests you the most?", q1Options, specCategories);
        //Q2
        String[] q2Options = {"Conducting a survey to understand people's opinions on social issues", "Examining ancient artifacts",
                "Traveling to different parts of the world a living with different communities to learn their culture",
                "Determining the effects of human activity on the environment"};
        socStudQ[1] = new Question("Which activity would you enjoy the most?", q2Options, specCategories);
        //Q3
        String[] q3Options = {"Studying social trends", "Writing about a historical event", "Researching cultures around the world",
                "Creating maps to manage natural resources"};
        socStudQ[2] = new Question("Which type of career would you find the most fulfilling?", q3Options, specCategories);
        return socStudQ;
    }

    //If true, college can be included in the career plan.
    private static boolean isReadyForCollege(float num) {
        return num >= 3.0 && num <= 5.0;
    }
}