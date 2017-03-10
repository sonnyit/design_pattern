package sonny.fsm.example;

import sonny.fsm.State;

/**
 *
 * @author minhnh3
 */
public enum MotorState implements State {
    IDLE(0),
    START(1),
    CHANGE_SPEED(2),
    STOP(3);

    private int _num;

    private MotorState(int num) {
        _num = num;
    }

    public int getInt() {
        return _num;
    }

    @Override
    public String toString() {
        switch (this) {
            case IDLE:
                return "state idle";
            case START:
                return "state start";
            case CHANGE_SPEED:
                return "state change_speed";
            case STOP:
                return "state stop";
        }
        return "not define";
    }

}
