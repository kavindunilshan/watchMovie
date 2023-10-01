package com.example.watchMovie.emailStarergy;

public abstract class EmailSenderStrategy {
     protected String email;
     protected String subject;
     protected String content;

     public EmailSenderStrategy() {
     }

     public EmailSenderStrategy(String email, String subject, String content) {
          this.email = email;
          this.subject = subject;
          this.content = content;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getSubject() {
          return subject;
     }

     public void setSubject(String subject) {
          this.subject = subject;
     }

     public String getContent() {
          return content;
     }

     public void setContent(String content) {
          this.content = content;
     }

     abstract void sendEmail();

     @Override
     public String toString() {
          return "EmailSenderStrategy{" +
                  "email='" + email + '\'' +
                  ", subject='" + subject + '\'' +
                  ", content='" + content + '\'' +
                  '}';
     }
}
