import java.util.Scanner;

public class Day1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long fuel = 0;
        while (sc.hasNextInt())
        {
            int mass = sc.nextInt();
            fuel += calculateFuel(mass);
        }
        System.out.println(fuel);
    }

    public static int calculateFuel(int mass)
    {
        if (mass <= 0 || (mass/3 - 2) <= 0)
        {
            return 0;
        }
        return (mass/3 - 2) + calculateFuel(mass/3 - 2);
    }
}
