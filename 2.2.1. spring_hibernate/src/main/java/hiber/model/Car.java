package hiber.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "car")
    private User user;

    public Car() {

    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return model + series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return series == car.series && model.equals(car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, series);
    }
}
