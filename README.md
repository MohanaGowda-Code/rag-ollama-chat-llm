# RAG-Based Document Chat with Spring Boot & Ollama
A real-world Retrieval Augmented Generation (RAG) backend built using Java + Spring Boot, demonstrating how to upload documents, extract and chunk content, perform semantic search using embeddings, and generate answers using a local LLM (Ollama).
This project is a GenAI backend reference for Java developers transitioning into AI + Microservices.

# Features

PDF upload and text extraction
Document chunking
Embedding generation
Semantic search (Top-K chunks)
Context building
LLM response using Ollama
End-to-end RAG pipeline
Fully testable via Postman

# RAG Flow
PDF Upload → Text Extraction → Chunking → Embeddings → Semantic Search → Context Building → Context + Question → LLM → Answer
✅ All steps are implemented

# Tech Stack
Java 17
Spring Boot 3.5
Apache PDFBox / Tika
Ollama (local LLM)

# REST APIs

Postman
Prerequisites
Java 17+
Ollama installed and running
brew install ollama
ollama serve
ollama pull llama3.2

# Run Application
./mvnw spring-boot:run


# App runs on http://localhost:8080

# APIs
Upload PDF
POST /api/rag/upload

# Chat (RAG)
POST /api/rag/chat


# Request:
{
  "question": "I am getting fever, still not yet meet doctor"
}


# Sample Response:

It's not a good idea to ignore symptoms like fever and wait.
Consider visiting a doctor or seeking medical attention.

# Current Status
PDF ingestion ✅
Context injection ✅
RAG working end-to-end ✅
Ollama LLM integration ✅

# Planned Enhancements
Vector DB integration
Streaming responses
Source citations
Prompt optimization
Docker & Kubernetes support

# Author
** Mohana P **
Lead Consultant – Java & Microservices Engineer
Exploring AI, RAG, and LLM integration with Spring Boot

# Contributions
This project is built as a real-world GenAI backend reference for Java developers moving into AI + Microservices.
Contributions and improvements are welcome.
