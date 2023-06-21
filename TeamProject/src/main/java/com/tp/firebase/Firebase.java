package com.tp.firebase;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class Firebase {

    @PostConstruct
    public void init(){
        try{
        	FileInputStream serviceAccount = new FileInputStream("src/main/resources/endprojectkey.json");
       			FirebaseOptions options = new FirebaseOptions.Builder()
      			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
       			  .build();

       			FirebaseApp.initializeApp(options);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}