/*    */ package com.elangzhi.fish.model;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Game
/*    */ {
/*    */   private Long id;
/*    */   private String name;
/*    */   private Date time;
/*    */   private String zhu;
/*    */   private String cheng;
/*    */   private Integer chang;
/*    */   private Integer qu;
/*    */   private String intro;
/*    */   
/*    */   public Long getId()
/*    */   {
/* 23 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 27 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 31 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 35 */     this.name = (name == null ? null : name.trim());
/*    */   }
/*    */   
/*    */   public Date getTime() {
/* 39 */     return this.time;
/*    */   }
/*    */   
/*    */   public void setTime(Date time) {
/* 43 */     this.time = time;
/*    */   }
/*    */   
/*    */   public String getZhu() {
/* 47 */     return this.zhu;
/*    */   }
/*    */   
/*    */   public void setZhu(String zhu) {
/* 51 */     this.zhu = (zhu == null ? null : zhu.trim());
/*    */   }
/*    */   
/*    */   public String getCheng() {
/* 55 */     return this.cheng;
/*    */   }
/*    */   
/*    */   public void setCheng(String cheng) {
/* 59 */     this.cheng = (cheng == null ? null : cheng.trim());
/*    */   }
/*    */   
/*    */   public Integer getChang() {
/* 63 */     return this.chang;
/*    */   }
/*    */   
/*    */   public void setChang(Integer chang) {
/* 67 */     this.chang = chang;
/*    */   }
/*    */   
/*    */   public Integer getQu() {
/* 71 */     return this.qu;
/*    */   }
/*    */   
/*    */   public void setQu(Integer qu) {
/* 75 */     this.qu = qu;
/*    */   }
/*    */   
/*    */   public String getIntro() {
/* 79 */     return this.intro;
/*    */   }
/*    */   
/*    */   public void setIntro(String intro) {
/* 83 */     this.intro = (intro == null ? null : intro.trim());
/*    */   }
/*    */ }


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\model\Game.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */