package com.eviro.assessment.grad001.kennymafuna;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class CSVFileParser implements FileParser {

    @Override
    public void parseCSV(File csvFile) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] nextLine;
            int count = 0;
            String[] headers = null;

            while ((nextLine = reader.readNext()) != null) {
                if (count == 0) {
                    headers = nextLine; // Store headers in an array
                } else {
                    Map<String, String> entryMap = new HashMap<>();
                    for (int i = 0; i < nextLine.length; i++) {
                        entryMap.put(headers[i], nextLine[i]); // Map header-value pairs
                    }
                    entries.add(entryMap); // Add the map to the entries list
                }
                count++;
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

    }

    @Override
    public File convertCSVDataToImage(String base64ImageData, String imageFormat, String name) {
        try {
            byte[] imageData = Base64.getDecoder().decode(base64ImageData);

            // Get the program directory
            Path programDir = Paths.get("").toAbsolutePath();

            // Create a new file in the program directory
            File imageFile = new File(
                    programDir.toString()+"/images",
                    name.replace(" ","") +"."+ imageFormat.split("/")[1]
            );

            FileOutputStream fos = new FileOutputStream(imageFile);
            fos.write(imageData);
            fos.close();

            return imageFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public URI createImageLink(File fileImage) {
        try {
            String[] nameParts = fileImage.getName().split("_");

            // Extract the name and surname from the file name
            String name = nameParts[0];
            
            String surname = nameParts[1].split("\\.")[0];

            // Construct the base URI for your application
            URI baseUri = new URI("http://localhost:8080/v1/api/image/");

            // Create the complete image URI by appending the name and surname
            URI imageUri = baseUri.resolve(name + "/" + surname);

            return imageUri;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null; // Return null if an error occurs
    }
}
