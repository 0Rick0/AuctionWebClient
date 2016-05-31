package nl.rickrongen.auction.registration;

import nl.rickrongen.auction.shared.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.5
 * 2016-05-31T11:36:04.558+02:00
 * Generated source version: 3.1.5
 * 
 */
@WebService(targetNamespace = "http://web.auction/", name = "Registration")
@XmlSeeAlso({ObjectFactory.class})
public interface Registration {

    @WebMethod
    @Action(input = "http://web.auction/Registration/getUserRequest", output = "http://web.auction/Registration/getUserResponse")
    @RequestWrapper(localName = "getUser", targetNamespace = "http://web.auction/", className = "nl.rickrongen.auction.registration.GetUser")
    @ResponseWrapper(localName = "getUserResponse", targetNamespace = "http://web.auction/", className = "nl.rickrongen.auction.registration.GetUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    User getUser(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://web.auction/Registration/registerUserRequest", output = "http://web.auction/Registration/registerUserResponse")
    @RequestWrapper(localName = "registerUser", targetNamespace = "http://web.auction/", className = "nl.rickrongen.auction.registration.RegisterUser")
    @ResponseWrapper(localName = "registerUserResponse", targetNamespace = "http://web.auction/", className = "nl.rickrongen.auction.registration.RegisterUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    User registerUser(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}
