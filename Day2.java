import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day2
{
    public static ArrayList<Integer> initalOpCode;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        initalOpCode = new ArrayList<>();

        while (sc.hasNextInt())
        {
            initalOpCode.add(sc.nextInt());
        }

        for (int a = 0; a <= 99; a++)
        {
            for (int b = 0; b <= 99; b++)
            {
                if(check(a,b) == 19690720)
                {
                    System.out.println(100 * a + b);
                    break;
                }
            }
        }
    }

    public static int check(int x, int y)
    {
        ArrayList<Integer> opCode = new ArrayList<>();

        for (int elem :initalOpCode)
        {
            opCode.add(elem);
        }

        opCode.set(1,x);
        opCode.set(2,y);
        for (int i = 0; i < opCode.size(); i+=4)
        {
            int dir = opCode.get(i);
            if (dir == 1)
            {
                int a = opCode.get(i + 1);
                int b = opCode.get(i + 2);
                int c = opCode.get(i + 3);
                opCode.set(c,opCode.get(a) + opCode.get(b));
            }
            else if (dir == 2)
            {
                int a = opCode.get(i + 1);
                int b = opCode.get(i + 2);
                int c = opCode.get(i + 3);
                opCode.set(c, opCode.get(a) * opCode.get(b));
            }
            else if (dir == 99)
            {
                break;
            }
        }
        return opCode.get(0);
    }
}
