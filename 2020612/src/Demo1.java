import java.util.*;

/**
 * @program: 2020612
 * @description
 * @author: mrs.yang
 * @create: 2020 -06 -22 17 :07
 */
class Student{
    String name;
    int score;
    public Student(String name, int score){
        this.name=name;
        this.score=score;
    }
}
public class Demo1 {
    public boolean[] chkSubStr(String[] p, int n, String s) {
     boolean[] arr=new boolean[n];
        for (int i = 0; i < n; i++) {
            boolean ret = s.contains(p[i]);
            arr[i]=ret;
        }
        return arr;
    }
//成绩排序
    public static void main1(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int num=scan.nextInt();
            int m=scan.nextInt();
            List<Student> list=new ArrayList<>();
            for (int i = 0; i < num; i++) {
                Student s=new Student(scan.next(),scan.nextInt());
                list.add(s);
            }
            if(m==0){
                list.sort((o1,o2)->o2.score-o1.score);
            }else{
                list.sort((o1,o2)->o1.score-o2.score);
            }
            for (Student p:list) {
                System.out.println(p.name+" "+p.score);
            }
        }
    }
    //微信红包
    public int getValue(int[] gifts, int n) {
       Arrays.sort(gifts);
      int ret=gifts[n/2];
      int count=0;
        for (int i = 0; i < n; i++) {
           if(gifts[i]==ret){
               count++;
           }
        }
        return count>n/2?gifts[n/2]:0;
    }
    //分割链表
     class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
        public ListNode partition(ListNode pHead, int x) {
            ListNode left=new ListNode(0);
            ListNode right=new ListNode(0);
            ListNode m=left;
            ListNode n=right;
            while(pHead!=null){
                if(pHead.val<x){
                    left.next=pHead;
                    pHead=pHead.next;
                    left=left.next;
                }else{
                    right.next=pHead;
                    pHead=pHead.next;
                    right=right.next;
                }
            }
            if(m.next==null){
                right.next=null;
                return n.next;
            }else if(n.next==null){
                left.next=null;
                return m.next;
            }else{
                left.next=n.next;
                right.next=null;
                return m.next;
            }
        }
static int foo(int x,int y){
        if(x<=0||y<=0)
            return 1;
        return 3*foo(x-6,y-2);
}

    public static void main2(String[] args) {
        System.out.printf("%d\n",foo(20,13));
    }
//最难的问题--密文转换
    public static void main3(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String str=scan.nextLine();
            char[] ch=str.toCharArray();
            for (int i = 0; i <ch.length; i++) {
                char ch1=ch[i];
               if(ch1-'A'>=0){
                  ch1=(char)(ch1>'E'?ch1-5:ch1+21);
                  ch[i]=ch1;
               }
            }
            System.out.println(new String(ch));
        }
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String seller=scan.nextLine();
        String buyer=scan.nextLine();
        HashMap<Character,Integer> s=new HashMap<>();
        HashMap<Character,Integer> b=new HashMap<>();
        for (char ss:seller.toCharArray()) {
            if(s.containsKey(ss)){
                s.put(ss,s.get(ss)+1);
            }else{
                s.put(ss,1);
            }
        }
        for (char bb:buyer.toCharArray()) {
            if(b.containsKey(bb)){
                b.put(bb,b.get(bb)+1);
            }else{
                b.put(bb,1);
            }
        }
        boolean isBuy=true;
        int lackNum=0;
        for (Map.Entry<Character,Integer> ret:b.entrySet()) {
            char key=ret.getKey();
            int value=ret.getValue();
            if(s.containsKey(key)&&s.get(key)<value){
                isBuy=false;
                lackNum+=value-s.get(key);
            }else if(!s.containsKey(key)){
               isBuy=false;
               lackNum+=value;
            }
        }
        if(isBuy){
            System.out.println("Yes "+(seller.length()-buyer.length()));
        }else{
            System.out.println("No "+lackNum);
        }
    }

}
