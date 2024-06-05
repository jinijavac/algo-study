
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1010번
public class Bridge {
    //조합을 써야 한다! --> 중복 허용 X기 때문에 겹치는 경우의 수 세지 않음
    //파스칼의 삼각형 ?? 대체 뭐임??
    //n-1Cr-1 + n-1Cr = nCr (삼각형에서 윗 자리 두개 더하면 내 값이 나옴)
    //그냥 조합 방식 쓰면 계산량 너무 많아짐 (시간 초과) --> 파스칼의 삼각형 공식으로 쪼개서 반복문 돌리기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //테스트 개수 받기

        int[][] dp = new int[30][30]; //배열 만들기

        //배열 초기화 -> 값 1일 때
        for (int i = 0; i < 30; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        //파스칼 삼각형 만들기
        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        //N,M 입력 받아 원하는 인덱스에서 값 뽑아오기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(dp[M][N]);
        }
    }
}
//ex) --> 위에서부터 내려오면서 계산! 5C3
//          1           (0번째 행)
//         1 1          (1번째 행)
//        1 2 1         (2번째 행)
//       1 3 3 1        (3번째 행)
//      1 4 6 4 1       (4번째 행)
//    1 5 10 10 5 1     (5번째 행)
// --> 5번째 행에 3번째 요소 --> 10