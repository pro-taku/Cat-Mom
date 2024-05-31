package game.objects;

import game.screen.Termianl;

/**
 * <h1>game.objects.Cat</h1>
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
 * </ol>
 */
public class Cat extends Termianl {
    //
    //

    public void update(int action) {
        switch (action) {
            case 1:
                feed();
                break;
            case 2:
                sleep();
                break;
            case 3:
                pet();
                break;
            case 4:
                wash();
                break;
            case 5:
                cure();
                break;
            case 6:
                stroll();
                break;
        }
        catEvent(this, action);
    }

    private String name;        // 이름
    private int nextAction;     // 다음 행동

    private int satiety;        // 1. 포만감
    private int health;         // 2. 건강
    private int clean;          // 3. 깨끗함
    private int fatigue;        // 4. 피로도
    private int intimacy;       // 5. 친밀도

    // 생성자
    public Cat(String name) {
        this.name = name;
        satiety = 30;
        health = 50;
        clean = 30;
        fatigue = 0;
        intimacy = 30;
    }

    // setter
    public void resetSatiety() {
        this.satiety = 30;
    }

    public void resetClean() {
        this.clean = 30;
    }

    public void resetFatigue() {
        this.fatigue = 70;
    }

    // Getter
    public String getName() {
        return name;
    }

    public int getSatiety() {
        return satiety;
    }

    public int getHealth() {
        return health;
    }

    public int getClean() {
        return clean;
    }

    public int getFatigue() {
        return fatigue;
    }

    public int getIntimacy() {
        return intimacy;
    }

    // 밥주기
    public void feed() {
        satiety += 40;
        fatigue += 20;
        intimacy += 10;
    }

    // 재우기
    public void sleep() {
        fatigue = 0;
        satiety -= 20;
    }

    // 쓰다듬기
    public void pet() {
        intimacy += 5;
        fatigue += 10;
    }

    // 씻기
    public void wash() {
        fatigue += 20;
        clean += 35;
        intimacy -= 15;
        satiety -= 20;
    }

    // 치료하기
    public void cure() {
        health += 45;
        fatigue += 30;
        intimacy -= 10;
    }

    // 산책시키기
    public void stroll() {
        intimacy += 15;
        health += 30;
        fatigue += 40;
        satiety -= 30;
        clean -= 30;
    }
}

