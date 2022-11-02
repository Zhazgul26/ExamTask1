package peaksoft.dao;

import peaksoft.entity.Person;

import java.util.List;

public interface PersonDao {
    public void savePerson(Person person);
    public Person getPerson(Long id);
    public List<Person> getAllPerson();
    public void updatePerson(Long id, Person person);
    public void deletePersonId(Long id);
    public Person getPersonByName(String name);
}
