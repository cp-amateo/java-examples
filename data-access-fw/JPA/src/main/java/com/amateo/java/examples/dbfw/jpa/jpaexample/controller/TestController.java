package com.amateo.java.examples.dbfw.jpa.jpaexample.controller;

import com.amateo.java.examples.dbfw.jpa.jpaexample.repository.AddressRepository;
import com.amateo.java.examples.dbfw.jpa.jpaexample.repository.ConsumerRepository;
import com.amateo.java.examples.dbfw.jpa.jpaexample.repository.ConsumerAccountRepository;
import com.amateo.java.examples.dbfw.jpa.jpaexample.repository.entity.ConsumerEntity;
import com.amateo.java.examples.dbfw.jpa.jpaexample.repository.entity.AddressEntity;
import com.amateo.java.examples.dbfw.jpa.jpaexample.repository.entity.CourseEntity;
import com.amateo.java.examples.dbfw.jpa.jpaexample.repository.entity.ConsumerAccountEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.hibernate.Session;

import java.util.Optional;
import java.util.Random;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/test/")
@Slf4j
public class TestController {

    public static final String NAME = "Alejandro";
    private static final String STREET = "Av. diagonal 500";
    private static final String STREET_2 = "Gran via 100";
    private static final String NAME_2 = "Pedro";
    private static final String COURSE_NAME_1 = "Course 1";
    private static final String COURSE_NAME_2 = "Course 2";
    private static final String COURSE_NAME_3 = "Course 3";

    private final ConsumerRepository consumerRepository;
    private final ConsumerAccountRepository consumerAccountRepository;
    private final AddressRepository addressRepository;

    private final SessionFactory sessionFactory;

    @GetMapping("uniqueColum")
    public void doTestUniqueColum() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        final Optional<ConsumerEntity> savedPerson = consumerRepository.findByName(NAME);
        ConsumerEntity person = ConsumerEntity.builder()
                .id(savedPerson.isPresent()
                        ? savedPerson.get().getId()
                        : null)
                .name(NAME)
                .random(new Random().toString())
                .build();

        consumerRepository.save(person);

        tx.commit();
    }

    @GetMapping("oneToMany")
    public void doTestOneToMany() {
        log.info("-----  oneToMany  -----");

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        ConsumerEntity person = ConsumerEntity.builder()
                .name(NAME)
                .build();

        AddressEntity address1 = AddressEntity.builder()
                .street(STREET)
                .person(person)
                .build();
        AddressEntity address2 = AddressEntity.builder()
                .street(STREET_2)
                .person(person)
                .build();

        person.setAddresses(Set.of(address1, address2));

        consumerRepository.save(person);

        tx.commit();

        final ConsumerEntity personSaved = consumerRepository.findById(Long.valueOf("1")).get();
        personSaved.getAddresses();

        log.info("--------------------");
    }

    @GetMapping("manyToMany")
    public void doTestManyToMany() {
        log.info("-----  oneToMany  -----");

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        ConsumerEntity person1 = ConsumerEntity.builder()
                .name(NAME)
                .build();
        ConsumerEntity person2 = ConsumerEntity.builder()
                .name(NAME_2)
                .build();

        CourseEntity course1 = CourseEntity.builder()
                .name(COURSE_NAME_1)
                .build();
        CourseEntity course2 = CourseEntity.builder()
                .name(COURSE_NAME_2)
                .build();
        CourseEntity course3 = CourseEntity.builder()
                .name(COURSE_NAME_3)
                .build();

        person1.setCourses(Set.of(course1, course2));
        person2.setCourses(Set.of(course2, course3));

        consumerRepository.save(person1);
        consumerRepository.save(person2);

        tx.commit();


        log.info("--------------------");
    }

    @GetMapping("oneToOne")
    public void doTestOneToOne() {
        log.info("-----  oneToOne  -----");

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        final ConsumerEntity consumer = ConsumerEntity.builder()
                .name(NAME)
                .build();
        final ConsumerAccountEntity consumerAccount = ConsumerAccountEntity.builder()
                .telephone("666999444")
                .consumer(consumer)
                .build();

        consumerAccountRepository.save(consumerAccount);

        tx.commit();

        log.info("--------------------");
    }

}
