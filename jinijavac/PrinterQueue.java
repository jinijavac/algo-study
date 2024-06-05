
import java.io.*;
import java.util.*;

//1966
public class PrinterQueue {
    //1. 문서 위치, 중요도 배열 큐 저장
    //2. 우선순위 큐에 우선순위 저장
    //3. 큐 두개 비교하며 출력 (같을 경우 출력, 아닌 경우 다시 추가)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken()); // 문서의 개수
            int loc = Integer.parseInt(st.nextToken()); // 궁금한 문서의 위치

            StringTokenizer str = new StringTokenizer(br.readLine());
            Queue<int[]> q = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            for (int a = 0; a < count; a++) {
                int prior = Integer.parseInt(str.nextToken()); //중요도
                q.add(new int[]{a, prior}); // 문서 위치, 중요도 추가
                priorityQueue.add(prior); //우선순위 큐에 중요도 추가
            }

            int printOrder = 0; //출력 순서 변수

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int index = cur[0];
                int priority = cur[1];

                if (priority == priorityQueue.peek()) { //현재 중요도와 우선순위 큐의 최상위 중요도가 같다면 출력
                    priorityQueue.poll();
                    printOrder++;
                    if (index == loc) {
                        bw.write(printOrder + "\n");
                        break;
                    }
                } else {
                    q.add(cur);
                }
            }
        }
        bw.flush();
        bw.close();
    }
}