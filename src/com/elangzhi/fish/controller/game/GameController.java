/*     */ package com.elangzhi.fish.controller.game;
/*     */ 
/*     */ import com.elangzhi.fish.controller.json.Tip;
/*     */ import com.elangzhi.fish.model.Game;
/*     */ import com.elangzhi.fish.model.Grade;
/*     */ import com.elangzhi.fish.model.Person;
/*     */ import com.elangzhi.fish.services.GameService;
/*     */ import com.elangzhi.fish.services.GradeService;
/*     */ import com.elangzhi.fish.services.PersonService;
/*     */ import java.util.List;
/*     */ import javax.annotation.Resource;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/game"})
/*     */ public class GameController
/*     */ {
/*  28 */   static Logger logger = Logger.getLogger(GameController.class.getName());
/*     */   
/*     */   @RequestMapping({"/setting"})
/*     */   public ModelAndView setting(ModelMap model) {
/*  32 */     Game game = this.gameService.findNew();
/*     */     
/*  34 */     model.put("game", game);
/*  35 */     if (game != null) {
/*  36 */       List<Person> persons = this.personService.listExcludePersonTypeByGame(game.getId(), Integer.valueOf(20));
/*  37 */       model.put("persons", persons);
/*     */     }
/*     */     
/*  40 */     return new ModelAndView("game/setting", model); }
/*     */   
/*     */   @Resource
/*     */   GameService gameService;
/*     */   @RequestMapping({"/show/{id}"})
/*  45 */   public ModelAndView show(@PathVariable Long id, ModelMap model) { Game game = (Game)this.gameService.findById(id);
/*  46 */     model.put("game", game);
/*  47 */     return new ModelAndView("game/down", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/worker/{id}"})
/*     */   public ModelAndView worker(@PathVariable Long id, ModelMap model)
/*     */   {
/*  53 */     Game game = (Game)this.gameService.findById(id);
/*     */     
/*  55 */     model.put("game", game);
/*  56 */     if (game != null) {
/*  57 */       List<Person> persons = this.personService.listExcludePersonTypeByGame(game.getId(), Integer.valueOf(20));
/*  58 */       model.put("persons", persons);
/*     */     }
/*  60 */     return new ModelAndView("game/worker", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/downGame"})
/*     */   @ResponseBody
/*     */   public Game down() {
/*  66 */     Game game = this.gameService.findNew();
/*     */     
/*  68 */     return game;
/*     */   }
/*     */   
/*     */   @RequestMapping({"/downUser"})
/*     */   @ResponseBody
/*     */   public List<Person> downUser() {
/*  74 */     Game game = this.gameService.findNew();
/*  75 */     List<Person> personList = this.personService.listByGameType(game.getId(), 20);
/*  76 */     return personList;
/*     */   }
/*     */   
/*     */   @RequestMapping({"/downGrade"})
/*     */   @ResponseBody
/*     */   public List<Grade> downGrade() {
/*  82 */     Game game = this.gameService.findNew();
/*  83 */     List<Grade> gradeList = this.gradeService.listByGame(game.getId());
/*  84 */     return gradeList;
/*     */   }
/*     */   
/*     */   @RequestMapping({"/save"})
/*     */   @ResponseBody
/*     */   public Tip save(Game game)
/*     */   {
/*     */     try
/*     */     {
/*  93 */       this.gameService.save(game);
/*  94 */       return new Tip();
/*     */     } catch (Exception e) {
/*  96 */       e.printStackTrace(); }
/*  97 */     return new Tip(Integer.valueOf(1));
/*     */   }
/*     */   
/*     */   @Resource
/*     */   PersonService personService;
/*     */   @Resource
/*     */   GradeService gradeService;
/*     */   @RequestMapping({"/update"})
/*     */   @ResponseBody
/*     */   public Tip update(Game game) {
/* 107 */     try { this.gameService.updateById(game);
/* 108 */       return new Tip();
/*     */     } catch (Exception e) {
/* 110 */       e.printStackTrace(); }
/* 111 */     return new Tip(Integer.valueOf(1));
/*     */   }
/*     */ }


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\controller\game\GameController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */