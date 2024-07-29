public class WebSite {

    //Realistically, we're probably going to have to create subclasses. Not now, but maybe in the near future.
    private static String[] tips;   //Random fun tips or messages given to the user.

    public WebSite() {
        implementRandTips();
        System.out.println("Tip of the day: " + randMsg());
    }

    //Precondition: tips.length > 0
    private static String randMsg() {
        int rIndex = (int) (Math.random() * tips.length);   //Random index.
        return tips[rIndex];
    }

    private static void implementRandTips() {
        tips = new String[5];
        tips[0] = "You can choose mundane things you’ve done to put in your college application; if you spice it up with the right words, it’ll work.";
        tips[1] = "Keep digging, you’ll reach gold eventually.";
        tips[2] = "If it works, it works.";
        tips[3] = "Some call it an addiction, I call it dedication.";
        tips[4] = "Do not take this website as gospel.";
    }
    










}
