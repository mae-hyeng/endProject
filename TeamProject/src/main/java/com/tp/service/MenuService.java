package com.tp.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.tp.entity.Board;
import com.tp.entity.Menu;
import com.tp.repository.MenuRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuService {
	
	private final MenuRepository menuRepository;
	
	@Transactional
    public void save(Menu menu, MultipartFile file) throws Exception{
       
       if(!file.isEmpty()) {
          String projectPath = System.getProperty("user.dir") +"\\src\\main\\webapp\\resources\\files";
          
          UUID uuid = UUID.randomUUID();
          
          String fileName = uuid +"_"+ file.getOriginalFilename();
          
          File savefile = new File(projectPath, fileName);
          
          file.transferTo(savefile);
          
          menu.setFilename(fileName);
          menu.setFilepath("/resources/files/" +fileName);
          
       }else {
          if(menu.getFilename()==null) {
        	  menu.setFilename("");
        	  menu.setFilepath("");
          }
          System.out.println("저장시 파일이름 : "+menu.getFilename());
          
       }
       
       menuRepository.save(menu);
    }
    
    public List<Menu> all() {
    	return menuRepository.findAll();
    }
    
    public Menu drinkNum(Long id) {
    	return menuRepository.findById(id).get();
    }
	
	
}
