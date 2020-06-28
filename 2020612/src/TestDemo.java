import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: 2020612
 * @description
 * @author: mrs.yang
 * @create: 2020 -06 -12 14 :45
 */

public class TestDemo {
    static boolean paddy;
    public static void main8(String[] args) {
        System.out.println(paddy);
    }
    public static void main1(String[] args){
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        int[] arr=new int[str.length()];
        for(int i=0;i<str.length();i++){
            arr[i]=Integer.valueOf(str.charAt(i));
        }
        Arrays.sort(arr);
        int count=0;
        int tmp=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==tmp){
                count++;
            }else{
                System.out.println(arr[tmp]+":"+count);
                count=1;
                tmp=arr[i];
                if(i==arr.length-1){
                    System.out.println(arr[tmp]+":"+count);
                }
            }
        }
    }
    //个位数统计
    public static void main2(String[] args){
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        char[] ch=str.toCharArray();
        int[] arr=new int[10];
        for(int i=0;i<ch.length;i++){
            arr[ch[i]-'0']++;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                System.out.println(i+":"+arr[i]);
            }
        }
    }
    //构建乘积数组
    public int[] multiply(int[] A) {
        if(A==null){
            return null;
        }
       int[] B=new int[A.length];
        for (int i = 0; i <A.length ; i++) {
            int tmp=1;
            for (int j = 0; j <B.length ; j++) {
                if(j!=i){
                    B[i]=tmp*A[j];
                }
            }
        }
        return B;
    }
    //生成格雷码
    public String[] getGray(int n) {
        String[] ret=null;
        if(n==1){
            ret=new String[]{"0","1"};
        }else{
            String[] str=getGray(n-1);
            ret=new String[2*str.length];
            for(int i=0;i<str.length;i++){
                ret[i]="0"+str[i];
                ret[ret.length-1-i]="1"+str[i];
            }
        }
        return ret;
    }
    public static void main3(String[] args) {
       String str1="hello";
       String str2="he"+"llo";
        System.out.println(str1==str2);
    }
//打印正方形
    public static void main5(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        String c=scan.next();
        int tmp=(int)Math.round(n/2.0);
        for (int i = 0; i < tmp; i++) {
            for (int j = 0; j <n ; j++) {
               if(i==0 || i==tmp-1){
                   System.out.print(c);
               }else{
                   if(j==0||j==n-1){
                       System.out.print(c);
                   }else{
                       System.out.print(" ");
                   }
               }
            }
            System.out.println();
        }
    }
    //超长正整数相加
    public static void main4(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String str1=scan.nextLine();
            String str2=scan.nextLine();
            BigInteger m=new BigInteger(str1);
            BigInteger n=new BigInteger(str2);
            System.out.println(m.add(n));
        }
    }
    //组个最小数
    public static void main6(String[] args){
        Scanner scan =new Scanner(System.in);
        int[] arr=new int[10];
        for (int i = 0; i <10; i++) {
            arr[i]=scan.nextInt();
        }
        Arrays.sort(arr);
        if(arr[0]==0){
            for (int i = 0; i < 10; i++) {
                if(arr[i]!=0){
                    arr[0]=arr[i];
                    arr[i]=0;
                    break;
                }
            }
        }
        for(int i=0;i<10;i++){
            System.out.print(arr[i]);
        }
    }
    //任何一个整数m都可以写成m个连续奇数之和
    public static void main7(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int m = scan.nextInt();
            StringBuffer ret = new StringBuffer();
            for (int i = 0; i < 10000; i++) {
                if (Math.pow(m, 3) == Math.pow(m, 2) + m * (i - 1)) {
                    ret.append(i);
                    for (int j = 1; j < m; j++) {
                        ret.append('+');
                        ret.append(i + 2 * j);
                    }
                    break;
                }
            }
            System.out.println(ret.toString());
        }
    }
    //判断是否为平衡树
    /*private int treeHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(treeHeight(root.left),treeHeight(root.right))+1;
    }
    public boolean isBalance(TreeNode root) {
        if(root==null){
            return true;
        }
        if(Math.abs(treeHeight(root.left)-treeHeight(root.right))>1){
            return false;
        }
        return isBalance(root.left)&&isBalance(root.right);
    }*/

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=scan.nextInt();
        }
        int flag=1;
        int sum1=0,sum2=0,sum3=0;
        int count1=0,count2=0,count3=0,
                count4=0,count5=0;
        int max=0;;
        for (int i = 0; i < n; i++) {
            int tmp=arr[i];
            if(tmp%5==0&&tmp%2==0){
                sum1+=tmp;
                count1++;
            }else if(tmp%5==1){
                sum2=sum2+tmp*flag;
                flag=-1;
                count2++;
            }else if(tmp%5==2){
                count3+=1;
            }else if(tmp%5==3){
                sum3+=tmp;
                count4++;
            }else if(tmp%5==4){
                if(tmp>=max){
                    max=tmp;
                }
                count5++;
            }
        }
        double ave=sum3*1.0/count4;
        if(count1!=0){
            System.out.print(sum1+" ");
        }
            System.out.print("N"+" ");
        if(count2!=0){
            System.out.print(sum2+" ");
        }
        System.out.print("N"+" ");
        if(count3!=0){
            System.out.print(count3+" ");
        }
        System.out.println("N");
        if(count4!=0){
            System.out.printf("0.1f"+" ",ave);
        }
        System.out.println("N");
        if(count5!=0){
            System.out.println(max+" ");
        }
        System.out.println("N");
    }
}
