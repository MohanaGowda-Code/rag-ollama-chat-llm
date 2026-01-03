package com.aiworld.ragollamachatllm.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class OllamaLLMService {

    private final WebClient webClient;

    public OllamaLLMService(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("http://localhost:11434")
                .build();
    }

    public String ask(String context, String question) {

        String prompt = """
                Context:
                %s

                Question:
                %s

                Answer only based on the context.
                """.formatted(context, question);

        Map<String, Object> request = Map.of(
                "model", "llama3.2",
                "prompt", prompt,
                "stream", false
        );

        return webClient.post()
                .uri("/api/generate")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Map.class)
                .map(res -> (String) res.get("response"))
                .block();
    }
}
