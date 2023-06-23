package com.tp.service;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.tp.DTO.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FirebaseService {

    public static final String COLLECTION_NAME = "user";

    public void insertUser(String id, String name, String address, String email, String password, String phone, String username )  {

        Firestore db = FirestoreClient.getFirestore();
        UserDTO user = new UserDTO();
        user.setId(id);
        user.setName(name);
        user.setAddress(address);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setUsername(username);
        ApiFuture<WriteResult> apiFuture = db.collection(COLLECTION_NAME).document().set(user);

    }


    public void selectUser(String username) throws Exception {
        Firestore db = FirestoreClient.getFirestore();
        UserDTO user = null;
        ApiFuture<DocumentSnapshot> apiFuture = db.collection(COLLECTION_NAME).document().get();
        DocumentSnapshot documentSnapshot = apiFuture.get();
        if(documentSnapshot.exists()) {
            user = documentSnapshot.toObject(UserDTO.class);
            log.info(user.toString());
        }
    }
}
