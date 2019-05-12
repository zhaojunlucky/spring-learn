package com.magicworldz.springlearn.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private static final ObjectMapper OM = new ObjectMapper();

    private JsonUtil() {

    }

    public static <T> String writeObjAsString(T obj) throws JsonProcessingException {
        return OM.writeValueAsString(obj);
    }
}