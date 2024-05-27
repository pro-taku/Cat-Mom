/**
 * <h1>Cat</h1>
 *
 * <p>
 *     수정 일자 : 2024.05.27 19:13<br>
 *     수정자 : 국희근(protaku)
 * </p>
 *
 * <br>
 *
 * <h2>인스턴스 변수</h2>
 * <ol>
 *     <li>{@link String} name: 이름</li>
 *     <li>int nextAction: 다음 행동</li>
 *     <li>int satiety: 포만감</li>
 *     <li>int health: 건강</li>
 *     <li>int clean: 깨끗함</li>
 *     <li>int fatigue: 피로도</li>
 *     <li>int intimacy: 친밀도</li>
 * </ol>
 *
 * <h2>주요 메소드</h2>
 * <ol>
 *     <li>{@link #initiate()}: 초기화</li>
 * </ol>
 */
public class Cat extends Display implements Action, Tick {
    private String name;        // 이름
    private int nextAction;     // 다음 행동

    private int satiety;        // 포만감
    private int health;         // 건강
    private int clean;          // 깨끗함
    private int fatigue;        // 피로도
    private int intimacy;       // 친밀도

    // 생성자
    public Cat(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

    @Override
    public void initiate() {

    }

    @Override
    public void update() {

    }

    @Override
    public void dispose() {

    }
}