package game;

import game.dto.Cat;
import game.dto.Player;
import game.terminal.Termianl;
import game.terminal.display.Display;
import game.terminal.display.TextColor;

/**
 * <h1>{@link Game}</h1>
 *
 * <p>
 *     수정 일자 : 2024.05.27 19:13<br>
 *     수정자 : 국희근(protaku)
 * </p>
 *
 * <br>
 *
 * <p>
 *     게임을 진행하는 클래스입니다.<br>
 *     플레이어와 고양이들을 저장하고, 현재 날짜와 경고 횟수를 관리합니다.
 * </p>
 *
 * <br>
 *
 * <h2>주요 메서드</h2>
 * <ol>
 *     <li>{@link #initiate()}: 게임을 초기화합니다.</li>
 *     <li>{@link #playing()}: 게임을 진행합니다.</li>
 * </ol>
 */
public class Game extends Termianl {
    Player player;
    Cat[] cats;
    int warning;
    int days;

    public void initiate() {
        Display.cleanScreen();

        // 플레이어의 이름 입력
        System.out.println(TextColor.yellow+ "\n플레이어 이름");
        String name = input();
        player = new Player(name);

        // 고양이 수 입력
        System.out.println("\n몇마리의 고양이를 키우시겠습니까? (최대 3마리까지 가능)");
        int catCount = input(1, 3);
        cats = new Cat[catCount+1];
        player.setCats(cats);

        // 고양이 이름 입력
        for (int i=1 ; i <= catCount; i++) {
            System.out.println(TextColor.yellow+"\n" + i + "번째 고양이 이름"+TextColor.exit);
            cats[i] = new Cat(input());
        }

        // 그 외의 변수 초기화
        warning = 0;
        days = 1;
        System.out.println("초기화 완료...");
        System.out.println("게임 시작!");
    }

    public void playing() {
        while (true) {
            Display.cleanScreen();
            showDays(days);

            // 플레이어의 행동을 결정
            int action = player.doSomething(cats);

            // 만약 플레이어가 정보 탐색을 시도했다면,
            // 게임 메뉴 화면을 보여준다.
            if (action == 0) {
                continue;
            }
            // 만약 플레이어가 종료를 선택했다면
            // 처음 화면으로 돌아간다.
            if (action < 0) {
                return;
            }

            // 고양이 상태 업데이트
            int catNumber = action / 10;
            action %= 10;
            cats[catNumber].update(action);

            // 경고 받을 상황인지 확인
            if (isWarningCheck()) {
                // 경고 메세지 출력
                if (++warning < 3) {
                    warningMessage(warning);
                }

                // 경고 3회 이상 받았을 경우 게임 종료
                else {
                    lose(days);
                    return;
                }
            }

            // 게임 승리 조건 확인하기
            // └ 모든 고양이의 친밀도가 100이면 승리
            else if (checkWin()) {
                win(player, days);
                return;
            }

            // 오늘 하루 동안 남은 횟수
            if (player.getActionCount() > 0) {
                remainingActionChances(player);
            }
            // 하루가 지났음을 알림
            else {
                dayUpdate();
            }

            // Enter 누를 때까지 대기
            waitBeforeEnter();
        }
    }

    private boolean isWarningCheck() {
        boolean check = false;
        for (Cat cat : cats) {
            if (cat == null) continue;

            if (cat.getSatiety() <= 0) {
                check = true;
                cat.resetSatiety();
                warningCatStatus(cat, 1);
            }
            if (cat.getClean() <= 0) {
                check = true;
                cat.resetClean();
                warningCatStatus(cat, 3);
            }
            if (cat.getFatigue() >= 100)  {
                check = true;
                cat.resetFatigue();
                warningCatStatus(cat, 4);
            }
        }
        return check;
    }

    private boolean checkWin() {
        for (Cat cat : cats) {
            if (cat == null) continue;
            if (cat.getIntimacy() != 100) return false;
        }
        return true;
    }

    private void dayUpdate() {
        days++;
        player.resetActionCount();
    }

    @Override
    public void previous() {}

    @Override
    public void next() {}

    @Override
    public void select() {}
}
