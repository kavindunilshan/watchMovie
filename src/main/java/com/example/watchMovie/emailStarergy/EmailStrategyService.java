package com.example.watchMovie.emailStarergy;

import java.io.IOException;

// Context class
public class EmailStrategyService {
    private EmailSenderStrategy sender;

    public EmailStrategyService(EmailSenderStrategy sender) {
        this.sender = sender;
    }

    public void sendConfirm() throws IOException {
        sender.sendEmail();
    }

}
