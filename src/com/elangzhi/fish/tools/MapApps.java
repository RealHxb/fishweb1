/*    */ package com.elangzhi.fish.tools;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class MapApps
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 12 */     Emp emp = new Emp("001", "张三");
/* 13 */     Emp emp2 = new Emp("005", "李四");
/* 14 */     Emp emp3 = new Emp("004", "王一");
/*    */     
/* 16 */     Map map = new java.util.HashMap();
/* 17 */     map.put(emp.getE_id(), emp.getE_name());
/* 18 */     map.put(emp2.getE_id(), emp2.getE_name());
/* 19 */     map.put(emp3.getE_id(), emp3.getE_name());
/* 20 */     Set set = map.keySet();
/* 21 */     System.out.println("Map集合中所有元素是：");
/* 22 */     Iterator it = set.iterator();
/* 23 */     while (it.hasNext()) {
/* 24 */       String key = (String)it.next();
/* 25 */       String name = (String)map.get(key);
/* 26 */       System.out.println(key + " " + name);
/*    */     }
/* 28 */     map.remove("005");
/* 29 */     System.out.println("Map集合中执行删除操作后所有元素是：");
/* 30 */     Iterator it2 = set.iterator();
/* 31 */     while (it2.hasNext()) {
/* 32 */       String key = (String)it2.next();
/* 33 */       String name = (String)map.get(key);
/* 34 */       System.out.println(key + " " + name);
/*    */     }
/*    */   }
/*    */ }


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\tools\MapApps.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */