package app.student.dao;
import app.student.model.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
public class StudentDaoImpl implements StudentDao {

    @Autowired
    DataSource dataSource;
    public void insert(Student student) {
        String sql = "insert into student (first_name,second_name) values (?,?); ";
           JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql, student.getFirstName(), student.getSecondName());
    }
    public List<Student> getStudentList() throws SQLException {
        String sql = "select id, first_name, second_name from student;";
        List<Student> studentList = new ArrayList<>();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        studentList = jdbcTemplate.query(sql, new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setFirstName(resultSet.getString(2));
                student.setSecondName(resultSet.getString(3));
                return student;
            }
        });
        return studentList;
    }
    public void update(Student student) {
String sql = "Update student set first_name=?,second_name=? where id=?;";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,student.getFirstName(),student.getSecondName(),student.getId());
    }
    public void delete(int id) {
        String sql = "delete from student where id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,id);

    }
    public Student getStudent(int id) {
        String sql= "select * from student where student.id = " + id + " ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return  jdbcTemplate.query(sql, new ResultSetExtractor<Student>() {
            @Override
            public Student extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if (resultSet.next()) {
                    Student student = new Student();
                    student.setId(resultSet.getInt(1));
                    student.setFirstName(resultSet.getString(2));
                    student.setSecondName(resultSet.getString(3));
                    return student;
                }
                return null;
            }
        });
    }
}