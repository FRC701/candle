# CANDle

The Candle project is a demonstration of the CTRE CANDle device.

The candle is a CAN based driver for addressable LEDs. THe CANDle has eight LEDs built-in.
The candle also can drive an LED string of lights.

## Code Formatting with Spotless

Code formatting must conform to spotless settings. You can make sure your code is formatted
correcttly by running `spotlessApply` from the "WPILib Run a command in Gradle" command.

Spotless changes should be squashed into your existing commits. Specifically, spotless-only
commits are discouraged.

CI will enforce the spotless settings and fail any merge that does not conform. So, you
might as well run `spotlessAppply`.

## TODO

1. Remove example subsystems and commands
2. Add candle subsystem
3. Add candle commands
4. Add bindings to the candle commands (probably to the dashboard)
