package ru.salamon.hiber.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parent_ids")
    @SequenceGenerator(name = "parent_ids", sequenceName = "parent_id_seq", allocationSize = 1)
    private Long id;

    @OneToMany(mappedBy = "parent", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Child> children = new HashSet<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Size(min = 2)
    public Set<Child> getChildren() {
        return children;
    }

    public Parent setChildren(Set<Child> children) {
        this.children = children;
        return this;
    }

    public void removeChildren(Child child) {
        if (child == null) return;
        children.remove(child);
        child.setParent(null);
    }

    public void addChildren(Set<Child>children) {
        children.addAll(children);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parent parent = (Parent) o;

        if (!Objects.equals(id, parent.id)) return false;
        return Objects.equals(children, parent.children);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }
}


