package com.eviro.assessment.grad001.kennymafuna;

import com.eviro.assessment.grad001.kennymafuna.entity.ProductEntity;
import com.eviro.assessment.grad001.kennymafuna.entity.InvestmentEntity;
import com.eviro.assessment.grad001.kennymafuna.entity.UserEntity;
import com.eviro.assessment.grad001.kennymafuna.entity.WithdrawalNoticeEntity;
import com.eviro.assessment.grad001.kennymafuna.repository.WithdrawalNoticeRepository;
import com.eviro.assessment.grad001.kennymafuna.service.InvestmentService;
import com.eviro.assessment.grad001.kennymafuna.service.ProductService;
import com.eviro.assessment.grad001.kennymafuna.service.UserService;
import com.eviro.assessment.grad001.kennymafuna.service.WithdrawalNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/withdrawal-notices")
public class WithdrawalNoticeController {

    @Autowired
    private WithdrawalNoticeService withdrawalNoticeService;

    @Autowired
    private WithdrawalNoticeRepository withdrawalNoticeRepository;

    @Autowired
    private  UserService userService;

    @Autowired
    private InvestmentService investmentService;

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<WithdrawalNoticeEntity> getAllWithdrawalNotices() {
        return withdrawalNoticeRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createWithdrawalNotice(@RequestParam int productId, int withdrawalAmount) {
        ProductEntity product = productService.getProductById(productId);

        if (product == null) {
            return ResponseEntity.badRequest().body("Product not found");
        }

        InvestmentEntity investment = investmentService.getInvestmentByProductId(productId);

        if (investment == null) {
            return ResponseEntity.badRequest().body("Investment not found");
        }

        int userId = investment.getUserId();

        UserEntity user = userService.getUserById(userId);

        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        int investorAge = user.getAge();

        if ("RETIREMENT".equals(product.getType()) && investorAge <= 65) {
            return ResponseEntity.badRequest().body("Investor's age must be greater than 65 for RETIREMENT product");
        }

        double withdrawalPercentage = 0.9; // 90%
        if (withdrawalAmount > product.getBalance() * withdrawalPercentage) {
            return ResponseEntity.badRequest().body("Withdrawal amount exceeds 90% of the current balance");
        }

        withdrawalNoticeService.createWithdrawalNotice(productId);

        return ResponseEntity.ok("Withdrawal notice created successfully");
    }
}
