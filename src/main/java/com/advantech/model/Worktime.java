package com.advantech.model;
// Generated 2017/4/7 下午 02:26:06 by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.envers.Audited;
import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Worktime generated by hbm2java
 */
@Entity
@Table(name = "Worktime",
        schema = "dbo",
        catalog = "E_Document",
        uniqueConstraints = @UniqueConstraint(columnNames = "model_name")
)
@DynamicInsert(true)
@DynamicUpdate(true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Worktime.class)
@Audited(targetAuditMode = NOT_AUDITED)
public class Worktime implements java.io.Serializable {

    private int id;
    private Floor floor;
    private Flow flowByTestFlowId;
    private Flow flowByPackingFlowId;
    private Flow flowByBabFlowId;
    private User userByEeOwnerId;
    private User userByQcOwnerId;
    private User userBySpeOwnerId;
    private Pending pending;
    private PreAssy preAssy;
    private Type type;
    private String modelName;
    private Double totalModule;
    private Double cleanPanel;
    private Double assy;
    private Double t1;
    private Double t2;
    private Double t3;
    private Double t4;
    private Double packing;
    private Double upBiRi;
    private Double downBiRi;
    private Double biCost;
    private Double vibration;
    private Double hiPotLeakage;
    private Double coldBoot;
    private Double warmBoot;
    private Double pendingTime;
    private String burnIn;
    private double biTime;
    private double biTemperature;
    private String assyPackingSop;
    private String testSop;
    private Integer keypartA;
    private Integer keypartB;
    private Character partLink;
    private int ce;
    private int ul;
    private int rohs;
    private int weee;
    private int madeInTaiwan;
    private int fcc;
    private int eac;
    private Double nsInOneCollectionBox;
    private char partNoAttributeMaintain;
    private Double assyLeadTime;
    private Double packingLeadTime;
    private Double productionWt;
    private Double setupTime;
    private Double assyToT1;
    private Double t2ToPacking;
    private Integer assyStation;
    private Integer packingStation;
    private Double assyKanbanTime;
    private Double packingKanbanTime;
    private Double cleanPanelAndAssembly;
    private Date modifiedDate;

    public Worktime() {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "floor_id", nullable = false)
    public Floor getFloor() {
        return this.floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_flow_id")
    public Flow getFlowByTestFlowId() {
        return this.flowByTestFlowId;
    }

    public void setFlowByTestFlowId(Flow flowByTestFlowId) {
        this.flowByTestFlowId = flowByTestFlowId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "packing_flow_id")
    public Flow getFlowByPackingFlowId() {
        return this.flowByPackingFlowId;
    }

    public void setFlowByPackingFlowId(Flow flowByPackingFlowId) {
        this.flowByPackingFlowId = flowByPackingFlowId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bab_flow_id")
    public Flow getFlowByBabFlowId() {
        return this.flowByBabFlowId;
    }

    public void setFlowByBabFlowId(Flow flowByBabFlowId) {
        this.flowByBabFlowId = flowByBabFlowId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ee_owner_id", nullable = false)
    public User getUserByEeOwnerId() {
        return this.userByEeOwnerId;
    }

    public void setUserByEeOwnerId(User userByEeOwnerId) {
        this.userByEeOwnerId = userByEeOwnerId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qc_owner_id", nullable = false)
    public User getUserByQcOwnerId() {
        return this.userByQcOwnerId;
    }

    public void setUserByQcOwnerId(User userByQcOwnerId) {
        this.userByQcOwnerId = userByQcOwnerId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spe_owner_id", nullable = false)
    public User getUserBySpeOwnerId() {
        return this.userBySpeOwnerId;
    }

    public void setUserBySpeOwnerId(User userBySpeOwnerId) {
        this.userBySpeOwnerId = userBySpeOwnerId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pending_id", nullable = false)
    public Pending getPending() {
        return this.pending;
    }

    public void setPending(Pending pending) {
        this.pending = pending;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pre_assy_id")
    public PreAssy getPreAssy() {
        return this.preAssy;
    }

    public void setPreAssy(PreAssy preAssy) {
        this.preAssy = preAssy;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", nullable = false)
    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Column(name = "model_name", unique = true, nullable = false, length = 50)
    public String getModelName() {
        return this.modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Column(name = "total_module")
    public Double getTotalModule() {
        return this.totalModule;
    }

    public void setTotalModule(Double totalModule) {
        this.totalModule = totalModule;
    }

    @Column(name = "clean_panel")
    public Double getCleanPanel() {
        return this.cleanPanel;
    }

    public void setCleanPanel(Double cleanPanel) {
        this.cleanPanel = cleanPanel;
    }

    @Column(name = "assy")
    public Double getAssy() {
        return this.assy;
    }

    public void setAssy(Double assy) {
        this.assy = assy;
    }

    @Column(name = "t1")
    public Double getT1() {
        return this.t1;
    }

    public void setT1(Double t1) {
        this.t1 = t1;
    }

    @Column(name = "t2")
    public Double getT2() {
        return this.t2;
    }

    public void setT2(Double t2) {
        this.t2 = t2;
    }

    @Column(name = "t3")
    public Double getT3() {
        return this.t3;
    }

    public void setT3(Double t3) {
        this.t3 = t3;
    }

    @Column(name = "t4")
    public Double getT4() {
        return this.t4;
    }

    public void setT4(Double t4) {
        this.t4 = t4;
    }

    @Column(name = "packing")
    public Double getPacking() {
        return this.packing;
    }

    public void setPacking(Double packing) {
        this.packing = packing;
    }

    @Column(name = "up_bi_ri")
    public Double getUpBiRi() {
        return this.upBiRi;
    }

    public void setUpBiRi(Double upBiRi) {
        this.upBiRi = upBiRi;
    }

    @Column(name = "down_bi_ri")
    public Double getDownBiRi() {
        return this.downBiRi;
    }

    public void setDownBiRi(Double downBiRi) {
        this.downBiRi = downBiRi;
    }

    @Column(name = "bi_cost")
    public Double getBiCost() {
        return this.biCost;
    }

    public void setBiCost(Double biCost) {
        this.biCost = biCost;
    }

    @Column(name = "vibration")
    public Double getVibration() {
        return this.vibration;
    }

    public void setVibration(Double vibration) {
        this.vibration = vibration;
    }

    @Column(name = "hi_pot_leakage")
    public Double getHiPotLeakage() {
        return this.hiPotLeakage;
    }

    public void setHiPotLeakage(Double hiPotLeakage) {
        this.hiPotLeakage = hiPotLeakage;
    }

    @Column(name = "cold_boot")
    public Double getColdBoot() {
        return this.coldBoot;
    }

    public void setColdBoot(Double coldBoot) {
        this.coldBoot = coldBoot;
    }

    @Column(name = "warm_boot")
    public Double getWarmBoot() {
        return this.warmBoot;
    }

    public void setWarmBoot(Double warmBoot) {
        this.warmBoot = warmBoot;
    }

    @Column(name = "pending_time", nullable = false)
    public Double getPendingTime() {
        return this.pendingTime;
    }

    public void setPendingTime(Double pendingTime) {
        this.pendingTime = pendingTime;
    }

    @Column(name = "burn_in", nullable = false, length = 10)
    public String getBurnIn() {
        return this.burnIn;
    }

    public void setBurnIn(String burnIn) {
        this.burnIn = burnIn;
    }

    @Column(name = "bi_time", nullable = false)
    public double getBiTime() {
        return this.biTime;
    }

    public void setBiTime(double biTime) {
        this.biTime = biTime;
    }

    @Column(name = "bi_temperature", nullable = false)
    public double getBiTemperature() {
        return this.biTemperature;
    }

    public void setBiTemperature(double biTemperature) {
        this.biTemperature = biTemperature;
    }

    @Column(name = "assy_packing_sop", length = 500)
    public String getAssyPackingSop() {
        return this.assyPackingSop;
    }

    public void setAssyPackingSop(String assyPackingSop) {
        this.assyPackingSop = assyPackingSop;
    }

    @Column(name = "test_sop", length = 500)
    public String getTestSop() {
        return this.testSop;
    }

    public void setTestSop(String testSop) {
        this.testSop = testSop;
    }

    @Column(name = "keypart_a")
    public Integer getKeypartA() {
        return this.keypartA;
    }

    public void setKeypartA(Integer keypartA) {
        this.keypartA = keypartA;
    }

    @Column(name = "keypart_b")
    public Integer getKeypartB() {
        return this.keypartB;
    }

    public void setKeypartB(Integer keypartB) {
        this.keypartB = keypartB;
    }

    @Column(name = "part_link", length = 1)
    public Character getPartLink() {
        return this.partLink;
    }

    public void setPartLink(Character partLink) {
        this.partLink = partLink;
    }

    @Column(name = "ce", nullable = false)
    public int getCe() {
        return this.ce;
    }

    public void setCe(int ce) {
        this.ce = ce;
    }

    @Column(name = "ul", nullable = false)
    public int getUl() {
        return this.ul;
    }

    public void setUl(int ul) {
        this.ul = ul;
    }

    @Column(name = "rohs", nullable = false)
    public int getRohs() {
        return this.rohs;
    }

    public void setRohs(int rohs) {
        this.rohs = rohs;
    }

    @Column(name = "weee", nullable = false)
    public int getWeee() {
        return this.weee;
    }

    public void setWeee(int weee) {
        this.weee = weee;
    }

    @Column(name = "made_in_taiwan", nullable = false)
    public int getMadeInTaiwan() {
        return this.madeInTaiwan;
    }

    public void setMadeInTaiwan(int madeInTaiwan) {
        this.madeInTaiwan = madeInTaiwan;
    }

    @Column(name = "fcc", nullable = false)
    public int getFcc() {
        return this.fcc;
    }

    public void setFcc(int fcc) {
        this.fcc = fcc;
    }

    @Column(name = "eac", nullable = false)
    public int getEac() {
        return this.eac;
    }

    public void setEac(int eac) {
        this.eac = eac;
    }

    @Column(name = "ns_in_one_collection_box")
    public Double getNsInOneCollectionBox() {
        return this.nsInOneCollectionBox;
    }

    public void setNsInOneCollectionBox(Double NsInOneCollectionBox) {
        this.nsInOneCollectionBox = NsInOneCollectionBox;
    }

    @Column(name = "part_no_attribute_maintain", nullable = false, length = 1)
    public char getPartNoAttributeMaintain() {
        return this.partNoAttributeMaintain;
    }

    public void setPartNoAttributeMaintain(char partNoAttributeMaintain) {
        this.partNoAttributeMaintain = partNoAttributeMaintain;
    }

    @Column(name = "assy_lead_time")
    public Double getAssyLeadTime() {
        return this.assyLeadTime;
    }

    public void setAssyLeadTime(Double assyLeadTime) {
        this.assyLeadTime = assyLeadTime;
    }

    @Column(name = "packing_lead_time")
    public Double getPackingLeadTime() {
        return this.packingLeadTime;
    }

    public void setPackingLeadTime(Double packingLeadTime) {
        this.packingLeadTime = packingLeadTime;
    }

    @Column(name = "productionWt")
    public Double getProductionWt() {
        return productionWt;
    }

    public void setProductionWt(Double productionWt) {
        this.productionWt = productionWt;
    }

    @Column(name = "setup_time")
    public Double getSetupTime() {
        return setupTime;
    }

    public void setSetupTime(Double setupTime) {
        this.setupTime = setupTime;
    }

    @Column(name = "assy_to_t1")
    public Double getAssyToT1() {
        return assyToT1;
    }

    public void setAssyToT1(Double assyToT1) {
        this.assyToT1 = assyToT1;
    }

    @Column(name = "t2_to_packing")
    public Double getT2ToPacking() {
        return t2ToPacking;
    }

    public void setT2ToPacking(Double t2ToPacking) {
        this.t2ToPacking = t2ToPacking;
    }

    @Column(name = "assy_station")
    public Integer getAssyStation() {
        return assyStation;
    }

    public void setAssyStation(Integer assyStation) {
        this.assyStation = assyStation;
    }

    @Column(name = "packing_station")
    public Integer getPackingStation() {
        return packingStation;
    }

    public void setPackingStation(Integer packingStation) {
        this.packingStation = packingStation;
    }

    @Column(name = "assy_kanban_time")
    public Double getAssyKanbanTime() {
        return assyKanbanTime;
    }

    public void setAssyKanbanTime(Double assyKanbanTime) {
        this.assyKanbanTime = assyKanbanTime;
    }

    @Column(name = "packing_kanban_time")
    public Double getPackingKanbanTime() {
        return packingKanbanTime;
    }

    public void setPackingKanbanTime(Double packingKanbanTime) {
        this.packingKanbanTime = packingKanbanTime;
    }

    @Column(name = "clean_panel_and_assembly")
    public Double getCleanPanelAndAssembly() {
        return cleanPanelAndAssembly;
    }

    public void setCleanPanelAndAssembly(Double cleanPanelAndAssembly) {
        this.cleanPanelAndAssembly = cleanPanelAndAssembly;
    }

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd'T'kk:mm:ss.SSS'Z'", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date", length = 23, insertable = false, updatable = false)
    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setDefaultProductWt() {
        Double defaultValue = this.totalModule + this.cleanPanel + this.assy
                + this.t1 + this.t2 + this.t3 + this.t4 + this.packing + this.upBiRi
                + this.downBiRi + this.biCost + this.vibration + this.hiPotLeakage
                + this.coldBoot + this.warmBoot;
        this.setProductionWt(defaultValue);
    }

    public void setDefaultSetupTime() { 
        Double defaultValue = (this.totalModule == 0 ? 0 : 10 + this.assy == 0 ? 0 : 30 + this.t1 == 0 ? 0 : 15
                + this.t2 == 0 ? 0 : 15 + this.t3 == 0 ? 0 : 5 + this.t4 == 0 ? 0 : 5
                                        + this.packing == 0 ? 0 : 20 + this.cleanPanel == 0 ? 0 : 10) + 0.0;
        this.setSetupTime(defaultValue);
    }

    public void setDefaultAssyToT1() {
        Double defaultValue = this.cleanPanelAndAssembly + this.t1 + this.upBiRi + this.vibration
                + this.hiPotLeakage + this.coldBoot + this.warmBoot;
        this.setAssyToT1(defaultValue);
    }

    public void setDefaultT2ToPacking() {
        Double defaultValue = this.t2 + this.t3 + this.t4 + this.packing
                + this.downBiRi;
        this.setT2ToPacking(defaultValue);
    }

    public void setDefaultAssyStation() {
        Long defaultValue = this.assy <= 45 ? 3 : (Math.round(this.assy / 15) >= 6 ? 6 : Math.round(this.assy / 15));
        this.setAssyStation(defaultValue.intValue());
    }

    public void setDefaultPackingStation() {
        Double defaultValue = this.packing <= 10 ? 2 : (round(this.packing / 5, 0) >= 6 ? 6 : round(this.packing / 5, 0));
        this.setPackingStation(defaultValue.intValue());
    }

    public void setDefaultAssyKanbanTime() {
        if (this.assyStation != null && this.assyStation != 0) {
            Double defaultValue = round((this.assy - this.assyLeadTime) / this.assyStation, 2);
            this.setAssyKanbanTime(defaultValue);
        }
    }

    public void setDefaultPackingKanbanTime() {
        if (this.packingStation != null && this.packingStation != 0) {
            Double defaultValue = round((this.packing - this.packingLeadTime) / this.packingStation, 2);
            this.setPackingKanbanTime(defaultValue);
        }
    }

    public void setDefaultCleanPanelAndAssembly() {
        Double defaultValue = this.cleanPanel + this.assy;
        this.setCleanPanelAndAssembly(defaultValue);
    }

    private double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.floor);
        hash = 23 * hash + Objects.hashCode(this.flowByTestFlowId);
        hash = 23 * hash + Objects.hashCode(this.flowByPackingFlowId);
        hash = 23 * hash + Objects.hashCode(this.flowByBabFlowId);
        hash = 23 * hash + Objects.hashCode(this.userByEeOwnerId);
        hash = 23 * hash + Objects.hashCode(this.userByQcOwnerId);
        hash = 23 * hash + Objects.hashCode(this.userBySpeOwnerId);
        hash = 23 * hash + Objects.hashCode(this.pending);
        hash = 23 * hash + Objects.hashCode(this.preAssy);
        hash = 23 * hash + Objects.hashCode(this.type);
        hash = 23 * hash + Objects.hashCode(this.modelName);
        hash = 23 * hash + Objects.hashCode(this.totalModule);
        hash = 23 * hash + Objects.hashCode(this.cleanPanel);
        hash = 23 * hash + Objects.hashCode(this.assy);
        hash = 23 * hash + Objects.hashCode(this.t1);
        hash = 23 * hash + Objects.hashCode(this.t2);
        hash = 23 * hash + Objects.hashCode(this.t3);
        hash = 23 * hash + Objects.hashCode(this.t4);
        hash = 23 * hash + Objects.hashCode(this.packing);
        hash = 23 * hash + Objects.hashCode(this.upBiRi);
        hash = 23 * hash + Objects.hashCode(this.downBiRi);
        hash = 23 * hash + Objects.hashCode(this.biCost);
        hash = 23 * hash + Objects.hashCode(this.vibration);
        hash = 23 * hash + Objects.hashCode(this.hiPotLeakage);
        hash = 23 * hash + Objects.hashCode(this.coldBoot);
        hash = 23 * hash + Objects.hashCode(this.warmBoot);
        hash = 23 * hash + Objects.hashCode(this.pendingTime);
        hash = 23 * hash + Objects.hashCode(this.burnIn);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.biTime) ^ (Double.doubleToLongBits(this.biTime) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.biTemperature) ^ (Double.doubleToLongBits(this.biTemperature) >>> 32));
        hash = 23 * hash + Objects.hashCode(this.assyPackingSop);
        hash = 23 * hash + Objects.hashCode(this.testSop);
        hash = 23 * hash + Objects.hashCode(this.keypartA);
        hash = 23 * hash + Objects.hashCode(this.keypartB);
        hash = 23 * hash + Objects.hashCode(this.partLink);
        hash = 23 * hash + this.ce;
        hash = 23 * hash + this.ul;
        hash = 23 * hash + this.rohs;
        hash = 23 * hash + this.weee;
        hash = 23 * hash + this.madeInTaiwan;
        hash = 23 * hash + this.fcc;
        hash = 23 * hash + this.eac;
        hash = 23 * hash + Objects.hashCode(this.nsInOneCollectionBox);
        hash = 23 * hash + this.partNoAttributeMaintain;
        hash = 23 * hash + Objects.hashCode(this.assyLeadTime);
        hash = 23 * hash + Objects.hashCode(this.packingLeadTime);
        hash = 23 * hash + Objects.hashCode(this.productionWt);
        hash = 23 * hash + Objects.hashCode(this.setupTime);
        hash = 23 * hash + Objects.hashCode(this.assyToT1);
        hash = 23 * hash + Objects.hashCode(this.t2ToPacking);
        hash = 23 * hash + Objects.hashCode(this.assyStation);
        hash = 23 * hash + Objects.hashCode(this.packingStation);
        hash = 23 * hash + Objects.hashCode(this.assyKanbanTime);
        hash = 23 * hash + Objects.hashCode(this.packingKanbanTime);
        hash = 23 * hash + Objects.hashCode(this.cleanPanelAndAssembly);
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
        final Worktime other = (Worktime) obj;
        if (Double.doubleToLongBits(this.biTime) != Double.doubleToLongBits(other.biTime)) {
            return false;
        }
        if (Double.doubleToLongBits(this.biTemperature) != Double.doubleToLongBits(other.biTemperature)) {
            return false;
        }
        if (this.ce != other.ce) {
            return false;
        }
        if (this.ul != other.ul) {
            return false;
        }
        if (this.rohs != other.rohs) {
            return false;
        }
        if (this.weee != other.weee) {
            return false;
        }
        if (this.madeInTaiwan != other.madeInTaiwan) {
            return false;
        }
        if (this.fcc != other.fcc) {
            return false;
        }
        if (this.eac != other.eac) {
            return false;
        }
        if (this.partNoAttributeMaintain != other.partNoAttributeMaintain) {
            return false;
        }
        if (!Objects.equals(this.modelName, other.modelName)) {
            return false;
        }
        if (!Objects.equals(this.burnIn, other.burnIn)) {
            return false;
        }
        if (!Objects.equals(this.assyPackingSop, other.assyPackingSop)) {
            return false;
        }
        if (!Objects.equals(this.testSop, other.testSop)) {
            return false;
        }
        if (!Objects.equals(this.floor, other.floor)) {
            return false;
        }
        if (!Objects.equals(this.flowByTestFlowId, other.flowByTestFlowId)) {
            return false;
        }
        if (!Objects.equals(this.flowByPackingFlowId, other.flowByPackingFlowId)) {
            return false;
        }
        if (!Objects.equals(this.flowByBabFlowId, other.flowByBabFlowId)) {
            return false;
        }
        if (!Objects.equals(this.userByEeOwnerId, other.userByEeOwnerId)) {
            return false;
        }
        if (!Objects.equals(this.userByQcOwnerId, other.userByQcOwnerId)) {
            return false;
        }
        if (!Objects.equals(this.userBySpeOwnerId, other.userBySpeOwnerId)) {
            return false;
        }
        if (!Objects.equals(this.pending, other.pending)) {
            return false;
        }
        if (!Objects.equals(this.preAssy, other.preAssy)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.totalModule, other.totalModule)) {
            return false;
        }
        if (!Objects.equals(this.cleanPanel, other.cleanPanel)) {
            return false;
        }
        if (!Objects.equals(this.assy, other.assy)) {
            return false;
        }
        if (!Objects.equals(this.t1, other.t1)) {
            return false;
        }
        if (!Objects.equals(this.t2, other.t2)) {
            return false;
        }
        if (!Objects.equals(this.t3, other.t3)) {
            return false;
        }
        if (!Objects.equals(this.t4, other.t4)) {
            return false;
        }
        if (!Objects.equals(this.packing, other.packing)) {
            return false;
        }
        if (!Objects.equals(this.upBiRi, other.upBiRi)) {
            return false;
        }
        if (!Objects.equals(this.downBiRi, other.downBiRi)) {
            return false;
        }
        if (!Objects.equals(this.biCost, other.biCost)) {
            return false;
        }
        if (!Objects.equals(this.vibration, other.vibration)) {
            return false;
        }
        if (!Objects.equals(this.hiPotLeakage, other.hiPotLeakage)) {
            return false;
        }
        if (!Objects.equals(this.coldBoot, other.coldBoot)) {
            return false;
        }
        if (!Objects.equals(this.warmBoot, other.warmBoot)) {
            return false;
        }
        if (!Objects.equals(this.pendingTime, other.pendingTime)) {
            return false;
        }
        if (!Objects.equals(this.keypartA, other.keypartA)) {
            return false;
        }
        if (!Objects.equals(this.keypartB, other.keypartB)) {
            return false;
        }
        if (!Objects.equals(this.partLink, other.partLink)) {
            return false;
        }
        if (!Objects.equals(this.nsInOneCollectionBox, other.nsInOneCollectionBox)) {
            return false;
        }
        if (!Objects.equals(this.assyLeadTime, other.assyLeadTime)) {
            return false;
        }
        if (!Objects.equals(this.packingLeadTime, other.packingLeadTime)) {
            return false;
        }
        if (!Objects.equals(this.productionWt, other.productionWt)) {
            return false;
        }
        if (!Objects.equals(this.setupTime, other.setupTime)) {
            return false;
        }
        if (!Objects.equals(this.assyToT1, other.assyToT1)) {
            return false;
        }
        if (!Objects.equals(this.t2ToPacking, other.t2ToPacking)) {
            return false;
        }
        if (!Objects.equals(this.assyStation, other.assyStation)) {
            return false;
        }
        if (!Objects.equals(this.packingStation, other.packingStation)) {
            return false;
        }
        if (!Objects.equals(this.assyKanbanTime, other.assyKanbanTime)) {
            return false;
        }
        if (!Objects.equals(this.packingKanbanTime, other.packingKanbanTime)) {
            return false;
        }
        if (!Objects.equals(this.cleanPanelAndAssembly, other.cleanPanelAndAssembly)) {
            return false;
        }
        return true;
    }

}
