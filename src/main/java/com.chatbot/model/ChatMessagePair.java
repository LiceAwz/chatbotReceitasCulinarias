package com.chatbot.model;

public class ChatMessagePair {
    private String question;
    private String answer;

    public ChatMessagePair(){}

    public ChatMessagePair(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
