package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue


    private Long id;

    private String name;

    private int age;

    @OneToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.PERSIST},mappedBy = "person",fetch = FetchType.LAZY)
    private List<Car>cars = new ArrayList<>();

    @ManyToMany(cascade = {DETACH, REFRESH, MERGE, PERSIST}, fetch = FetchType.LAZY,mappedBy = "personList")
    List<SocialMedia> socialMediaList = new ArrayList<>();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
