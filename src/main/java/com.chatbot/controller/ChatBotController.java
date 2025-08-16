package com.chatbot.controller;

import com.chatbot.service.ChatBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/chatbot")
public class ChatBotController {

    @Autowired
    private ChatBotService chatBotService;

    @PostMapping("/perguntar")
    public String question(@RequestBody String question){
        return chatBotService.answer(question);
    }

    @GetMapping("/receitas")
    public List<String> getRecipes() {
        return chatBotService.getAvailableQuestions();
    }
}
