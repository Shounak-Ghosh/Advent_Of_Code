import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Day3
{
    public static void main(String[] args)
    {
        System.out.println(Integer.MAX_VALUE);
        ArrayList<String> instructions = new ArrayList<>();
//        instructions.add("U1");
//        instructions.add("R1");
//        instructions.add("D1");
//        instructions.add("L1");
//        instructions.add("U1");
//        System.out.println(buildSet(instructions));
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 301; i++) // 301
        {
            instructions.add(sc.next());
        }
        HashSet<Point> wire1 = buildSet(instructions);
        ArrayList<Point> wire1List = new ArrayList<>();
        for(Point p: wire1)
        {
            wire1List.add(p);
        }
//        System.out.println(wire1);
        instructions.clear();
        for(int i = 0; i < 301; i++) // 301
        {
            instructions.add(sc.next());
        }
        HashSet<Point> wire2 = buildSet(instructions);
        ArrayList<Point> wire2List = new ArrayList<>();
        for(Point p: wire1)
        {
            wire2List.add(p);
        }
//        System.out.println(wire2);
        int ans = Integer.MAX_VALUE;


        for (Point p1: wire1)
        {
            for (Point p2: wire2)
            {
                if (p1.x == p2.x && p1.y == p2.y)
                {
                    ans = Math.min(ans, p1.step + p2.step);
                }
            }
        }

//        for (Point p1 : wire1)
//        {
//            if(wire2.contains(p1))
//            {
//                System.out.println(p1);
////                if(/*p1.x == p2.x && p1.y == p2.y && */!(p1.x == 0 && p1.y == 0))
//                {
//                    ans = Math.min(ans,wire1List.get(wire1List.indexOf(p1)).step + wire2List.get(wire2List.indexOf(p1)).step);
//                }
//            }
//        }
        System.out.println(ans);
    }

    public static HashSet<Point> buildSet(ArrayList<String> instructions)
    {
        HashSet<Point> path = new HashSet<>();
        int step = 0;
        Point current = new Point(0,0,step);
        char[] dirArray;
        for(String directions: instructions)
        {
            dirArray = directions.toCharArray();
            Integer num = Integer.parseInt(directions.substring(1));
            switch (dirArray[0])
            {
                case 'U':
                    for (int i = 0; i < num; i++)
                    {
                        path.add(new Point(current.x,++current.y,++step));
//                        System.out.println(step);
                    }
                    break;
                case 'D':
                    for (int i = 0; i < num; i++)
                    {
                        path.add(new Point(current.x,--current.y,++step));
//                        System.out.println(step);
                    }
                    break;
                case 'L':
                    for (int i = 0; i < num; i++)
                    {
                        path.add(new Point(--current.x,current.y,++step));
//                        System.out.println(step);
                    }
                    break;
                case 'R':
                    for (int i = 0; i < num; i++)
                    {
                        path.add(new Point(++current.x,current.y,++step));
//                        System.out.println(step);
                    }
                    break;
            }
        }
        return path;
    }


    static class Point
    {
        int x;
        int y;
        int step;

        public Point(int x, int y, int step)
        {
            this.x = x;
            this.y = y;
            this.step = step;
        }

        public int hashCode()
        {
            String k = x  + ", " + y;
            return k.hashCode();
        }

        public String toString()
        {
            return "(" + x + ", " + y + ", " + step +  ")";
        }

        public boolean equals(Object other)
        {
            if (other instanceof Point)
            {
                Point o = (Point) other;
                return o.x == this.x && o.y == this.y;
            }
            return false;
        }

        public int manhattan()
        {
            return Math.abs(x) + Math.abs(y);
        }
    }
}
