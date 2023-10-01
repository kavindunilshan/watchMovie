package com.example.watchMovie.emailStarergy;

public class EmailStrategyService {
    EmailSenderStrategy sender;

    public EmailStrategyService(EmailSenderStrategy sender) {
        this.sender = sender;
    }

    public void sendConfirm() {
        sender.sendEmail();
    }

}
