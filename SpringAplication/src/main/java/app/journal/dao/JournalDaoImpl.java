package app.journal.dao;

import app.discipline.model.Discipline;
import app.journal.model.Journal;
import app.journal.model.Table;
import app.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 11.09.2015.
 */
public class JournalDaoImpl implements JournalDao {
    @Autowired
    DataSource dataSource;

    @Override
    public List<Table> select() {
        String sql ="select j.id,s.second_name, s.first_name,d.name_discipline\n" +
                "              from journal j inner join\n" +
                "              student s on j.student_id=s.id\n" +
                "              inner join\n" +
                "              discipline d on j.discipline_id=d.id\n" +
                "              ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
       List<Table> tableList = new ArrayList<>();
        tableList = jdbcTemplate.query(sql, new RowMapper<Table>() {
            @Override
            public Table mapRow(ResultSet resultSet, int i) throws SQLException {
                Discipline discipline=new Discipline();
                Journal journal=new Journal();
                Student student=new Student();

                Table join=new Table(journal,discipline,student);

                journal.setId(resultSet.getInt("id"));
                ;
                student.setSecondName(resultSet.getString("second_name"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setId(resultSet.getInt("id"));
                discipline.setId(resultSet.getInt("id"));
                discipline.setNameDiscipline(resultSet.getString("name_discipline"));
                return join;
            }
        });
        return tableList;
    }

    @Override
    public void insert(Journal journal) {
        String sql = "insert into journal (student_id,discipline_id) values (?,?);";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, journal.getStudentId(),journal.getDisciplineId());

    }

    @Override
    public void update(Journal journal) {
        String sql = "update  journal set student_id=?,discipline_id=? where id=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,journal.getStudentId(),journal.getDisciplineId(),journal.getId());
    }

    @Override
    public void delete(int id) {
        String sql =  "delete from journal WHERE  id=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,id);

    }

    @Override
    public Journal getById(int id) {
        String sql =  "select * from journal where journal.id = " + id + " ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return  jdbcTemplate.query(sql, new ResultSetExtractor<Journal>() {
            @Override
            public Journal extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()){
                    Journal journal = new Journal();
                    journal.setId(resultSet.getInt(1));
                    journal.setStudentId(resultSet.getInt(2));
                    journal.setDisciplineId(resultSet.getInt(3));
                    return journal;
                }
                return null;
            }
        });
    }
       }
