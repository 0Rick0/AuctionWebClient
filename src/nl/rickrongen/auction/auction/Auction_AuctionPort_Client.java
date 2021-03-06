
package nl.rickrongen.auction.auction;

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
 * 2016-05-31T11:36:14.135+02:00
 * Generated source version: 3.1.5
 * 
 */
public final class Auction_AuctionPort_Client {

    private static final QName SERVICE_NAME = new QName("http://web.auction/", "AuctionService");

    private Auction_AuctionPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = AuctionService.WSDL_LOCATION;
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
      
        AuctionService ss = new AuctionService(wsdlURL, SERVICE_NAME);
        Auction port = ss.getAuctionPort();  
        
        {
        System.out.println("Invoking newBid...");
        nl.rickrongen.auction.auction.Item _newBid_arg0 = null;
        User _newBid_arg1 = null;
        nl.rickrongen.auction.auction.Money _newBid_arg2 = null;
        nl.rickrongen.auction.auction.Bid _newBid__return = port.newBid(_newBid_arg0, _newBid_arg1, _newBid_arg2);
        System.out.println("newBid.result=" + _newBid__return);


        }
        {
        System.out.println("Invoking offerItem...");
        User _offerItem_arg0 = null;
        nl.rickrongen.auction.auction.Category _offerItem_arg1 = null;
        java.lang.String _offerItem_arg2 = "";
        nl.rickrongen.auction.auction.Item _offerItem__return = port.offerItem(_offerItem_arg0, _offerItem_arg1, _offerItem_arg2);
        System.out.println("offerItem.result=" + _offerItem__return);


        }
        {
        System.out.println("Invoking revokeItem...");
        nl.rickrongen.auction.auction.Item _revokeItem_arg0 = null;
        boolean _revokeItem__return = port.revokeItem(_revokeItem_arg0);
        System.out.println("revokeItem.result=" + _revokeItem__return);


        }
        {
        System.out.println("Invoking findItemByDescription...");
        java.lang.String _findItemByDescription_arg0 = "";
        java.util.List<nl.rickrongen.auction.auction.Item> _findItemByDescription__return = port.findItemByDescription(_findItemByDescription_arg0);
        System.out.println("findItemByDescription.result=" + _findItemByDescription__return);


        }
        {
        System.out.println("Invoking getItem...");
        long _getItem_arg0 = 0;
        nl.rickrongen.auction.auction.Item _getItem__return = port.getItem(_getItem_arg0);
        System.out.println("getItem.result=" + _getItem__return);


        }

        System.exit(0);
    }

}
