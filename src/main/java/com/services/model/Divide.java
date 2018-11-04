
package com.services.model;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="intA" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="intB" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "intA",
    "intB"
})
@XmlRootElement(name = "Divide")
@Generated(value = "com.sun.tools.xjc.Driver", date = "2018-10-19T11:52:32-05:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
public class Divide {

    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-10-19T11:52:32-05:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected int intA;
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-10-19T11:52:32-05:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    protected int intB;

    /**
     * Gets the value of the intA property.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-10-19T11:52:32-05:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public int getIntA() {
        return intA;
    }

    /**
     * Sets the value of the intA property.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-10-19T11:52:32-05:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setIntA(int value) {
        this.intA = value;
    }

    /**
     * Gets the value of the intB property.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-10-19T11:52:32-05:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public int getIntB() {
        return intB;
    }

    /**
     * Sets the value of the intB property.
     * 
     */
    @Generated(value = "com.sun.tools.xjc.Driver", date = "2018-10-19T11:52:32-05:00", comments = "JAXB RI vhudson-jaxb-ri-2.1-2")
    public void setIntB(int value) {
        this.intB = value;
    }

}
