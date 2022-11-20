import java.util.concurrent.Callable;

public class Zadanie implements Callable<String> {

    private long waitTime;
    private int liczba1;
    private int liczba2;
    private char dzialanie;
    public float wynik;

    public Zadanie(int czas, int l1, int l2, char dzialanie){
        this.waitTime=czas;
        this.liczba1 = l1;
        this.liczba2 = l2;
        this.dzialanie = dzialanie;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        switch(this.dzialanie){
            case '*':
                this.wynik = this.liczba1 * this.liczba2;
                break;
            case '+':
                this.wynik = this.liczba1 + this.liczba2;
                break;
            case '-':
                this.wynik = this.liczba1 - this.liczba2;
                break;
            case '/':
                if(this.liczba2 != 0) {
                    this.wynik = this.liczba1 / this.liczba2;
                }
                break;
            default:
                return Thread.currentThread().getName() + " nie mozna wykonac dzialania";
        }
        //return the thread name executing this callable task
        return Thread.currentThread().getName() + " - wynik: " + this.wynik;
    }

}
