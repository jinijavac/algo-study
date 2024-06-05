

import java.util.Scanner;
import java.util.Stack;

public class Zero {
    //1. 스택 이용해서 0 입력시 pop
    //2. 스택에 남은 데이터 합 계산 --> pop 이용
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if (num == 0) {
                stack.pop();
            } else {
                stack.add(num);
            }
        }
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
