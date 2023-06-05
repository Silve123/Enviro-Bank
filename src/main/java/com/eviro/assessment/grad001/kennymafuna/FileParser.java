package com.eviro.assessment.grad001.kennymafuna;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface FileParser {
    public List<Map<String, String>> entries = new ArrayList<>();

    void parseCSV(File csvFile);

    File convertCSVDataToImage(String base64ImageData, String imageFormat, String name);
    URI createImageLink(File fileImage);

}
