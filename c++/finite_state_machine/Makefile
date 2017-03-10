state_machine_example: include/state_machine.h include/state_machine.cpp light_stick.h light_stick.cpp motor.h motor.cpp example.cpp

state_machine_example: include/state_machine.cpp light_stick.cpp motor.cpp example.cpp
	$(CXX) -Wall -g -std=c++11 -o state_machine_example include/state_machine.cpp light_stick.cpp motor.cpp example.cpp

clean:
	rm -f state_machine_example
