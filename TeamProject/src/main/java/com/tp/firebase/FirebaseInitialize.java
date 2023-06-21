package com.tp.firebase;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class FirebaseInitialize {

	@PostConstruct
    public void initialize() {
        try {
	        FileInputStream serviceAccount =
	              new FileInputStream("./copycodingServiceAccount.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
            		.setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://copycoding-bca04.firebaseio.com")
                    .build();	       
                  FirebaseApp.initializeApp(options);
      } catch (Exception e) {
          e.printStackTrace();
      }	             
}
	


}
