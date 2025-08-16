package com.chatbot.service;


import com.chatbot.model.ChatMessagePair;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatBotService {

    private final List<com.chatbot.model.ChatMessagePair> pairQuestionAnswer = new ArrayList<>();

    public ChatBotService() {
       loadRecipesFromJson();
    }

    private void loadRecipesFromJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("recipes.json");
            List<ChatMessagePair> data = objectMapper.readValue(is, new TypeReference<List<ChatMessagePair>>() {});
            pairQuestionAnswer.addAll(data);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar as receitas", e);
        }
    }

    public String answer(String question){
        for (ChatMessagePair pair : pairQuestionAnswer){
            if (pair.getQuestion().equalsIgnoreCase(question.trim())){
                return pair.getAnswer();
            }
        }
        return "Desculpe, não sei essa receita. Tente outra receita!";
    }

    public List<String> getAvailableQuestions() {
        List<String> question = new ArrayList<>();
        for (ChatMessagePair pair : pairQuestionAnswer){
            question.add(pair.getQuestion());
        }
        return question;
    }
}
