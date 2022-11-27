
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Read implements Callable<String> {
   //BufferReader musi być static ponieważ każdy reader korzysta z niego
        static BufferedReader bufferedReader ;
        Lock locker = new ReentrantLock();
        int counter=0;
        static ArrayList<Long> listOfIdThread;


       private int howMany;

    public  Read(FileReader fileReader,int howMany) throws  IOException,FileNotFoundException{
        bufferedReader =new BufferedReader(fileReader);
        this.howMany=howMany;
     //   atomicInteger.set(0);
        listOfIdThread = new ArrayList<Long>();
    }
//    public int incrementCounter(){
//
//         return atomicInteger.getAndIncrement();
//
//    }
    //blokowanie wątku jeśli został wykorzystany 2 razy
    static public void getList(){
        System.out.println("init "+ listOfIdThread.get(0));
        for (long numb:listOfIdThread
             ) {
            System.out.println(numb);

        }
    }

    @Override
    public String call() throws Exception {

        String answer="";
      // int[] lista=new int[]{};
      //  int temp=0;
        //
        try {


            answer = bufferedReader.readLine();
                counter++;
              // System.out.println("call(). " +answer);
               // incrementCounter();
              //  synchronized (locker) {

                  //  counter = atomicInteger.get()
                Thread.sleep(600);


        }catch (Exception exception){
            exception.getStackTrace();
        }
        finally {


           // listOfIdThread.add(Thread.currentThread().getId());
            System.out.println("Wynik czytania => "+answer + " Wątek:"+Thread.currentThread().getId());
            return answer+" :anwser | thread: "+Thread.currentThread().getId();

        }

    }
}
