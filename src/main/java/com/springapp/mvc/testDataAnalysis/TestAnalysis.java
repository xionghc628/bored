package com.springapp.mvc.testDataAnalysis;

import java.text.DecimalFormat;
import java.util.Random;

public class TestAnalysis {


    private final static double dmax=999;//Double.MAX_VALUE;//Double类型的最大值，太大的double值，相乘会达到无穷大
    private final static double dmin=Double.MIN_VALUE;//Double类型的最小值
    private final static int n=100;//假设求取100个doubl数的方差和标准差

    public static void main(String[] args){
        Random random = new Random();
        double[] x=new double[n];
        for(int i=0;i<n;i++){//随机生成n个double数
            x[i]=Double.valueOf(Math.floor(random.nextDouble()*(dmax-dmin)));
            System.out.println(x[i]);
        }
        //设置doubl字符串输出格式，不以科学计数法输出
        DecimalFormat df=new DecimalFormat("#,##0.00");//格式化设置
        //计算均值
        double avg =avg(x);
        //计算标准差
        double dS=StandardDiviation(x);
        System.out.println("均值为："+avg+",标准差为："+dS+",极限值为：="+(avg+3*dS) + " 或者"+(avg-3*dS));
    }

    //方差s^2=[(x1-x)^2 +...(xn-x)^2]/n
    public static double avg(double[] x) {
        int m=x.length;
        double sum=0;
        for(int i=0;i<m;i++){//求和
            sum+=x[i];
        }
        //求平均值
        return sum/m;
    }

    //标准差σ=sqrt(s^2)
    public static double StandardDiviation(double[] x) {
        int m = x.length;
        double sum = 0;
        for (int i = 0; i < m; i++) {//求和
            sum += x[i];
        }
        double dAve = sum / m;//求平均值
        double dVar = 0;
        for (int i = 0; i < m; i++) {//求方差
            dVar += (x[i] - dAve) * (x[i] - dAve);
        }
        return Math.sqrt(dVar / m);
    }



}
