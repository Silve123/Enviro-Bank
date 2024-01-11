package com.eviro.assessment.grad001.kennymafuna.controller;

import com.eviro.assessment.grad001.kennymafuna.entity.InvestmentEntity;
import com.eviro.assessment.grad001.kennymafuna.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/investments")
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;

    @GetMapping("/user/{userId}")
    public List<InvestmentEntity> getInvestmentsByUserId(@PathVariable int userId) {
        return investmentService.getInvestmentsByUserId(userId);
    }
}
