package com.eviro.assessment.grad001.kennymafuna.repository;

import com.eviro.assessment.grad001.kennymafuna.entity.InvestmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentRepository extends JpaRepository<InvestmentEntity, Integer> {
    List<InvestmentEntity> findByUserId(int userId);

    InvestmentEntity findByProductId(int productId);
}
