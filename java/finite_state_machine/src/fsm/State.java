package fsm;

/**
 *
 * @author minhnh3
 */
public enum State {
    IDLE("state idle") {
        @Override
        void setSpeed(Motor motor, int speed) {
            motor.setState(State.START);
            motor.setSpeed(speed);
        }

        @Override
        void halt(Motor motor) {
        }

    },
    START("state start") {
        @Override
        void setSpeed(Motor motor, int speed) {
            motor.setState(State.CHANGE_SPEED);
            motor.setSpeed(speed);
        }

        @Override
        void halt(Motor motor) {
            motor.setSpeed(0);
            motor.setState(State.STOP);
        }

    },
    CHANGE_SPEED("state change_speed") {
        @Override
        void setSpeed(Motor motor, int speed) {
            motor.setSpeed(speed);
        }

        @Override
        void halt(Motor motor) {
            motor.setSpeed(0);
            motor.setState(State.STOP);
            this.autoTransition();
        }

    },
    STOP("state stop") {
        @Override
        void setSpeed(Motor motor, int speed) {
            motor.setState(State.STOP);
            motor.setSpeed(0);
        }

        @Override
        void halt(Motor motor) {
        }

    };

    private String _stateName;

    private State(String _stateName) {
        this._stateName = _stateName;
    }

    abstract void setSpeed(Motor motor, int speed);

    abstract void halt(Motor motor);

    public String toString() {
        return _stateName;
    }

    public void autoTransition() {

    }
}
