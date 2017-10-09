/*    */ package com.elangzhi.fish.services.impl;
/*    */ 
/*    */ import com.elangzhi.fish.dao.PersonMapper;
/*    */ import com.elangzhi.fish.model.Person;
/*    */ import com.elangzhi.fish.services.GradeService;
/*    */ import com.elangzhi.fish.services.PersonService;
/*    */ import com.elangzhi.fish.tools.UUIDFactory;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service("personService")
/*    */ public class PersonServiceImpl
/*    */   implements PersonService
/*    */ {
/*    */   @Resource
/*    */   PersonMapper personMapper;
/*    */   @Resource
/*    */   GradeService gradeService;
/*    */   
/*    */   public Long save(Person person)
/*    */   {
/* 28 */     person.setId(UUIDFactory.getLongId());
/* 29 */     this.personMapper.insertSelective(person);
/* 30 */     return person.getId();
/*    */   }
/*    */   
/*    */   public Integer deleteById(Long id)
/*    */   {
/* 35 */     return Integer.valueOf(this.personMapper.deleteByPrimaryKey(id));
/*    */   }
/*    */   
/*    */   public Person findById(Long id)
/*    */   {
/* 40 */     return this.personMapper.selectByPrimaryKey(id);
/*    */   }
/*    */   
/*    */   public Integer updateById(Person person)
/*    */   {
/* 45 */     return Integer.valueOf(this.personMapper.updateByPrimaryKeySelective(person));
/*    */   }
/*    */   
/*    */   public List<Person> listByGame(Long gameId)
/*    */   {
/* 50 */     return this.personMapper.listByGame(gameId);
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Person> listExcludePersonTypeByGame(Long gameId, Integer type)
/*    */   {
/* 56 */     return this.personMapper.listExcludePersonTypeByGame(gameId, type);
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Person> listByGameType(Long id, int i)
/*    */   {
/* 62 */     return this.personMapper.listByGameType(id, Integer.valueOf(i));
/*    */   }
/*    */   
/*    */   public Person findNewNumber(Long gameId)
/*    */   {
/* 67 */     return this.personMapper.findNewNumber(gameId);
/*    */   }
/*    */ }


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\services\impl\PersonServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */