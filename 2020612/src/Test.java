import java.util.*;

/**
 * @program: 2020612
 * @description
 * @author: mrs.yang
 * @create: 2020 -06 -17 17 :06
 */
class X{
    Y y=new Y();
    public X(){
        System.out.println("X");
    }
}
class Y{
    public Y(){
        System.out.println("Y");
    }
}
public class Test extends X{
    Y y=new Y();
    public Test(){
        System.out.println("Z");
    }

    public static void main7(String[] args) {
        new Test();//YXYZ
    }
    /*public static void main1(String[] args) {
        A classa=new A("hehe");
        A classb=new A("hehe");
        System.out.println(classa==classb);
    }*/
    //饥饿的小易
    static final int max=100000;
    static final long place=1000000007L;
    public static long find(long m){
        Map<Long,Integer> map=new HashMap<>();
        Queue<Long> queue=new LinkedList<>();
        queue.offer(m);
        map.put(m,0);
        while(!queue.isEmpty()){
            long x=queue.poll();
            if(map.get(x)>max){
                break;
            }
            if(x==0){
               return map.get(x);
            }
            long y=((x<<2)+3)%place;
            if(y==0){
                return map.get(x)+1;
            }
            if(!map.containsKey(y)){
                map.put(y,map.get(y)+1);
                queue.offer(y);
            }
            y=((x<<3)+7)%place;
            if(y==0){
                return map.get(x)+1;
            }
            if(!map.containsKey(y)){
                map.put(y,map.get(y)+1);
                queue.offer(y);
            }
        }
        return -1L;
    }
    //不使用算数运算符两个数相加
    public int addAB(int A, int B) {
        int x=A^B;
        int y=(A&B)<<1;
        return x+y;
    }
    //洗牌
    public static void main2(String[] args) {
        Scanner scan=new Scanner(System.in);
        int T=scan.nextInt();
        for (int i = 0; i < T; i++) {
            int n=scan.nextInt();
            int k=scan.nextInt();
            int[] arr=new int[2*n];
            for (int j = 0; j <2*n; j++) {
                arr[j]=scan.nextInt();
            }
            for (int j = 0; j <k ; j++) {
                func(arr,2*n);
            }
            for (int j = 0; j < 2*n-1; j++) {
                System.out.print(arr[j]+" ");
            }
            System.out.print(arr[2*n-1]);
        }
    }
    private static void func(int[] arr, int m) {
        List<Integer> list=new ArrayList<>(m);
        for (int i = 0; i < m/2; i++) {
            list.add(arr[i]);
            list.add(arr[i+m/2]);
        }
        for (int i = 0; i < m; i++) {
            arr[i]=list.get(i);
        }
    }
    //统计同成绩学生人数
    public static void main3(String[] args) {
        Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();
        int[] arr=new int[N];
        if(N==0){
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[i]=scan.nextInt();
        }
        int score=scan.nextInt();
        int count=0;
        for (int i = 0; i < N; i++) {
            if(arr[i]==score){
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main4(String[] args) {
        String str1=new String("hello");
        String str2=new String("hello");
        System.out.println(str1==str2);//false
        System.out.println(str1.equals(str2) );//true
    }
//组个最小数
    public static void main5(String[] args) {
        Scanner scan=new Scanner(System.in);
        int[] arr=new int[10];
        for(int i=0;i<10;i++){
          arr[i]=scan.nextInt();
        }
        for (int i = 1; i <10 ; i++) {
            if(arr[i]!=0){
                System.out.print(i);
                arr[i]--;
                break;
            }
        }
        while(arr[0]!=0){
            System.out.print(0);
            arr[0]--;
        }
        for (int i = 1; i < 10; i++) {
            while(arr[i]!=0){
                System.out.print(i);
                arr[i]--;
            }
        }
    }
    //不通过的代码
    public static void main6(String[] args) {
        Scanner scan=new Scanner(System.in);
        StringBuffer ret=new StringBuffer();
        while(scan.hasNext()){
            int n=scan.nextInt();
            int s=n^2-n+1;
            ret.append(s);
            for(int i=1;i<n;i++){
                ret.append("+");
                ret.append(s+=2);
            }
            System.out.println(ret.toString());
        }
    }
}
