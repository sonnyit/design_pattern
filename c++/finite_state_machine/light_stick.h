/* 
 * File:   light_stick.h
 * Author: sonny
 *
 * Created on February 6, 2017, 5:06 PM
 */

#ifndef LIGHTSTICK_H
#define LIGHTSTICK_H

#include "include/state_machine.h"

class LightStick : public StateMachine {
public:
    LightStick();
    void stick();

private:

    enum States {
        ST_OFF,
        ST_ON,
        ST_MAX_STATES
    };

    void stOff(const NoEventData*);
    StateAction<LightStick, NoEventData, &LightStick::stOff> off;
    
    void stOn(const NoEventData*);
    StateAction<LightStick, NoEventData, &LightStick::stOn> on;

private:
    virtual const StateMapRow* getStateMap() {
        static const StateMapRow stateMap[] = {
            &off,
            &on
        };
        
        return &stateMap[0];
    }
};

#endif /* LIGHTSTICK_H */

