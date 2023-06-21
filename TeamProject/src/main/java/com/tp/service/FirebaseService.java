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

    public void insertUser()  {

        Firestore db = FirestoreClient.getFirestore();
        UserDTO user = new UserDTO();
        user.setId("1111");
        user.setName("1111");
        user.setAddress("서울");
        user.setEmail("test@com");
        user.setPassword("1234");
        user.setPhone("11111111");
        user.setUsername("테스트");
        ApiFuture<WriteResult> apiFuture = db.collection(COLLECTION_NAME).document("Users").set(user);

    }


    public void selectUser() throws Exception {

        Firestore db = FirestoreClient.getFirestore();
        UserDTO user = null;
        ApiFuture<DocumentSnapshot> apiFuture = db.collection(COLLECTION_NAME).document("user_4").get();
        DocumentSnapshot documentSnapshot = apiFuture.get();
        if(documentSnapshot.exists()) {
            user = documentSnapshot.toObject(UserDTO.class);
            log.info(user.toString());
        }
    }
}
