import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
//Steven Wang, 12/10/24, Pd. 3, CP3
class StackQueueMini {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        part1();
        part2();
        input.close();

    } // end main

    public static void part1() {

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
        System.out.println("bottom " + s_nums + " top");

    } //end part 1

    public static void part2() {
        
        Queue<Integer> q_nums = new LinkedList<Integer>();
        System.out.println("Please enter 10 whole numbers: ");
        for (int i = 0; i < 10; i++) {
            q_nums.add(input.nextInt());
            input.nextLine();
        }
        
        int i = 0;
        Queue<Integer> temp = new LinkedList<Integer>();
        while (i < 10) {
            int cur = q_nums.remove();
            if (cur % 2 == 0) {
                q_nums.add(cur);
            } else {
                temp.add(cur);
            }
            i++;
        }
        
        q_nums = combine(q_nums, temp);
        // Queue<Integer> even = new LinkedList<Integer>();
        // Queue<Integer> odd = new LinkedList<Integer>();

        // while (!q_nums.isEmpty()) {
        //     int cur = q_nums.remove();
        //     if (cur % 2 == 0) {
        //         even.add(cur);
        //     } else {
        //         odd.add(cur);
        //     }
        // }
        
        // q_nums = combine(even, odd);

        System.out.println("front " + q_nums + " back");

    } //end part 2

    private static Queue<Integer> combine(Queue<Integer> l1, Queue<Integer> l2) {
        Queue<Integer> result = new LinkedList<Integer>();
        while (!l1.isEmpty()) {
            result.add(l1.remove());
        }
        while (!l2.isEmpty()) {
            result.add(l2.remove());
        }
        return result;
    } //end combine
} // end class
