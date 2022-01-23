package com.fedex.automation.Utils;

import com.fedex.automation.Constants.GlobalConstants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class ConfigFileProvider {
    private static Properties properties;
    BufferedReader reader;

    public ConfigFileProvider(){
        try {

            reader = new BufferedReader(new FileReader(GlobalConstants.getConfigFilePath()));
            properties = new Properties();
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String,String> getPropertiesValues(){
        return properties.entrySet().stream().collect(
                Collectors.toMap(
                        e -> String.valueOf(e.getKey()),
                        e -> String.valueOf(e.getValue()),
                        (prev,next) -> next,HashMap::new
                )
        );
    }
}
