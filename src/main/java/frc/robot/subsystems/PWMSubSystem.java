// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PWMSubSystem extends SubsystemBase {

  private SpeedController motor;
  private Servo servo;

  /** Creates a new ExampleSubsystem. */
  public PWMSubSystem() {
    motor = new Spark(Constants.PWM_MOTOR_PORT);
    servo = new Servo(Constants.PWM_SERVO_PORT);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMotorPWM(double value) {
    motor.set(bound(value, -1, 1));
  }

  public double getMotorPower() {
    return bound(motor.get(), -1, 1);
  }

  public void setServoPWM(double value) {
    servo.setPosition(bound(value, 0, 1));
  }

  public double getServoPosition() {
    return bound(servo.getPosition(), 0, 1);
  }

  private double bound(double value, double lowerBound, double upperBound) {
    return (value % (upperBound-lowerBound)) + lowerBound;
  }
}
