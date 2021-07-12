package com.lukinhasssss.ecommerce.utils.email;

import com.lukinhasssss.ecommerce.entities.User;
import org.springframework.stereotype.Component;

@Component
public class SendEmailFake implements EmailSender {

    @Override
    public void sendEmail(String message) {
        /*
            Envia email
         */
        System.out.println(message);
    }

}
