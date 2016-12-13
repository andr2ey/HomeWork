package javase01.t06;

import java.util.Formatter;


/**
 * The Notepad allow to add, edit and delete notes by number and
 * display all notes in console. This class implements a growable
 * array of notes.
 *
 */
public class Notepad {

    private Note[] notes;

    /**
     * Shows current unfilled place in notes. {@code (carriage - 1)}
     * is filled by Note if {@code (carriage != 0)} .
     */
    private int carriage = 0;

    /**
     * Constructs an notepad with array as storage.
     */
    public Notepad() {
        notes = new Note[10];
    }

    /**
     * Appends the text to the end of the notes.
     *
     * If notes are filled then widens notes. After that shifts carriage.
     *
     * @param text text to be appended to the notes
     */
    public void addNote(String text) {
        if (carriage == notes.length) {
            newNotesStorage();
        }
        Note newNote = new Note(text, carriage + 1);
        notes[carriage] = newNote;
        carriage++;
    }

    /**
     * Deletes text with number from notes.
     *
     * @param number number of text to be deleted from the notes
     */
    public void deleteNote(int number) {
        if (number < 1 || number > carriage) {
            return;
        }
        reorganizeNotes(number - 1);
        carriage = carriage == 0 ? carriage : --carriage;
    }

    /**
     * Inserts text at the determined by number position in notes.
     *
     * @param text text for exchange
     * @param number number of editable note
     */
    public void editNote(int number, String text) {
        if (number < 1 || number > carriage) {
            return;
        }
        notes[number - 1] = new Note(text, number);
    }

    /**
     * Displays to console all notes.
     */
    public void watchNotes() {
        Formatter f = new Formatter(System.out);
        for (int i = 0; i < carriage; i++) {
            f.format("%d# %s\n", notes[i].getNumber(), notes[i].getText());
        }
        f.format("\n");
    }

    /**
     * Starting from number shifts all notes in the left on one position.
     *
     * @param number number of deleted position
     */
    private void reorganizeNotes(int number) {
        for (int i = number + 1; i < carriage; i++) {
            notes[i - 1] = notes[i];
            notes[i - 1].setNumber(i);
        }
    }

    /**
     * Widens notes in one and half.
     */
    private void newNotesStorage() {
        Note[] tmp = notes;
        notes = new Note[(int)(tmp.length*1.5)];
        System.arraycopy(tmp, 0, notes, 0, tmp.length);
    }

    public static void main(String[] args) {
        Notepad notepad = new Notepad();

        System.out.println("ADD 3 notes");
        notepad.addNote("note 1");
        notepad.addNote("note 2");
        notepad.addNote("note 3");
        notepad.watchNotes();

        System.out.println("DELETE 2#");
        notepad.deleteNote(2);
        notepad.watchNotes();

        System.out.println("EDIT 2#");
        notepad.editNote(2, "note 2");
        notepad.watchNotes();

        System.out.println("ADD until 12 notes");
        notepad.addNote("note 3");
        notepad.addNote("note 4");
        notepad.addNote("note 5");
        notepad.addNote("note 6");
        notepad.addNote("note 7");
        notepad.addNote("note 8");
        notepad.addNote("note 9");
        notepad.addNote("note 10");
        notepad.addNote("note 11");
        notepad.addNote("note 12");
        notepad.watchNotes();

        System.out.println("EDIT -1#");
        notepad.editNote(-1, "note -1");
        notepad.watchNotes();

        System.out.println("EDIT 13#");
        notepad.editNote(13, "note 13");
        notepad.watchNotes();

        System.out.println("DELETE -1#");
        notepad.deleteNote(-1);
        notepad.watchNotes();

        System.out.println("DELETE 13#");
        notepad.deleteNote(13);
        notepad.watchNotes();

        System.out.println("DELETE 1# 13 times#");
        for (int i = 0; i < 13; i++) {
            notepad.deleteNote(1);
        }
        notepad.watchNotes();

        System.out.println("ADD 1 note");
        notepad.addNote("note 1");
        notepad.watchNotes();


    }
}
