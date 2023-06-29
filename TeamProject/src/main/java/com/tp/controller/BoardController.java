package com.tp.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tp.DTO.CommentDTO;
import com.tp.entity.Board;
//import com.tp.entity.BoardVO;
import com.tp.service.BoardService;
import com.tp.service.CommentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

   private final BoardService boardservice;
   private final CommentService commentService;
   
   // ����¡, �Խù� �˻�, �Խù� ��� ����
   @RequestMapping("/board")
   public String main(Model model, 
         @PageableDefault(page = 0,size = 10, sort = "num", direction = Sort.Direction.DESC) Pageable pageable,
         String keyword) {
      
      Page<Board> list = null;
      
      if(keyword == null) {
         list = boardservice.Content(pageable);
      }else {
         list = boardservice.boardSearch(keyword, pageable);
      }
      
      // ���������� �������� nowPage
      int nowPage = list.getPageable().getPageNumber()+1;
      
      //Math.max() �� �� �� ū�� ��ȯ min �� �ݴ�
      int startPage = Math.max(nowPage - 4, 1);
      int endPage = Math.min(nowPage + 5, list.getTotalPages());
      
      model.addAttribute("list", list);
      model.addAttribute("nowPage", nowPage);
      model.addAttribute("startPage", startPage);
      model.addAttribute("endPage", endPage);
      
      return "board/list";
   }
   
   //�Խù� �ۼ�
   @RequestMapping("register")
   public String write() {
      return "board/register";
   }
   
   //�Խù� ����(GET)
   @GetMapping("/save")
   public String saveForm() {
      
      return "board/list";
   }
   
   //�Խù� ����(POST)
   @PostMapping("/save")
   public String postsave(Board board, 
         MultipartFile file) throws Exception {
      
      boardservice.save(board, file);
      
      return "redirect:/board";
      
   }

   
   //�Խù� �󼼺���
   @RequestMapping("/content")
   public String content(@RequestParam("num") Long num,
         Model model,
         HttpServletRequest req, 
         HttpServletResponse res, HttpSession session) {
	   
	   List<CommentDTO> commentDTOList = commentService.findAll(num);
	   model.addAttribute("commentList", commentDTOList);
	   
	   viewCountUp(num, req, res);
	   model.addAttribute("one", boardservice.selectOne(num));
	   if(session.getAttribute("listnum_mo") != null) {
		   	session.setAttribute("listnum", 3);
			session.removeAttribute("listnum_mo");
	   }else {
		   session.setAttribute("listnum", 1);
	   }
	   return "board/content";
   }

   // �Խù� ����
   @GetMapping("delete_content")
   public String delete(@RequestParam Long num) {
      
      boardservice.delete(num);
      return "redirect:/board";
   }
   
   // �Խù� ����
   @GetMapping("modify")
   public String modify(@RequestParam Long num, Model model, HttpSession session) {
      
      session.setAttribute("listnum", 2);
      model.addAttribute("one", boardservice.selectOne(num));
      
      return "board/board_modify";
   }
   
   // �Խù� ���� �� ������ ��� ����
   @PostMapping("modify")
   public String modifyAfter(Board board, MultipartFile file, HttpSession session) throws Exception {
      
      session.setAttribute("listnum_mo", 2);
      Timestamp now = new Timestamp(System.currentTimeMillis());
      board.setRegdate(now);
      
      boardservice.save(board, file);
      return "redirect:/content?num=" + board.getNum();
   }
   
   //��ȸ�� �ߺ� ���� ��Ű�� ����
    private void viewCountUp(Long num, 
          HttpServletRequest req, 
          HttpServletResponse res) {

        Cookie oldCookie = null;

        Cookie[] cookies = req.getCookies();
        System.out.println(cookies);
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("hit")) {
                    oldCookie = cookie;
                }
            }
        }

        if (oldCookie != null) {
            if (!oldCookie.getValue().contains("[" + num.toString() + "]")) {   
                boardservice.viewCountUp(num);
                oldCookie.setValue(oldCookie.getValue() + "_[" + num + "]");   //���� ������ �˻��ϱ� ����[]_[]

                oldCookie.setPath("/");            //��� ���
                oldCookie.setMaxAge(60);         //�ð�����
                res.addCookie(oldCookie);
            }
        } else {
            boardservice.viewCountUp(num);
            Cookie newCookie = new Cookie("hit","[" + num + "]");
            newCookie.setPath("/");
            newCookie.setMaxAge(60);         
            res.addCookie(newCookie);
        }
    }
    
    @GetMapping("/commMo")
    public String commentModify(@RequestParam Long id,
    		@RequestParam Long num,
    		Model model) {
    	model.addAttribute("one", boardservice.selectOne(num));
    	model.addAttribute("comOne", commentService.selectComment(id));
    	
    	return "comment/modify";
    }
    
    
    @PostMapping("/commMo")
    public String commentModifyAfter(@RequestParam Long id,
    		@RequestParam Long num,
    		@ModelAttribute CommentDTO commentDTO) {
    	
    	commentDTO.setBoardNum(num);
    	Timestamp now = new Timestamp(System.currentTimeMillis());
    	commentDTO.setCommentCreatedTime(now);
    	
    	commentService.save(commentDTO);	
    	return "redirect:/content?num=" + num;
    }


   


}