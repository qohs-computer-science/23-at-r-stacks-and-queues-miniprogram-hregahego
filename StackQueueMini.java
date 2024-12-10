import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.ListIterator;
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
        
        LinkedList<Integer> q_nums = new LinkedList<Integer>();
        System.out.println("Please enter 10 whole numbers: ");
        for (int i = 0; i < 10; i++) {
            q_nums.add(input.nextInt());
            input.nextLine();
        }

        LinkedList<Integer> temp = new LinkedList<Integer>();
        ListIterator<Integer> it = q_nums.listIterator();
        
        while (it.hasNext()) {
            int cur = it.next();
            if (cur % 2 == 0) {
                temp.add(cur);
                it.remove();
            }
        }

        
        combine(temp, q_nums);
        q_nums = temp;

        System.out.println("front " + q_nums + " back");

    } //end part 2

    private static void combine(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        ListIterator<Integer> it1 = l1.listIterator();
        ListIterator<Integer> it2 = l2.listIterator();
        while (it1.hasNext()) {
            it1.next();
        }
        while (it2.hasNext()) {
            it1.add(it2.next());
        }
    } //end combine
} // end class
