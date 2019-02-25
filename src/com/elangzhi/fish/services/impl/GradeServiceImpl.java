/*     */ package com.elangzhi.fish.services.impl;
/*     */ 
/*     */ import com.elangzhi.fish.dao.GameMapper;
/*     */ import com.elangzhi.fish.dao.GradeMapper;
import com.elangzhi.fish.model.ChouQian;
/*     */ import com.elangzhi.fish.model.Game;
/*     */ import com.elangzhi.fish.model.Grade;
/*     */ import com.elangzhi.fish.services.GradeService;
/*     */ import com.elangzhi.fish.tools.UUIDFactory;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.annotation.Resource;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service("gradeService")
/*     */ public class GradeServiceImpl
/*     */   implements GradeService
/*     */ {
/*  26 */   static Logger logger = Logger.getLogger(GradeServiceImpl.class.getName());
/*     */   
/*     */   @Resource
/*     */   GradeMapper gradeMapper;
/*     */   
/*     */   @Resource
/*     */   GameMapper gameMapper;
/*     */   
/*     */   public Long save(Grade grade)
/*     */   {
/*  36 */     grade.setId(UUIDFactory.getLongId());
/*  37 */     grade.setTime(new Date());
/*  38 */     return this.gradeMapper.insertSelective(grade);
/*     */   }
/*     */   
/*     */   public Integer deleteById(Long id)
/*     */   {
/*  43 */     return Integer.valueOf(this.gradeMapper.deleteByPrimaryKey(id));
/*     */   }
/*     */   
/*     */   public Grade findById(Long id)
/*     */   {
/*  48 */     return this.gradeMapper.selectByPrimaryKey(id);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer updateById(Grade grade)
/*     */   {
/*  55 */     return Integer.valueOf(this.gradeMapper.updateByPrimaryKeySelective(grade));
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Grade> findInfo1(Long gameId, Integer chang, Integer qu)
/*     */   {
/*  61 */     return this.gradeMapper.findInfo1(gameId, chang, qu);
/*     */   }
/*     */   
/*     */   public List<Grade> findInfo2(Long gameId, Integer number) {
/*  65 */     return this.gradeMapper.findInfo2(gameId, number);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Grade> CheckInfo(Long gameId, Integer chang, Integer qu)
/*     */   {
/*  71 */     List<Grade> list = this.gradeMapper.CheckInfo(gameId, chang, qu);
/*     */     
/*  73 */     return list;
/*     */   }
/*     */   
/*     */   public List<Grade> listByGame(Long id)
/*     */   {
/*  78 */     return this.gradeMapper.listByGame(id);
/*     */   }
/*     */   
/*     */   public List<Grade> countQu(Long id)
/*     */   {
/*  83 */     return this.gradeMapper.countQu(id);
/*     */   }
/*     */   
/*     */   public Grade findByGameChangPerson(Long gameId, Integer chang, Long personId)
/*     */   {
/*  88 */     List<Grade> list = this.gradeMapper.findByGameChangPerson(gameId, chang, personId);
/*     */     
/*  90 */     if (list.size() > 0) {
/*  91 */       return (Grade)list.get(0);
/*     */     }
/*  93 */     return null;
/*     */   }
/*     */   
/*     */   public List<Grade> gradeShow(Long gameId, Integer chang, Integer qu)
/*     */   {
/*  98 */     return this.gradeMapper.gradeShow(gameId, chang, qu);
/*     */   }
/*     */   
/*     */   public List<Grade> jifen(Long gameId, Integer chang, Integer qu)
/*     */   {
/* 103 */     return this.gradeMapper.jifen(gameId, chang, qu);
/*     */   }
/*     */   
/*     */   public Grade findByChangNumber(Long gameId, Integer chang, Long personId)
/*     */   {
/* 108 */     List<Grade> gradeList = this.gradeMapper.findByChangNumber(gameId, chang, personId);
/* 109 */     if (gradeList.size() > 0) {
/* 110 */       return (Grade)gradeList.get(0);
/*     */     }
/* 112 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Grade> groupShow(Long gameId, Integer chang, Integer qu)
/*     */   {
/* 122 */     List<Grade> list = this.gradeMapper.groupShow(gameId, chang, qu);
/*     */     
/* 124 */     for (int i = 0; i < list.size() - 1; i++) {
/* 125 */       List<Grade> tempList = new ArrayList<Grade>();
/* 126 */       tempList.add((Grade)list.get(i));
/* 127 */       double defen = ((Grade)list.get(i)).getDefen().doubleValue();
/* 128 */       for (int j = i + 1; j < list.size(); j++) {
/* 129 */         if (((Grade)list.get(j)).getDefen().doubleValue() != defen) break;
/* 130 */         tempList.add((Grade)list.get(j));
/* 131 */         i++;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 136 */       if (tempList.size() > 1) {
/* 137 */         sameGroupGradeOrder(tempList, gameId, chang, qu);
/* 138 */         for (int o = 0; o < tempList.size(); o++) {
/* 139 */           list.set(i - (tempList.size() - o - 1), (Grade)tempList.get(o));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 144 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void sameGroupGradeOrder(List<Grade> tempList, Long gameId, Integer chang, Integer qu)
/*     */   {
/* 152 */     for (int i = 0; i < tempList.size() - 1; i++) {
/* 153 */       for (int j = 0; j < tempList.size() - i - 1; j++) {
/* 154 */         Grade grade1 = (Grade)tempList.get(j);
/* 155 */         Grade grade2 = (Grade)tempList.get(j + 1);
/* 156 */         if (isGroupFirstBig(grade1, grade2, gameId, chang, qu)) {
/* 157 */           tempList.set(j, grade2);
/* 158 */           tempList.set(j + 1, grade1);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isGroupFirstBig(Grade g1, Grade g2, Long gameId, Integer chang, Integer qu)
/*     */   {
/* 170 */     int size = 0;
/*     */     
/* 172 */     List<Grade> g1GradeList = this.gradeMapper.findGroupAllGrade(g1.getPersonName(), gameId, chang, qu);
/* 173 */     List<Grade> g2GradeList = this.gradeMapper.findGroupAllGrade(g2.getPersonName(), gameId, chang, qu);
/* 174 */     if (g1GradeList.size() > g2GradeList.size()) {
/* 175 */       size = g2GradeList.size();
/*     */     } else {
/* 177 */       size = g1GradeList.size();
/*     */     }
/* 179 */     for (int i = 0; i < size; i++) {
/* 180 */       if (((Grade)g1GradeList.get(i)).getGrade().doubleValue() > ((Grade)g2GradeList.get(i)).getGrade().doubleValue())
/* 181 */         return true;
/* 182 */       if (((Grade)g1GradeList.get(i)).getGrade().doubleValue() < ((Grade)g2GradeList.get(i)).getGrade().doubleValue())
/* 183 */         return false;
/* 184 */       if (((Grade)g1GradeList.get(i)).getGrade() != ((Grade)g2GradeList.get(i)).getGrade()) {}
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 189 */     List<Grade> g1NumberList = this.gradeMapper.findGroupAllNumberGrade(g1.getPersonName(), gameId, chang, qu);
/* 190 */     List<Grade> g2NumberList = this.gradeMapper.findGroupAllNumberGrade(g2.getPersonName(), gameId, chang, qu);
/* 191 */     if (g1NumberList.size() > g2NumberList.size()) {
/* 192 */       size = g2NumberList.size();
/*     */     } else {
/* 194 */       size = g1NumberList.size();
/*     */     }
/* 196 */     for (int i = 0; i < size; i++) {
/* 197 */       if (((Grade)g1NumberList.get(i)).getNumber().intValue() < ((Grade)g2NumberList.get(i)).getNumber().intValue())
/* 198 */         return true;
/* 199 */       if (((Grade)g1NumberList.get(i)).getNumber().intValue() > ((Grade)g2NumberList.get(i)).getNumber().intValue())
/* 200 */         return false;
/* 201 */       if (((Grade)g1NumberList.get(i)).getNumber() != ((Grade)g2NumberList.get(i)).getNumber()) {}
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 206 */     List<Grade> g1WeightList = this.gradeMapper.findGroupAllWeightGrade(g1.getPersonName(), gameId, chang, qu);
/* 207 */     List<Grade> g2WeightList = this.gradeMapper.findGroupAllWeightGrade(g2.getPersonName(), gameId, chang, qu);
/* 208 */     if (g1WeightList.size() > g2WeightList.size()) {
/* 209 */       size = g2WeightList.size();
/*     */     } else {
/* 211 */       size = g1WeightList.size();
/*     */     }
/* 213 */     for (int i = 0; i < size; i++) {
/* 214 */       if (((Grade)g1WeightList.get(i)).getWeight().doubleValue() < ((Grade)g2WeightList.get(i)).getWeight().doubleValue())
/* 215 */         return true;
/* 216 */       if (((Grade)g1WeightList.get(i)).getWeight().doubleValue() > ((Grade)g2WeightList.get(i)).getWeight().doubleValue())
/* 217 */         return false;
/* 218 */       if (((Grade)g1WeightList.get(i)).getWeight() != ((Grade)g2WeightList.get(i)).getWeight()) {}
/*     */     }
/*     */     
/*     */ 
/* 222 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Grade> gradeCheck(Long gameId, Integer chang, Integer qu)
/*     */   {
/* 228 */     return this.gradeMapper.groupCheck(gameId, chang, qu);
/*     */   }
/*     */   //规则如下：
			//首先对比分数，如果分数相同，则比较最优名次；名次靠前的，排名在先。
			//如果最优成绩相同；则比较条数；条数多的排名在先；
			//如果条数也相同；则比较重量，重量大的排名在先；  
			//根据排名，查询具体场次得分情况
/*     */   public List<Grade> zongfenShow(Long gameId)
/*     */   {
/* 233 */     Game game = this.gameMapper.selectByPrimaryKey(gameId);
/* 234 */     List<Grade> list = this.gradeMapper.zongfenShow(gameId);
			  Iterator<Grade> localIterator = list.iterator();
/* 236 */     while ( localIterator.hasNext())
/*     */     {
/* 236 */       Grade g = (Grade)localIterator.next();
/* 238 */       g.setChild(new ArrayList<Grade>());
/* 239 */       for(int i=1; i <= game.getChang().intValue();i++) {
	      			List<Grade> gradeList = this.gradeMapper.findByGameChangPerson(gameId, Integer.valueOf(i), g.getPersonId());
	      			if (gradeList.size() > 0) {
	      				g.getChild().add((Grade)gradeList.get(0));
	      			} else {
	      				g.getChild().add(new Grade());
	      			}
				}
/*     */     }
/* 254 */     for (int i = 0; i < list.size() - 1; i++) {
/* 255 */       List<Grade> tempList = new ArrayList<Grade>();
/* 256 */       tempList.add((Grade)list.get(i));
/* 257 */       double defen = ((Grade)list.get(i)).getDefen().doubleValue();
/* 258 */       for (int j = i + 1; j < list.size(); j++) {
/* 259 */         if (((Grade)list.get(j)).getDefen().doubleValue() != defen) break;
/* 260 */         tempList.add((Grade)list.get(j));
/* 261 */         i++;
/*     */       }
/* 266 */       if (tempList.size() > 1) {
/* 267 */         sameGradeOrder(tempList);
/* 268 */         for (int o = 0; o < tempList.size(); o++) {
/* 269 */           list.set(i - (tempList.size() - o - 1), (Grade)tempList.get(o));
/*     */         }
/*     */       }
/*     */     }
/* 275 */     return list;
/*     */   }
/*     */   public void sameGradeOrder(List<Grade> tempList)
/*     */   {
/* 282 */     for (int i = 0; i < tempList.size() - 1; i++) {
/* 283 */       for (int j = 0; j < tempList.size() - i - 1; j++) {
/* 284 */         Grade grade1 = (Grade)tempList.get(j);
/* 285 */         Grade grade2 = (Grade)tempList.get(j + 1);
/* 286 */         if (isFirstBig(grade1, grade2)) {
/* 287 */           tempList.set(j, grade2);
/* 288 */           tempList.set(j + 1, grade1);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isFirstBig(Grade g1, Grade g2)
/*     */   {
/* 300 */     int size = 0;
/*     */     
/* 302 */     List<Grade> g1GradeList = this.gradeMapper.findPersonAllGrade(g1);
/* 303 */     List<Grade> g2GradeList = this.gradeMapper.findPersonAllGrade(g2);
/* 304 */     if ((g1GradeList == null) || (g2GradeList == null)) {
/* 305 */       return false;
/*     */     }
/* 307 */     if (g1GradeList.size() > g2GradeList.size()) {
/* 308 */       size = g2GradeList.size();
/*     */     } else {
/* 310 */       size = g1GradeList.size();
/*     */     }
/* 312 */     for (int i = 0; i < size; i++) {
/* 313 */       if (((Grade)g1GradeList.get(i)).getGrade().doubleValue() > ((Grade)g2GradeList.get(i)).getGrade().doubleValue())
/* 314 */         return true;
/* 315 */       if (((Grade)g1GradeList.get(i)).getGrade().doubleValue() < ((Grade)g2GradeList.get(i)).getGrade().doubleValue())
/* 316 */         return false;
/* 317 */       if (((Grade)g1GradeList.get(i)).getGrade() != ((Grade)g2GradeList.get(i)).getGrade()) {}
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 322 */     List<Grade> g1NumberList = this.gradeMapper.findPersonAllNumberGrade(g1);
/* 323 */     List<Grade> g2NumberList = this.gradeMapper.findPersonAllNumberGrade(g2);
/* 324 */     if ((g1NumberList != null) && (g2NumberList != null)) {
/* 325 */       if (g1NumberList.size() > g2NumberList.size()) {
/* 326 */         size = g2NumberList.size();
/*     */       } else {
/* 328 */         size = g1NumberList.size();
/*     */       }
/* 330 */       for (int i = 0; i < size; i++) {
/* 331 */         if (((Grade)g1NumberList.get(i)).getNumber().intValue() < ((Grade)g2NumberList.get(i)).getNumber().intValue())
/* 332 */           return true;
/* 333 */         if (((Grade)g1NumberList.get(i)).getNumber().intValue() > ((Grade)g2NumberList.get(i)).getNumber().intValue())
/* 334 */           return false;
/* 335 */         if (((Grade)g1NumberList.get(i)).getNumber() != ((Grade)g2NumberList.get(i)).getNumber()) {}
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 341 */     List<Grade> g1WeightList = this.gradeMapper.findPersonAllWeightGrade(g1);
/* 342 */     List<Grade> g2WeightList = this.gradeMapper.findPersonAllWeightGrade(g2);
/* 343 */     if ((g1WeightList != null) && (g2WeightList != null)) {
/* 344 */       if (g1WeightList.size() > g2WeightList.size()) {
/* 345 */         size = g2WeightList.size();
/*     */       } else {
/* 347 */         size = g1WeightList.size();
/*     */       }
/* 349 */       for (int i = 0; i < size; i++) {
/* 350 */         if (((Grade)g1WeightList.get(i)).getWeight().doubleValue() < ((Grade)g2WeightList.get(i)).getWeight().doubleValue())
/* 351 */           return true;
/* 352 */         if (((Grade)g1WeightList.get(i)).getWeight().doubleValue() > ((Grade)g2WeightList.get(i)).getWeight().doubleValue())
/* 353 */           return false;
/* 354 */         if (((Grade)g1WeightList.get(i)).getWeight() != ((Grade)g2WeightList.get(i)).getWeight()) {}
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 359 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int compare(Object o1, Object o2)
/*     */   {
/* 366 */     Grade g1 = (Grade)o1;
/* 367 */     Grade g2 = (Grade)o2;
/*     */     
/*     */ 
/*     */ 
/* 371 */     int flag = g1.getDefen().compareTo(g2.getDefen());
/*     */     
/* 373 */     if (flag == 0) {
/* 374 */       return g1.getGrade().compareTo(g2.getGrade());
/*     */     }
/* 376 */     return flag;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Grade> findDabianGrade(Long gameId, Integer chang, Long personId, Integer room)
/*     */   {
/* 384 */     return this.gradeMapper.findDabianGrade(gameId, chang, personId, room);
/*     */   }
/*     */   
/*     */ 
/*     */   public int getMaxGradeByGame(Long gameId)
/*     */   {
/* 390 */     return this.gradeMapper.getMaxGradeByGame(gameId);
/*     */   }
/*     */
	public List<ChouQian> chouQianList(Long gameId, int chang) {
		
		return this.gradeMapper.chouQianList(gameId,chang);
	}
	public void updateOrInsertGrade(Grade g) {
		Grade grade = this.gradeMapper.findItem(g);
		if(null != grade) {
			grade.setQu(g.getQu());
			grade.setRoom(g.getRoom());
			gradeMapper.updateByPrimaryKeySelective(grade);
		}else {
			save(g);
		}
	}
}
