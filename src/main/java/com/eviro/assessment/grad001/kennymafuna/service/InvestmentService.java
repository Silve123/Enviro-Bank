package com.eviro.assessment.grad001.kennymafuna.service;

import com.eviro.assessment.grad001.kennymafuna.entity.InvestmentEntity;

import java.util.List;

public interface InvestmentService {
    List<InvestmentEntity> getInvestmentsByUserId(int userId);

    InvestmentEntity getInvestmentByProductId(int productId);
}
