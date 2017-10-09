/*     */ package com.elangzhi.fish.model;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Person
/*     */ {
/*     */   private Long id;
/*     */   
/*     */ 
/*     */   private String name;
/*     */   
/*     */ 
/*     */   private Integer type;
/*     */   
/*     */ 
/*     */   private Integer number;
/*     */   
/*     */ 
/*     */   private String phone;
/*     */   
/*     */ 
/*     */   private String address;
/*     */   
/*     */ 
/*     */   private Double price;
/*     */   
/*     */ 
/*     */   private String intro;
/*     */   
/*     */   private String group;
/*     */   
/*     */   private Long gameId;
/*     */   
/*     */ 
/*     */   public Integer getNumber()
/*     */   {
/*  37 */     return this.number;
/*     */   }
/*     */   
/*     */   public void setNumber(Integer number) {
/*  41 */     this.number = number;
/*     */   }
/*     */   
/*     */   public Long getId() {
/*  45 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  49 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  53 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  57 */     this.name = (name == null ? null : name.trim());
/*     */   }
/*     */   
/*     */   public Integer getType() {
/*  61 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(Integer type) {
/*  65 */     this.type = type;
/*     */   }
/*     */   
/*     */   public String getPhone() {
/*  69 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/*  73 */     this.phone = (phone == null ? null : phone.trim());
/*     */   }
/*     */   
/*     */   public String getAddress() {
/*  77 */     return this.address;
/*     */   }
/*     */   
/*     */   public void setAddress(String address) {
/*  81 */     this.address = (address == null ? null : address.trim());
/*     */   }
/*     */   
/*     */   public Double getPrice() {
/*  85 */     return this.price;
/*     */   }
/*     */   
/*     */   public void setPrice(Double price) {
/*  89 */     this.price = price;
/*     */   }
/*     */   
/*     */   public String getIntro() {
/*  93 */     return this.intro;
/*     */   }
/*     */   
/*     */   public void setIntro(String intro) {
/*  97 */     this.intro = (intro == null ? null : intro.trim());
/*     */   }
/*     */   
/*     */   public Long getGameId() {
/* 101 */     return this.gameId;
/*     */   }
/*     */   
/*     */   public void setGameId(Long gameId) {
/* 105 */     this.gameId = gameId;
/*     */   }
/*     */   
/*     */   public String getGroup() {
/* 109 */     return this.group;
/*     */   }
/*     */   
/*     */   public void setGroup(String group) {
/* 113 */     this.group = group;
/*     */   }
/*     */ }


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\model\Person.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */