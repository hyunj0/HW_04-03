package nyc.c4q.hyunj0;

import java.util.ArrayList;

public class LinearSearch
{

    public static void main(String[] args)
    {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(3);
        numbers.add(45);
        numbers.add(1);
        numbers.add(2);
        numbers.add(99);

        System.out.println("Returns: " + firstIndex(numbers, 1));
    }

    public static int firstIndex(ArrayList alist, int x)
    {
        if(alist.contains(x))
        {
            return alist.indexOf(x);
        }
        else
        {
            return - 1;
        }
    }

}
