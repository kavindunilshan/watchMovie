package com.example.watchMovie.emailStarergy;

public class ThirdPartyEmailStrategy extends EmailSenderStrategy {

    public ThirdPartyEmailStrategy() {
    }

    public ThirdPartyEmailStrategy(String email, String subject, String content) {
        super(email, subject, content);
    }

    @Override
    public void sendEmail() {

    }


}
