package com.springapp.mvc.testModel;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by xionghuacheng on 2018/6/1.
 */
public class Context {

   /**
    * 消费线程数
    */
   private int cusmmerNum;

   /**
    * 生产队列
    */
   private LinkedBlockingQueue productList;

   /**
    * 执行类名
    */
   private String excutorClass;


   public static void init(int threadNum,int producerNum,String className){
      Context context = new Context();
      context.setCusmmerNum(threadNum);
   }

   public int getCusmmerNum() {
      return cusmmerNum;
   }

   public void setCusmmerNum(int cusmmerNum) {
      this.cusmmerNum = cusmmerNum;
   }

   public LinkedBlockingQueue getProductList() {
      return productList;
   }

   public void setProductList(LinkedBlockingQueue productList) {
      this.productList = productList;
   }

   public String getExcutorClass() {
      return excutorClass;
   }

   public void setExcutorClass(String excutorClass) {
      this.excutorClass = excutorClass;
   }
}
