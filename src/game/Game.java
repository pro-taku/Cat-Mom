package game;

import game.objects.Cat;
import game.objects.Player;
import game.screen.Termianl;
import game.script.Action;

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
 *     <li>{@link #update()}: 게임을 업데이트합니다.</li>
 *     <li>{@link #dispose()}: 게임을 종료합니다.</li>
 *     <li>{@link #playing()}: 게임을 진행합니다.</li>
 * </ol>
 */
public class Game extends Termianl implements Action, Tick {
    Player player;
    Cat[] cats;
    int warning;
    int days;

    @Override
    public void initiate() {
        // 플레이어의 이름 입력
        System.out.println("\n플레이어 이름");
        String name = input();
        player = new Player(name);

        // 고양이 수 입력
        System.out.println("\n몇마리의 고양이를 키우시겠습니까? (최대 3마리까지 가능)");
        int catCount = input(1, 3);
        cats = new Cat[catCount+1];

        // 고양이 이름 입력
        for (int i=1 ; i <= catCount; i++) {
            System.out.println("\n" + i + "번째 고양이 이름");
            cats[i] = new Cat(input());
        }

        // 그 외의 변수 초기화
        warning = 0;
        days = 0;
        System.out.println("초기화 완료...");
        System.out.println("게임 시작!");
    }

    @Override
    public void update() {

    }

    @Override
    public void dispose() {

    }

    public void playing() {
        // 플레이어의 행동을 결정
        int action = player.doSomething(cats);

        // 만약 플레이어가 종료를 선택했다면
        // 처음 화면으로 돌아간다.
        if (action == 0) {
            return;
        }
    }
}
