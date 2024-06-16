package com.arcanum.compendium.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonUtils {
    private JsonUtils() {}
    public static <T> String toJSON(T object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper.writeValueAsString(object);
    }

    public static <T> T fromJSON(String jsonString, Class<T> cls) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, cls);
    }

    public static <T> List<T> loopOverJsonObject(String jsonString, String arrayName, Class<T> cls) throws JsonProcessingException {
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONObject spells = jsonObject.getJSONObject(arrayName);
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> listToReturn = new ArrayList<>();

        for (Iterator<String> it = spells.keys(); it.hasNext(); ) {
            String key = it.next();
            listToReturn.add(objectMapper.readValue(spells.getJSONObject(key).toString(), cls));
        }
        return listToReturn;
    }
}
