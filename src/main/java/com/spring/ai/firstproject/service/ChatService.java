package com.spring.ai.firstproject.service;

import java.util.List;

public interface ChatService {
    public String chatTemplate(String query, String userId);
    public void  saveData(List<String> list);
}
