public class Game extends Display implements Action, Tick {
    Player player;
    Cat[] cats;
    int warning;
    int days;

    @Override
    public void initiate() {
        System.out.println("\n플레이어 이름");
        String name = input();
        player = new Player(name);

        System.out.println("\n몇마리의 고양이를 키우시겠습니까? (최대 3마리까지 가능)");
        int catCount = input(1, 3);
        cats = new Cat[catCount+1];

        for (int i=1 ; i <= catCount; i++) {
            System.out.println("\n" + i + "번째 고양이 이름");
            cats[i] = new Cat(input());
        }

        warning = 0;
        days = 0;
        System.out.println("초기화 완료...");
        System.out.println("게임 시작!");
    }

    void playing() {
        int action = player.doSomething(cats);
        if (action == 0) {
            return;
        }
    }
}
