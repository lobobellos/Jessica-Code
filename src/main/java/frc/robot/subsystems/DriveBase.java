// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveBase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  WPI_TalonSRX fl = new WPI_TalonSRX(constants.db.fl);
  WPI_TalonSRX fr = new WPI_TalonSRX(constants.db.fr);
  WPI_TalonSRX rl = new WPI_TalonSRX(constants.db.rl);
  WPI_TalonSRX rr = new WPI_TalonSRX(constants.db.rr);

  DifferentialDrive db;

  public DriveBase() {
    MotorControllerGroup rightMotors = new MotorControllerGroup(fr,rr);
    MotorControllerGroup leftMotors = new MotorControllerGroup(fl,rl);

    leftMotors.setInverted(true);
    db = new DifferentialDrive(rightMotors, leftMotors);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDrive(double speed,double rotation){
    db.arcadeDrive(speed, rotation);
  }

  public void tankDrive(double lSpeed,double rSpeed){
    db.tankDrive(rSpeed,lSpeed );
  }
}
