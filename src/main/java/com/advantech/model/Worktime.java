package com.advantech.model;
// Generated 2017/4/7 下午 02:26:06 by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.AutoPopulatingList;

/**
 * Worktime generated by hbm2java
 * http://www.cnblogs.com/chenssy/archive/2012/09/09/2677279.html How to use
 * BigDecimal
 */
@Entity
@Table(name = "Worktime",
        uniqueConstraints = @UniqueConstraint(columnNames = "model_name")
)
@DynamicInsert(true)
@DynamicUpdate(true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Worktime.class)
@Audited(targetAuditMode = NOT_AUDITED, withModifiedFlag = true)
//@FlowValidate
//@EsValidate
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
    private BusinessGroup businessGroup;
    private String modelName;

//    @JsonIgnore
    private List<BwField> bwField = new AutoPopulatingList<BwField>(BwField.class);

    @JsonIgnore
    private List<WorktimeFormulaSetting> worktimeFormulaSettings = new AutoPopulatingList<WorktimeFormulaSetting>(WorktimeFormulaSetting.class);

    private String workCenter;
    private BigDecimal totalModule = BigDecimal.ZERO;
    private BigDecimal cleanPanel = BigDecimal.ZERO;
    private BigDecimal assy = BigDecimal.ZERO;
    private BigDecimal t1 = BigDecimal.ZERO;
    private BigDecimal t2 = BigDecimal.ZERO;
    private BigDecimal t3 = BigDecimal.ZERO;
    private BigDecimal t4 = BigDecimal.ZERO;
    private BigDecimal packing = BigDecimal.ZERO;
    private BigDecimal upBiRi = BigDecimal.ZERO;
    private BigDecimal downBiRi = BigDecimal.ZERO;
    private BigDecimal biCost = BigDecimal.ZERO;
    private BigDecimal vibration = BigDecimal.ZERO;
    private BigDecimal hiPotLeakage = BigDecimal.ZERO;
    private BigDecimal coldBoot = BigDecimal.ZERO;
    private BigDecimal warmBoot = BigDecimal.ZERO;
    private BigDecimal pendingTime;
    private String burnIn;
    private BigDecimal biTime;
    private BigDecimal biTemperature;
    private String assyPackingSop;
    private String testSop;
    private Integer keypartA = 0;
    private Integer keypartB = 0;
    private Character partLink;
    private int ce;
    private int ul;
    private int rohs;
    private int weee;
    private int madeInTaiwan;
    private int fcc;
    private int eac;
    private int kc;
    private BigDecimal nsInOneCollectionBox = BigDecimal.ZERO;
    private char partNoAttributeMaintain;
    private BigDecimal weight = BigDecimal.ZERO;
    private BigDecimal tolerance = BigDecimal.ZERO;
    private BigDecimal assyLeadTime = BigDecimal.ZERO;
    private BigDecimal packingLeadTime = BigDecimal.ZERO;
    private BigDecimal productionWt = BigDecimal.ZERO;
    private BigDecimal setupTime = BigDecimal.ZERO;
    private BigDecimal assyToT1 = BigDecimal.ZERO;
    private BigDecimal t2ToPacking = BigDecimal.ZERO;
    private Integer assyStation = 0;
    private Integer packingStation = 0;
    private BigDecimal assyKanbanTime = BigDecimal.ZERO;
    private BigDecimal packingKanbanTime = BigDecimal.ZERO;
    private BigDecimal cleanPanelAndAssembly = BigDecimal.ZERO;
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

    @NotNull
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

//    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ee_owner_id", nullable = true)
    public User getUserByEeOwnerId() {
        return this.userByEeOwnerId;
    }

    public void setUserByEeOwnerId(User userByEeOwnerId) {
        this.userByEeOwnerId = userByEeOwnerId;
    }

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qc_owner_id", nullable = true)
    public User getUserByQcOwnerId() {
        return this.userByQcOwnerId;
    }

    public void setUserByQcOwnerId(User userByQcOwnerId) {
        this.userByQcOwnerId = userByQcOwnerId;
    }

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spe_owner_id", nullable = true)
    public User getUserBySpeOwnerId() {
        return this.userBySpeOwnerId;
    }

    public void setUserBySpeOwnerId(User userBySpeOwnerId) {
        this.userBySpeOwnerId = userBySpeOwnerId;
    }

    @NotNull
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

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", nullable = false)
    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

//    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "businessGroup_id")
    public BusinessGroup getBusinessGroup() {
        return businessGroup;
    }

    public void setBusinessGroup(BusinessGroup businessGroup) {
        this.businessGroup = businessGroup;
    }

    @NotNull
    @NotEmpty
    @Size(min = 0, max = 50)
    @Column(name = "model_name", unique = true, nullable = false, length = 50)
    public String getModelName() {
        return this.modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Size(min = 0, max = 50)
    @Column(name = "work_center", length = 50)
    public String getWorkCenter() {
        return workCenter;
    }

    public void setWorkCenter(String workCenter) {
        this.workCenter = workCenter;
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "total_module", precision = 10, scale = 1)
    public BigDecimal getTotalModule() {
        return this.totalModule;
    }

    public void setTotalModule(BigDecimal totalModule) {
        this.totalModule = autoFixScale(totalModule, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "clean_panel", precision = 10, scale = 1)
    public BigDecimal getCleanPanel() {
        return this.cleanPanel;
    }

    public void setCleanPanel(BigDecimal cleanPanel) {
        this.cleanPanel = autoFixScale(cleanPanel, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "assy", precision = 10, scale = 1)
    public BigDecimal getAssy() {
        return this.assy;
    }

    public void setAssy(BigDecimal assy) {
        this.assy = autoFixScale(assy, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "t1", precision = 10, scale = 1)
    public BigDecimal getT1() {
        return this.t1;
    }

    public void setT1(BigDecimal t1) {
        this.t1 = autoFixScale(t1, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "t2", precision = 10, scale = 1)
    public BigDecimal getT2() {
        return this.t2;
    }

    public void setT2(BigDecimal t2) {
        this.t2 = autoFixScale(t2, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "t3", precision = 10, scale = 1)
    public BigDecimal getT3() {
        return this.t3;
    }

    public void setT3(BigDecimal t3) {
        this.t3 = autoFixScale(t3, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "t4", precision = 10, scale = 1)
    public BigDecimal getT4() {
        return this.t4;
    }

    public void setT4(BigDecimal t4) {
        this.t4 = autoFixScale(t4, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "packing", precision = 10, scale = 1)
    public BigDecimal getPacking() {
        return this.packing;
    }

    public void setPacking(BigDecimal packing) {
        this.packing = autoFixScale(packing, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "up_bi_ri", precision = 10, scale = 1)
    public BigDecimal getUpBiRi() {
        return this.upBiRi;
    }

    public void setUpBiRi(BigDecimal upBiRi) {
        this.upBiRi = autoFixScale(upBiRi, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "down_bi_ri", precision = 10, scale = 1)
    public BigDecimal getDownBiRi() {
        return this.downBiRi;
    }

    public void setDownBiRi(BigDecimal downBiRi) {
        this.downBiRi = autoFixScale(downBiRi, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "bi_cost", precision = 10, scale = 1)
    public BigDecimal getBiCost() {
        return this.biCost;
    }

    public void setBiCost(BigDecimal biCost) {
        this.biCost = autoFixScale(biCost, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "vibration", precision = 10, scale = 1)
    public BigDecimal getVibration() {
        return this.vibration;
    }

    public void setVibration(BigDecimal vibration) {
        this.vibration = autoFixScale(vibration, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "hi_pot_leakage", precision = 10, scale = 1)
    public BigDecimal getHiPotLeakage() {
        return this.hiPotLeakage;
    }

    public void setHiPotLeakage(BigDecimal hiPotLeakage) {
        this.hiPotLeakage = autoFixScale(hiPotLeakage, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "cold_boot", precision = 10, scale = 1)
    public BigDecimal getColdBoot() {
        return this.coldBoot;
    }

    public void setColdBoot(BigDecimal coldBoot) {
        this.coldBoot = autoFixScale(coldBoot, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "warm_boot", precision = 10, scale = 1)
    public BigDecimal getWarmBoot() {
        return this.warmBoot;
    }

    public void setWarmBoot(BigDecimal warmBoot) {
        this.warmBoot = autoFixScale(warmBoot, 1);
    }

    @NotNull(message = "Pending Time 不可為空")
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "pending_time", nullable = false, precision = 10, scale = 1)
    public BigDecimal getPendingTime() {
        return this.pendingTime;
    }

    public void setPendingTime(BigDecimal pendingTime) {
        this.pendingTime = autoFixScale(pendingTime, 1);
    }

    @NotNull
    @NotEmpty
    @Column(name = "burn_in", nullable = false, length = 10)
    public String getBurnIn() {
        return this.burnIn;
    }

    public void setBurnIn(String burnIn) {
        this.burnIn = burnIn;
    }

    @NotNull(message = "Bi Time 不可為空")
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "bi_time", nullable = false, precision = 10, scale = 1)
    public BigDecimal getBiTime() {
        return this.biTime;
    }

    public void setBiTime(BigDecimal biTime) {
        this.biTime = autoFixScale(biTime, 1);
    }

    @NotNull(message = "Bi Temperature 不可為空")
    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "bi_temperature", nullable = false, precision = 10, scale = 1)
    public BigDecimal getBiTemperature() {
        return this.biTemperature;
    }

    public void setBiTemperature(BigDecimal biTemperature) {
        this.biTemperature = autoFixScale(biTemperature, 1);
    }

    @Size(min = 0, max = 500)
    @Column(name = "assy_packing_sop", length = 500)
    public String getAssyPackingSop() {
        return this.assyPackingSop != null ? ("".equals(this.assyPackingSop.trim()) ? null : this.assyPackingSop.trim()) : null;
    }

    public void setAssyPackingSop(String assyPackingSop) {
        this.assyPackingSop = assyPackingSop;
    }

    @Size(min = 0, max = 500)
    @Column(name = "test_sop", length = 500)
    public String getTestSop() {
        return this.testSop != null ? ("".equals(this.testSop.trim()) ? null : this.testSop.trim()) : null;
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

    @NotNull
    @Column(name = "ce", nullable = false)
    public int getCe() {
        return this.ce;
    }

    public void setCe(int ce) {
        this.ce = ce;
    }

    @NotNull
    @Column(name = "ul", nullable = false)
    public int getUl() {
        return this.ul;
    }

    public void setUl(int ul) {
        this.ul = ul;
    }

    @NotNull
    @Column(name = "rohs", nullable = false)
    public int getRohs() {
        return this.rohs;
    }

    public void setRohs(int rohs) {
        this.rohs = rohs;
    }

    @NotNull
    @Column(name = "weee", nullable = false)
    public int getWeee() {
        return this.weee;
    }

    public void setWeee(int weee) {
        this.weee = weee;
    }

    @NotNull
    @Column(name = "made_in_taiwan", nullable = false)
    public int getMadeInTaiwan() {
        return this.madeInTaiwan;
    }

    public void setMadeInTaiwan(int madeInTaiwan) {
        this.madeInTaiwan = madeInTaiwan;
    }

    @NotNull
    @Column(name = "fcc", nullable = false)
    public int getFcc() {
        return this.fcc;
    }

    public void setFcc(int fcc) {
        this.fcc = fcc;
    }

    @NotNull
    @Column(name = "eac", nullable = false)
    public int getEac() {
        return this.eac;
    }

    public void setEac(int eac) {
        this.eac = eac;
    }

    @NotNull
    @Column(name = "kc", nullable = false)
    public int getKc() {
        return this.kc;
    }

    public void setKc(int kc) {
        this.kc = kc;
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "ns_in_one_collection_box", precision = 10, scale = 1)
    public BigDecimal getNsInOneCollectionBox() {
        return this.nsInOneCollectionBox;
    }

    public void setNsInOneCollectionBox(BigDecimal NsInOneCollectionBox) {
        this.nsInOneCollectionBox = autoFixScale(NsInOneCollectionBox, 1);
    }

    @NotNull
    @Column(name = "part_no_attribute_maintain", nullable = false, length = 1)
    public char getPartNoAttributeMaintain() {
        return this.partNoAttributeMaintain;
    }

    public void setPartNoAttributeMaintain(char partNoAttributeMaintain) {
        this.partNoAttributeMaintain = partNoAttributeMaintain;
    }

//    @Transient
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 4 /*scale*/)
    @Column(name = "weight", nullable = false, precision = 10, scale = 4)
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

//    @Transient
    @NotNull
    @Digits(integer = 10 /*precision*/, fraction = 3 /*scale*/)
    @Column(name = "tolerance", nullable = false, precision = 10, scale = 3)
    public BigDecimal getTolerance() {
        return tolerance;
    }

    public void setTolerance(BigDecimal tolerance) {
        this.tolerance = tolerance;
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "assy_lead_time", precision = 10, scale = 1)
    public BigDecimal getAssyLeadTime() {
        return this.assyLeadTime;
    }

    public void setAssyLeadTime(BigDecimal assyLeadTime) {
        this.assyLeadTime = autoFixScale(assyLeadTime, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "packing_lead_time", precision = 10, scale = 1)
    public BigDecimal getPackingLeadTime() {
        return this.packingLeadTime;
    }

    public void setPackingLeadTime(BigDecimal packingLeadTime) {
        this.packingLeadTime = autoFixScale(packingLeadTime, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "productionWt", precision = 10, scale = 1)
    public BigDecimal getProductionWt() {
        return productionWt;
    }

    public void setProductionWt(BigDecimal productionWt) {
        this.productionWt = autoFixScale(productionWt, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "setup_time", precision = 10, scale = 1)
    public BigDecimal getSetupTime() {
        return setupTime;
    }

    public void setSetupTime(BigDecimal setupTime) {
        this.setupTime = autoFixScale(setupTime, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "assy_to_t1", precision = 10, scale = 1)
    public BigDecimal getAssyToT1() {
        return assyToT1;
    }

    public void setAssyToT1(BigDecimal assyToT1) {
        this.assyToT1 = autoFixScale(assyToT1, 1);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "t2_to_packing", precision = 10, scale = 1)
    public BigDecimal getT2ToPacking() {
        return t2ToPacking;
    }

    public void setT2ToPacking(BigDecimal t2ToPacking) {
        this.t2ToPacking = autoFixScale(t2ToPacking, 1);
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

    @Digits(integer = 10 /*precision*/, fraction = 2 /*scale*/)
    @Column(name = "assy_kanban_time", precision = 10, scale = 2)
    public BigDecimal getAssyKanbanTime() {
        return assyKanbanTime;
    }

    public void setAssyKanbanTime(BigDecimal assyKanbanTime) {
        this.assyKanbanTime = autoFixScale(assyKanbanTime, 2);
    }

    @Digits(integer = 10 /*precision*/, fraction = 2 /*scale*/)
    @Column(name = "packing_kanban_time", precision = 10, scale = 2)
    public BigDecimal getPackingKanbanTime() {
        return packingKanbanTime;
    }

    public void setPackingKanbanTime(BigDecimal packingKanbanTime) {
        this.packingKanbanTime = autoFixScale(packingKanbanTime, 2);
    }

    @Digits(integer = 10 /*precision*/, fraction = 1 /*scale*/)
    @Column(name = "clean_panel_and_assembly", precision = 10, scale = 1)
    public BigDecimal getCleanPanelAndAssembly() {
        return cleanPanelAndAssembly;
    }

    public void setCleanPanelAndAssembly(BigDecimal cleanPanelAndAssembly) {
        this.cleanPanelAndAssembly = autoFixScale(cleanPanelAndAssembly, 1);
    }

    private BigDecimal autoFixScale(BigDecimal d, int scale) {
        return d == null ? null : d.setScale(scale, RoundingMode.HALF_UP);
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

    @NotAudited
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "worktime", orphanRemoval = true)
    public List<WorktimeFormulaSetting> getWorktimeFormulaSettings() {
        return this.worktimeFormulaSettings;
    }

    public void setWorktimeFormulaSettings(List<WorktimeFormulaSetting> worktimeFormulaSettings) {
        this.worktimeFormulaSettings = worktimeFormulaSettings;
    }

    @NotAudited
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "worktime")
    public List<BwField> getBwFields() {
        return bwField;
    }

    public void setBwFields(List<BwField> bwFields) {
        this.bwField = bwFields;
    }

//  Default formula column caculate
    public void setDefaultProductWt() {
        BigDecimal defaultValue = notEmpty(totalModule).add(notEmpty(cleanPanel))
                .add(notEmpty(assy)).add(notEmpty(t1)).add(notEmpty(t2))
                .add(notEmpty(t3)).add(notEmpty(t4)).add(notEmpty(packing)).add(notEmpty(upBiRi))
                .add(notEmpty(downBiRi)).add(notEmpty(biCost)).add(notEmpty(vibration)).add(notEmpty(hiPotLeakage))
                .add(notEmpty(coldBoot)).add(notEmpty(warmBoot));

        this.setProductionWt(defaultValue);
    }

    public void setDefaultSetupTime() {
        BigDecimal defaultValue = BigDecimal.ZERO
                .add(notEmpty(totalModule).compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : new BigDecimal(5))
                .add((notEmpty(assy)).compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : new BigDecimal(25))
                .add(notEmpty(t1).compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : new BigDecimal(10))
                .add(notEmpty(t2).compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : new BigDecimal(10))
                .add(notEmpty(t3).compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : new BigDecimal(5))
                .add(notEmpty(t4).compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : new BigDecimal(5))
                .add((notEmpty(packing)).compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : new BigDecimal(15));
        this.setSetupTime(defaultValue);
    }

    public void setDefaultAssyToT1() {
        BigDecimal defaultValue = notEmpty(cleanPanel).add(notEmpty(assy).add(notEmpty(totalModule))).add(notEmpty(t1))
                .add(notEmpty(upBiRi)).add(notEmpty(vibration))
                .add(notEmpty(hiPotLeakage)).add(notEmpty(coldBoot)).add(notEmpty(warmBoot));
        this.setAssyToT1(defaultValue);
    }

    public void setDefaultT2ToPacking() {
        BigDecimal defaultValue = notEmpty(t2)
                .add(notEmpty(t3)).add(notEmpty(t4)).add(notEmpty(packing).add(notEmpty(packingLeadTime))).add(notEmpty(downBiRi));
        this.setT2ToPacking(defaultValue);
    }

    public void setDefaultAssyStation() {
        int defaultValue;
        if ((notEmpty(assy).add(notEmpty(totalModule))).compareTo(new BigDecimal(45)) <= 0) {
            defaultValue = 3;
        } else {
            BigDecimal b = (notEmpty(assy).add(notEmpty(totalModule))).divide(new BigDecimal(15), 0, RoundingMode.HALF_UP);
            if (b.compareTo(new BigDecimal(6)) >= 0) {
                defaultValue = 6;
            } else {
                defaultValue = b.intValue();
            }
        }
        this.setAssyStation(defaultValue);
    }

    public void setDefaultPackingStation() {
        int defaultValue;
        if ((notEmpty(packing).add(notEmpty(packingLeadTime))).compareTo(new BigDecimal(10)) <= 0) {
            defaultValue = 2;
        } else {
            BigDecimal b = (notEmpty(packing).add(notEmpty(packingLeadTime))).divide(new BigDecimal(5), 0, RoundingMode.HALF_UP);
            if (b.compareTo(new BigDecimal(6)) >= 0) {
                defaultValue = 6;
            } else {
                defaultValue = b.intValue();
            }
        }
        this.setPackingStation(defaultValue);
    }

    public void setDefaultAssyKanbanTime() {
        BigDecimal defaultValue = notEmpty(assy)
                .divide(new BigDecimal(assyStation), 2, RoundingMode.HALF_UP);
        this.setAssyKanbanTime(defaultValue);

    }

    public void setDefaultPackingKanbanTime() {
        BigDecimal defaultValue = notEmpty(packing)
                .divide(new BigDecimal(packingStation), 2, RoundingMode.HALF_UP);
        this.setPackingKanbanTime(defaultValue);
    }

    public void setDefaultCleanPanelAndAssembly() {
        BigDecimal defaultValue = notEmpty(cleanPanel).add(notEmpty(assy));
        this.setCleanPanelAndAssembly(defaultValue);
    }

    private BigDecimal notEmpty(BigDecimal d) {
        return d == null ? BigDecimal.ZERO : d;
    }

    //Override hashcode and equals will force audit query eager loading the one to many field
    //Still looking for reason.
}
