package com.example.sweater.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.protocol}")
    private String protocol;

    @Value("${mail.smtp.auth}")
    private String smtpAuth;

    @Value("${mail.smtp.starttls.enable}")
    private String starttls;


    @Value("${mail.debug}")
    private String debug;


    @Bean
    public JavaMailSender getMailSender() {

        /*
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);


        Properties properties = mailSender.getJavaMailProperties();
        properties.setProperty("mail.transport.protocol", protocol);
        properties.put("mail.smtp.auth", smtpAuth);
        properties.put("mail.smtp.starttls.enable", starttls);


        properties.setProperty("mail.debug", debug);

        */

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("nikita.nikitinov@gmail.com");
        mailSender.setPassword("1ghjuhfvvfN");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
