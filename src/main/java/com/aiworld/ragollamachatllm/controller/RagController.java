package com.aiworld.ragollamachatllm.controller;

import com.aiworld.ragollamachatllm.model.ChatRequest;
import com.aiworld.ragollamachatllm.model.DocumentChunk;
import com.aiworld.ragollamachatllm.model.SearchRequest;
import com.aiworld.ragollamachatllm.model.SearchResponse;
import com.aiworld.ragollamachatllm.service.ChatService;
import com.aiworld.ragollamachatllm.service.ChunkingService;
import com.aiworld.ragollamachatllm.service.DocumentService;
import com.aiworld.ragollamachatllm.service.EmbeddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/rag")
public class RagController {


    @Autowired
    private DocumentService documentService;

    @Autowired
    private ChunkingService chunkingService;

    @Autowired
    EmbeddingService embeddingService;

    @Autowired
    ChatService chatService;

    @PostMapping("/upload")
    public List<DocumentChunk> upload(@RequestParam MultipartFile file) {
        String text = documentService.extractText(file);       // STEP-2
        List<DocumentChunk> chunks = chunkingService.chunkText(text); // STEP-3
        return embeddingService.generateSingleEmbedding(chunks);   // STEP-4
    }

    @PostMapping("/search")
    public List<SearchResponse> search(@RequestBody SearchRequest request) {
        return embeddingService.semanticSearch(
                        request.getQuery(),
                        request.getTopK()
                ).stream()
                .map(c -> new SearchResponse(c.getIndex(), c.getContent()))
                .toList();
    }

    @PostMapping("/chat")
    public String chat(@RequestBody ChatRequest request) {
        return chatService.chat(request.getQuestion());
    }
}