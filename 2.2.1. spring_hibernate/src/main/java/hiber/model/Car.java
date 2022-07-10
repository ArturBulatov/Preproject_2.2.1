package hiber.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="cars")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="model")
    String model;

    @Column(name="series")
    int series;

    @OneToOne(mappedBy = "car")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car() {

    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }


    @Override
    public String toString() {
        return "{" +
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
