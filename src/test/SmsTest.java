/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Sahnoun Yusuf
 */
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import services.UserServices;

public class SmsTest {
    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    public static final String ACCOUNT_SID = "ACb6048bcc447741b1155a12ae9e46d19d";
    public static final String AUTH_TOKEN = "e185c70b289adee6d018dc097a48ac09";
    
    

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+21656207034"),
                new com.twilio.type.PhoneNumber("+14233972171"),
                "Where's Wallace?")
            .create();

        System.out.println(message.getSid());
    }
}
