package fsm;

/**
 *
 * @author minhnh3
 */
public class Motor {

    private int _speed;
    private State _state;

    public Motor() {
        _speed = 0;
        _state = State.IDLE;
    }

    public int getSpeed() {
        return _speed;
    }

    public void setSpeed(int speed) {
        this._speed = speed;
    }

    public State getState() {
        return _state;
    }

    public void setState(State state) {
        this._state = state;
    }

    public void changeSpeed(int speed) {
        _state.setSpeed(this, speed);
    }
    
    public void halt() {
        _state.halt(this);
    }

    @Override
    public String toString() {
        return "Motor - state: " + _state.toString() + " - speed: " + _speed;
    }

    public static void main(String[] args) {
        Motor motor = new Motor();
        System.out.println(motor);
        
        motor.changeSpeed(10);
        System.out.println(motor);
        
        motor.changeSpeed(10);
        System.out.println(motor);
        
        motor.changeSpeed(10);
        System.out.println(motor);
        
        motor.halt();
        System.out.println(motor);
    }

}
