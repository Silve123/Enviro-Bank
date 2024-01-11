package com.eviro.assessment.grad001.kennymafuna.fileParser;

import com.eviro.assessment.grad001.kennymafuna.entity.InvestmentEntity;
import com.eviro.assessment.grad001.kennymafuna.entity.ProductEntity;
import com.eviro.assessment.grad001.kennymafuna.entity.UserEntity;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CSVFileParser implements FileParser {

    private void universalParser(String type, File csvFile) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] headers = reader.readNext();

            String[] line;
            while ((line = reader.readNext()) != null) {
                if (Objects.equals(type, "users")) {
                    UserEntity user = createUserObject(headers, line);
                    users.add(user);
                } else if (Objects.equals(type, "products")) {
                    ProductEntity product = createProductObject(headers, line);
                    products.add(product);
                } else if (Objects.equals(type, "investments")) {
                    InvestmentEntity investment = createInvestmentObject(headers, line);
                    investments.add(investment);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    private UserEntity createUserObject(String[] headers, String[] line) {
        Map<String, String> lineMap = new HashMap<>();
        for (int x = 0; x < headers.length; x++){
            lineMap.put(headers[x], line[x]);
        }
        return new UserEntity(lineMap);
    }

    private ProductEntity createProductObject(String[] headers, String[] line) {
        Map<String, String> lineMap = new HashMap<>();
        for (int x = 0; x < headers.length; x++){
            lineMap.put(headers[x], line[x]);
        }
        return new ProductEntity(lineMap);
    }

    private InvestmentEntity createInvestmentObject(String[] headers, String[] line) {
        Map<String, String> lineMap = new HashMap<>();
        for (int x = 0; x < headers.length; x++){
            lineMap.put(headers[x], line[x]);
        }
        return new InvestmentEntity(lineMap);
    }
    @Override
    public void parseUserCSV(File csvFile) {
        universalParser("users", csvFile);
    }

    @Override
    public void parseInvestmentCSV(File csvFile) {
        universalParser("investments", csvFile);
    }

    @Override
    public void parseProductsCSV(File csvFile) {
        universalParser("products",csvFile);
    }

}
