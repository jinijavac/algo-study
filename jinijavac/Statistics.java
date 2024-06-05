
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//2108
public class Statistics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n]; //개수

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        //산술평균
        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        int mean = (int) Math.round(sum / n);
        System.out.println(mean);

        //중앙값
        Arrays.sort(numbers);
        int mid = numbers[n/2];
        System.out.println(mid);

        //최빈값
        // --> 정렬 후 가장 많이 모여있는 숫자를 최빈값으로 출력하려고 했지만.. --> 최빈값 겹치는 경우를 생각하지 못함
        // --> 이상한 결과..

        // Map으로 숫자와 그 숫자의 빈도수 저장 후 정렬
        // --> 숫자 빈도 최대값 출력 (최대값이 여러개인 경우 리스트에 저장 후 정렬 -> 두번쩨 출력)

        Map<Integer, Integer> freqMap = new HashMap<>(); //숫자 빈도 저장 (숫자, 숫자 빈도)
        for (int num : numbers) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            //존재하면 값 반환, 그렇지 않으면 0 반환 후 +1
        }

        int max = Collections.max(freqMap.values()); //숫자 빈도 가장 큰 값 찾기
        List<Integer> modes = new ArrayList<>(); //최빈값 저장 리스트
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == max) {
                modes.add(entry.getKey());
            }
        }

        Collections.sort(modes); //숫자 오름차순
        int mode = modes.size() > 1 ? modes.get(1) : modes.get(0);
        //mode 2 이상 -> 두번째로 작은 값
        System.out.println(mode);

        //범위
        int range = numbers[n-1] - numbers[0];
        System.out.println(range);

    }
}
