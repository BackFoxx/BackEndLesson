package com.example.restapi.common;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.validation.Errors;

import java.io.IOException;

@JsonComponent // 스프링에서 사용하는 ObjectMapper에 등록
public class ErrorsSerializer extends JsonSerializer<Errors> {
    @Override
    public void serialize(Errors errors, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        errors.getFieldErrors().forEach(error -> {
            try {
                gen.writeStartObject();

                gen.writeStringField("field", error.getField());
                gen.writeStringField("objectName", error.getObjectName());
                gen.writeStringField("code", error.getCode());
                gen.writeStringField("defaultMessage", error.getDefaultMessage());
                Object rejectedValue = error.getRejectedValue();
                if (rejectedValue != null) {
                    gen.writeStringField("rejectedValue", rejectedValue.toString());
                }

                gen.writeEndObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        errors.getGlobalErrors().forEach(error -> {
            try {
                gen.writeStartObject();

                gen.writeStringField("objectName", error.getObjectName());
                gen.writeStringField("code", error.getCode());
                gen.writeStringField("defaultMessage", error.getDefaultMessage());

                gen.writeEndObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        gen.writeEndArray();
    }
}
