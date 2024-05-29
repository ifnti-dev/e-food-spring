package com.entreprise.efood.config;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class MyRequestModelDeserializer  extends StdDeserializer<MyRequestModel> {

    public MyRequestModelDeserializer() {
        this(null);
    }

    public MyRequestModelDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public MyRequestModel deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);

        String userId = node.get("userId").asText();
        String queryResults = node.get("queryResults").toString();

        MyRequestModel model = new MyRequestModel();
        model.setQueryResults(queryResults);
        model.setUserId(userId);

        return model;
    }

   

}