package com.amateo.java.examples.dbfw.jpa.jpaexample.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.With;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "addresses")
@ToString(exclude = "addresses")
@Table(name = "persons")
public class ConsumerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    private String random;

    @OneToOne(cascade = CascadeType.ALL,
    mappedBy = "consumer")
    private ConsumerAccountEntity consumerAccount;

    @OneToMany(mappedBy = "person",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
//    @OneToMany(
//            cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    @JoinColumn(name = "person_id", nullable = false)
    private Set<AddressEntity> addresses;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "persons_courses",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<CourseEntity> courses;

}
