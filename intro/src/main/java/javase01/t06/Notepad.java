package javase01.t06;

import java.util.Formatter;


/**
 *
 * */
public class Notepad {

    /**
     *
     * */
    private Note[] notes;

    /**
     *
     * */
    private int index = 0;

    /**
     *
     * */
    public Notepad() {
        notes = new Note[10];
    }

    /**
     *
     * */
    public void addNote(String text) {
        if (index == notes.length - 1) {
            newNotesStorage();
        }
        Note newNote = new Note(text, index);
        notes[index] = newNote;
        index++;
    }

    /**
     *
     * */
    public void deleteNote(int number) {
        if (number < 0 || number > index) {
            return;
        }
        reorganizeNotes(number);
        index = index == 0 ? index : --index;
    }

    /**
     *
     * */
    public void editNote(int number, String text) {
        if (number < 0 || number > index) {
            return;
        }
        notes[number] = new Note(text, number);
    }

    /**
     *
     * */
    public void watchNotes() {
        Formatter f = new Formatter(System.out);
        for (int i = 0; i < index; i++) {
            f.format("%d# %s\n", notes[i].getNumber(), notes[i].getText());
        }
        f.format("\n");
    }

    /**
     *
     * */
    private void reorganizeNotes(int startNumber) {
        for (int i = startNumber + 1; i < index; i++) {
            notes[i - 1] = notes[i];
            notes[i - 1].setNumber(i - 1);
        }
    }

    /**
     *
     * */
    private void newNotesStorage() {
        Note[] tmp = notes;
        notes = new Note[(int)(tmp.length*1.5)];
        System.arraycopy(tmp, 0, notes, 0, tmp.length);
    }

    /**
     *
     * */
    public static void main(String[] args) {
        Notepad notepad = new Notepad();

        notepad.addNote("note 0");
        notepad.addNote("note 1");
        notepad.addNote("note 2");
        notepad.watchNotes();

        System.out.println("DELETE 1#");
        notepad.deleteNote(1);
        notepad.watchNotes();

        System.out.println("EDIT 1#");
        notepad.editNote(1, "note 1");
        notepad.watchNotes();

        notepad.addNote("note 2");
        notepad.addNote("note 3");
        notepad.addNote("note 4");
        notepad.addNote("note 5");
        notepad.addNote("note 6");
        notepad.addNote("note 7");
        notepad.addNote("note 8");
        notepad.addNote("note 9");
        notepad.addNote("note 10");
        notepad.addNote("note 11");
        notepad.watchNotes();

        System.out.println("EDIT -1#");
        notepad.editNote(-1, "note -1");
        notepad.watchNotes();

        System.out.println("EDIT 12#");
        notepad.editNote(12, "note 12");
        notepad.watchNotes();

        System.out.println("DELETE -1#");
        notepad.deleteNote(-1);
        notepad.watchNotes();

        System.out.println("DELETE 12#");
        notepad.deleteNote(12);
        notepad.watchNotes();

        System.out.println("DELETE 0 11 times#");
        for (int i = 0; i < 12; i++) {
            notepad.deleteNote(0);
        }
        notepad.watchNotes();

        notepad.addNote("note 0");
        notepad.watchNotes();
    }
}
