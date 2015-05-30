
package com.wangp.ws.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import com.wangp.ws.service.ObjectFactory;
import com.wangp.ws.service.User;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IMyService1", targetNamespace = "http://service.ws.wangp.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IMyService1 {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "add", targetNamespace = "http://service.ws.wangp.com/", className = "com.wangp.ws.service.Add")
    @ResponseWrapper(localName = "addResponse", targetNamespace = "http://service.ws.wangp.com/", className = "com.wangp.ws.service.AddResponse")
    @Action(input = "http://service.ws.wangp.com/IMyService1/addRequest", output = "http://service.ws.wangp.com/IMyService1/addResponse")
    public int add(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

    /**
     * 
     * @param userId
     * @return
     *     returns com.wangp.ws.service.User
     */
    @WebMethod
    @WebResult(name = "currUser", targetNamespace = "")
    @RequestWrapper(localName = "getUserById", targetNamespace = "http://service.ws.wangp.com/", className = "com.wangp.ws.service.GetUserById")
    @ResponseWrapper(localName = "getUserByIdResponse", targetNamespace = "http://service.ws.wangp.com/", className = "com.wangp.ws.service.GetUserByIdResponse")
    @Action(input = "http://service.ws.wangp.com/IMyService1/getUserByIdRequest", output = "http://service.ws.wangp.com/IMyService1/getUserByIdResponse")
    public User getUserById(
        @WebParam(name = "userId", targetNamespace = "")
        int userId);

}
