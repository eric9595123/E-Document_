package com.advantech.model;
// Generated 2017/4/7 下午 02:26:06 by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Floor generated by hbm2java
 */
@Entity
@Table(name = "[Floor]")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Floor implements java.io.Serializable {

    private int id;
    private String name;

    @JsonIgnore
    private Set<User> users = new HashSet<>(0);

    @JsonIgnore
    private Set<TestTable> testTables = new HashSet<>(0);

    @JsonIgnore
    private Set<Line> lines = new HashSet<>(0);

    @JsonIgnore
    private Set<ActionCodeMapping> actionCodeMappings = new HashSet<>(0);

    public Floor() {
    }

    public Floor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "floor")
    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "floor")
    public Set<TestTable> getTestTables() {
        return testTables;
    }

    public void setTestTables(Set<TestTable> testTables) {
        this.testTables = testTables;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "floor")
    public Set<Line> getLines() {
        return lines;
    }

    public void setLines(Set<Line> lines) {
        this.lines = lines;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "floor")
    public Set<ActionCodeMapping> getActionCodeMappings() {
        return actionCodeMappings;
    }

    public void setActionCodeMappings(Set<ActionCodeMapping> actionCodeMappings) {
        this.actionCodeMappings = actionCodeMappings;
    }

}
