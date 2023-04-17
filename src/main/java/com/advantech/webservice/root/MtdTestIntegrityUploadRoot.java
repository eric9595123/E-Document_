//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 所產生 
// 請參閱 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2021.12.08 於 09:04:01 AM CST 
//
package com.advantech.webservice.root;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * anonymous complex type 的 Java 類別.
 *
 * <p>
 * 下列綱要片段會指定此類別中包含的預期內容.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="METHOD">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="MTD_TEST_INTEGRITY">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DUT_PART_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="STATION_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="TOTALSTATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="TOTALTESTITEM" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "method",
    "mtdtestintegrity",
    "extdept"
})
@XmlRootElement(name = "root")
public class MtdTestIntegrityUploadRoot {

    @XmlElement(name = "METHOD", required = true)
    protected MtdTestIntegrityUploadRoot.METHOD method;
    @XmlElement(name = "MTD_TEST_INTEGRITY", required = true)
    protected MtdTestIntegrityUploadRoot.MTDTESTINTEGRITY mtdtestintegrity;
    @XmlElement(name = "EXT_DEPT", required = true)
    protected String extdept = "PD03";

    public MtdTestIntegrityUploadRoot() {
        this.method = new MtdTestIntegrityUploadRoot.METHOD();
        this.mtdtestintegrity = new MtdTestIntegrityUploadRoot.MTDTESTINTEGRITY();
    }

    /**
     * 取得 method 特性的值.
     *
     * @return possible object is {@link Root.METHOD }
     *
     */
    public MtdTestIntegrityUploadRoot.METHOD getMETHOD() {
        return method;
    }

    /**
     * 設定 method 特性的值.
     *
     * @param value allowed object is {@link Root.METHOD }
     *
     */
    public void setMETHOD(MtdTestIntegrityUploadRoot.METHOD value) {
        this.method = value;
    }

    /**
     * 取得 mtdtestintegrity 特性的值.
     *
     * @return possible object is {@link Root.MTDTESTINTEGRITY }
     *
     */
    public MtdTestIntegrityUploadRoot.MTDTESTINTEGRITY getMTDTESTINTEGRITY() {
        return mtdtestintegrity;
    }

    /**
     * 設定 mtdtestintegrity 特性的值.
     *
     * @param value allowed object is {@link Root.MTDTESTINTEGRITY }
     *
     */
    public void setMTDTESTINTEGRITY(MtdTestIntegrityUploadRoot.MTDTESTINTEGRITY value) {
        this.mtdtestintegrity = value;
    }

    public String getExtdept() {
        return extdept;
    }

    public void setExtdept(String extdept) {
        this.extdept = extdept;
    }

    /**
     * <p>
     * anonymous complex type 的 Java 類別.
     *
     * <p>
     * 下列綱要片段會指定此類別中包含的預期內容.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class METHOD {

        @XmlAttribute(name = "ID", required = true)
        protected String id = "Advantech.ETL.ETL.BLL.TxMtdTestIntegrity001";

        /**
         * 取得 id 特性的值.
         *
         * @return possible object is {@link String }
         *
         */
        public String getID() {
            return id;
        }

        /**
         * 設定 id 特性的值.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setID(String value) {
            this.id = value;
        }

    }

    /**
     * <p>
     * anonymous complex type 的 Java 類別.
     *
     * <p>
     * 下列綱要片段會指定此類別中包含的預期內容.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DUT_PART_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="STATION_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="TOTALSTATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="TOTALTESTITEM" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "dutpartno",
        "stationname",
        "totalstate",
        "totaltestitem"
    })
    public static class MTDTESTINTEGRITY {

        @XmlElement(name = "DUT_PART_NO", required = true)
        protected String dutpartno;
        @XmlElement(name = "STATION_NAME", required = true)
        protected String stationname;
        @XmlElement(name = "TOTALSTATE", required = true)
        protected String totalstate;
        @XmlElement(name = "TOTALTESTITEM", required = true)
        protected String totaltestitem;

        /**
         * 取得 dutpartno 特性的值.
         *
         * @return possible object is {@link String }
         *
         */
        public String getDUTPARTNO() {
            return dutpartno;
        }

        /**
         * 設定 dutpartno 特性的值.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setDUTPARTNO(String value) {
            this.dutpartno = value;
        }

        /**
         * 取得 stationname 特性的值.
         *
         * @return possible object is {@link String }
         *
         */
        public String getSTATIONNAME() {
            return stationname;
        }

        /**
         * 設定 stationname 特性的值.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setSTATIONNAME(String value) {
            this.stationname = value;
        }

        /**
         * 取得 totalstate 特性的值.
         *
         * @return possible object is {@link String }
         *
         */
        public String getTOTALSTATE() {
            return totalstate;
        }

        /**
         * 設定 totalstate 特性的值.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setTOTALSTATE(String value) {
            this.totalstate = value;
        }

        /**
         * 取得 totaltestitem 特性的值.
         *
         * @return possible object is {@link String }
         *
         */
        public String getTOTALTESTITEM() {
            return totaltestitem;
        }

        /**
         * 設定 totaltestitem 特性的值.
         *
         * @param value allowed object is {@link String }
         *
         */
        public void setTOTALTESTITEM(String value) {
            this.totaltestitem = value;
        }

    }

}
