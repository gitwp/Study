
package com.wangp.ws.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getUserByIdResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="getUserByIdResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="currUser" type="{http://service.ws.wangp.com/}user" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUserByIdResponse", propOrder = {
    "currUser"
})
public class GetUserByIdResponse {

    protected User currUser;

    /**
     * 获取currUser属性的值。
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getCurrUser() {
        return currUser;
    }

    /**
     * 设置currUser属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setCurrUser(User value) {
        this.currUser = value;
    }

}
