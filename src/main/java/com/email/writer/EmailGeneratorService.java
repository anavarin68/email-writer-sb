package com.email.writer;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmailGeneratorService {

    public String generateEmailReply(EmailRequest emailRequest){
        //Build the prompt
        String prompt =  buildPrompt(emailRequest);

        //Craft the request
        Map<String, Object> requestBody = Map.of(
                "contents", new Object[]{
                        Map.of("parts", new Object[]{
                            Map.of("text", prompt)
                })
                }
        );

        //Do request and get reponse
        //Return Response

    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a professional email reply for the following content. Please don't generate a subject line ");
        if(emailRequest.getTone() != null && emailRequest.getTone().isEmpty()){
            prompt.append("Use a").append(emailRequest.getTone()).append(" tone.");
        }
        prompt.append("\nOriginal email: \n").append(emailRequest.getEmailContent());
        return prompt.toString();
    }

}
