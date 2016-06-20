package ar.edu.unq.desapp.grupob.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Route {

    private Coordinate begin;
    private Coordinate end;
    private Integer id;

    public Route(){}

    public Route(Coordinate begin, Coordinate end) {
        this.begin = begin;
        this.end = end;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    public Coordinate getBegin() {
        return begin;
    }

    public void setBegin(Coordinate begin) {
        this.begin = begin;
    }

    @OneToOne
    public Coordinate getEnd() {
        return end;
    }

    public void setEnd(Coordinate end) {
        this.end = end;
    }
}
