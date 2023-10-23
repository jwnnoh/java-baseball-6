package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class baseballModel {

    String STRIKE = "스트라이크";
    String Ball = "볼";
    String Nothing = "낫싱";
    String Result = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    List<Integer> computer;
    int ball = 0, strike = 0;

    public void computerNumber() { //컴퓨터가 생성하는 서로 다른 세 자리의 숫자
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public void ballCount(String insert) { //사용자 입력값과 컴퓨터의 값을 비교하여 볼, 스트라이크 갯수를 판단
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add(Integer.parseInt(String.valueOf(insert.charAt(i))));
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(computer.get(i))) {
                strike++;
            }
            if (list.contains(computer.get(i))) {
                ball++;
            }
        }
    }

    public String stringResult() { //입력한 수에 대한 결과 출력
        StringBuilder sb = new StringBuilder();
        if (strike == 0 && ball == 0) { //하나도 없는 경우
            return "낫싱";
        }

        if (ball != 0) {
            sb.append(ball).append("볼").append(" ");
        }
        if (strike != 0) {
            sb.append(strike).append("스트라이크").append("\n");
        }
        if (strike == 3) {
            sb.append(3).append("개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        return String.valueOf(sb);
    }
}
