package com.tp.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.entity.UserEntity;
import com.tp.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	
	@Autowired(required=true)
	UserRepository userRepository;
	public UserEntity save(final UserEntity userEntity) {	
		return userRepository.save(userEntity);	
	}
	
	public UserEntity getByCredentials(final String username, final String password) {	
		return userRepository.findByUsernameAndPassword(username, password);
	}
	
	// 유저 삭제
	public void deleteById(String id) {		
		userRepository.deleteById(id);		
	}
		
	// 아이디 중복체크 기능
	public int idCheck(final String username) {
		int result = 0;
		if(userRepository.existsByUsername(username)) {
			result=1;
		}else {
			result=0;
		}
		return result;
	}
	
	// 이름값으로 유저 정보 찾는 기능
	public UserEntity UserInfo(final String username) {
		return userRepository.findByUsername(username);				
	}
		
	// 로그인체크 기능
	public int loginChek(final String username, final String password) {
		int result = 1;
		if(userRepository.existsByUsername(username)) { // < ���대��媛� ����吏� ���명�댁�� �ㅼ���� �ㅽ��
			UserEntity user =userRepository.findByUsername(username); //< ���대�� 媛��쇰� ��蹂대�� 諛�����
			if(user.getPassword().equals(password)) { // < 諛����� ������ 鍮�諛�踰��몄�� ���� 鍮�諛�踰��� 鍮�援�
				result = 0; 
			}
		}else {
			result = 2;  // 아이디가 없으면 2를 반환
		}
		return result;
	}


	
	
	

	
	
}