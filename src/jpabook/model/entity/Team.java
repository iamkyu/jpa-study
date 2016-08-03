package jpabook.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kj Nam
 * @since 2016-08-03
 */
@Entity
public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private String id;

    private String name;

    public Team() {
    }

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<Member>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
