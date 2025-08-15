package main.java.com.chatbot.controller;

import main.java.com.chatbot.service.ChatBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/chatbot")
@CrossOrigin(origins = "*")
public class ChatBotController {

    @Autowired
    private ChatBotService chatBotService;

    @PostMapping("/question")
    public String question(@RequestBody String question){
        return chatBotService.answer(question);
    }
}
