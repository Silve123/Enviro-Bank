package com.eviro.assessment.grad001.kennymafuna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

@SpringBootApplication
@ComponentScan(basePackages = "com.eviro.assessment.grad001.kennymafuna")
public class MainClass {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            //Parsing CSV file
            FileParser myFileParser = new CSVFileParser();
            String csvFile = "1672815113084-GraduateDev_AssessmentCsv_Ref003.csv";
            myFileParser.parseCSV(new File(csvFile));
            for (Map<String,String> entry:myFileParser.entries){
                File imageFile = myFileParser.convertCSVDataToImage(
                        entry.get("imageData"),
                        entry.get("imageFormat"),
                        entry.get("name")+"_"+entry.get("surname")
                );
                entry.put("imageLink",  myFileParser.createImageLink(imageFile).toString());
                System.out.println(entry.get("imageLink"));
            }

            //populating and creating the database
            connection = DataBaseManagement.DatabaseConnection.getConnection();
            DataBaseManagement.TableManagement tb =  new DataBaseManagement.TableManagement();
            tb.createTable(connection);
            tb.insertIntoTable(connection,myFileParser.entries);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //closing database the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //Initializing the SpringBootApplication
        SpringApplication.run(MainClass.class);
    }

}
