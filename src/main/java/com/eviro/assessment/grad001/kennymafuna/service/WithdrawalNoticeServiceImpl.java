package com.eviro.assessment.grad001.kennymafuna.service;

import com.eviro.assessment.grad001.kennymafuna.entity.WithdrawalNoticeEntity;
import com.eviro.assessment.grad001.kennymafuna.repository.WithdrawalNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalNoticeServiceImpl implements WithdrawalNoticeService {

    @Autowired
    private WithdrawalNoticeRepository withdrawalNoticeRepository;

    @Override
    public void createWithdrawalNotice(int productId) {
        WithdrawalNoticeEntity withdrawalNotice = new WithdrawalNoticeEntity(productId);
        withdrawalNoticeRepository.save(withdrawalNotice);
    }
}
