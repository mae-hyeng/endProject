package com.tp.firebase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class FirebaseController {

	@Autowired
    FirebaseService firebaseService;

    @GetMapping("/insertMember")
    public String insertMember(@RequestParam Member member) throws Exception {
           return firebaseService.insertMember(member);
    }

    @GetMapping("/getMemberDetail")
    public Member getMemberDetail(@RequestParam String id) throws Exception {
           return firebaseService.getMemberDetail(id);
    }

    @GetMapping("/updateMember")
    public String updateMember(@RequestParam Member member) throws Exception {
           return firebaseService.updateMember(member);
    }

    @GetMapping("/deleteMember")
    public String deleteMember(@RequestParam String id) throws Exception {
           return firebaseService.deleteMember(id);
    }
	
}
