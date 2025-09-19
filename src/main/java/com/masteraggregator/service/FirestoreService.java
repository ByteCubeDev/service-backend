package com.masteraggregator.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class FirestoreService {

    private Firestore db;

    public FirestoreService() {
        this.db = FirestoreClient.getFirestore();
    }

    // Создание/обновление документа
    public void saveDocument(String collection, String docId, Map<String, Object> data) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> result = db.collection(collection).document(docId).set(data);
        System.out.println("Update time : " + result.get().getUpdateTime());
    }

    // Получение документа
    public DocumentSnapshot getDocument(String collection, String docId) throws ExecutionException, InterruptedException {
        DocumentReference docRef = db.collection(collection).document(docId);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        return future.get();
    }

    // Получение всех документов коллекции
    public List<QueryDocumentSnapshot> getAllDocuments(String collection) throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> future = db.collection(collection).get();
        return future.get().getDocuments();
    }
}