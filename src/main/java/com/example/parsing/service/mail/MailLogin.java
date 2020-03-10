package com.example.parsing.service.mail;

public class MailLogin {

    private static com.example.parsing.service.mail.MailOut Sender = new com.example.parsing.service.mail.MailOut("webparsing90@gmail.com", "Webparsing1990");

    public static void senderOut(String email) {
        Sender.send("Парсинг окончен!", "Данное уведомление подтверждает окончание парсинга!", "webparsing90@gmail.com", email);
    }

}
