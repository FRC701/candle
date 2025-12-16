// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.CANdleConfiguration;
import com.ctre.phoenix6.controls.EmptyAnimation;
import com.ctre.phoenix6.hardware.CANdle;
import com.ctre.phoenix6.signals.RGBWColor;
import com.ctre.phoenix6.signals.StatusLedWhenActiveValue;
import com.ctre.phoenix6.signals.StripTypeValue;
import com.ctre.phoenix6.signals.VBatOutputModeValue;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.stream.IntStream;

public class Candle extends SubsystemBase {

  /** Setup different colors to be used with the main (first eight (8)) LEDs. */
  public static final RGBWColor kRed = new RGBWColor(Color.kRed);

  public static final RGBWColor kOrange = new RGBWColor(Color.kOrange);
  public static final RGBWColor kYellow = new RGBWColor(Color.kYellow);
  public static final RGBWColor kGreen = new RGBWColor(Color.kGreen);
  public static final RGBWColor kBlue = new RGBWColor(Color.kBlue);
  public static final RGBWColor kIndigo = new RGBWColor(Color.kIndigo);
  public static final RGBWColor kViolet = new RGBWColor(Color.kViolet);
  public static final RGBWColor kWhite = new RGBWColor(Color.kWhite);

  /** Creates a new Candle. */
  public Candle() {
    Configure();
    ClearAnimations();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  private void Configure() {
    CANdleConfiguration configuration = new CANdleConfiguration();
    configuration.LED.StripType = StripTypeValue.GRB;
    configuration.LED.BrightnessScalar = 0.75;
    configuration.CANdleFeatures.StatusLedWhenActive = StatusLedWhenActiveValue.Disabled;
    configuration.CANdleFeatures.VBatOutputMode = VBatOutputModeValue.On;
    mCandle.getConfigurator().apply(configuration);
  }

  private void ClearAnimations() {
    IntStream.range(0, 8)
        .forEach(
            animation -> {
              mCandle.setControl(new EmptyAnimation(animation));
            });
  }

  private CANdle mCandle = new CANdle(1, "rio");
}
