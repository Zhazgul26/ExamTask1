package peaksoft.daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.dao.CarDao;
import peaksoft.entity.Car;
import peaksoft.entity.Person;
import peaksoft.util.Util;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {
    SessionFactory sessionFactory = Util.getSessionFactory();

    @Override
    public void saveCar(Car car) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
        }
    }

    @Override
    public Car getCarById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Car car = session.get(Car.class, id);
            session.getTransaction().commit();
            return car;
        } catch (HibernateException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Car> getCarsByPersonId(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Person> personList = session.
                    createQuery("select c from Person c where c.id = :id", Person.class)
                    .setParameter("id", id).list();

            Person person = personList.get(0);
            List<Car> instructors = new ArrayList<>(person.getCars());
            session.getTransaction().commit();
            return instructors;
        } catch (HibernateException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Car> getCarsByPersonName(String name) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Person> personList = session.createQuery("select u from Person u").list();

            Person person = null;
            for (Person i : personList) {
                if (i.getName().equals(name)) {
                    List<Person> personList2 = session.createQuery("select c from Person c where c.id = :id", Person.class).setParameter("id", i.getId()).list();
                    person = personList2.get(0);
                }
            }
            List<Car> instructors = new ArrayList<>(person.getCars());
            session.getTransaction().commit();
            return instructors;
        } catch (HibernateException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Car> getAllCars() {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List<Car> cars = session.createQuery("select u from Car u").list();
            session.getTransaction().commit();
            session.close();
            return cars;
        } catch (HibernateException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteCarById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Car car = session.get(Car.class, id);
            session.delete(car);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new RuntimeException();
        }
    }
}
