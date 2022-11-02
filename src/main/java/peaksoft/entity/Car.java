package peaksoft.entity;

import javax.persistence.*;

import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.util.Util;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.util.Util;
import static jakarta.persistence.CascadeType.*;

@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "cars")
@NoArgsConstructor
@Getter
@Setter
public class Car {
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String carModel;

    @jakarta.persistence.ManyToOne(cascade = {MERGE, PERSIST, PERSIST, DETACH}, fetch = FetchType.EAGER)
    private Person person;

    public Car(String carModel, Long personId) {
        this.carModel = carModel;
        this.person = convertPerson(personId);
    }

    public Person convertPerson(Long id){
        SessionFactory sessionFactory = Util.getSessionFactory();
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Person person = session.get(Person.class, id);
            session.getTransaction().commit();
            return person;
        } catch (HibernateException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carModel='" + carModel + '\'' +
                '}';
    }

}


