/*    */ package com.elangzhi.fish.controller.index;
/*    */ 
/*    */ import com.elangzhi.fish.controller.json.Tip;
/*    */ import com.elangzhi.fish.services.GameService;
/*    */ import java.io.PrintStream;
/*    */ import javax.annotation.Resource;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.ModelMap;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ public class IndexController
/*    */ {
/*    */   @Resource
/*    */   GameService gameService;
/*    */   
/*    */   @RequestMapping({"/game"})
/*    */   public ModelAndView showCall(HttpServletRequest request, ModelMap model)
/*    */   {
/* 25 */     model.put("indexTest", "结果1");
/* 26 */     model.put("game", this.gameService.findNew());
/* 27 */     return new ModelAndView("index", model);
/*    */   }
/*    */   
/*    */ 
/*    */   @RequestMapping({"/saveTest"})
/*    */   @ResponseBody
/*    */   public Tip saveTest(@RequestParam String name)
/*    */   {
/* 35 */     System.out.println(name);
/* 36 */     return new Tip();
/*    */   }
/*    */ }


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\controller\index\IndexController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */