package app.journal.model;

import app.discipline.model.Discipline;
import app.student.model.Student;

/**
 * Created by Acer on 11.09.2015.
 */
public class Table {
    private Discipline discipline;
    private Journal journal;
    private Student student;


    public Table(Journal journal, Discipline discipline, Student student) {
        this.journal = journal;
        this.discipline = discipline;
        this.student = student;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
