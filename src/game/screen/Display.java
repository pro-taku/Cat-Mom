package game.screen;

import game.objects.Cat;
import game.objects.Player;

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
 *     <li>{@link #showCatsName(Cat[] cats)}: 고양이 정보를 보여준다.</li>
 *     <li>{@link #actionMenu()}: 행동 메뉴를 보여준다.</li>
 * </ol>
 */
public class Display {

    void systemOn() {
        System.out.println(TextColor.yellow + "╔════════════════════════════════════════════════════════════════════════════════════╗" + TextColor.exit);
        System.out.println(TextColor.yellow + "║   ______      ___      .___________.     ______      ___      .______     _______  ║" + TextColor.exit);
        System.out.println(TextColor.yellow + "║  /      |    /   \\     |           |    /      |    /   \\     |   _  \\   |   ____| ║" + TextColor.exit);
        System.out.println(TextColor.yellow + "║ |  ,----'   /  ^  \\    `---|  |----`   |  ,----'   /  ^  \\    |  |_)  |  |  |__    ║" + TextColor.exit);
        System.out.println(TextColor.yellow + "║ |  |       /  /_\\  \\       |  |        |  |       /  /_\\  \\   |      /   |   __|   ║" + TextColor.exit);
        System.out.println(TextColor.yellow + "║ |  `----. /  _____  \\      |  |        |  `----. /  _____  \\  |  |\\  \\--.|  |____  ║" + TextColor.exit);
        System.out.println(TextColor.yellow + "║  \\______|/__/     \\__\\     |__|         \\______|/__/     \\__\\ | _| `.___||_______| ║" + TextColor.exit);
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
        System.out.println("   ║  1. 게임 시작                                                                ║" );
        System.out.println("   ║  2. 게임 설명                                                                ║" );
        System.out.println("   ║  3. 제작자 정보                                                              ║" );
        System.out.println("   ║  4. 게임 종료                                                                ║");
        System.out.println("   ║                                                                              ║" );
        System.out.println("   ║  (원하는 번호를 입력해주세요)                                                ║");
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

    void showDay(int day) {
        System.out.println("\n< " + day + " day >");
    }

    void mainMenu() {
        System.out.println("\n   ╔═══════════════════════════════════════════════════════════════════════════════╗");
        System.out.println(  "   ║  "+TextColor.green+ "메인 메뉴"+TextColor.exit+"                                                                    ║" );
        System.out.println(  "   ║  1. 행동하기                                                                  ║");
        System.out.println(  "   ║  2. 고양이 정보                                                               ║");
        System.out.println(  "   ║  3. 플레이어 정보                                                             ║");
        System.out.println(  "   ║  4. 메인 창으로                                                               ║");
        System.out.println(  "   ╚═══════════════════════════════════════════════════════════════════════════════╝\n");
    }

    void showCatsName(Cat[] cats) {
        for (int i=1 ; i < cats.length ; i++) {
            System.out.printf("([" + i + "] " + cats[i].getName() + ")  ");
        }
        System.out.println();
    }

    void showCatInfo(Cat cat) {
        System.out.println("\n");
        System.out.println("   /\\_/\\              "+TextColor.yellow+"이름 : "+cat.getName()+TextColor.exit);
        System.out.println(" >(• ༝ •)<            "+TextColor.yellow+"친밀도 : "+cat.getIntimacy()+TextColor.exit);
        System.out.println("   |        \\       ");
        System.out.println("   |  |   |   )_      "+TextColor.yellow+"포만감 : "+cat.getSatiety()+TextColor.exit);
        System.out.println("   l--l--l / /        "+TextColor.yellow+"건강 : "+cat.getHealth()+TextColor.exit);
        System.out.println("           |  |       "+TextColor.yellow+"청결도 : "+cat.getClean()+TextColor.exit);
        System.out.println("            \\ \\       "+TextColor.yellow+"피로도 : "+cat.getFatigue()+TextColor.exit);
        System.out.println("              \\/    ");
        System.out.println("\n");
    }

    void showPlayerInfo(Player player) {
        System.out.println("\n=========================\n");
        System.out.println(  "  이름 : " + player.getName());
        System.out.println(  "  행동 횟수 : " + player.getActionCount());
        System.out.print(    "  돌보는 고양이들  : "); showCatsName(player.getCats());
        System.out.println("\n=========================\n");
    }

    void actionMenu() {

        System.out.println("\n   ╔══════════════════════════════════════════════════════════════════════════════╗" );
        System.out.println(  "   ║  "+TextColor.green+ "행동"+TextColor.exit+"                                                                        ║" );
        System.out.println(  "   ║  1. 밥 주기                                                                  ║" );
        System.out.println(  "   ║  2. 재우기                                                                   ║" );
        System.out.println(  "   ║  3. 쓰다듬기                                                                 ║");
        System.out.println(  "   ║  4. 씻기                                                                     ║" );
        System.out.println(  "   ║  5. 치료하기                                                                 ║");
        System.out.println(  "   ║  6. 산책시키기                                                               ║");
        System.out.println(  "   ║  0. 뒤로 가기                                                                ║");
        System.out.println(  "   ╚══════════════════════════════════════════════════════════════════════════════╝\n" );
    }

    void catEvent(Cat cat, int action) {
        System.out.println("\n");
        switch (action) {
            case 1:
                System.out.println(" 　 ∧ ∧　　　　　　");
                System.out.println(" 　( ´･ω･)　배불러        " + cat.getName() + "(에)게 밥을 주었습니다");
                System.out.println(" 　/　　⌒ヽ　　　         [효과]");
                System.out.println(" （人＿__つ_つ            "
                        + "포만감 " + TextColor.green+"+40"+TextColor.exit + ", "
                        + "피로도 " + TextColor.red  +"+20"+TextColor.exit + ", "
                        + "친밀도 " + TextColor.green+"+10"+TextColor.exit);
                break;
            case 2:
                System.out.println("         . º   ");
                System.out.println("     ∧_∧ .º    ");
                System.out.println("　  ( ･ω･)  흐암        " + cat.getName() + "(을)를 재웠습니다.");
                System.out.println("  　｜⊃／(＿＿＿         [효과]");
                System.out.println("  ／└-(＿＿＿_／         "
                        + "피로도 " + TextColor.red + "0" + TextColor.exit + ", "
                        + "포만감 " + TextColor.red + "-20" + TextColor.exit);
                System.out.println("  ￣￣￣￣￣￣   ");
                break;
            case 3:
                System.out.println("   　∧＿∧   (쓰담쓰담)");
                System.out.println("  （´・ω・)つ＿ ∧              " + cat.getName() + "(을)를 쓰다듬어 주었습니다.");
                System.out.println("  （つ　 / (・ω・｡)            [효과]");
                System.out.println("   しーＪ　 (nnノ)             "
                        + "친밀도 " + TextColor.green + "+5" + TextColor.exit + ", "
                        + "피로도 " + TextColor.red + "+10" + TextColor.exit);
                break;
            case 4:
                System.out.println("    ⋀,,⋀.       ");
                System.out.println("  (*・ω・)/  뽀송!        " + cat.getName() + "(을)를 씻겼습니다.");
                System.out.println("   (つ　 ﾉ               [효과]");
                System.out.println("   しーＪ                "
                        + "피로도 " + TextColor.red + "+20" + TextColor.exit + ", "
                        + "청결도 " + TextColor.green + "+35" + TextColor.exit + ", "
                        + "친밀도 " + TextColor.red + "-15" + TextColor.exit + ", "
                        + "포만감 " + TextColor.red + "-20" + TextColor.exit);
                break;
            case 5:
                System.out.println("    ∧＿∧                 ");
                System.out.println("  （｡･ω･｡)つ━☆☆*다               " + cat.getName() + "(을)를 치료했습니다.");
                System.out.println("  ⊂　　 ノ   　나았다옹　☆☆        [효과]");
                System.out.println("  　し-Ｊ　　　°。+ * 。            "
                        + "건강 " + TextColor.green + "+45" + TextColor.exit + ", "
                        + "피로도 " + TextColor.red + "+30" + TextColor.exit + ", "
                        + "친밀도 " + TextColor.red + "-10" + TextColor.exit);
                break;
            case 6:
                System.out.println(" 　　∧_∧             ");
                System.out.println("　((・∀・∩　 산책 시간!");
                System.out.println("　 ＼　　〈                    " + cat.getName() + "(을)를 산책시켰습니다.");
                System.out.println("　　  丶丶_)          ");
                System.out.println("　　　　　　푸슝                [효과]");
                System.out.println("　　  ____＼从/_               "
                        + "건강 " + TextColor.green + "+30" + TextColor.exit + ", "
                        + "친밀도 " + TextColor.green + "+15" + TextColor.exit + ", "
                        + "피로도 " + TextColor.red + "+40" + TextColor.exit + ", "
                        + "포만감 " + TextColor.red + "-30" + TextColor.exit + ", "
                        + "청결도 " + TextColor.red + "-30" + TextColor.exit);
                System.out.println("　 ／＼＿＿＿＿＼       ");
                System.out.println("　|￣＼(∩゜Д゜;)＼     ");
                System.out.println("　|　  ｜￣￣∪￣｜     ");
                break;
        }
        System.out.println("\n");
    }

    void warningCatStatus(Cat cat, int checkedValue) {
        System.out.print("[!] " + cat.getName() + "이(가) ");
        switch (checkedValue) {
            case 1:
                System.out.println("굶고 있습니다! (포만감 < 0) => 30으로 초기화");
                break;
            case 3:
                System.out.println("너무 더럽습니다! (청결감 < 0) => 30으로 초기화");
                break;
            case 4:
                System.out.println("너무 지쳐있습니다! (피로도 > 100) => 70으로 초기화");
                break;
        }
    }

    void warningMessage(int warning) {
        System.out.println("\n경고 횟수 : " + warning);
        System.out.println("[!] 3회 초과시 게임이 종료됩니다. 주의하세요!\n");
    }

    void remainingActionChances(Player player) {
        System.out.println("\n(오늘 남은 행동 횟수 : " + player.getActionCount() + ")\n");
    }

    void lose(int days) {
        System.out.println("""
                ==============================
                
                           게임 오버!

                       고양이가 도망쳤습니다.
                """);
        System.out.println(
                "       (총 소요 시간 : " + days + " 일)");
        System.out.println("""

                ==============================""");
    }

    void win(Player player, int days) {
        System.out.println();
        System.out.println(" 　 　 ∧＿∧     "+TextColor.red+ "고양이가 당신에게 하고 싶은 말이 있대요."+TextColor.exit);
        System.out.println("　 　 (・ω・)    ");
        System.out.println("  ┏ーー∪ー∪ーー━┓");
        System.out.println("  ┃＼　　　　　／┃");
        System.out.println("  ┃　＼　♡　／　┃");
        System.out.println("  ┃　／＼＿／＼　┃");
        System.out.println("  ┗━━ー━ー━ーー━┛\n");
        System.out.println("╭ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝ ͡ ◜◝╮");
        System.out.println("    난 너가 좋아!  "+player.getName()+"!");
        System.out.println("╰ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ╯\n");
        System.out.println(TextColor.yellow+"플레이해주셔서 감사합니다!"+TextColor.exit
                +"   (클리어까지 걸린 시간 : "+TextColor.green+days+"일"+TextColor.exit+")");
    }
}
