/* 
 * File:   state_machine.h
 * Author: sonny
 *
 * Created on February 6, 2017, 1:20 PM
 */

#ifndef STATEMACHINE_H
#define STATEMACHINE_H

#include <assert.h>

typedef unsigned char BYTE;

class EventData {
public:

    virtual ~EventData() {
    }
};

typedef EventData NoEventData;
class StateMachine;

class StateBase {
public:
    virtual void invokeStateAction(StateMachine* sm, const EventData* data) const = 0;
};

template <class SM, class Data, void (SM::*Func)(const Data*)>
class StateAction : public StateBase {
public:
    void invokeStateAction(StateMachine* sm, const EventData* data) const override {
        SM* derivedSM = static_cast<SM*>(sm);
        const Data* derivedData = dynamic_cast<const Data*>(data);
        assert(derivedData != nullptr);
        
        (derivedSM->*Func)(derivedData);
    }
};

struct StateMapRow {
    const StateBase* const State;
};

class StateMachine {
public:

    enum {
        EVENT_IGNORED = 0xFE, CANNOT_HAPPEN
    };
    StateMachine(BYTE maxStates, BYTE initState = 0);

    virtual ~StateMachine() {
    }
    
    BYTE getCurrentState() { return _currentState; }
protected:
    void externalEvent(BYTE newState, const EventData* pData = nullptr);
    void internalEvent(BYTE newState, const EventData* pData = nullptr);
private:
    const BYTE MAX_STATES;
    BYTE _currentState;
    BYTE _newState;
    bool _eventGenerated;
    const EventData* _pEventData;
    
    virtual const StateMapRow* getStateMap() = 0;
    void setCurrentState(BYTE newState) { _currentState = newState; }
    
    void StateEngine(void);
    void StateEngine(const StateMapRow* const pStateMap);
};

#endif /* STATEMACHINE_H */

