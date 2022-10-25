package ru.salamon.hiber.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "child_ids")
    @SequenceGenerator(name = "child_ids_ids", sequenceName = "child_ids_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    public String getName() {
        return name;
    }

    public Child setName(String name) {
        this.name = name;
        return this;
    }

    @NotNull
    private String name;


    public Child setId(Long id) {
        this.id = id;
        return this;
    }


    public Long getId() {
        return id;
    }

    public Parent getParent() {
        return parent;
    }

    public Child setParent(Parent parent) {
        this.parent = parent;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Child child = (Child) o;

        if (!Objects.equals(id, child.id)) return false;
        if (parent != child.parent && parent.getId() != child.id) {
            return parent.getId().equals(child.id);
        }

        return name.equals(child.name);
    }

    @Override
    public int hashCode() {
        return 1001;
    }
}
