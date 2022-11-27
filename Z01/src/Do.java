import java.util.Random;
import java.util.concurrent.Callable;

public class Do implements Callable<Integer> {
    private int numb = 0;
    public   String name= String.valueOf(numb);
    private Random random = new Random();
    Do(int numb){
        this.numb=numb;
    }
    @Override
    public Integer call() throws Exception {
       int n= random.nextInt(51)*(random.nextInt(2)+1);
        System.out.println("Odczytano "+ Thread.currentThread().getId());
        return n;
    }
}
