/* 
 * File:   state_machine.cpp
 * Author: sonny
 *
 * Created on February 6, 2017, 3:07 PM
 */

#include "state_machine.h"

/*-----------------------------------------------------------------------------
 * StateMachine
 *----------------------------------------------------------------------------*/

StateMachine::StateMachine(BYTE maxStates, BYTE initState) :
MAX_STATES(maxStates),
_currentState(initState),
_newState(0),
_eventGenerated(false),
_pEventData(nullptr) {
}

void StateMachine::externalEvent(BYTE newState, const EventData* pData) {
    if (newState == EVENT_IGNORED) {
    } else {
        internalEvent(newState, pData);
        StateEngine();
    }
}

void StateMachine::internalEvent(BYTE newState, const EventData* pData) {
    if (pData == nullptr) {
        pData = new NoEventData();
    }

    _pEventData = pData;
    _eventGenerated = true;
    _newState = newState;
}

void StateMachine::StateEngine() {
    const StateMapRow* pStateMap = getStateMap();
    if (pStateMap != nullptr) {
        StateEngine(pStateMap);
    }
}

void StateMachine::StateEngine(const StateMapRow* const pStateMap) {
    const EventData* pDataTemp = nullptr;
    while(_eventGenerated) {
        assert(_newState < MAX_STATES);
        const StateBase* state = pStateMap[_newState].State;
        
        pDataTemp = _pEventData;
        _pEventData = nullptr;
        
        _eventGenerated = false;
        
        setCurrentState(_newState);
        
        assert(state != nullptr);
        state->invokeStateAction(this, pDataTemp);
    }
}
