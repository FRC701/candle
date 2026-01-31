// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.CANdleConfiguration;
import com.ctre.phoenix6.controls.SolidColor;
import com.ctre.phoenix6.controls.TwinkleAnimation;
import com.ctre.phoenix6.hardware.CANdle;
import com.ctre.phoenix6.signals.RGBWColor;
import com.ctre.phoenix6.signals.StatusLedWhenActiveValue;
import com.ctre.phoenix6.signals.StripTypeValue;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDs extends SubsystemBase {

  private final CANdle m_candle = new CANdle(1);

  private static final int kLED_COLUMNS = 2;
  private static final int kLED_ROWS = 4;
  private static final int kSTRIP_START = 0;
  private static final int kSTRIP_LENGTH = 8;
  private static final int kPANEL_START = 1;
  private static final int kPANEL_END = 8;

  private static final int kLED_TOTAL = kLED_COLUMNS * kLED_ROWS + kSTRIP_LENGTH;

  private static final int LedCount = 0;

  private static final RGBWColor kGreen = new RGBWColor(0, 225, 0, 0);
  private static final RGBWColor kRed = new RGBWColor();

  private enum AnimationType {
    None,
    Fire,
    Blink,
    RainbowAnimation,
    Twinkle
  }

  private AnimationType m_anim1State = AnimationType.None;

  private final SendableChooser<AnimationType> m_anim1Chooser =
      new SendableChooser<AnimationType>();

  /** Creates a new LedPannel. */
  public LEDs() {
    // Configures CANdle, sets brightness, strip type, and applies it all
    TwinkleAnimation animation = new TwinkleAnimation(kPANEL_START, kPANEL_END);
    CANdleConfiguration configALL = new CANdleConfiguration();

    configALL.LED.BrightnessScalar = 0.5;
    configALL.LED.StripType = StripTypeValue.GRBW;

    configALL.CANdleFeatures.StatusLedWhenActive = StatusLedWhenActiveValue.Disabled;

    m_candle.getConfigurator().apply(configALL);

    m_candle.setControl(animation);

    m_candle.setControl(new SolidColor(0, 3).withColor(kRed));
    m_candle.setControl(new SolidColor(4, 7).withColor(kGreen));

    m_anim1Chooser.setDefaultOption("Twinkle", AnimationType.Twinkle);
  }

  @Override
  public void periodic() {
    final var anim1Selection = m_anim1Chooser.getSelected();
    if (m_anim1State != anim1Selection) {
      m_anim1State = anim1Selection;

      switch (m_anim1State) {
        default:
        case Twinkle:
          m_candle.setControl(
              new TwinkleAnimation(kPANEL_START, kPANEL_END).withSlot(0).withColor(kRed));
      }
    }
  }
}
