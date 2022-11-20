import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {

    public static void main(String[] args) {
        Zadanie dzialanie1 = new Zadanie(1000, 12, 15, '+');
        Zadanie dzialanie2 = new Zadanie(1000, 12, 15, '-');
        Zadanie dzialanie3 = new Zadanie(1000, 12, 15, '*');

        FutureTask<String> futureTask1 = new FutureTask<String>(dzialanie1);
        FutureTask<String> futureTask2 = new FutureTask<String>(dzialanie2);
        FutureTask<String> futureTask3 = new FutureTask<String>(dzialanie3);

        ExecutorService executor = Executors.newFixedThreadPool(1);
//        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(futureTask1);
        executor.execute(futureTask2);
        executor.execute(futureTask3);

        while (true) {
            try {

                if(!futureTask1.isDone()){
                    //wait indefinitely for future task to complete
                    System.out.println("FutureTask1 output= "+futureTask1.get());
                }

                if(!futureTask2.isDone()){
                    //wait indefinitely for future task to complete
                    System.out.println("FutureTask2 output= "+futureTask2.get());
                }

                if(!futureTask3.isDone()){
                    //wait indefinitely for future task to complete
                    System.out.println("FutureTask3 output= "+futureTask3.get());
                }

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
