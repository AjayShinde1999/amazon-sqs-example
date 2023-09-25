package com.amazon.sqs.example.controller;

import com.amazon.sqs.example.payload.SqsMessage;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SqsController {

    @Autowired
    private AmazonSQS amazonSQS;

    @Value("${aws.sqs.queueUrl}")
    private String queueUrl;

    @PostMapping("/send")
    public String sendToSqs(@RequestBody SqsMessage sqsMessage) {
        String messageBody = sqsMessage.toJson();
        SendMessageRequest sendMessageRequest = new SendMessageRequest(queueUrl, messageBody);
        amazonSQS.sendMessage(sendMessageRequest);
        return "Message sent to SQS successfully!";
    }
}
