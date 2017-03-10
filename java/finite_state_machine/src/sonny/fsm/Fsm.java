package sonny.fsm;

import sonny.fsm.example.MotorState;

/**
 *
 * @author minhnh3
 * @param <T>
 */
public abstract class Fsm {

    protected MotorState[] _states;
    protected MotorState[][] _transitions;
    protected MotorState _currentState;

    public MotorState getCurrentState() {
        return _currentState;
    }

    public void setCurrentState(MotorState current) {
        this._currentState = current;
    }

    protected void externalEvent(Event event) {
        //_currentState = _transitions[_currentState.getInt()][event.getInt()];
    }
    
    protected void internalEvent() {
        //_currentState = _transitions[_currentState.getInt()][InternalEvent.INTERNAL_EVENT.getInt()];
    }

    @Override
    public String toString() {
        return "state: " + _currentState.toString();
    }
}
