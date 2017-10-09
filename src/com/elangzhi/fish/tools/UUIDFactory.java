/*    */ package com.elangzhi.fish.tools;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.UUID;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UUIDFactory
/*    */ {
/*    */   public static Long getLongId()
/*    */   {
/* 16 */     Long id = Long.valueOf(UUID.randomUUID().getMostSignificantBits());
/*    */     
/* 18 */     return Long.valueOf(Math.abs(id.longValue()));
/*    */   }
/*    */   
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 24 */     for (int i = 0; i < 1000; i++) {
/* 25 */       Long id = getLongId();
/*    */       
/* 27 */       System.out.println(id);
/*    */     }
/*    */   }
/*    */ }


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\tools\UUIDFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */