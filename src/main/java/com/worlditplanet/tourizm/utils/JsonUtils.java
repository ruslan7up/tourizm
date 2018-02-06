package com.worlditplanet.tourizm.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class JsonUtils {
    private static ObjectMapper mapper = new ObjectMapper();
    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    public static <T> Object deserializeObject(String json, Class<T> valueType) {
        try {
            return mapper.readValue(json, valueType);
        } catch (IOException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public static <T> Object deserializeObject(String json, TypeReference<T> valueType) {
        try {
            return mapper.readValue(json, valueType);
        } catch (IOException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public static String serializeObject(Object value) {
        try {
            return mapper.writeValueAsString(value);
        } catch (IOException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public static JsonNode deserializeJsonNode(String json) {
        try {
            return mapper.readTree(json);
        } catch (IOException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public static ObjectNode createObjectNode() {
        return mapper.createObjectNode();
    }
}
