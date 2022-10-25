package ru.salamon.hiber.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.salamon.hiber.model.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
}