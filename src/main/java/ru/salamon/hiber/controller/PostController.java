package ru.salamon.hiber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.salamon.hiber.model.Child;
import ru.salamon.hiber.model.Parent;
import ru.salamon.hiber.repo.ChildRepository;
import ru.salamon.hiber.repo.ParentRepository;

import java.util.HashSet;

@RestController
public class PostController {

    private final ParentRepository parentRepo;
    private final ChildRepository childRepository;

    @Autowired
    public PostController(ParentRepository parentRepo, ChildRepository childRepository) {
        this.parentRepo = parentRepo;
        this.childRepository = childRepository;
    }

    @GetMapping("/store")
    @Transactional
    public void store() {
        var p = new Parent();
        var c = new HashSet<Child>();
        c.add(new Child().setParent(p).setName("777"));
        c.add(new Child().setParent(p).setName("ghfgh"));
        c.add(new Child().setParent(p).setName("9999"));
        c.add(new Child().setParent(p).setName("oooo"));
       childRepository.saveAll(c);

        p.setChildren(c);
        parentRepo.save(p);
    }

    @GetMapping("/update")
    @Transactional
    public void update() {
        var p = parentRepo.findAll().get(0);
        var c = p.getChildren().iterator().next();
        p.removeChildren(c);
        parentRepo.save(p);
    }

}
