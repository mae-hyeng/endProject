package com.tp.firebase;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.tp.entity.UserEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FirebaseServiceTest {
	
	public static final String COLLECTION_NAME = "user";

    public void insertUser() throws Exception {

        Firestore db = FirestoreClient.getFirestore();
        UserEntity user = new UserEntity();
        user.setId("1111");
        user.setName("1111");
        user.setUsername("sujin");
        user.setPassword("1111");
        user.setEmail("1111@naver.com");
        user.setPhone("01011111111");
        user.setAddress("home");
//        user.setId("4444");
//        user.setName("4444");
        
        ApiFuture<WriteResult> apiFuture = db.collection(COLLECTION_NAME).document("user_4").set(user);

        log.info(apiFuture.get().getUpdateTime().toString());
    }


    public void selectUser() throws Exception {

        Firestore db = FirestoreClient.getFirestore();
        UserEntity user = null;
        ApiFuture<DocumentSnapshot> apiFuture = db.collection(COLLECTION_NAME).document("user_4").get();
        DocumentSnapshot documentSnapshot = apiFuture.get();
        if(documentSnapshot.exists()) {
            user = documentSnapshot.toObject(UserEntity.class);
            log.info(user.toString());
        }
    }
}
