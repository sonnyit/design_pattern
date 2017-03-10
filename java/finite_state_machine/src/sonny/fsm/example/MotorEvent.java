package sonny.fsm.example;

import sonny.fsm.Event;

/**
 *
 * @author minhnh3
 */
public enum MotorEvent implements Event {
    SET_SPEED(0),
    HALT(1),
    INTERNAL_EVENT(2);
    private final int _id;

    private MotorEvent(int _id) {
        this._id = _id;
    }

    @Override
    public int getInt() {
        return _id;
    }
}
