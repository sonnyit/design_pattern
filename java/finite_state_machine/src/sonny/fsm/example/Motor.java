package sonny.fsm.example;

import sonny.fsm.Event;
import sonny.fsm.Fsm;

/**
 *
 * @author minhnh3
 */
public class Motor extends Fsm {

    private int _speed;

    public Motor() {
        this._states = new MotorState[]{MotorState.IDLE, MotorState.START, MotorState.CHANGE_SPEED, MotorState.STOP};
        this._transitions = new MotorState[][]{
            /*                      SET_SPEED               ,   HALT           ,    INTERNAL_EVENT */
            /* IDLE */              {MotorState.START,          MotorState.IDLE,    MotorState.IDLE},
            /* START */             {MotorState.CHANGE_SPEED,   MotorState.STOP,    MotorState.START},
            /* CHANGE_SPEED */      {MotorState.CHANGE_SPEED,   MotorState.STOP,    MotorState.CHANGE_SPEED},
            /* STOP */              {MotorState.STOP,           MotorState.STOP,    MotorState.IDLE}
        };
        this._currentState = MotorState.IDLE;
        this._speed = 0;
    }

    @Override
    protected void internalEvent() {
        _currentState = _transitions[_currentState.getInt()][MotorEvent.INTERNAL_EVENT.getInt()];
    }

    @Override
    protected void externalEvent(Event event) {
        _currentState = _transitions[_currentState.getInt()][event.getInt()];
    }

    public void changeSpeed(int speed) {
        this._speed = speed;
        externalEvent(MotorEvent.SET_SPEED);
    }

    public void halt() {
        this._speed = 0;
        externalEvent(MotorEvent.HALT);
        internalEvent();
    }

    @Override
    public String toString() {
        return "state: " + _currentState.toString() + ", speed: " + _speed;
    }

    public static void main(String[] args) {
        Motor motor = new Motor();
        System.out.println(motor);

        motor.changeSpeed(5);
        System.out.println(motor);
        
        motor.changeSpeed(10);
        System.out.println(motor);
        
        motor.changeSpeed(12);
        System.out.println(motor);
        
        motor.halt();
        System.out.println(motor);
        
        motor.halt();
        System.out.println(motor);
    }
}
