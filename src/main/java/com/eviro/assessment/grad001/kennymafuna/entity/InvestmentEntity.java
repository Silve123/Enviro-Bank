package com.eviro.assessment.grad001.kennymafuna.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "Investment")
public class InvestmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "investmentId")
    private int investmentId;

    @Column(name = "USERID")
    private int userId;

    @Column(name = "PRODUCTID")
    private int productId;

    public  InvestmentEntity(){}
    public InvestmentEntity(Map<String, String> investmentMap) {
        this.userId = Integer.parseInt(investmentMap.get("userId"));
        this.productId = Integer.parseInt(investmentMap.get("productId"));
    }

    public int getInvestmentId() {
        return investmentId;
    }

    public int getProductId() {
        return productId;
    }

    public int getUserId() {
        return userId;
    }
}