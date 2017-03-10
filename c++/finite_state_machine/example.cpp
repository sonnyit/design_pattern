/* 
 * File:   example.cpp
 * Author: sonny
 *
 * Created on February 6, 2017, 11:53 AM
 */

#include <cstdlib>
#include "motor.h"
#include "light_stick.h"

using namespace std;

int main(int argc, char** argv) {
    /* example with Motor */
    Motor motor1;
    
    MotorData* pData = new MotorData();
    pData->speed = 10;
    motor1.setSpeed(pData);
    
    MotorData* pData2 = new MotorData();
    pData2->speed = 50;
    motor1.setSpeed(pData2);
    
    motor1.Halt();
    motor1.Halt();
    
    /* example with LightStick */
    LightStick ls1;
    
    ls1.stick();
    ls1.stick();
    ls1.stick();
    
    return 0;
}

