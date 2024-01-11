package com.eviro.assessment.grad001.kennymafuna.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "WithdrawalNotice")
public class WithdrawalNoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "withdrawalNoticeId")
    private int withdrawalNoticeId;

    @Column(name = "PRODUCTID")
    private int productId;

    @Column(name = "noticeDate")
    private Date noticeDate;

    public WithdrawalNoticeEntity(){}
    public WithdrawalNoticeEntity(int productId) {
        this.productId = productId;
        this.noticeDate = new Date();
    }

    public int getWithdrawalNoticeId() {
        return withdrawalNoticeId;
    }

    public int getProductId() {
        return productId;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }
}
