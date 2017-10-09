/*     */ package com.elangzhi.fish.model;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Grade
/*     */ {
/*     */   private Long id;
/*     */   private Long personId;
/*     */   private Long gameId;
/*     */   private Date time;
/*     */   private Integer chang;
/*     */   private Integer qu;
/*     */   private Integer room;
/*  21 */   private Integer number = Integer.valueOf(0);
/*     */   
/*  23 */   private Double weight = Double.valueOf(0.0D);
/*     */   
/*  25 */   private Double grade = Double.valueOf(0.0D);
/*     */   
/*  27 */   private Double ranking = Double.valueOf(0.0D);
/*     */   
/*     */   private Double defen;
/*     */   
/*     */   private Double sorts;
/*     */   
/*     */   private Integer quCount;
/*     */   
/*     */   List<Grade> child;
/*     */   private String personName;
/*     */   private Integer personNumber;
/*     */   
/*     */   public List<Grade> getChild()
/*     */   {
/*  41 */     return this.child;
/*     */   }
/*     */   
/*     */   public void setChild(List<Grade> child) {
/*  45 */     this.child = child;
/*     */   }
/*     */   
/*     */   public Integer getQuCount() {
/*  49 */     return this.quCount;
/*     */   }
/*     */   
/*     */   public void setQuCount(Integer quCount) {
/*  53 */     this.quCount = quCount;
/*     */   }
/*     */   
/*     */   public Integer getPersonNumber() {
/*  57 */     return this.personNumber;
/*     */   }
/*     */   
/*     */   public void setPersonNumber(Integer personNumber) {
/*  61 */     this.personNumber = personNumber;
/*     */   }
/*     */   
/*     */   public Integer getRoom() {
/*  65 */     return this.room;
/*     */   }
/*     */   
/*     */   public void setRoom(Integer room) {
/*  69 */     this.room = room;
/*     */   }
/*     */   
/*     */   public String getPersonName() {
/*  73 */     return this.personName;
/*     */   }
/*     */   
/*     */   public void setPersonName(String personName) {
/*  77 */     this.personName = personName;
/*     */   }
/*     */   
/*     */   public Long getId() {
/*  81 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  85 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Long getPersonId() {
/*  89 */     return this.personId;
/*     */   }
/*     */   
/*     */   public void setPersonId(Long personId) {
/*  93 */     this.personId = personId;
/*     */   }
/*     */   
/*     */   public Long getGameId() {
/*  97 */     return this.gameId;
/*     */   }
/*     */   
/*     */   public void setGameId(Long gameId) {
/* 101 */     this.gameId = gameId;
/*     */   }
/*     */   
/*     */   public Date getTime() {
/* 105 */     return this.time;
/*     */   }
/*     */   
/*     */   public void setTime(Date time) {
/* 109 */     this.time = time;
/*     */   }
/*     */   
/*     */   public Integer getChang() {
/* 113 */     return this.chang;
/*     */   }
/*     */   
/*     */   public void setChang(Integer chang) {
/* 117 */     this.chang = chang;
/*     */   }
/*     */   
/*     */   public Integer getQu() {
/* 121 */     return this.qu;
/*     */   }
/*     */   
/*     */   public void setQu(Integer qu) {
/* 125 */     this.qu = qu;
/*     */   }
/*     */   
/*     */   public Integer getNumber() {
/* 129 */     return this.number;
/*     */   }
/*     */   
/*     */   public void setNumber(Integer number) {
/* 133 */     this.number = number;
/*     */   }
/*     */   
/*     */   public Double getWeight() {
/* 137 */     return this.weight;
/*     */   }
/*     */   
/*     */   public void setWeight(Double weight) {
/* 141 */     this.weight = weight;
/*     */   }
/*     */   
/*     */   public Double getGrade() {
/* 145 */     return this.grade;
/*     */   }
/*     */   
/*     */   public void setGrade(Double grade) {
/* 149 */     this.grade = grade;
/*     */   }
/*     */   
/*     */   public Double getRanking() {
/* 153 */     return this.ranking;
/*     */   }
/*     */   
/*     */   public void setRanking(Double ranking) {
/* 157 */     this.ranking = ranking;
/*     */   }
/*     */   
/*     */   public Double getDefen() {
/* 161 */     return this.defen;
/*     */   }
/*     */   
/*     */   public void setDefen(Double defen) {
/* 165 */     this.defen = defen;
/*     */   }
/*     */   
/*     */   public Double getSorts() {
/* 169 */     return this.sorts;
/*     */   }
/*     */   
/*     */   public void setSorts(Double sorts) {
/* 173 */     this.sorts = sorts;
/*     */   }
/*     */ }


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\model\Grade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */