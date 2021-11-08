import java.util.Arrays;
public class JavaTraining {
/**returns the median of the five integer parameters
		*@param(int num1) first number given
		*@param(int num2) second number given
		*@param(int num3) third number given
		*@param(int num4) fourth number given
		*@param(int num5) fifth number given

		*/

public static int[] sort (int [] arraySort){
    int temp;
    for (int i = 0; i < arraySort.length-1; i++)
    {
        if(arraySort[i] > arraySort[i+1])
        {
            temp=arraySort[i];
            arraySort[i]=arraySort[i+1];
            arraySort[i+1]=temp;
            i=-1;
        }
    }
    return arraySort;
}


public static void median(int num1, int num2, int num3, int num4, int num5)
	{
		int[] initial_array = {num1, num2, num3, num4, num5};
        sort(initial_array);
        boolean even;
        int len = initial_array.length;
        if(len % 2 != 0) even = false;
        else even = true;
        int median = 0;
        float median_float = 0;
        System.out.println(even);
        if (even == false)
        {
            //System.out.println(len);
            double newlen = len/2;
            //System.out.println(newlen);
            double newlen_final = newlen + 0.5;
            //System.out.println(newlen_final);
            median = initial_array[(int) newlen_final];
            //System.out.println(median);
        } else if (even == true)
        {
            //double newlen = len/2;
            //System.out.println(newlen);
            //double newlen_final = newlen * 2 + 1;
            //double newlen_finalfinal = newlen_final/2;
            //float median_avg = initial_array[(float) newlen] + initial_array[(float) newlen + 1];
            //median_float = median_avg/2;
        }
        if (even == true) 
        {
            System.out.println(median);
        } else if (even == false)
        {
            System.out.println(median);
        }
			
    }
    public static void main(String[] args) {
        median(6, 5, 4, 2, 1);
    }
}
