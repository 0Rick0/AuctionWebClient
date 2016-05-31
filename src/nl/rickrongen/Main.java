package nl.rickrongen;

import nl.rickrongen.auction.auction.*;
import nl.rickrongen.auction.registration.Registration;
import nl.rickrongen.auction.registration.RegistrationService;
import nl.rickrongen.auction.shared.User;

import javax.xml.namespace.QName;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final QName AUCTION_NAME = new QName("http://web.auction/", "AuctionService");
    private static final QName REGISTERATION_NAME = new QName("http://web.auction/", "RegistrationService");

    public static void main(String[] args) {
        URL wsdlURLauction = AuctionService.WSDL_LOCATION;
        URL wsdlURLregistration = RegistrationService.WSDL_LOCATION;



        AuctionService ass = new AuctionService(wsdlURLauction, AUCTION_NAME);
        Auction auctionPort = ass.getAuctionPort();

        RegistrationService ss = new RegistrationService(wsdlURLregistration, REGISTERATION_NAME);
        Registration registrationPort = ss.getRegistrationPort();

        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Commands: \n\t" + String.join("\n\t",
                "ADDUSER {email}\t\t\t\t\t-\tAdd User",
                "GETUSER {email}\t\t\t\t\t-\tGet user",
                "GETITEM {id}\t\t\t\t\t-\tGet item with id",
                "FINDITEM {descr}\t\t\t\t-\tGet items with description",
                "BID {amount}\t\t\t\t\t-\tCreate new bid with last user and last item",
                "OFFER {category} {description}\t-\tOffer a new item with last user",
                "REVOKE\t\t\t\t\t\t\t-\tRevoke last item",
                "EXIT\t\t\t\t\t\t\t-\tClose program"));
        System.out.println("");

        User lastUser = null;
        Item lastItem = null;



        while(running){
            String input = scanner.nextLine();
            String[] split = input.split(" ");
            String command = split[0].toUpperCase();
            try {
                switch (command) {
                    case "EXIT":
                        if(!validateInput(split,1)){
                            System.out.println("Invalid arguments");
                            break;
                        }
                        running=false;
                        break;
                    case "ADDUSER":
                        if(!validateInput(split,2)){
                            System.out.println("Invalid arguments");
                            break;
                        }
                        String addEmail = split[1];
                        lastUser = registrationPort.registerUser(addEmail);
                        System.out.println(lastUser);
                        break;
                    case "GETUSER":
                        if(!validateInput(split,2)){
                            System.out.println("Invalid arguments");
                            break;
                        }
                        String getEmail = split[1];
                        lastUser = registrationPort.getUser(getEmail);
                        System.out.println(lastUser);
                        break;
                    case "GETITEM":
                        if(!validateInput(split,2)){
                            System.out.println("Invalid arguments");
                            break;
                        }
                        long getItemId = Long.valueOf(split[1]);
                        if(getItemId<0){
                            System.out.println("Input not valid!");
                            break;
                        }
                        lastItem = auctionPort.getItem(getItemId);
                        System.out.println(lastItem);
                        break;
                    case "FINDITEM":
                        if(!validateInput(split,2)){
                            System.out.println("Invalid arguments");
                            break;
                        }
                        String description = split[1];
                        List<Item> items = auctionPort.findItemByDescription(description);
                        for (Item i :
                                items) {
                            System.out.println(i + "\n");
                        }
                        if(items.size()>0)
                            lastItem = items.get(0);
                        else
                            System.out.println("No items found!");
                        break;
                    case "BID":
                        if(!validateInput(split,2)){
                            System.out.println("Invalid arguments");
                            break;
                        }
                        if(lastItem==null){
                            System.out.println("Last item not set!");
                            break;
                        }
                        if(lastUser == null){
                            System.out.println("Last user not set!");
                            break;
                        }
                        long amount = Long.valueOf(split[1]);
                        Money bida = new Money();
                        bida.setCents(amount);
                        bida.setCurrency("EUR");
                        Bid bid = auctionPort.newBid(lastItem,lastUser,bida);
                        System.out.println(bid);
                        break;
                    case "OFFER":
                        if(!validateInput(split,3)){
                            System.out.println("Invalid arguments");
                            break;
                        }
                        if(lastUser == null){
                            System.out.println("Last user not set!");
                            break;
                        }
                        String cat = split[1];
                        String omsch = split[2];
                        Item offerItem = auctionPort.offerItem(lastUser,new Category(cat),omsch);
                        System.out.println(offerItem);
                        break;
                    case "REVOKE":
                        if(!validateInput(split,1)){
                            System.out.println("Invalid arguments");
                            break;
                        }
                        if(lastItem == null){
                            System.out.println("Last item not set!");
                            break;
                        }
                        System.out.println(auctionPort.revokeItem(lastItem)?"Removed!":"Not Removed!");
                        break;
                }
            }catch (Exception ex){
                System.out.println(ex);
                System.out.println("Can't execute action!");
            }
        }

    }

    private static boolean validateInput(String[] input, int size){
        return input.length == size;
    }
}
