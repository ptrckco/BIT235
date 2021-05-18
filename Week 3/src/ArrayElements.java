
public class ArrayElements {

	boolean[] array1 = {false,false,false};

    int count = 0;

     void set(boolean[] arr, int x){

          arr[x] = true;

          count++;

          System.out.println(count);

      }

    void func(){

    if(array1[0] && (

       array1[++count - 2] || array1 [count - 1]))

    count++;

    System.out.println("count = " + count);

 }

public static void main(String[] args){

    ArrayElements Object1 = new ArrayElements();

    Object1.set(Object1.array1, 0);

    Object1.set(Object1.array1, 1);

    Object1.func();

   }
}


