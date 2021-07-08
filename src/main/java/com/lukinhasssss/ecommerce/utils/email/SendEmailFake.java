package com.lukinhasssss.ecommerce.utils.email;

import com.lukinhasssss.ecommerce.entities.User;
import org.springframework.stereotype.Component;

@Component
public class SendEmailFake implements EmailSender {

    @Override
    public void sendEmail(User user) {
        /*
            Envia email pro login do usuário
         */
        System.out.println("Email enviado para " + user.getLogin());
    }

}
