package sonny.fsm2;

/**
 *
 * @author minhnh3
 */
public enum State {
    IDLE(0) {
        @Override
        void process(Fsm fsm, int speed) {
            fsm.setSpeed(speed);
        }
    },
    START(1) {
        @Override
        void process(Fsm fsm, int speed) {
            fsm.setSpeed(speed);
        }
    },
    CHANGE_SPEED(2) {
        @Override
        void process(Fsm fsm, int speed) {
            fsm.setSpeed(speed);
        }
    },
    STOP(3) {
        @Override
        void process(Fsm fsm, int speed) {
            fsm.setSpeed(0);
        }
    };

    private int _num;

    abstract void process(Fsm fsm, int speed);

    private State(int num) {
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
