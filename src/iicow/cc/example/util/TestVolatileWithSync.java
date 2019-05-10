/**
 * 测试volatile可见性的一个很好的测试类
 * 当没有volatile修饰的时候，执行程序不会结束，卡在那了
 * @author wangxinyu
 * @date 2019/5/10 9:38
 * @verson 1.0
 **/
public class TestVolatileWithSync {
    //volatile修饰
     private volatile int count;

     public int get(){
         return count;
     }
     public
     //synchronized
     void set(int count){
         this.count = count;
     }

    public static void main(String[] args) {
        TestVolatileWithSync volatileWithSync = new TestVolatileWithSync();
        for(int i = 0;i<8;i++){
            new Thread(()->{
                int x = 0;
                while(volatileWithSync.get()<100){
                    x++;
                }
                System.out.println(x);
            }).start();
        }
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        volatileWithSync.set(200);
    }
}

