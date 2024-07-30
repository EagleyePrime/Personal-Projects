public class Website {

    //Realistically, we're probably going to have to create subclasses. Not now, but maybe in the near future.

    public Website() {
        System.out.println("Tip of the day: " + randomTip());
        System.out.println("You felt lucky today, here's the career path you should go down: " + randomCareer());
    }

    private static String randomTip() {
        int length = 5;
        String[] tips = new String[length];
        tips[0] = "You can choose mundane things you’ve done to put in your college application; if you spice it up with the right words, it’ll work.";
        tips[1] = "Keep digging, you’ll reach gold eventually.";
        tips[2] = "If it works, it works.";
        tips[3] = "Some call it an addiction, I call it dedication.";
        tips[4] = "Do not take this website as gospel.";
        int index = findRandIndex(length);
        return tips[index];
    }

    private static String randomCareer(){
        int length = 7;
        String[] careers = new String[length];
        careers[0] = "STEM";
        careers[1] = "Art";
        careers[2] = "Technical";
        careers[3] = "Business";
        careers[4] = "Medical";
        careers[5] = "Law";
        careers[6] = "Social Studies";
        int num = findRandIndex(length);
        return careers[num];
    }

    private static void revealResourceList() {
        System.out.println("Here you will find a list of helpful links below.\n");

        System.out.println("College websites:\n"
                + "University of California (UC): https://www.universityofcalifornia.edu/\n"
                + "California State University (CSU): https://www.calstate.edu/\n"
                + "California Community Colleges (CCC): https://www.cccco.edu/\n"
                + "California Adult Education (CAE): https://caladulted.org/\n");
    }

    //For finding random indices in an array.
    private static int findRandIndex(int arrayLength) {
        return (int) (Math.random() * arrayLength);
    }

    //For finding a random number.
    private static int findRandNum(int max, int min) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }











}