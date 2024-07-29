package database.jdbc;

import java.text.MessageFormat;
import java.util.Objects;

public class Person {

    public static final String DEFAULT_NAME ="UNKNOWN";

    private Integer id;
    private String name;

    public Person() {
        this(DEFAULT_NAME);
    }
    public Person(String name){
        this.name = name;
    }

    public Person(Integer id, String name) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name);
    }
    // doesnt allow equivalence between classes and subclasses

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
