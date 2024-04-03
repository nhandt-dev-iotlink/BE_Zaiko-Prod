/////////////////////////////////////////////////////////////////////////////
//
// © 2019 andro Japan. All right reserved.
//
/////////////////////////////////////////////////////////////////////////////

package org.api.config.mail;

import java.util.Properties;

import org.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * 
 * [OVERVIEW] MailConfiguration.
 *
 * @author: (TanDX)
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2022/07/01     (TanDX)     		 Create new
 */
@Configuration
public class MailConfiguration {

    @Autowired
    Environment evn;

    /**
     * Configuration mail server.
     * @return JavaMailSender
     */
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(evn.getProperty(Constants.MAIL_HOST));
        mailSender.setPort(Integer.valueOf(evn.getProperty(Constants.MAIL_PORT)));
        mailSender.setUsername(evn.getProperty(Constants.MAIL_USERNAME));
        mailSender.setPassword(evn.getProperty(Constants.MAIL_PASSWORD));

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
