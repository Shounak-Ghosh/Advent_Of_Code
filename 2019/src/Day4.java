import java.util.ArrayList;

public class Day4
{
    public static void main(String[] args)
    {
        int res = 0;
        String num = "";
        char[] digits;
        ArrayList<Integer> repeats = new ArrayList<>();
        for (int i = 387638; i <= 919123; i++) // 387638 919123
        {
            num = "" + i;
            digits = num.toCharArray();
            boolean isDouble = false;
            int count = 1;
            for (int k = 0; k < 5; k++)
            {
//                System.out.println("c: " + count);
                if(digits[k] == digits[k + 1])
                {
                    count++;
                }
                else
                    {
                        repeats.add(count);
                        count = 1;
                    }

            }
            repeats.add(count);

//            System.out.println(repeats);

            for (int k = 0; k < repeats.size(); k++)
            {
                if (repeats.get(k) == 2)
                {
                    isDouble = true;
                }
            }

            boolean isIncreasing = true;
            for (int k = 0; k < 5; k++)
            {
                if(digits[k] > digits[k + 1])
                {
                    isIncreasing = false;
                }
            }

            if (isDouble && isIncreasing)
            {
                res++;
            }
            repeats.clear();
        }
        System.out.println(res);
    }
}