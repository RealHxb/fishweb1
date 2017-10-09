/*    */ package com.elangzhi.fish.controller.file;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.Date;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.ModelMap;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/file"})
/*    */ public class FileController
/*    */ {
/*    */   @RequestMapping({"/image"})
/*    */   @ResponseBody
/*    */   public ModelMap fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("name") String name, ModelMap model, HttpServletRequest request)
/*    */   {
/* 28 */     if (file != null) {
/*    */       try
/*    */       {
/* 31 */         String path = request.getSession().getServletContext().getRealPath("/upload/headimg/");
/* 32 */         String fileName = file.getOriginalFilename();
/* 33 */         file.transferTo(new File(path, fileName));
/*    */       } catch (IOException e) {
/* 35 */         e.printStackTrace();
/*    */       }
/*    */     } else {
/* 38 */       return null;
/*    */     }
/*    */     
/* 41 */     model.put("fileName", file.getOriginalFilename());
/* 42 */     model.put("name", name);
/* 43 */     model.put("date", new Date());
/* 44 */     return model;
/*    */   }
/*    */ }

