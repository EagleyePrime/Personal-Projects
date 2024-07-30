//Jaden's Class

public class Question {
    private String questionText;
    private String[] options;
    private String[] categories;
    private float numericalAnswer;
    private boolean isNumerical;
    private boolean isConfirmed; //True means the user confirmed their answer.

    public Question(String questionText, String[] options, String[] categories) {
        this.questionText = questionText;
        this.options = options;
        this.categories = categories;
    }

    public Question(String questionText, float num) {
        this.questionText = questionText;
        numericalAnswer = num;
        isNumerical = true;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public String[] getCategories() {
        return categories;
    }

    public float getNumber() {
        return numericalAnswer;
    }

    public boolean isCustomAnswer(){
        return isNumerical;
    }

    public boolean checkConfirmation() {
        return isConfirmed;
    }
}
