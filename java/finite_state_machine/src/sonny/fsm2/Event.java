package sonny.fsm2;

/**
 *
 * @author minhnh3
 */
public enum Event {
    CHANGE_SPEED(0),
    HALT(1),
    ALWAY_RUN(2);
    
    private int _num;

    private Event(int _num) {
        this._num = _num;
    }
    
    public int getInt() { 
        return _num;
    }
}
