package com.example.watchMovie.service;

import com.example.watchMovie.emailStarergy.EmailSenderStrategy;
import com.example.watchMovie.emailStarergy.EmailStrategyService;
import com.example.watchMovie.emailStarergy.SMTPEmailStrategy;
import com.example.watchMovie.emailStarergy.ThirdPartyEmailStrategy;
import com.example.watchMovie.entity.Email;
import com.example.watchMovie.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;

    private EmailStrategyService service;

    public Email createEmail(Email email) {
        if (email.isSecure()) {
            service = new EmailStrategyService(new SMTPEmailStrategy
                    (email.getEmail(), email.getSubject(), email.getContent()));
        } else {
            service = new EmailStrategyService(new ThirdPartyEmailStrategy
                    (email.getEmail(), email.getSubject(), email.getContent()));
        }
        try {
            service.sendConfirm();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emailRepository.save(email);
    }

    public List<Email> getEmailList() {
        return emailRepository.findAll();
    }

    public Email getEmailById(int id) {
        return emailRepository.findById(id).orElse(null);
    }

    public String deleteById(int  id) {
        emailRepository.deleteById(id);
        return "Email " + id + " is deleted.";
    }

}
