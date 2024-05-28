import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//1316
public class GroupWordChecker {
    public static void main(String[] args) {
        //뒤의 알파벳과 현재 알파벳이 다를 때
        //다음 알파벳이 단어에 없으면 됨
        //어덯게...?
        //--> 배열 순회로 확인!

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //입력 단어 개수
        int group = 0; //그룹 단어 개수

        for (int i = 0; i < n; i++) {
            String word = scanner.next();
            if (GroupWord(word) == true) {
                group++;
            }
        }

        System.out.println(group);
    }

    //그룹 단어인지 판별
    public static boolean GroupWord(String word) {
        List<Character> alpa = new ArrayList<>(); //한 글자씩 배열에 담음 --> 존재하면 false
        char preChar = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i); //한 단어의 한 글자씩
            if (preChar != ch) {
                if (alpa.contains(ch)) {
                    return false;
                }
                alpa.add(ch); //리스트에 기록
            }
            // 현재 문자 저장
            preChar = ch;
        }
        return true; // 그룹 단어인 경우
    }
}
