package app.discipline.dao;

import app.discipline.model.Discipline;

import java.util.List;

/**
 * Created by Acer on 09.09.2015.
 */
public interface DisciplineDao {
    public void insert(Discipline discipline);
    public List<Discipline> getDisciplineList();
    public void delete(int id);
    public void update (Discipline discipline);
    public Discipline getById(int id);

}
