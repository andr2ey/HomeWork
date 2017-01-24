package javase01.t06;

import java.util.Formatter;


/**
 * The Notepad allow to add, edit and delete notes by number and
 * display all notes in console. This class implements a expandable
 * array of notes.
 */
public class Notepad {

    private Note[] notes;

    /**
     * Shows current unfilled place in notes. {@code (carriage - 1)}
     * is filled by Note if {@code (carriage != 0)} .
     */
    private int carriage = 0;


    public Notepad(int size) {
        notes = new Note[size];
    }

    public Notepad() {
        this(10);
    }

    public int size() {
        return notes.length;
    }

    /**
     * Appends the text to the end of the notes.
     *
     * If notes are filled then widens notes. After that shifts carriage.
     *
     * @param text to be appended to the notes
     * @param number of adding note
     */
    public void add(int number, String text) {
        if (number < 1 || number > carriage)
            return;
        if (carriage == notes.length)
            widenStorage();
        for (int i = carriage; i >= number; i--) {
            notes[i] = notes[i - 1];
            notes[i].setNumber(i + 1);
        }
        edit(number, text);
        carriage++;
    }

    /**
     * Inserts the text to the determined position by number.
     *
     * If notes are filled then widens notes. After that shifts carriage.
     *
     * @param text to be appended to the notes
     */
    public void add(String text) {
        if (carriage == notes.length)
            widenStorage();
        Note newNote = new Note(text, carriage + 1);
        notes[carriage] = newNote;
        carriage++;
    }

    /**
     * Deletes text with number from notes.
     *
     * @param number of text to be deleted from the notepad
     */
    public void delete(int number) {
        if (number < 1 || number > carriage)
            return;
        reorganize(number);
    }

    /**
     * Inserts text at the determined position by number.
     *
     * @param text for exchange
     * @param number of editable note
     */
    public void edit(int number, String text) {
        if (number < 1 || number > carriage)
            return;
        notes[number - 1] = new Note(text, number);
    }

    /**
     * Displays to console all notes.
     */
    public void display() {
        Formatter f = new Formatter(System.out);
        for (int i = 0; i < carriage; i++)
            f.format("%d# %s\n", notes[i].getNumber(), notes[i].getText());
        f.format("\n");
    }

    /**
     * Reduces array's length to current amount of notes.
     */
    public void trimToSize() {
        Note[] tmp = notes;
        notes = new Note[carriage];
        System.arraycopy(tmp, 0, notes, 0, carriage);
    }

    /**
     * Starting from number shifts all notes in the left on one position.
     *
     * @param number of deleted position of note
     */
    private void reorganize(int number) {
        for (int i = number; i < carriage; i++) {
            notes[i - 1] = notes[i];
            notes[i - 1].setNumber(i);
        }
        notes[--carriage] = null;
    }

    /**
     * Widens notes in one and half.
     */
    private void widenStorage() {
        Note[] tmp = notes;
        notes = new Note[(int)(tmp.length*1.5)];
        System.arraycopy(tmp, 0, notes, 0, tmp.length);
    }

    public static void main(String[] args) {
        Notepad notepad = new Notepad();

        System.out.println("ADD 3 notes");
        notepad.add("note 1");
        notepad.add("note 2");
        notepad.add("note 3");
        notepad.display();

        System.out.println("DELETE 2#");
        notepad.delete(2);
        notepad.display();

        System.out.println("EDIT 2#");
        notepad.edit(2, "note 2");
        notepad.display();

        System.out.println("ADD until 12 notes");
        notepad.add("note 3");
        notepad.add("note 4");
        notepad.add("note 5");
        notepad.add("note 6");
        notepad.add("note 7");
        notepad.add("note 8");
        notepad.add("note 9");
        notepad.add("note 10");
        notepad.add("note 11");
        notepad.add("note 12");
        notepad.display();

        System.out.println("EDIT 0#");
        notepad.edit(0, "note -1");
        notepad.display();

        System.out.println("EDIT 13#");
        notepad.edit(13, "note 13");
        notepad.display();

        System.out.println("DELETE 0#");
        notepad.delete(0);
        notepad.display();

        System.out.println("DELETE 13#");
        notepad.delete(13);
        notepad.display();

        System.out.println("DELETE 1# 13 times#");
        for (int i = 0; i < 13; i++) {
            notepad.delete(1);
        }
        notepad.display();

        System.out.println("ADD 5 note");
        notepad.add("note 1");
        notepad.add("note 2");
        notepad.add("note 3");
        notepad.add("note 4");
        notepad.add("note 5");
        notepad.display();

        System.out.println("ADD note to 2#");
        notepad.add(2, "note 2 new");
        notepad.display();

        System.out.println("ADD note to 1#");
        notepad.add(1, "note 1 new");
        notepad.display();

        System.out.println("ADD note to 7#");
        notepad.add(7, "note 7 new");
        notepad.display();

        System.out.println("Verifies trimToSize");
        System.out.println("size before: " + notepad.size());
        notepad.trimToSize();
        System.out.println("size after: " + notepad.size());
    }
}
