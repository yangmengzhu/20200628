import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: 2020612
 * @description
 * @author: mrs.yang
 * @create: 2020 -06 -19 15 :16
 */

public class TestDemo1 {
    //饥饿的小易
    private static int func(int count){
        if(count%3==0){
            return count/3;
        }else{
            return count/3+1;
        }
    }
    public static void main9(String[] args){
        Scanner scan=new Scanner(System.in);
        int x=scan.nextInt();
        int count=0;
        while(x!=0&&count<=300000){
            x=(x*2+1)%1000000007;//两次2x+1=4x+3,第一步让x=2x+1
            count++;
        }
        int ret=func(count);
        System.out.println(ret<100000?ret:-1);
    }
    public static void main3(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr=new int[n];
        int start=0;
        for(int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }
        List<int[]> list=new ArrayList<>();
        //排列组合
        organized(arr,n,list,start);
    }

    private static void organized(int[] arr, int n, List<int[]> list,int start) {
        if(start==n){
            return;
        }
        if(start==n-1){
            int[] arr1=arr.clone();
            list.add(arr1);
            return;
        }
        for (int i = start; i <n ; i++) {
            swap(arr,start,i);
            organized(arr,n,list,start+1);
            swap(arr,start,i);
        }
    }

    private static void swap(int[] arr, int start, int i) {
        int tmp=arr[i];
        arr[i]=arr[start];
        arr[start]=tmp;
    };


    public String name="abc";
    public static void main1(String[] args) {
        TestDemo1 test=new TestDemo1();
        TestDemo1 testb=new TestDemo1();
        System.out.println(test.equals(testb)+","+test.name.equals(testb.name) );
    }

    public static void main2(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int n=scan.nextInt();
            int[] arr=new int[n];
            for (int i = 0; i < n; i++) {
                arr[i]=scan.nextInt();
            }

        }
    }
    //二叉树的镜像
    /*public void Mirror(TreeNode root) {
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        if(root.left!=null){
            Mirror(root.left);
        }
        if(root.right!=null){
            Mirror(root.right);
        }
    }*/
    //富翁问题
    public static void main4(String[] args) {
        long rich=30*10;
        long strange=(1<<30)-1;
        System.out.println(rich+" "+strange);
    }
    private static double ratio(String str,int n){
        double ret=0;
        int count=0;
        for (char ch:str.toCharArray()) {
            if(ch=='C'||ch=='G'){
                count++;
            }
        }
        ret=(double)count/n;
        return ret;
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        int n=scan.nextInt();
        String maxStr="";
        double max=0;
        for (int i = 0; i <str.length()-n+1 ; i++) {
           String str1=str.substring(i,i+n);
            double ret=ratio(str1,n);
            if(ret>max){
               maxStr=str1;
               max=ret;
            }
        }
        System.out.println(maxStr);
    }
}
