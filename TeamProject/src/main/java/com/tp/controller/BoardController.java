package com.tp.controller;

import java.sql.Timestamp;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tp.entity.Board;
import com.tp.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

   private final BoardService boardservice;

   
   // 페이징, 게시물 검색, 게시물 목록 보기
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
      

      
      //Math.max() 는 둘 중 큰걸 반환 min 은 반대
      int nowPage = list.getPageable().getPageNumber()+1;

      int startPage = Math.max(nowPage - 4, 1);
      int endPage = Math.min(nowPage + 5, list.getTotalPages());
      
      model.addAttribute("list", list);
      model.addAttribute("nowPage", nowPage);
      model.addAttribute("startPage", startPage);
      model.addAttribute("endPage", endPage);
      
      return "board/list";
   }
   
   //게시물 작성

   @RequestMapping("register")
   public String write() {
      return "board/register";
   }

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

   
//   //�Խù� �󼼺���
//   @RequestMapping("/content")
//   public String content(@RequestParam("num") Long num,
//         Model model,
//         HttpServletRequest req, 
//         HttpServletResponse res, HttpSession session) {
//	   
//	   List<CommentDTO> commentDTOList = commentService.findAll(num);
//	   model.addAttribute("commentList", commentDTOList);
//	   
//	   viewCountUp(num, req, res);
//	   model.addAttribute("one", boardservice.selectOne(num));
//	   if(session.getAttribute("listnum_mo") != null) {
//		   	session.setAttribute("listnum", 3);
//			session.removeAttribute("listnum_mo");
//	   }else {
//		   session.setAttribute("listnum", 1);
//	   }
//	   return "board/content";
//   }


   @GetMapping("delete_content")
   public String delete(@RequestParam Long num) {
      
      boardservice.delete(num);
      return "redirect:/board";
   }
   
   // 게시물 수정
   @GetMapping("modify")
   public String modify(@RequestParam Long num, Model model, HttpSession session) {
      
      session.setAttribute("listnum", 2);
      model.addAttribute("one", boardservice.selectOne(num));
      
      return "board/board_modify";
   }
   
   // 게시물 수정 후 수정된 결과 보기
   @PostMapping("modify")
   public String modifyAfter(Board board, MultipartFile file, HttpSession session) throws Exception {
      
      session.setAttribute("listnum_mo", 2);
      
      Timestamp now = new Timestamp(System.currentTimeMillis());
      board.setRegdate(now);
      
      boardservice.save(board, file);
      return "redirect:/content?num=" + board.getNum();
   }
   
   //조회수 중복 방지 쿠키값 설정
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
                oldCookie.setValue(oldCookie.getValue() + "_[" + num + "]");   //숫자 온전히 검사하기 위해[]_[]

                oldCookie.setPath("/");            //모든 경로
                oldCookie.setMaxAge(60);         //시간설정
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
    


 
}