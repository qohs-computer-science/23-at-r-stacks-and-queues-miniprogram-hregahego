import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ListIterator;

class StackQueueMini {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        part1();
        part2();
        input.close();
    } // end main

    public static void part1() {
        // PART 1
        System.out.println("Please enter 5 whole numbers: ");
        Stack<Integer> s_nums = new Stack<Integer>();
        for (int i = 0; i < 5; i++) {
            s_nums.push(input.nextInt());
            input.nextLine();
        }

        
        Stack<Integer> s_temp = new Stack<Integer>();
        while (!s_nums.isEmpty()) {
            int cur = s_nums.pop();
            s_temp.push(cur);
            s_temp.push(cur);
        }
        s_nums.clear();
        while (!s_temp.isEmpty()) {
            s_nums.push(s_temp.pop());
        }
        
        System.out.println("Duplicated stack: ");
        System.out.println(s_nums + " top");

    }

    public static void part2() {
        //PART 2
        LinkedList<Integer> q_nums = new LinkedList<Integer>();
        System.out.println("Please enter 10 whole numbers: ");
        for (int i = 0; i < 10; i++) {
            q_nums.push(input.nextInt());
            input.nextLine();
        }

        LinkedList<Integer> even = new LinkedList<Integer>();
        LinkedList<Integer> odd = new LinkedList<Integer>();
        ListIterator<Integer> it = q_nums.listIterator();
        
        while (it.hasNext()) {
            int cur = it.next();
            if (cur % 2 == 0) {
                even.push(cur);
            } else {
                odd.push(cur);
            }
        }

        q_nums = even.addAll(odd);
        System.out.println(q_nums);

    }
} // end class
