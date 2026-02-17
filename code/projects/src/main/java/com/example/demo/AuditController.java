package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditController {

    @GetMapping("/audit")
    public String advancedAudit(@RequestParam double amount, @RequestParam int days) {
		if (amount > 1000000 && days <3) {
			return "警报：金额" + amount + "较大，但审核仅用时"+ days + "天，请重新核实尽调报告！";
		}
		return "审核时长合规。";
    }
}
