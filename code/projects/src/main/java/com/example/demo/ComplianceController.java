package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComplianceController {

    @GetMapping("/check")
    public String checkContract(@RequestParam(value = "amount", defaultValue = "0") double amount) {
		if (amount > 1000000) {
			return "【合规提醒】合同金额为：" + amount + "，已超过100万元，必须提交总经理审批！";
		} else if (amount >= 0) {
			return "【合规提醒】合同金额为：" + amount + "，法务部已备案，请按正常流程审批。";
		} else {
			return "请输入有效的合同金额进行合规校验（例如：/check?amount=1200000）";
		}
    }
}
