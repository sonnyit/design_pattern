/* 
 * File:   motor.h
 * Author: sonny
 *
 * Created on February 6, 2017, 2:16 PM
 */

#ifndef MOTOR_H
#define MOTOR_H

#include "include/state_machine.h"

class MotorData : public EventData {
public:
    int speed;
};

class Motor : public StateMachine {
public:
    Motor();
    void setSpeed(MotorData* pData);
    void Halt();
    
private:
    int _currentSpeed;
    
    enum States {
        ST_IDLE,
        ST_STOP,
        ST_START,
        ST_CHANGE_SPEED,
        ST_MAX_STATES
    };
    
    void stIdle(const NoEventData*);
    StateAction<Motor, NoEventData, &Motor::stIdle> idle;
    
    void stStop(const NoEventData*);
    StateAction<Motor, NoEventData, &Motor::stStop> stop;
    
    void stStart(const MotorData*);
    StateAction<Motor, MotorData, &Motor::stStart> start;
    
    void stChangeSpeed(const MotorData*);
    StateAction<Motor, MotorData, &Motor::stChangeSpeed> changeSpeed;
    
private:
    virtual const StateMapRow* getStateMap() {
        static const StateMapRow stateMap[] = {
            &idle,
            &stop,
            &start,
            &changeSpeed
        };
        
        return &stateMap[0];
    }
};

#endif /* MOTOR_H */

