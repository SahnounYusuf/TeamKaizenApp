/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import entities.User;
import java.sql.SQLException;

/**
 *
 * @author Sahnoun Yusuf
 */
public class SmsService {

    public static final String ACCOUNT_SID = "ACb6048bcc447741b1155a12ae9e46d19d";
    public static final String AUTH_TOKEN = "e185c70b289adee6d018dc097a48ac09";

    public SmsService(String userPhoneNumber) throws SQLException {
        UserServices us = new UserServices();
        String userPassword = us.retriveUserPasswordByPhone(userPhoneNumber);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+216" + userPhoneNumber),
                new com.twilio.type.PhoneNumber("+14233972171"),
                "your password is: "+userPassword)
                .create();

        System.out.println(message.getSid());
    }

}
