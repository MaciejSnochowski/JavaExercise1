import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Read> ReadArrayList= new ArrayList<Read>();
        ArrayList<Future<String>> ReadArrayListFuture= new ArrayList<Future<String>>();

        ArrayList<Do> doArrayList= new ArrayList<Do>();
        ArrayList<Future<Integer>> doArrayListFuture= new ArrayList<Future<Integer>>();
        ExecutorService exec = Executors.newFixedThreadPool(2);
        for (int i = 0; i <10 ; i++) {
          //  doArrayList.add(new Do(i));
            ReadArrayList.add(new Read(new FileReader("src/File.txt")));

        }
//        for (Do dus:doArrayList
//             ) {
//            doArrayListFuture.add(exec.submit(dus));
//
//        }
        for (Read rd:ReadArrayList
        ) {
            ReadArrayListFuture.add(exec.submit(rd));

        }
        try {
            Thread.sleep(10000);
        }catch (InterruptedException E){
            E.printStackTrace();
        }
        exec.shutdown();
        for (Future<String> a:ReadArrayListFuture){
            String msg="";
            try{
                if (a.isCancelled()){
                    msg+=" zadanie "+a +" Anulowane";
                } else if (a.isDone()) {
                    msg+=Thread.currentThread().getId()+" zadanie "+ a+ " wykonane: "+a.get();

                }else msg+= "zadanie "+ a + " jeszcze nie wykonanne";


            }catch (Exception e){

                e.printStackTrace();
            }
            System.out.println(msg);
        }
        System.out.println(" ExecutionService isTerminated: "+ exec.isTerminated());
        System.out.println( "uruchomiono zadań: "+ doArrayListFuture.size());


    }
}