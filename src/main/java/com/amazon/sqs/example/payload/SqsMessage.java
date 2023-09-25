package com.amazon.sqs.example.payload;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class SqsMessage {

    private String name;
    private String city;
    private String email;

    public String toJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(this);
        } catch (Exception e) {
            throw new RuntimeException("Error converting to JSON", e);
        }
    }
}
