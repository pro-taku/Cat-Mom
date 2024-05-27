public class Player extends Display implements Action {
    private String name;
    private int actionCount = 5;

    public Player(String name) {
        this.name = name;
    }

    int doSomething(Cat[] cats) {
        boolean looping;
        int catCount = cats.length;
        int option, result = 0;

        do {
            looping = false;

            mainMenu();
            option = input(1, 4);

            if (option != 1)  {
                looping = true;
                if (option == 2) {
                    System.out.println("고양이 정보");
                    waitBeforeEnter();
                } else if (option == 3) {
                    System.out.println("플레이어 정보");
                    waitBeforeEnter();
                } else if (option == 4) {
                    System.out.println("메인창으로 돌아갑니다.");
                    waitBeforeEnter();
                    return 0;
                }
                continue;
            }

            System.out.println("누구에게 대상으로 하시겠습니까? (번호로 입력해주세요)");
            showCatProfile(cats);
            option = input(1, catCount);
            result += option * 10;

            actionMenu();
            option = input(0, 6);
            if (option == 0) {
                looping = true;
            } else {
                result += option;
            }
        } while(looping);

        return option;
    }
}
