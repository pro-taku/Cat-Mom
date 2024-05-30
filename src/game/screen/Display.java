package game.screen;

import game.objects.Cat;
import game.screen.UserInput;
import game.screen.TextColor;
/**
 * <h1>{@link Display}</h1>
 *
 * <p>
 *     수정 일자 : 2024.05.27 19:13<br>
 *     수정자 : 국희근(protaku)
 * </p>
 *
 * <br>
 *
 * <p>
 *     이 게임은 터미널을 통해 실행되는 콘솔 게임이다.<br>
 *     해당 클래스를 써서 사용자의 입력을 받거나, 정해진 메뉴를 보여줄 수 있다.
 * </p>
 *
 * <br>
 *
 * <h3>출력 관련</h3>
 * <ol>
 *     <li>{@link #systemOn()}: 게임 시작 시 메인 메뉴를 보여준다.</li>
 *     <li>{@link #systemOff()}: 게임 종료 시 메시지를 보여준다.</li>
 *     <li>{@link #explainGame()}: 게임 설명을 보여준다.</li>
 *     <li>{@link #showContributors()}: 제작자 정보를 보여준다.</li>
 *     <li>{@link #mainMenu()}: 게임 플레이어의 메인 메뉴를 보여준다.</li>
 *     <li>{@link #showCatProfile(Cat[] cats)}: 고양이 정보를 보여준다.</li>
 *     <li>{@link #actionMenu()}: 행동 메뉴를 보여준다.</li>
 *     <li>{@link #event()}: 이벤트를 보여준다.</li>
 *     <li>{@link #acting()}: 행동을 보여준다.</li>
 *     <li>{@link #nextDay()}: 하루가 지났음을 알린다.</li>
 * </ol>
 */
public class Display {

    void systemOn() {
        System.out.println(TextColor.yellow + "╔════════════════════════════════════════════════════════════════════════════════════╗" + TextColor.exit);
        System.out.println(TextColor.yellow + "║  ______      ___      .___________.     ______      ___      .______       _______ ║" + TextColor.exit);
        System.out.println(TextColor.yellow + "║ /      |    /   \\     |           |    /      |    /   \\     |   _  \\     |   ____|║" + TextColor.exit);
        System.out.println(TextColor.yellow + "║|  ,----'   /  ^  \\    `---|  |----`   |  ,----'   /  ^  \\    |  |_)  |    |  |__   ║" + TextColor.exit);
        System.out.println(TextColor.yellow + "║|  |       /  /_\\  \\       |  |        |  |       /  /_\\  \\   |      /     |   __|  ║" + TextColor.exit);
        System.out.println(TextColor.yellow + "║|  `----. /  _____  \\      |  |        |  `----. /  _____  \\  |  |\\  \\----.|  |____ ║" + TextColor.exit);
        System.out.println(TextColor.yellow + "║ \\______|/__/     \\__\\     |__|         \\______|/__/     \\__\\ | _| `._____||_______|║" + TextColor.exit);
        System.out.println(TextColor.yellow + "╚════════════════════════════════════════════════════════════════════════════════════╝" + TextColor.exit);

        System.out.println("                      ⢀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("                      ⣸⣿⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣶⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("                      ⣿⣿⣿⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("                      ⣿⣿⣿⣿⣿⣿⣧⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⡧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("                      ⣿⣿⣿⣿⣿⣿⣿⣿⣧⣤⣤⣴⣴⣤⣤⣀⣀⣀⣴⣾⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("                      ⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("                      ⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("                      ⠸⣿⣿⣿⠏⠀⣠⣤⡙⣿⣿⣿⣿⣿⣿⠟⠉⣉⡛⢿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("                      ⣸⣿⣿⣿⣆⣀⠹⢿⣡⣿⣿⣿⣿⣿⣗⠀⠨⣿⣿⢈⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("                      ⣿⣿⣿⣿⣿⣿⣿⣿⣿⡁⠁⠉⢙⣿⣿⣿⣶⣶⣷⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("                      ⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("   ╔══════════════════════════════════════════════════════════════════════════════╗" );
        System.out.println("   ║  1. 게임 시작                                                                  ║" );
        System.out.println("   ║  2. 게임 설명                                                                  ║" );
        System.out.println("   ║  3. 제작자 정보                                                                 ║" );
        System.out.println("   ║  4. 게임 종료                                                                  ║");
        System.out.println("   ║                                                                              ║" );
        System.out.println("   ║  (원하는 번호를 입력해주세요)                                                      ║");
        System.out.println("   ╚══════════════════════════════════════════════════════════════════════════════╝" );










    }

    void systemOff() {
        System.out.println("게임을 종료합니다.");
    }

    void explainGame() {
        System.out.println("게임 설명 페이지");
    }

    void showContributors() {
        System.out.println("제작자 정보 페이지");
    }

    void mainMenu() {
        System.out.println("\n   ╔═══════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("   ║  "+TextColor.red+ "메인 메뉴"+TextColor.exit+"                                                                      ║" );
        System.out.println("   ║  1. 행동하기                                                                    ║");
        System.out.println("   ║  2. 고양이 정보                                                                  ║");
        System.out.println("   ║  3. 플레이어 정보                                                                ║");
        System.out.println("   ║  4. 메인 창으로                                                                  ║");
        System.out.println("   ╚═══════════════════════════════════════════════════════════════════════════════╝\n");
    }


    void showCatProfile(Cat[] cats) {
        for (int i=1 ; i < cats.length ; i++) {
            System.out.printf("([" + i + "] " + cats[i].getName() + ")  ");
        }
        System.out.println();
    }

    void actionMenu() {

        System.out.println("\n   ╔══════════════════════════════════════════════════════════════════════════════╗" );
        System.out.println("   ║  "+TextColor.red+ "행동"+TextColor.exit+"                                                                         ║" );
        System.out.println("   ║  1. 밥 주기                                                                    ║" );
        System.out.println("   ║  2. 재우기                                                                     ║" );
        System.out.println("   ║  3. 쓰다듬기                                                                   ║");
        System.out.println("   ║  4. 씻기                                                                      ║" );
        System.out.println("   ║  5. 치료하기                                                                   ║");
        System.out.println("   ║  6. 산책시키기                                                                  ║");
        System.out.println("   ║  0. 뒤로 가기                                                                  ║");
        System.out.println("   ╚══════════════════════════════════════════════════════════════════════════════╝\n" );


    }

    // 1번 클릭했을 때 다음 메세지 출력
    //         System.out.println(".　 ∧ ∧　　　　　　");
    //        System.out.println(" 　( ´･ω･)　배불러");
    //        System.out.println(" 　/　　⌒ヽ　　　");
    //        System.out.println(" （人＿__つ_つ");
    // 2번 클릭했을 때, 다음 메시지 출력
    //         System.out.println(".    ∧_∧ ");
    //        System.out.println("　  ( ･ω･)  흐암");
    //        System.out.println("  　｜⊃／(＿＿＿");
    //        System.out.println("  ／└-(＿＿＿_／");
    //        System.out.println("  ￣￣￣￣￣￣");
    // 3번 클릭했을 때, 다음 메시지 출력
    //                System.out.println(".  　∧＿∧ 쓰담쓰담");
    //                System.out.println("  （´・ω・)つ＿ ∧");
    //                System.out.println("  （つ　 / (・ω・｡)");
    //                System.out.println("   しーＪ　 (nnノ)");
    // 4번 클릭했을 때,
    //     System.out.println(".   ⋀,,⋀. ");
    //        System.out.println("  (*・ω・)/  뽀송!");
    //        System.out.println(".  (つ　 ﾉ");
    //        System.out.println(".  しーＪ");
    // 5번 클릭했을 때,
    //                System.out.println(".    ∧＿∧");
    //                System.out.println("  （｡･ω･｡)つ━☆☆*다");
    //                System.out.println("  ⊂　　 ノ   　나았다옹　☆☆");
    //                System.out.println("  　し-Ｊ　　　°。+ * 。");
    // 6번 클릭했을 때,
    //        System.out.println(".　　∧_∧");
    //        System.out.println("　((・∀・∩　산책 시간!");
    //        System.out.println("　 ＼　　〈");
    //        System.out.println("　　  丶丶_)");
    //        System.out.println("　　　　　　푸슝");
    //        System.out.println("　　  ____＼从/_");
    //        System.out.println("　 ／＼＿＿＿＿＼");
    //        System.out.println("　|￣＼(∩゜Д゜;)＼");
    //        System.out.println("　|　  ｜￣￣∪￣｜");
    // 고양이 친밀도 30 이상일 때,
//        System.out.println(".  /\\_/\\    ♡ 친밀도가 30이 되었어요.");
//        System.out.println(" >(• ༝ •)<");
//        System.out.println("   |        \\");
//        System.out.println("   |  |   |   )_");
//        System.out.println("   l--l--l / /");
//        System.out.println("           |  |");
//        System.out.println("            \\ \\");
//        System.out.println("              \\/");
    // 고양이 친밀도 60 이상일 때,
//        System.out.println(".  /\\_/\\    ♡ 친밀도가 60이 되었어요.");
//        System.out.println(" >(• ༝ •)<");
//        System.out.println("   |        \\");
//        System.out.println("   |  |   |   )_");
//        System.out.println("   l--l--l / /");
//        System.out.println("           |  |");
//        System.out.println("            \\ \\");
//        System.out.println("              \\/");
    // 고양이 친밀도 90 이상일 때,
    //        System.out.println(".  /\\_/\\    ♡ 친밀도가 90이 되었어요.");
    //        System.out.println(" >(• ༝ •)<");
    //        System.out.println("   |        \\");
    //        System.out.println("   |  |   |   )_");
    //        System.out.println("   l--l--l / /");
    //        System.out.println("           |  |");
    //        System.out.println("            \\ \\");
    //        System.out.println("              \\/");
    // 고양이 친밀도 100이상일 떼 => 게임 종료 엔딩!!
    //            System.out.println(".　 　 ∧＿∧ "+TextColor.red+ "고양이가 당신에게 하고 싶은 말이 있대요."+TextColor.exit);
    //        System.out.println("　 　 (・ω・)");
    //        System.out.println("┏ーー∪ー∪ーー┓");
    //        System.out.println("┃＼　　　　　／┃");
    //        System.out.println("┃　＼　♡　／　┃");
    //        System.out.println("┃　／＼＿／＼　┃");
    //        System.out.println("┗ー━ー━ー━ー┛");
    //        System.out.println("\n╭ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝╮");
    //        System.out.println("    난 너가 좋아!  "+Player.name+"!");
    //        System.out.println("╰ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ╯")
    void event() {}
    void acting() {}
    void nextDay() {}
}
