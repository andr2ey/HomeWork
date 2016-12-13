package javase01.t06;

/**
 * Note which keeps text with corresponding number.
 */
class Note {

    private String text;

    private int number;

    Note(String text, int number) {
        this.text = text;
        this.number = number;
    }

    String getText() {
        return text;
    }

    int getNumber() {
        return number;
    }

    void setNumber(int number) {
        this.number = number;
    }

}
