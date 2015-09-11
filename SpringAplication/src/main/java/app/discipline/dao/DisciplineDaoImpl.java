package app.discipline.dao;

import app.discipline.model.Discipline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 09.09.2015.
 */
public class DisciplineDaoImpl implements DisciplineDao {

     @Autowired
     DataSource dataSource;

    @Override
    public void insert(Discipline discipline) {
        String sql = "insert  into discipline(name_discipline) values(?);";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,discipline.getNameDiscipline());

    }

    @Override
    public List<Discipline> getDisciplineList() {
        List<Discipline> disciplineList = new ArrayList<>();
        String sql = "select id,name_discipline from discipline;";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        disciplineList = jdbcTemplate.query(sql, new org.springframework.jdbc.core.RowMapper<Discipline>() {
            @Override
            public Discipline mapRow(ResultSet resultSet, int i) throws SQLException {
              Discipline discipline = new Discipline();
                discipline.setId(resultSet.getInt(1));
                discipline.setNameDiscipline(resultSet.getString(2));
            return discipline;
            }
        });

        return disciplineList;
    }

    @Override
    public void delete(int id) {
        String sql = "delete from discipline where id = ?";
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,id);

    }
        @Override
        public void update(Discipline discipline) {
            String sql = "update discipline set name_discipline=? where id=?; ";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql, discipline.getNameDiscipline(), discipline.getId());

    }

    @Override
    public Discipline getById(int id) {
        String sql = "select * from discipline where discipline.id = " + id + " ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
       return jdbcTemplate.query(sql, new ResultSetExtractor<Discipline>() {
            @Override
            public Discipline extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if (resultSet.next()) {
                    Discipline discipline = new Discipline();
                    discipline.setId(resultSet.getInt(1));
                    discipline.setNameDiscipline(resultSet.getString(2));
                    return discipline;
                }
                return null;
            }
        });

    }}
