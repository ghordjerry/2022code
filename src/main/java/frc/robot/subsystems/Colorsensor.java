package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;


public class Colorsensor {  /**
   * Change the I2C port below to match the connection of your color sensor
   */
  private final ColorMatch m_colorMatcher = new ColorMatch();
  private final ColorSensorV3 colorSensor = new ColorSensorV3(I2C.Port.kOnboard);
  private final Color kBlueTarget = Color.kBlue;
  private final Color kRedTarget = Color.kRed;
  
  /**
   * A Rev Color Sensor V3 object is constructed with an I2C port as a 
   * parameter. The device will be automatically initialized with default 
   * parameters.
   */
  public Colorsensor() {
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
  }
}
