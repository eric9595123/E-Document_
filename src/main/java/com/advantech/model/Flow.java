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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Flow generated by hbm2java
 */
@Entity
@Table(name = "Flow",
        schema = "dbo",
        catalog = "E_Document"
)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Flow implements java.io.Serializable {

    private int id;
//    private Flow flow;
    private FlowGroup flowGroup;
    private String name;
    @JsonIgnore
    private Set<Worktime> worktimesForTestFlowId = new HashSet<Worktime>(0);
    @JsonIgnore
    private Set<Worktime> worktimesForPackingFlowId = new HashSet<Worktime>(0);
//    @JsonIgnore
//    private Set<Flow> flows = new HashSet<Flow>(0);
    @JsonIgnore
    private Set<Worktime> worktimesForBabFlowId = new HashSet<Worktime>(0);

    private Integer p_flow_id;

    public Flow() {
    }

    public Flow(int id) {
        this.id = id;
    }

    public Flow(int id, Flow flow, FlowGroup flowGroup, String name, Set<Worktime> worktimesForTestFlowId, Set<Worktime> worktimesForPackingFlowId, Set<Flow> flows, Set<Worktime> worktimesForBabFlowId) {
        this.id = id;
//        this.flow = flow;
        this.flowGroup = flowGroup;
        this.name = name;
        this.worktimesForTestFlowId = worktimesForTestFlowId;
        this.worktimesForPackingFlowId = worktimesForPackingFlowId;
//        this.flows = flows;
        this.worktimesForBabFlowId = worktimesForBabFlowId;
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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "p_flow_id")
//    public Flow getFlow() {
//        return this.flow;
//    }
//
//    public void setFlow(Flow flow) {
//        this.flow = flow;
//    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flow_group_id")
    public FlowGroup getFlowGroup() {
        return this.flowGroup;
    }

    public void setFlowGroup(FlowGroup flowGroup) {
        this.flowGroup = flowGroup;
    }

    @Column(name = "name", length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flowByTestFlowId")
    public Set<Worktime> getWorktimesForTestFlowId() {
        return this.worktimesForTestFlowId;
    }

    public void setWorktimesForTestFlowId(Set<Worktime> worktimesForTestFlowId) {
        this.worktimesForTestFlowId = worktimesForTestFlowId;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flowByPackingFlowId")
    public Set<Worktime> getWorktimesForPackingFlowId() {
        return this.worktimesForPackingFlowId;
    }

    public void setWorktimesForPackingFlowId(Set<Worktime> worktimesForPackingFlowId) {
        this.worktimesForPackingFlowId = worktimesForPackingFlowId;
    }

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flow")
//    public Set<Flow> getFlows() {
//        return this.flows;
//    }
//
//    public void setFlows(Set<Flow> flows) {
//        this.flows = flows;
//    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "flowByBabFlowId")
    public Set<Worktime> getWorktimesForBabFlowId() {
        return this.worktimesForBabFlowId;
    }

    public void setWorktimesForBabFlowId(Set<Worktime> worktimesForBabFlowId) {
        this.worktimesForBabFlowId = worktimesForBabFlowId;
    }

    @Column(name = "p_flow_id")
    public Integer getP_flow_id() {
        return p_flow_id;
    }

    public void setP_flow_id(Integer p_flow_id) {
        this.p_flow_id = p_flow_id;
    }

}
