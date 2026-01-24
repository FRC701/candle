// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;


import com.ctre.phoenix6.hardware.CANdle;
import com.ctre.phoenix6.signals.RGBWColor;
import com.ctre.phoenix6.configs.CANdleConfiguration; 
import com.ctre.phoenix6.controls.RainbowAnimation; 
public class LEDs extends SubsystemBase {
    
    private final CANdle  m_candle = new CANdle(1);
 

    private final static int kLED_COLUMNS = 2;
    private final static int kLED_ROWS = 4;
    private final static int kSTRIP_START = 0;
    private final static int kSTRIP_LENGTH = 8;
    private final static int kPANEL_START = 1;
    private final static int kPANEL_END = 8;

    private final static int kLED_TOTAL = kLED_COLUMNS * kLED_ROWS + kSTRIP_LENGTH;

    private static final int LedCount = 0;

    private static final RGBWColor kGreen = new RGBWColor(0, 225, 0, 0);



    private enum AnimationType{
        Fire, Blink
    }


    /** Creates a new LedPannel. */
    public LEDs() {
        RainbowAnimation animation = new RainbowAnimation(kPANEL_START, kPANEL_END);
        CANdleConfiguration configALL = new CANdleConfiguration();
       
        
       
        m_candle.setControl(animation);

    }

    




   
    

   @Override
    public void periodic() {


    }
   
}