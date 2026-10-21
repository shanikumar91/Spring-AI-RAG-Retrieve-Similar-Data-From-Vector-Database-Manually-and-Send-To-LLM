package com.spring.ai.firstproject.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService{

    private ChatClient chatClient;

    private VectorStore vectorStore;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("classPath:/prompts/user-message.st")
    private Resource userMessage;

    @Value("classPath:/prompts/system-message.st")
    private Resource systemMessage;

    public ChatServiceImpl(ChatClient chatClient, VectorStore vectorStore )
    {
        this.chatClient = chatClient;
        this.vectorStore = vectorStore;
    }

public String chatTemplate(String query, String userId){
//        Load data from vector database
          SearchRequest searchRequest = SearchRequest.builder()
                  .topK(5)
                  .similarityThreshold(0.6)
                  .query(query)
                  .build();
          List<Document> documents = this.vectorStore.similaritySearch(searchRequest);
          List<String> documentList = documents.stream().map(Document::getText).toList();
          String contextData = String.join(", ",documentList);
          logger.info("Context Data : {}", contextData);

    return chatClient
            .prompt()
            .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, userId))
            .system(system->system.text(systemMessage).param("documents",contextData))
            .user(user -> user.text(userMessage).param("query", query))
            .call()
            .content();
}
    @Override
    public void  saveData(List<String> list){
       List<Document> documentList =   list.stream().map(Document::new).toList();
       this.vectorStore.add(documentList);
    }
}
