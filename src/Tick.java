/**
 * <h1>(interface) Tick</h1>
 *
 * <p>
 *     수정 일자 : 2024.05.27 19:13<br>
 *     수정자 : 국희근(protaku)
 * </p>
 *
 * <br>
 *
 * <p>
 *     게임을 시작할 때, 진행할 때, 종료할 때 각 객체마다 다른 함수를 실행시켜야 하기 때문에<br>
 *     각 객체마다 Tick 인터페이스를 구현하여 각 객체의 특성에 맞게 함수를 오버라이딩하여 사용한다.
 * </p>
 *
 * <br>
 *
 * <h2>메서드</h2>
 * <ol>
 *     <li>{@return void} {@link #initiate()}: 객체를 초기화한다.</li>
 *     <li>{@return void} {@link #update()}: 객체를 진행한다.</li>
 *     <li>{@return void} {@link #dispose()}: 객체를 삭제한다.</li>
 * </ol>
 */
public interface Tick {
    void initiate();
    void update();
    void dispose();
}
