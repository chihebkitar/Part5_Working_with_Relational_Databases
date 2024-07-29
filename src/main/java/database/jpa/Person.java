package database.jpa;

import javax.persistence.*;
import java.text.MessageFormat;
// hibernate orm mechanism has jpa provider in it
// jpa based on annotaion

// entity : this is a mapped class to rdba table
//
@Entity
@Table(name = "PEOPLE")
// math person class to people table
public class Person {

    // pk , GeneratedValue by db
@Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
// @column to match columns with attribute
    private String name;

    public Person() {}
    public Person(String name){
        this.name = name;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Person'{'id={0}, name=''{1}'''}'", id, name);
    }

    // Java Persistence API (JPA) and Jakarta Persistence Layer (JPL) are both popular frameworks for managing relational data in Java applications. While JPA has been around for a longer time, JPL was introduced as part of the Jakarta EE specifications after Java EE was transferred to the Eclipse Foundation.
    // The code implementation for JPL is almost identical to JPA, with the main difference being the package names.
}

