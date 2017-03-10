/* 
 * File:   motor.cpp
 * Author: sonny
 *
 * Created on February 6, 2017, 3:40 PM
 */

#include <iostream>
#include "motor.h"

using namespace std;

Motor::Motor() :
StateMachine(ST_MAX_STATES),
_currentSpeed(0) {
}

void Motor::setSpeed(MotorData* pData) {
    static const BYTE TRANSITIONS[] = {
        ST_START,           /* ST_IDLE */
        CANNOT_HAPPEN,      /* ST_STOP */
        ST_CHANGE_SPEED,    /* ST_START */
        ST_CHANGE_SPEED     /* ST_CHANGE_SPEED */
    };
    
    externalEvent(TRANSITIONS[getCurrentState()], pData);
}

void Motor::Halt() {
    static const BYTE TRANSITIONS[] = {
        EVENT_IGNORED,  /* ST_IDLE */
        CANNOT_HAPPEN,  /* ST_STOP */
        ST_STOP,        /* ST_START */
        ST_STOP         /* ST_CHANGE_SPEED */
    };
    externalEvent(TRANSITIONS[getCurrentState()], nullptr);
}

void Motor::stIdle(const NoEventData*) {
    cout << "Motor::stIdle\n";
}

void Motor::stStop(const NoEventData*) {
    cout << "Motor::stStop\n";
    _currentSpeed = 0;
    
    internalEvent(ST_IDLE);
}

void Motor::stStart(const MotorData* pData) {
    cout << "Motor::stStart - speed is: " << pData->speed << endl;
    _currentSpeed = pData->speed;
}

void Motor::stChangeSpeed(const MotorData* pData) {
    cout << "Motor::stChangeSpeed - speed is: " << pData->speed << endl;
    _currentSpeed = pData->speed;
}
