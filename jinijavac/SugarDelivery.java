<<<<<<< HEAD

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2839
public class SugarDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int bags = 0;

        if (n == 4 || n == 7){
            //1, 2, 4, 7은 3이나 5로 나누어지지 않음
            System.out.println(-1);

        }else if (n % 5 == 0){
            System.out.println(n/5);

        }else if (n % 5 == 1 || n % 5 == 3){
            // 나머지가 1인 경우: n = 5a + 6 (3kg * 2)
            // ex) 6 -> 3kg 2개
            // 나머지가 3인 경우: n = 5a + 3 (5kg * 1 + 3kg * 1)
            // ex) 8 -> 5kg 1개 3kg 1개
            System.out.println(n/5 +1);

        }else if (n % 5 == 2 || n % 5 == 4){
            // n % 5 == 2인 경우: n = 5a + 12 (3kg * 4)
            //ex) 12 -> 3+3+3+3
            // n % 5 == 4인 경우: n = 5a + 9 (3kg * 3)
            //ex) 9 -> 3+3+3
            System.out.println(n/5 +2);
        }
    }
}

// | N (kg) | n % 5 | 5kg 봉지 수 | 3kg 봉지 수 | 총 봉지 수 |
// |--------|-------|------------|------------|-----------|
// | 3      | 3     | 0          | 1          | 1         |
// | 4      | 4     | -          | -          | -1        |
// | 5      | 0     | 1          | 0          | 1         |
// | 6      | 1     | 0          | 2          | 2         |
// | 7      | 2     | -          | -          | -1        |
// | 8      | 3     | 1          | 1          | 2         |
// | 9      | 4     | 0          | 3          | 3         |
// | 10     | 0     | 2          | 0          | 2         |
=======
package PACKAGE_NAME;public class SugarDelivery {
}
>>>>>>> ff4446672123670586feaa5657dfdbf3ecd3825a
