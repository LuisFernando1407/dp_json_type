package entity;

import org.hibernate.annotations.Type;
import javax.persistence.*;

@Entity()
@Table(name = "events")
public class Event<T> extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Type(type = "json")
    @Column(name="dataEvent", columnDefinition = "json")
    private T t;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public T getDataEvent() {
        return t;
    }

    public void setDataEvent(T t) {
        this.t = t;
    }
}