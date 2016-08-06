package jpabook.model.exam;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Kj Nam
 * @since 2016-08-06
 */
@Entity
@DiscriminatorValue("M")
public class Movie extends Item{

    private String director;
    private String actor;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
