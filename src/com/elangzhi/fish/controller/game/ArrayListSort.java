/*    */ package com.elangzhi.fish.controller.game;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Scanner;
/*    */ 
/*    */ public class ArrayListSort
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/* 10 */     ArrayList<Integer> list = new ArrayList();
/* 11 */     Scanner input = new Scanner(System.in);
/* 12 */     int num = 0;
/*    */     do
/*    */     {
/* 15 */       System.out.print("请输入一个整数（输入0结束）：");
/* 16 */       num = input.nextInt();
/* 17 */       list.add(Integer.valueOf(num));
/* 18 */     } while (num != 0);
/* 19 */     System.out.println("结束输入！");
/*    */     
/*    */     int j;
/*    */     
/* 23 */     for (int i = 0; i < list.size() - 1; i++) {
/* 24 */       for (j = 0; j < list.size() - i - 1; j++) {
/* 25 */         if (((Integer)list.get(j)).intValue() > ((Integer)list.get(j + 1)).intValue())
/*    */         {
/* 27 */           Integer temp = (Integer)list.get(j);
/* 28 */           list.set(j, (Integer)list.get(j + 1));
/* 29 */           list.set(j + 1, temp);
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 35 */     System.out.println("排序后的结果是：");
/* 36 */     for (Integer i : list) {
/* 37 */       System.out.print(i.intValue() + "  ");
/*    */     }
/* 39 */     input.close();
/*    */   }
/*    */ }

