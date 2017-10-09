/*     */ package com.elangzhi.fish.controller.game;
/*     */ 
/*     */ import com.elangzhi.fish.controller.json.Tip;
/*     */ import com.elangzhi.fish.model.Game;
/*     */ import com.elangzhi.fish.model.Grade;
/*     */ import com.elangzhi.fish.services.GameService;
/*     */ import com.elangzhi.fish.services.GradeService;
/*     */ import com.elangzhi.fish.services.PersonService;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ @Controller
/*     */ @RequestMapping({"/grade"})
/*     */ public class GradeController
/*     */ {
/*  35 */   static Logger logger = Logger.getLogger(GameController.class.getName());
/*     */   
/*     */   @RequestMapping({"/jifen/{gameId}"})
/*     */   @ResponseBody
/*     */   public Tip jifen(@PathVariable Long gameId, ModelMap model) {
/*  40 */     Game game = (Game)this.gameService.findById(gameId);
/*  41 */     int maxGrade = this.gradeService.getMaxGradeByGame(gameId);
/*     */     try {
/*  43 */       for (int i = 1; i <= game.getChang().intValue(); i++) {
/*  44 */         for (int j = 1; j <= game.getQu().intValue(); j++) {
/*  45 */           List<Grade> grades = this.gradeService.jifen(gameId, Integer.valueOf(i), Integer.valueOf(j));
/*     */           
/*  47 */           for (int r = 0; r < grades.size(); r++) {
/*  48 */             ((Grade)grades.get(r)).setGrade(Double.valueOf(r + 1.0D));
/*     */             
/*  50 */             if ((((Grade)grades.get(0)).getNumber() != null) && (((Grade)grades.get(0)).getNumber().intValue() != 0)) {
/*  51 */               if (((Grade)grades.get(r)).getNumber().intValue() == 0) {
/*  52 */                 ((Grade)grades.get(r)).setGrade(Double.valueOf(maxGrade + 1.0D));
/*     */               }
/*     */             }
/*  55 */             else if (((Grade)grades.get(r)).getWeight().doubleValue() == 0.0D) {
/*  56 */               ((Grade)grades.get(r)).setGrade(Double.valueOf(maxGrade + 1.0D));
/*     */             }
/*     */           }
/*     */           
/*     */ 
/*  61 */           for (int x = 0; x < grades.size(); x++) {
/*  62 */             List<Grade> temp = new ArrayList();
/*  63 */             temp.add((Grade)grades.get(x));
/*     */             
/*  65 */             for (int s = x + 1; s < grades.size(); s++) {
/*  66 */               if ((((Grade)grades.get(s)).getNumber() != null) && (((Grade)grades.get(x)).getNumber().intValue() != 0)) {
/*  67 */                 if (((Grade)grades.get(s)).getNumber() != ((Grade)grades.get(x)).getNumber()) break;
/*  68 */                 temp.add((Grade)grades.get(s));
/*  69 */                 x++;
/*     */ 
/*     */               }
/*     */               else
/*     */               {
/*  74 */                 if (!((Grade)grades.get(s)).getWeight().equals(((Grade)grades.get(x)).getWeight())) break;
/*  75 */                 temp.add((Grade)grades.get(s));
/*  76 */                 x++;
/*     */               }
/*     */             }
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*  83 */             Double grade = Double.valueOf(0.0D);
/*  84 */             for (Grade g : temp) {
/*  85 */               grade = Double.valueOf(grade.doubleValue() + g.getGrade().doubleValue());
/*     */             }
/*     */             
/*  88 */             for (Grade g : temp) {
/*  89 */               g.setGrade(Double.valueOf(grade.doubleValue() / temp.size()));
/*  90 */               this.gradeService.updateById(g);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*  97 */       for (int i = 1; i <= game.getChang().intValue(); i++) {
/*  98 */         List<Grade> grades = this.gradeService.gradeShow(gameId, Integer.valueOf(i), null);
/*     */         
/* 100 */         for (int j = 0; j < grades.size(); j++) {
/* 101 */           Double f1 = Double.valueOf(new BigDecimal(j / 100.0F).setScale(2, 4).doubleValue());
/* 102 */           Double defen = ((Grade)grades.get(j)).getDefen();
/* 103 */           ((Grade)grades.get(j)).setSorts(Double.valueOf(defen.doubleValue() + f1.doubleValue()));
/* 104 */           Grade g = (Grade)grades.get(j);
/* 105 */           if (g != null) {
/* 106 */             this.gradeService.updateById(g);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 112 */       return new Tip();
/*     */     } catch (Exception e) {
/* 114 */       e.printStackTrace();
/*     */     }
/* 116 */     return new Tip(Integer.valueOf(1));
/*     */   }
/*     */   
/*     */   @RequestMapping({"/fafen"})
/*     */   @ResponseBody
/*     */   public Tip fafen(Grade grade) {
/*     */     try {
/* 123 */       Grade grade1 = this.gradeService.findByChangNumber(grade.getGameId(), grade.getChang(), grade.getPersonId());
/* 124 */       grade1.setRanking(grade.getRanking());
/* 125 */       this.gradeService.updateById(grade1);
/* 126 */       return new Tip();
/*     */     } catch (Exception e) {
/* 128 */       e.printStackTrace(); }
/* 129 */     return new Tip(Integer.valueOf(1));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/check/{gameId}/{chang}/{qu}"})
/*     */   public ModelAndView infoA(@PathVariable Long gameId, @PathVariable Integer chang, @PathVariable Integer qu, ModelMap model)
/*     */   {
/* 138 */     Game game = (Game)this.gameService.findById(gameId);
/* 139 */     model.put("game", game);
/* 140 */     model.put("chang", chang);
/* 141 */     model.put("qu", qu);
/* 142 */     model.put("grades", this.gradeService.CheckInfo(gameId, chang, qu));
/* 143 */     return new ModelAndView("grade/check", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/check/{gameId}/{chang}"})
/*     */   public ModelAndView infoB(@PathVariable Long gameId, @PathVariable Integer chang, ModelMap model) {
/* 148 */     Game game = (Game)this.gameService.findById(gameId);
/* 149 */     model.put("game", game);
/* 150 */     model.put("chang", chang);
/* 151 */     model.put("grades", this.gradeService.CheckInfo(gameId, chang, null));
/* 152 */     return new ModelAndView("grade/check", model);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @RequestMapping({"/show/{gameId}/{chang}/{qu}"})
/*     */   public ModelAndView show1(@PathVariable Long gameId, @PathVariable Integer chang, @PathVariable Integer qu, ModelMap model)
/*     */   {
/* 160 */     Game game = (Game)this.gameService.findById(gameId);
/* 161 */     model.put("game", game);
/* 162 */     model.put("chang", chang);
/* 163 */     model.put("qu", qu);
/* 164 */     List<Grade> grades = this.gradeService.gradeShow(gameId, chang, qu);
/*     */     
/* 166 */     model.put("grades", grades);
/* 167 */     return new ModelAndView("grade/show", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/show/{gameId}/{chang}"})
/*     */   public ModelAndView show2(@PathVariable Long gameId, @PathVariable Integer chang, ModelMap model) {
/* 172 */     Game game = (Game)this.gameService.findById(gameId);
/* 173 */     model.put("game", game);
/* 174 */     model.put("chang", chang);
/* 175 */     List<Grade> grades = this.gradeService.gradeShow(gameId, chang, null);
/* 176 */     model.put("grades", grades);
/* 177 */     return new ModelAndView("grade/show", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/show/{gameId}"})
/*     */   public ModelAndView show3(@PathVariable Long gameId, ModelMap model) {
/* 182 */     Game game = (Game)this.gameService.findById(gameId);
/* 183 */     model.put("game", game);
/* 184 */     List<Grade> grades = this.gradeService.zongfenShow(gameId);
/*     */     
/* 186 */     model.put("grades", grades);
/* 187 */     return new ModelAndView("grade/show-all", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/group/{gameId}/{chang}/{qu}"})
/*     */   public ModelAndView groupShow1(@PathVariable Long gameId, @PathVariable Integer chang, @PathVariable Integer qu, ModelMap model)
/*     */   {
/* 193 */     Game game = (Game)this.gameService.findById(gameId);
/* 194 */     model.put("game", game);
/* 195 */     model.put("chang", chang);
/* 196 */     model.put("qu", qu);
/* 197 */     List<Grade> grades = this.gradeService.groupShow(gameId, chang, qu);
/*     */     
/* 199 */     model.put("grades", grades);
/* 200 */     return new ModelAndView("grade/group-show", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/group/{gameId}/{chang}"})
/*     */   public ModelAndView groupShow1(@PathVariable Long gameId, @PathVariable Integer chang, ModelMap model) {
/* 205 */     Game game = (Game)this.gameService.findById(gameId);
/* 206 */     model.put("game", game);
/* 207 */     model.put("chang", chang);
/* 208 */     List<Grade> grades = this.gradeService.groupShow(gameId, chang, null);
/*     */     
/* 210 */     model.put("grades", grades);
/* 211 */     return new ModelAndView("grade/group-show", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/group/{gameId}"})
/*     */   public ModelAndView groupShow1(@PathVariable Long gameId, ModelMap model) {
/* 216 */     Game game = (Game)this.gameService.findById(gameId);
/* 217 */     model.put("game", game);
/* 218 */     List<Grade> grades = this.gradeService.groupShow(gameId, null, null);
/*     */     
/* 220 */     model.put("grades", grades);
/* 221 */     return new ModelAndView("grade/group-show", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/info/{gameId}/{chang}/{qu}"})
/*     */   public ModelAndView info1(@PathVariable Long gameId, @PathVariable Integer chang, @PathVariable Integer qu, ModelMap model)
/*     */   {
/* 227 */     Game game = (Game)this.gameService.findById(gameId);
/* 228 */     model.put("game", game);
/* 229 */     model.put("chang", chang);
/* 230 */     model.put("qu", qu);
/* 231 */     model.put("grades", this.gradeService.findInfo1(gameId, chang, qu));
/* 232 */     return new ModelAndView("grade/info", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/info/{gameId}/{chang}"})
/*     */   public ModelAndView info2(@PathVariable Long gameId, @PathVariable Integer chang, ModelMap model) {
/* 237 */     Game game = (Game)this.gameService.findById(gameId);
/* 238 */     model.put("game", game);
/* 239 */     model.put("chang", chang);
/* 240 */     model.put("grades", this.gradeService.findInfo1(gameId, chang, null));
/* 241 */     return new ModelAndView("grade/info", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/info/{gameId}"})
/*     */   public ModelAndView info2(@PathVariable Long gameId, ModelMap model) {
/* 246 */     Game game = (Game)this.gameService.findById(gameId);
/* 247 */     model.put("game", game);
/* 248 */     model.put("grades", this.gradeService.findInfo1(gameId, null, null));
/* 249 */     return new ModelAndView("grade/info", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/room/{gameId}/{number}"})
/*     */   public ModelAndView room(@PathVariable Long gameId, @PathVariable Integer number, ModelMap model)
/*     */   {
/* 255 */     Game game = (Game)this.gameService.findById(gameId);
/* 256 */     model.put("game", game);
/* 257 */     model.put("grades", this.gradeService.findInfo2(gameId, number));
/* 258 */     return new ModelAndView("grade/room", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/save"})
/*     */   @ResponseBody
/*     */   public Tip save(Grade grade) {
/*     */     try {
/* 265 */       this.gradeService.save(grade);
/* 266 */       return new Tip();
/*     */     } catch (Exception e) {
/* 268 */       e.printStackTrace(); }
/* 269 */     return new Tip(Integer.valueOf(1));
/*     */   }
/*     */   
/*     */ 
/*     */   @RequestMapping({"/{id}"})
/*     */   public ModelAndView show1(@PathVariable Long id, HttpServletRequest request, ModelMap model)
/*     */   {
/* 276 */     model.put("obj", this.gradeService.findById(id));
/*     */     
/* 278 */     return new ModelAndView("person/print", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/print/{id}"})
/*     */   public ModelAndView print(@PathVariable Long id, HttpServletRequest request, ModelMap model)
/*     */   {
/* 284 */     model.put("obj", this.personService.findById(id));
/*     */     
/* 286 */     return new ModelAndView("person/print", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/saveValue"})
/*     */   @ResponseBody
/*     */   public Tip saveValue(Grade grade) {
/*     */     try {
/* 293 */       Grade grade1 = this.gradeService.findByGameChangPerson(grade.getGameId(), grade.getChang(), grade.getPersonId());
/* 294 */       if (grade1 != null) {
/* 295 */         grade1.setWeight(grade.getWeight());
/* 296 */         grade1.setNumber(grade.getNumber());
/* 297 */         this.gradeService.updateById(grade1);
/* 298 */         return new Tip();
/*     */       }
/* 300 */       return new Tip(Integer.valueOf(1));
/*     */     }
/*     */     catch (Exception e) {
/* 303 */       e.printStackTrace(); }
/* 304 */     return new Tip(Integer.valueOf(1));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Resource
/*     */   PersonService personService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   GameService gameService;
/*     */   
/*     */ 
/*     */   @Resource
/*     */   GradeService gradeService;
/*     */   
/*     */ 
/*     */   @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public Tip delete(@RequestParam(value="id", required=false) Long id)
/*     */   {
/*     */     try
/*     */     {
/* 327 */       this.gradeService.deleteById(id);
/*     */     } catch (Exception e) {
/* 329 */       return new Tip(Integer.valueOf(1));
/*     */     }
/* 331 */     return new Tip();
/*     */   }
/*     */   
/*     */   @RequestMapping({"/update"})
/*     */   @ResponseBody
/*     */   public Tip update(Grade grade)
/*     */   {
/*     */     try
/*     */     {
/* 340 */       Grade grade1 = (Grade)this.gradeService.findById(grade.getId());
/* 341 */       if (grade1 != null) {
/* 342 */         grade1.setWeight(grade.getWeight());
/* 343 */         grade1.setNumber(grade.getNumber());
/* 344 */         grade1.setRanking(grade.getRanking());
/* 345 */         this.gradeService.updateById(grade1);
/* 346 */         return new Tip();
/*     */       }
/* 348 */       return new Tip(Integer.valueOf(1));
/*     */     }
/*     */     catch (Exception e) {
/* 351 */       e.printStackTrace(); }
/* 352 */     return new Tip(Integer.valueOf(1));
/*     */   }
/*     */ }


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\controller\game\GradeController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */