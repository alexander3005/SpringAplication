package app.journal.dao;

import app.journal.model.Journal;
import app.journal.model.Table;

import java.util.List;

/**
 * Created by Acer on 11.09.2015.
 */
public interface JournalDao {
    public List<Table> select();
    public void insert(Journal journal);
    public void update(Journal journal);
    public void delete(int id);
    public Journal getById(int id);
}
