/*    */ package com.elangzhi.fish.controller.json;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Tip
/*    */ {
/*    */   Boolean success;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   Integer code;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   Object data;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Tip()
/*    */   {
/* 30 */     this.success = Boolean.valueOf(true);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Tip(Object data)
/*    */   {
/* 37 */     this.success = Boolean.valueOf(true);
/* 38 */     this.data = data;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Tip(Integer code)
/*    */   {
/* 46 */     this.success = Boolean.valueOf(false);
/* 47 */     this.code = code;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Tip(Integer code, Object data)
/*    */   {
/* 56 */     this.success = Boolean.valueOf(false);
/* 57 */     this.code = code;
/* 58 */     this.data = data;
/*    */   }
/*    */   
/*    */   public Boolean getSuccess() {
/* 62 */     return this.success;
/*    */   }
/*    */   
/*    */   public void setSuccess(Boolean success) {
/* 66 */     this.success = success;
/*    */   }
/*    */   
/*    */   public Integer getCode() {
/* 70 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(Integer code) {
/* 74 */     this.code = code;
/*    */   }
/*    */   
/*    */   public Object getData() {
/* 78 */     return this.data;
/*    */   }
/*    */   
/*    */   public void setData(Object data) {
/* 82 */     this.data = data;
/*    */   }
/*    */ }


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\controller\json\Tip.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */