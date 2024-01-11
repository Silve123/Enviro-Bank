package com.eviro.assessment.grad001.kennymafuna.entity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "Product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCTID")
    private int productId;
    @Column(name = "type")
    private String type;
    @Column(name = "name")
    private String name;
    @Column(name = "balance")
    private double balance;

    public ProductEntity(){}
    public ProductEntity(Map<String, String> lineMap) {
        this.type = lineMap.get("type");
        this.name = lineMap.get("name");
        this.balance = Double.parseDouble(lineMap.get("balance"));
    }

    public double getBalance() {
        return balance;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
