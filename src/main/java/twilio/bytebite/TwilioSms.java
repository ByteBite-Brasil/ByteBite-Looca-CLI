/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package twilio.bytebite;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author ViniciusJesus
 */
public class TwilioSms {
    private static final String ACCOUNT_SID = "AC5e7b5e7f979340aae93c8ba952eccbbc";
    private static final String AUTH_TOKEN = "c171eb48dd1e4709e2c84a8399b5d75b";

    public TwilioSms() {
       Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }
    
    public void enviaSms(String messageInfo){
        try{
            Message message = Message
                    .creator(
                            new PhoneNumber("+5511996402257"),
                            new PhoneNumber("+16202930474"),
                            messageInfo
                    )
                    .create();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
