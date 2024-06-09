import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1463
public class MakeItOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        //숫자에 해당하는 인덱스 설정 (값은 연산의 최소 횟수)

        dp[1] = 0;
        //인덱스 1은 0 설정

        for (int i = 2; i < dp.length; i++) {
            // -1 연산
            //앞 숫자에서 -1 연산 해줘야하므로 앞의 횟수에 +1
            dp[i] = dp[i - 1] + 1;
            //최소 연산 개수 초기화 (기본 연산)

            //나누기 3 연산
            //현재 수가 3으로 나누어 떨어지면 나눈 수의 횟수에 +1
            //**
            if (i % 3 == 0) {
                if (dp[i / 3] + 1 < dp[i]) {
                    //비교?
                    //더 적은 연산 횟수 고르기
                    dp[i] = dp[i / 3] + 1;
                }
            }

            //나누기 2 연산
            //현재 수가 2으로 나누어 떨어지면 나눈 수의 횟수에 +1
            if (i % 2 == 0) {
                if (dp[i / 2] + 1 < dp[i]) {
                    dp[i] = dp[i / 2] + 1;
                }
            }
        }
        System.out.println(dp[n]);
    }
}

//dp[1] = 0
//dp[2] = 1
//dp[3] = 1
//dp[4] = 2
//dp[5] = 3
//dp[6] = 2
//dp[7] = 3
//dp[8] = 3
//dp[9] = 2
//dp[10] = 3

// ex) 10

// 1번) dp[10] = dp[9] + 1
// dp[9] + 1 = dp[3] + 1 + 1 => 1 + 1 + 1 = 3

// 2번) dp[10] = dp[8] + 1
// dp[8] + 1 => dp[6] + 1 + 1
// dp[6] + 1 + 1 => dp[2] + 1 + 1 + 1
// dp[2] + 1 + 1 + 1 = 1 + 1 + 1 + 1 = 4

//*** 2번보다 1번이 횟수가 더 적음 --> 비교 후 횟수 3 채택