import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Read implements Callable<String> {
    static BufferedReader bufferedReader ;
  //  Lock lock = new ReentrantLock();
    private Random random = new Random();
    //    String anws;
    static  int counter=0;


    public int EnhancedReadLine() throws IOException {
        bufferedReader.readLine();
        counter++;
        return counter;
    }

    public  Read(FileReader fileReader) throws  IOException,FileNotFoundException{
        bufferedReader =new BufferedReader(fileReader);
    }




    @Override
    public String call() throws Exception,IOException {
        String anwser="";
        try {

                anwser+= bufferedReader.readLine();
            bufferedReader.mark(1);





                counter++;


        }finally {

            bufferedReader.close();
            System.out.println("Wynik czytania => "+anwser + " "+Thread.currentThread().getId());
            return anwser+"  *  "+random.nextInt(5)+1;
        }

    }
}
