package game.script;

/**
 * <h1>(interface) game.script.Action</h1>
 *
 * <p>
 *     수정 일자 : 2024.05.27 19:13<br>
 *     수정자 : 국희근(protaku)
 * </p>
 *
 * <br>
 *
 * <p> 고양이 키우기에 등장하는 모든 행동들 </p>
 *
 * <br>
 *
 * <h2>메소드</h2>
 * <ol>
 *     <li> {@return void} {@link #feed()} : 밥주기 </li>
 *     <li> {@return void} {@link #sleep()} : 재우기 </li>
 *     <li> {@return void} {@link #pet()} : 쓰다듬기 </li>
 *     <li> {@return void} {@link #wash()} : 씻기 </li>
 *     <li> {@return void} {@link #cure()} : 치료하기 </li>
 *     <li> {@return void} {@link #stroll()} : 산책시키기 </li>
 * </ol>
 */

public interface Action {
    public static void feed() {}
    public static void sleep() {}
    public static void pet() {}
    public static void wash() {}
    public static void cure() {}
    public static void stroll() {}
}
