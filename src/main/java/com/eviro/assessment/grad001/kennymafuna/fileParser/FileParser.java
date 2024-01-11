package com.eviro.assessment.grad001.kennymafuna.fileParser;

import com.eviro.assessment.grad001.kennymafuna.entity.InvestmentEntity;
import com.eviro.assessment.grad001.kennymafuna.entity.ProductEntity;
import com.eviro.assessment.grad001.kennymafuna.entity.UserEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface FileParser {
    public List<UserEntity> users = new ArrayList<>();
    public List<InvestmentEntity> investments = new ArrayList<>();
    public List<ProductEntity> products = new ArrayList<>();

    void parseUserCSV(File csvFile);

    void parseInvestmentCSV(File csvFile);

    void parseProductsCSV(File csvFile);
}
