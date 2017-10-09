/*     */ package com.elangzhi.fish.tools;
/*     */ public class NumberSort
/*     */ {
/*     */   public static void bubbleSort(int[] numbers)
/*     */   {
/*  15 */     int size = numbers.length;
/*  16 */     for (int i = 0; i < size - 1; i++) {
/*  17 */       for (int j = i + 1; j < size; j++) {
/*  18 */         if (numbers[i] < numbers[j]) {
/*  19 */           int temp = numbers[i];
/*  20 */           numbers[i] = numbers[j];
/*  21 */           numbers[j] = temp;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void quickSort(int[] numbers, int start, int end) {
/*  28 */     if (start < end) {
/*  29 */       int base = numbers[start];
/*  31 */       int i = start;
				int j = end;
/*     */       
///*     */       break label21;
/*  34 */       i++;
///*     */       label21:
/*     */       do
/*     */       {
/*  33 */         if (numbers[i] < base) if (i < end)
/*     */             break;
/*  35 */         while ((numbers[j] > base) && (j > start))
/*  36 */           j--;
/*  37 */         if (i <= j) {
/*  38 */           int temp = numbers[i];
/*  39 */           numbers[i] = numbers[j];
/*  40 */           numbers[j] = temp;
/*  41 */           i++;
/*  42 */           j--;
/*     */         }
/*  32 */       } while (i <= j);
/*  45 */       if (start < j)
/*  46 */         quickSort(numbers, start, j);
/*  47 */       if (end > i)
/*  48 */         quickSort(numbers, i, end);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void selectSort(int[] numbers) {
/*  53 */     int size = numbers.length;
/*  54 */     for (int i = 0; i < size; i++) {
/*  55 */       int k = i;
/*  56 */       for (int j = size - 1; j > i; j--) {
/*  57 */         if (numbers[j] < numbers[k])
/*  58 */           k = j;
/*     */       }
/*  60 */       int temp = numbers[i];
/*  61 */       numbers[i] = numbers[k];
/*  62 */       numbers[k] = temp;
/*     */     }
/*     */   }
/*     */   
/*     */   public static void insertSort(int[] numbers)
/*     */   {
/*  68 */     int size = numbers.length;
/*  69 */     for (int i = 1; i < size; i++) {
/*  70 */       int temp = numbers[i];
/*  71 */       for (int j = i; (j > 0) && (temp < numbers[(j - 1)]); j--) {
/*  72 */         numbers[j] = numbers[(j - 1)];
				  numbers[j]= temp;
				  }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void mergeSort(int[] numbers, int left, int right) {
/*  78 */     int t = 1;
/*  79 */     int size = right - left + 1;
/*  80 */     while (t < size) {
/*  81 */       int s = t;
/*  82 */       t = 2 * s;
/*  83 */       int i = left;
/*  84 */       while (i + (t - 1) < size) {
/*  85 */         merge(numbers, i, i + (s - 1), i + (t - 1));
/*  86 */         i += t;
/*     */       }
/*  88 */       if (i + (s - 1) < right)
/*  89 */         merge(numbers, i, i + (s - 1), right);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void merge(int[] data, int p, int q, int r) {
/*  94 */     int[] B = new int[data.length];
/*  95 */     int s = p;
/*  96 */     int t = q + 1;
/*  97 */     int k = p;
/*  98 */     while ((s <= q) && (t <= r)) {
/*  99 */       if (data[s] <= data[t]) {
/* 100 */         B[k] = data[s];
/* 101 */         s++;
/*     */       } else {
/* 103 */         B[k] = data[t];
/* 104 */         t++;
/*     */       }
/* 106 */       k++;
/*     */     }
/* 108 */     if (s == q + 1) {
/* 109 */       B[(k++)] = data[(t++)];
/*     */     } else
/* 111 */       B[(k++)] = data[(s++)];
/* 112 */     for (int i = p; i <= r; i++) {
/* 113 */       data[i] = B[i];
/*     */     }
/*     */   }
/*     */ }


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\tools\NumberSort.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */