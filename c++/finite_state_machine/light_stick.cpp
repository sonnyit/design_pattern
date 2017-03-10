/* 
 * File:   light_stick.cpp
 * Author: sonny
 *
 * Created on February 6, 2017, 5:14 PM
 */

#include "light_stick.h"
#include <iostream>

using namespace std;

LightStick::LightStick() :
StateMachine(ST_MAX_STATES)
{
}

void LightStick::stick() {
    static const BYTE TRANSITIONS[] = {
        ST_ON, /* ST_OFF */
        ST_OFF /* ST_ON */
    };
    
    externalEvent(TRANSITIONS[getCurrentState()], nullptr);
}

void LightStick::stOff(const NoEventData*) {
    cout << "light is off\n";
}

void LightStick::stOn(const NoEventData*) {
    cout << "light is on\n";
}
