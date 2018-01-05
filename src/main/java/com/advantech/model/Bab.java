/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advantech.model;

import com.advantech.converter.BabStatusConverter;
import com.advantech.model.view.BabAvg;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Wei.Cheng
 */
@Entity
@Table(name = "Bab")
@JsonIdentityInfo(generator = JSOGGenerator.class, property = "id")
public class Bab implements Serializable {

    private int id;
    private String po;
    private String modelName;
    private Line line;
    private int people;
    private int startPosition;
    private BabStatus babStatus;
    private Date beginTime;
    private Date lastUpdateTime;
    private int ispre = 0;

    @JsonIgnore
    private Set<Fbn> fbns = new HashSet<Fbn>(0);

    @JsonIgnore
    private Set<Countermeasure> countermeasures = new HashSet<Countermeasure>(0);

    @JsonIgnore
    private Set<BabPcsDetailHistory> babPcsDetailHistorys = new HashSet<BabPcsDetailHistory>(0);

    @JsonIgnore
    private Set<BabSettingHistory> babSettingHistorys = new HashSet<BabSettingHistory>(0);

    @JsonIgnore
    private Set<BabAlarmHistory> babAlarmHistorys = new HashSet<BabAlarmHistory>(0);

    @JsonIgnore
    private Set<BabBalanceHistory> babBalanceHistorys = new HashSet<BabBalanceHistory>(0);

    @JsonIgnore
    private List<BabAvg> babAvgs = new ArrayList();

    public Bab() {
    }

    public Bab(String po, String modelName, Line line, int people, int startPosition, int ispre) {
        this.po = po;
        this.modelName = modelName;
        this.line = line;
        this.people = people;
        this.startPosition = startPosition;
        this.ispre = ispre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Size(min = 0, max = 50)
    @Column(name = "po", length = 50, nullable = false)
    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }

    @NotNull
    @Size(min = 0, max = 50)
    @Column(name = "modelName", length = 50, nullable = false)
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_id", nullable = false)
    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    @NotNull
    @Column(name = "people", nullable = false)
    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    @NotNull
    @Column(name = "startPosition", nullable = false)
    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    @Column(name = "isused")
    @Convert(converter = BabStatusConverter.class)
    public BabStatus getBabStatus() {
        return babStatus;
    }

    public void setBabStatus(BabStatus babStatus) {
        this.babStatus = babStatus;
    }

    @CreationTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd'T'kk:mm:ss.SSS'Z'", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "btime", length = 23, insertable = false, updatable = false)
    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    @UpdateTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd'T'kk:mm:ss.SSS'Z'", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastUpdateTime", length = 23, insertable = false, updatable = false)
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @NotNull
    @Column(name = "ispre", nullable = false)
    public int getIspre() {
        return ispre;
    }

    public void setIspre(int ispre) {
        this.ispre = ispre;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bab")
    public Set<Fbn> getFbns() {
        return fbns;
    }

    public void setFbns(Set<Fbn> fbns) {
        this.fbns = fbns;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bab")
    public Set<Countermeasure> getCountermeasures() {
        return countermeasures;
    }

    public void setCountermeasures(Set<Countermeasure> countermeasures) {
        this.countermeasures = countermeasures;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bab")
    public Set<BabPcsDetailHistory> getBabPcsDetailHistorys() {
        return babPcsDetailHistorys;
    }

    public void setBabPcsDetailHistorys(Set<BabPcsDetailHistory> babPcsDetailHistorys) {
        this.babPcsDetailHistorys = babPcsDetailHistorys;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bab")
    public Set<BabSettingHistory> getBabSettingHistorys() {
        return babSettingHistorys;
    }

    public void setBabSettingHistorys(Set<BabSettingHistory> babSettingHistorys) {
        this.babSettingHistorys = babSettingHistorys;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bab")
    public Set<BabAlarmHistory> getBabAlarmHistorys() {
        return babAlarmHistorys;
    }

    public void setBabAlarmHistorys(Set<BabAlarmHistory> babAlarmHistorys) {
        this.babAlarmHistorys = babAlarmHistorys;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bab")
    public Set<BabBalanceHistory> getBabBalanceHistorys() {
        return babBalanceHistorys;
    }

    public void setBabBalanceHistorys(Set<BabBalanceHistory> babBalanceHistorys) {
        this.babBalanceHistorys = babBalanceHistorys;
    }

    @Transient
    public List<BabAvg> getBabAvgs() {
        return babAvgs;
    }

    public void setBabAvgs(List<BabAvg> babAvgs) {
        this.babAvgs = babAvgs;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bab other = (Bab) obj;
        return this.id == other.id;
    }
}
