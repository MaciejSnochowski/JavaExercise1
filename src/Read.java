
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
        static BufferedReader bufferedReader ;
        Lock locker = new ReentrantLock();

        int howMany;

    public  Read(FileReader fileReader,int howMany) throws  IOException,FileNotFoundException{
        bufferedReader =new BufferedReader(fileReader);
        this.howMany=howMany;
    }

    @Override
    public String call() throws Exception {
        String answer="";
        try {
            answer = bufferedReader.readLine();
                Thread.sleep(600);

        }catch (Exception exception){
            exception.getStackTrace();
        }
        finally {



            System.out.println("Wynik czytania wysyłania obiektu => "+answer + " Wątek:"+Thread.currentThread().getId());
            return answer+" <= odpowiedź Future| thread: "+Thread.currentThread().getId();

        }

    }
}
