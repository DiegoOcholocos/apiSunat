package com.acme.sunatapi.integration.sendgrid;

import java.io.IOException;

import org.springframework.stereotype.Service;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class SendGridAPI {
   
    public int send(String strfrom, String strto, String strsuject, String body){
        Email from = new Email(strfrom);
        String subject = strsuject;
        Email to = new Email(strto);
        Content content = new Content("text/plain", body);
        Mail mail = new Mail(from, subject, to, content);
        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        int statusCode = 0;
        try {
          request.setMethod(Method.POST);
          request.setEndpoint("mail/send");
          request.setBody(mail.build());
          Response response = sg.api(request);
          statusCode=response.getStatusCode();
        }catch(IOException ex) {
            ex.printStackTrace();
            statusCode=500;
        }
        return statusCode;
    }
}
