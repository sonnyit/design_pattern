package sonny.fsm2;

/**
 *
 * @author minhnh3
 */
public class Fsm {

    private int _speed;
    private State[] _states = {State.IDLE, State.START, State.CHANGE_SPEED, State.STOP};
    private State[][] _transitions = new State[][]{
            /*                      SET_SPEED          ,   HALT      ,    INTERNAL_EVENT */
            /* IDLE */              {State.START,          State.IDLE,    State.IDLE},
            /* START */             {State.CHANGE_SPEED,   State.STOP,    State.START},
            /* CHANGE_SPEED */      {State.CHANGE_SPEED,   State.STOP,    State.CHANGE_SPEED},
            /* STOP */              {State.STOP,           State.STOP,    State.IDLE}
        };
    private State _current = State.IDLE;

    public Fsm() {
        _speed = 0;
    }

    public int getSpeed() {
        return _speed;
    }

    public void setSpeed(int speed) {
        this._speed = speed;
    }

    private void next(Event event) {
        _current = _transitions[_current.getInt()][event.getInt()];
    }

    public void changeSpeed(int speed) {
        _states[_current.getInt()].process(this, speed);
        next(Event.CHANGE_SPEED);
        alwaysRun();
    }

    public void halt() {
        _states[_current.getInt()].process(this, 0);
        next(Event.HALT);
        alwaysRun();
    }

    private void alwaysRun() {
        next(Event.ALWAY_RUN);
    }

    @Override
    public String toString() {
        return "state: " + _current.toString() + ", speed: " + _speed;
    }

    public static void main(String[] args) {
        Fsm fsm = new Fsm();
        System.out.println(fsm);

        fsm.changeSpeed(5);
        System.out.println(fsm);

        fsm.changeSpeed(10);
        System.out.println(fsm);

        fsm.changeSpeed(15);
        System.out.println(fsm);

        fsm.halt();
        System.out.println(fsm);

        fsm.halt();
        System.out.println(fsm);

        fsm.changeSpeed(12);
        System.out.println(fsm);

        fsm.halt();
        System.out.println(fsm);
    }
}
