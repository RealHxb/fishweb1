/*     */ package com.elangzhi.fish.controller.game;
/*     */ 
/*     */ import com.elangzhi.fish.controller.json.Tip;
/*     */ import com.elangzhi.fish.model.Game;
/*     */ import com.elangzhi.fish.model.Grade;
/*     */ import com.elangzhi.fish.model.Person;
/*     */ import com.elangzhi.fish.services.GameService;
/*     */ import com.elangzhi.fish.services.GradeService;
/*     */ import com.elangzhi.fish.services.PersonService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/person"})
/*     */ public class PersonController
/*     */ {
/*  35 */   static Logger logger = Logger.getLogger(PersonController.class.getName());
/*     */   
/*  37 */   private Map<String, List<Integer>> haoMap = new HashMap<String, List<Integer>>();
/*     */   
/*  39 */   private Map<String, List<Integer>> maxHaoMap = new HashMap<String, List<Integer>>();
/*     */   private Integer maxHao;
/*     */   @Resource
/*     */   PersonService personService;
/*     */   
/*     */   @RequestMapping({"/setting"})
/*  45 */   public ModelAndView setting(ModelMap model) { Game game = this.gameService.findNew();
/*  46 */     model.put("game", game);
/*  47 */     if (game != null) {
/*  48 */       List<Person> persons = this.personService.listByGameType(game.getId(), 20);
/*  49 */       model.put("persons", persons);
/*     */     }
/*  51 */     return new ModelAndView("person/setting", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/sport/{id}"})
/*     */   public ModelAndView sport(@PathVariable Long id, ModelMap model) {
/*  56 */     Game game = (Game)this.gameService.findById(id);
/*  57 */     model.put("game", game);
/*  58 */     if (game != null) {
/*  59 */       List<Person> persons = this.personService.listByGameType(game.getId(), 20);
/*  60 */       model.put("persons", persons);
/*     */     }
/*     */     
/*  63 */     return new ModelAndView("person/sport", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/save"})
/*     */   @ResponseBody
/*     */   public Tip save(Person person) {
/*     */     try {
/*  70 */       if ((person != null) && (person.getType().intValue() != 20)) {
/*  71 */         List<Person> personlist = this.personService.listExcludePersonTypeByGame(person.getGameId(), Integer.valueOf(20));
/*  72 */         person.setNumber(genNumber(personlist, 1));
/*     */       } else {
/*  74 */         List<Person> personlist = this.personService.listByGameType(person.getGameId(), 20);
/*  75 */         person.setNumber(genNumber(personlist, 20));
/*     */       }
/*  77 */       Long id = this.personService.save(person);
/*  78 */       return new Tip(id.toString());
/*     */     } catch (Exception e) {
/*  80 */       e.printStackTrace(); }
/*  81 */     return new Tip(Integer.valueOf(1));
/*     */   }
/*     */   
/*     */ 
/*     */   @RequestMapping({"/firstChouHao/{id}"})
/*     */   @ResponseBody
/*     */   public Grade firstChouHao(@RequestParam("id") Long id)
/*     */   {
/*  89 */     Game game = this.gameService.findNew();
/*  90 */     if (this.haoMap.isEmpty()) {
/*  91 */       addHaos(game);
/*     */     }
/*  93 */     Grade grade = chouHao(game, Integer.valueOf(1), null, id);
/*  94 */     return grade;
/*     */   }
/*     */   
/*     */   @RequestMapping({"/otherChouHao"})
/*     */   @ResponseBody
/*     */   public Grade otherChouHao(@RequestParam("persionid") Long persionid, @RequestParam("chang") Integer chang, @RequestParam("qu") String qus)
/*     */   {
/* 101 */     String[] quArray = qus.split(";");
/* 102 */     List<String> quList = new ArrayList<String>();
/* 103 */     String[] arrayOfString1;
				int j = (arrayOfString1 = quArray).length; 
				for (int i = 0; i < j; i++) { 
					String q = arrayOfString1[i];
/* 104 */       if ((q != null) && (q.length() != 0)) {
/* 105 */         quList.add(q);
/*     */       }
/*     */     }
/*     */     
/* 109 */     Game game = this.gameService.findNew();
/* 110 */     if (this.haoMap.isEmpty()) {
/* 111 */       addHaos(game);
/*     */     }
/* 113 */     Grade grade = chouHao(game, chang, quList, persionid);
/* 114 */     return grade;
/*     */   }
/*     */   
/*     */   public Grade chouHao(Game game, Integer chang, List<String> quList, Long personid)
/*     */   {
/* 119 */     Grade isNull = this.gradeService.findByGameChangPerson(game.getId(), chang, personid);
/* 120 */     Person person = (Person)this.personService.findById(personid);
/* 121 */     if (isNull != null) {
/* 122 */       isNull.setPersonName(person.getName());
/* 123 */       isNull.setPersonNumber(person.getNumber());
/* 124 */       return isNull;
/*     */     }
/* 126 */     boolean hadDabian = hadDabian(game.getId(), Integer.valueOf(chang.intValue() - 1), personid);
/* 127 */     if ((quList == null) || (quList.isEmpty())) {
/* 128 */       quList = new ArrayList<String>();
/* 129 */       for (int i = 1; i <= game.getQu().intValue(); i++) {
/* 130 */         quList.add(String.valueOf(i));
/*     */       }
/*     */     }
/*     */     try {
/* 134 */       int qu = 0;int room = 0;
/* 135 */       qu = getRandQu(quList, chang);
/* 136 */       if (qu == -1) {
/* 137 */         Grade grade = new Grade();
/* 138 */         grade.setChang(chang);
/* 139 */         grade.setRoom(Integer.valueOf(-1));
/* 140 */         grade.setPersonName("号码池已无数据！");
/* 141 */         return grade;
/*     */       }
/* 143 */       List<Integer> theHaos = (List<Integer>)this.haoMap.get(chang +""+ qu);
/* 144 */       List<Integer> theMaxHaos = (List<Integer>)this.maxHaoMap.get(chang +""+ qu);
/* 145 */       int roomValue;
				if (theHaos.size() > 0) {
/* 146 */         roomValue = getRightNumber(theHaos, hadDabian);
/*     */       } else {
/* 148 */         roomValue = getRightNumber(theMaxHaos, hadDabian);
/*     */       }
/*     */       
/* 151 */       room = roomValue % 1000;
/* 152 */       return addGrade(game.getId(), personid, chang, Integer.valueOf(qu), Integer.valueOf(room), person);
/*     */     } catch (Exception e) {
/* 154 */       e.printStackTrace();
/*     */     }
/* 156 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getRandQu(List<String> qulist, Integer chang)
/*     */   {
/* 166 */     boolean isempty = true;
/*     */     
/* 168 */     int random = getRandom(Integer.valueOf(qulist.size()));
/* 169 */     int thequ = Integer.parseInt((String)qulist.get(random));
/* 170 */     if ((this.maxHaoMap.get(chang +""+ thequ)).isEmpty()) {
/* 171 */       qulist.remove(random);
/* 172 */       for (int i = 0; i < qulist.size(); i++) {
/* 173 */         String q = (String)qulist.get(i);
/* 174 */         if ((this.maxHaoMap.get(chang +""+ q)).isEmpty()) {
/* 175 */           qulist.remove(i);
/*     */         } else {
/* 177 */           isempty = false;
/* 178 */           break;
/*     */         }
/*     */       }
/* 181 */       if (isempty) {
/* 182 */         return -1;
/*     */       }
/* 184 */       return getRandQu(qulist, chang);
/*     */     }
/*     */     
/* 187 */     return thequ;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getRightNumber(List<Integer> haoPool, boolean hadDabian)
/*     */   {
/* 198 */     boolean isDabian = false;
/* 199 */     int randNum = getRandom(Integer.valueOf(haoPool.size()));
/* 200 */     int roomValue = ((Integer)haoPool.get(randNum)).intValue();
/* 201 */     int room = roomValue % 1000;
/* 202 */     if ((room == 1) || (room == this.maxHao.intValue())) {
/* 203 */       isDabian = true;
/*     */     }
/* 205 */     if ((!hadDabian) || (!isDabian)) {
/* 206 */       haoPool.remove(randNum);
/* 207 */       return roomValue;
/*     */     }
/* 209 */     roomValue = getRightNumber(haoPool, hadDabian);
/* 210 */     return roomValue;
/*     */   }
/*     */   
/*     */ 
/*     */   @Resource
/*     */   GameService gameService;
/*     */   
/*     */   @Resource
/*     */   GradeService gradeService;
/*     */   
/*     */   private boolean hadDabian(Long gameid, Integer chang, Long personid)
/*     */   {
/* 222 */     List<Grade> list = this.gradeService.findDabianGrade(gameid, chang, personid, this.maxHao);
/* 223 */     if ((list == null) || (list.isEmpty())) {
/* 224 */       return false;
/*     */     }
/*     */     
/* 227 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getRandom(Integer size)
/*     */   {
/* 236 */     Random rand = new Random();
/* 237 */     int randNum = rand.nextInt(size.intValue());
/* 238 */     return randNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addHaos(Game game)
/*     */   {
/* 246 */     Integer qu = game.getQu();
/* 247 */     Integer chang = game.getChang();
/* 248 */     List<Person> persons = this.personService.listByGameType(game.getId(), 20);
/* 249 */     Integer count = Integer.valueOf(persons.size());
/* 250 */     haoPool(count, qu, chang);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void haoPool(Integer count, Integer qu, Integer chang)
/*     */   {
/* 260 */     Integer max = Integer.valueOf(count.intValue() / qu.intValue());
/* 261 */     if (count.intValue() % qu.intValue() != 0) {
/* 262 */       max = Integer.valueOf(max.intValue() + 1);
/*     */     }
/* 264 */     this.maxHao = max;
/* 265 */     for (int q = 1; q <= qu.intValue(); q++) {
/* 266 */       List<Integer> haos = new ArrayList<Integer>();
/* 267 */       List<Integer> haosOut = new ArrayList<Integer>();
/* 268 */       for (int j = 1; j <= max.intValue(); j++) {
/* 269 */         int number = q * 1000 + j;
/* 270 */         if (j == max.intValue()) {
/* 271 */           haosOut.add(Integer.valueOf(number));
/*     */         } else {
/* 273 */           haos.add(Integer.valueOf(number));
/*     */         }
/*     */       }
/* 276 */       for (int c = 1; c <= chang.intValue(); c++)
/*     */       {
/* 278 */         List<Integer> newHaos = new ArrayList<Integer>(haos);
/* 279 */         List<Integer> newHaosOut = new ArrayList<Integer>(haosOut);
/* 280 */         String key = c+""+q ;
/* 281 */         this.haoMap.put(key, newHaos);
/* 282 */         this.maxHaoMap.put(key, newHaosOut);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public Grade addGrade(Long gameId, Long personId, Integer chang, Integer qu, Integer number, Person person) {
/* 288 */     Grade grade = new Grade();
/* 289 */     grade.setChang(chang);
/* 290 */     grade.setPersonId(personId);
/* 291 */     grade.setGameId(gameId);
/* 292 */     grade.setQu(qu);
/* 293 */     grade.setRoom(number);
/* 294 */     grade.setPersonName(person.getName());
/* 295 */     grade.setPersonNumber(person.getNumber());
/*     */     
/* 297 */     this.gradeService.save(grade);
/* 298 */     return grade;
/*     */   }
/*     */   
/*     */   public Integer genNumber(List<Person> personlist, int type) {
/* 302 */     int size = 0;
/* 303 */     if ((personlist != null) && (personlist.size() > 0)) {
/* 304 */       size = ((Person)personlist.get(0)).getNumber().intValue();
/*     */     }
/* 306 */     if (size != 0)
/* 307 */       return Integer.valueOf(size + 1);
/* 308 */     if ((type == 20) && (size == 0)) {
/* 309 */       return Integer.valueOf(1001);
/*     */     }
/* 311 */     return Integer.valueOf(2001);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/lucky/{id}"})
/*     */   public ModelAndView lucky(@PathVariable Long id, HttpServletRequest request, ModelMap model)
/*     */   {
/* 317 */     Game game = this.gameService.findNew();
/* 318 */     List<Person> persons = this.personService.listExcludePersonTypeByGame(game.getId(), null);
/* 319 */     List<Grade> grades = this.gradeService.zongfenShow(game.getId());
/* 320 */     for (Person p : persons) {
/* 321 */       if (p.getType().intValue() != 20) {
/* 322 */         Grade g = new Grade();
/* 323 */         g.setPersonName(p.getName());
/* 324 */         g.setPersonId(p.getId());
/* 325 */         g.setPersonNumber(p.getNumber());
/* 326 */         g.setDefen(Double.valueOf(0.0D));
/* 327 */         g.setRanking(Double.valueOf(0.0D));
/* 328 */         grades.add(g);
/*     */       }
/*     */     }
/* 331 */     model.put("persons", grades);
/*     */     
/* 333 */     return new ModelAndView("person/lucky", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/{id}"})
/*     */   public ModelAndView show(@PathVariable Long id, HttpServletRequest request, ModelMap model)
/*     */   {
/* 339 */     model.put("obj", this.personService.findById(id));
/*     */     
/* 341 */     return new ModelAndView("person/print", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/print/{id}"})
/*     */   public ModelAndView print(@PathVariable Long id, HttpServletRequest request, ModelMap model)
/*     */   {
/* 347 */     model.put("obj", this.personService.findById(id));
/*     */     
/* 349 */     return new ModelAndView("person/print", model);
/*     */   }
/*     */   
/*     */   @RequestMapping({"/printall"})
/*     */   public ModelAndView printall(HttpServletRequest request, ModelMap model) {
/* 354 */     Game game = this.gameService.findNew();
/* 355 */     model.put("game", game);
/* 372 */     return new ModelAndView("person/printAll", model);
/*     */   }
			@RequestMapping(value={"/ajaxPrint"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
			@ResponseBody
			public List<Person> printList(){
				Game game = this.gameService.findNew();
				List<Person> persons2 = new ArrayList<Person>();
				if (game != null) {
					List<Person> persons = this.personService.listByGameType(game.getId(), 20);
					if(persons != null) {
						for (int i = persons.size()-1; i >= 0; i--) {
							persons2.add(persons.get(i));
						}
					}
				}
				return persons2;
			}
/*     */   
/*     */   @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public Tip delete(@RequestParam(value="id", required=false) Long id)
/*     */   {
/*     */     try {
/* 380 */       this.personService.deleteById(id);
/*     */     } catch (Exception e) {
/* 382 */       return new Tip(Integer.valueOf(1));
/*     */     }
/* 384 */     return new Tip();
/*     */   }
/*     */ }


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\controller\game\PersonController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */