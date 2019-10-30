package com.shukai.vhrserver.util;

import com.shukai.vhrserver.bean.Employee;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class EmailRunnable implements Runnable {
    private Employee employee;
    private JavaMailSender javaMailSender;
    private TemplateEngine templateEngine;
    private String emailAddress;

    public EmailRunnable(Employee employee, JavaMailSender javaMailSender, TemplateEngine templateEngine, String emailAddress) {
        this.employee = employee;
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
        this.emailAddress = emailAddress;
    }

    @Override
    public void run() {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(emailAddress);
            helper.setTo(employee.getEmail());
            helper.setSubject("Sekay-Z集团：通知");
            Context ctx=new Context();
            ctx.setVariable("name", employee.getName());
            ctx.setVariable("workID", employee.getWorkID());
            ctx.setVariable("contractTerm", employee.getContractTerm());
            ctx.setVariable("beginContract", employee.getBeginContract());
            ctx.setVariable("endContract", employee.getEndContract());
            ctx.setVariable("departmentName", employee.getDepartmentName());
            ctx.setVariable("posName", employee.getPosName());
            String mail = templateEngine.process("email.html", ctx);
            helper.setText(mail,true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.out.println("发送失败");
        }
    }
}
