package com.eviro.assessment.grad001.kennymafuna.service;

import com.eviro.assessment.grad001.kennymafuna.entity.InvestmentEntity;
import com.eviro.assessment.grad001.kennymafuna.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentServiceImpl implements InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

    @Override
    public List<InvestmentEntity> getInvestmentsByUserId(int userId) {
        return investmentRepository.findByUserId(userId);
    }

    @Override
    public InvestmentEntity getInvestmentByProductId(int productId) {
        return investmentRepository.findByProductId(productId);
    }
}
