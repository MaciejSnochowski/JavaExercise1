import javax.crypto.spec.PSource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;


//opisac np callable
public class Main {
    static int counter=0;
    static void countHowManyLines(FileReader fileReader) throws IOException {
         BufferedReader bufferedReader = new BufferedReader(fileReader);
         while(bufferedReader.readLine()!=null){
             counter++;
         }
    }
    static int howManyLines(){
         return counter ;
    }
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, TimeoutException {
      int threads =Integer.parseInt(args[0]);

        //Deklaracja list do przechowywania obiektów
        ArrayList<Read> ReadArrayList= new ArrayList<Read>();

        ArrayList<Future<String>> FutureArrayList= new ArrayList<>();
        //Executor service
        ExecutorService exec = Executors.newFixedThreadPool(threads);
        //Odczytywanie pliku aby dowiedzieć się ile ma linii
        countHowManyLines(new FileReader("src/File.txt"));
        //howManyLines(); zwraca int z ilością linii w pliku

       //Tworzenie Readerów i dodawanie ich do listy
        for (int i = 0; i <howManyLines() ; i++) {
            ReadArrayList.add(new Read(new FileReader("src/File.txt"),howManyLines()));
        }
      //  List<Future<String>> resultList ;

        //Wysyłanie listy z obiektami Callable do executora
     //   resultList=exec.invokeAll(ReadArrayList); //prawdopodobnie nie może być ponieważ wszyskie wątki "rzucają się na zmienne"
        for (Read reader: ReadArrayList //iloś wątków det
       ) {

           // Thread.sleep(600);

            FutureArrayList.add(exec.submit(reader));
            //Future<String> ft=exec.submit(reader);
            // ft.get();


        }
        exec.shutdown();
        System.out.println("wielkosc listy "+FutureArrayList.size());
        for (int i = 0; i <FutureArrayList.size() ; i++) {
            System.out.println(FutureArrayList.get(i).get(7,TimeUnit.SECONDS));

        }
        System.out.println(
                "koniec"
        );





    }
}