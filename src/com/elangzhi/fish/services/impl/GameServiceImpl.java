/*    */ package com.elangzhi.fish.services.impl;
/*    */ 
/*    */ import com.elangzhi.fish.dao.GameMapper;
/*    */ import com.elangzhi.fish.model.Game;
/*    */ import com.elangzhi.fish.services.GameService;
/*    */ import com.elangzhi.fish.services.PersonService;
/*    */ import com.elangzhi.fish.tools.UUIDFactory;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service("gameService")
/*    */ public class GameServiceImpl
/*    */   implements GameService
/*    */ {
/* 24 */   static Logger logger = Logger.getLogger(GameServiceImpl.class.getName());
/*    */   
/*    */   @Resource
/*    */   GameMapper gameMapper;
/*    */   
/*    */   @Resource
/*    */   PersonService personService;
/*    */   
/*    */ 
/*    */   public Long save(Game game)
/*    */   {
/* 35 */     game.setId(UUIDFactory.getLongId());
/* 36 */     game.setTime(new Date());
/* 37 */     return this.gameMapper.insertSelective(game);
/*    */   }
/*    */   
/*    */   public Integer deleteById(Long id)
/*    */   {
/* 42 */     return Integer.valueOf(this.gameMapper.deleteByPrimaryKey(id));
/*    */   }
/*    */   
/*    */   public Game findById(Long id)
/*    */   {
/* 47 */     return this.gameMapper.selectByPrimaryKey(id);
/*    */   }
/*    */   
/*    */   public Integer updateById(Game game)
/*    */   {
/* 52 */     return Integer.valueOf(this.gameMapper.updateByPrimaryKeySelective(game));
/*    */   }
/*    */   
/*    */ 
/*    */   public Game findNew()
/*    */   {
/* 58 */     List<Game> list = this.gameMapper.list();
/* 59 */     if ((list != null) && (list.size() > 0)) {
/* 60 */       return (Game)list.get(0);
/*    */     }
/* 62 */     return null;
/*    */   }
/*    */ }


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\services\impl\GameServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */