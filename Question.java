public class Question {
    private String questionText;
    private String[] options;
    private String[] categories;
    private boolean isConfirmed; //True means the user confirmed their answer.

    public Question(String questionText, String[] options, String[] categories) {
        this.questionText = questionText;
        this.options = options;
        this.categories = categories;

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

    public boolean checkConfirmation() {
        return isConfirmed;
    }
}