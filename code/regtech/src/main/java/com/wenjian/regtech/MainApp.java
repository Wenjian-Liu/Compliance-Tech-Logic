package com.wenjian.regtech;

import com.wenjian.regtech.domain.Transaction;
import com.wenjian.regtech.exception.ComplianceViolationException;
import com.wenjian.regtech.service.AmfComplianceService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.wenjian.regtech")
public class MainApp {
	public static void main(String[] args) throws ComplianceViolationException {

		ApplicationContext context = SpringApplication.run(MainApp.class, args);

		AmfComplianceService service = context.getBean(AmfComplianceService.class);

		Transaction tx = new Transaction("123", 50000, "RMB");

		service.validateTransaction(tx);

		System.out.println("Transaction passed compliance check.");
	}
}
