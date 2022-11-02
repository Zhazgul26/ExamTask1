package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import  static jakarta.persistence.CascadeType. *;
import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "socialmedia")
@NoArgsConstructor
@Getter
@Setter
public class SocialMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = {DETACH, REFRESH, MERGE, PERSIST}, fetch = FetchType.LAZY)
    List<Person> personList = new ArrayList<>();

    public SocialMedia(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SocialMedia{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
