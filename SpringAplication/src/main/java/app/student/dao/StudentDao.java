package app.student.dao;

import app.student.model.Student;

import java.sql.SQLException;
import java.util.List;


public interface StudentDao {
    public void insert(Student student);

    public List<Student> getStudentList() throws SQLException;

    public void update(Student student);

    public void delete(int id);

    public Student getStudent(int id);
}