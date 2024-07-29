package database.jdbc;

import java.util.List;

public interface PersonDAO {
    // dao data access object pattern
    // interface list all the methods that we want to implement
    List<Person> findAll();
    Person findById(Integer id);
    Integer save(Person p);
    void delete(Person p);
    List<Integer> getIds();
}
