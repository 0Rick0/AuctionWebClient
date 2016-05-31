
package nl.rickrongen.auction.registration;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import nl.rickrongen.auction.shared.User;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
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
 * 2016-05-31T11:36:04.491+02:00
 * Generated source version: 3.1.5
 * 
 */
public final class Registration_RegistrationPort_Client {

    private static final QName SERVICE_NAME = new QName("http://web.auction/", "RegistrationService");

    private Registration_RegistrationPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = RegistrationService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        RegistrationService ss = new RegistrationService(wsdlURL, SERVICE_NAME);
        Registration port = ss.getRegistrationPort();  
        
        {
        System.out.println("Invoking getUser...");
        java.lang.String _getUser_arg0 = "";
        User _getUser__return = port.getUser(_getUser_arg0);
        System.out.println("getUser.result=" + _getUser__return);


        }
        {
        System.out.println("Invoking registerUser...");
        java.lang.String _registerUser_arg0 = "";
        User _registerUser__return = port.registerUser(_registerUser_arg0);
        System.out.println("registerUser.result=" + _registerUser__return);


        }

        System.exit(0);
    }

}