// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class DriveBase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  VictorSPX fl = new VictorSPX(3);
  VictorSPX fr = new VictorSPX(2);
  VictorSPX rl = new VictorSPX(4);
  VictorSPX rr = new VictorSPX(1);

  DifferentialDrive db;

  public DriveBase() {
    MotorControllerGroup rightMotors = new MotorControllerGroup((MotorController)fr,(MotorController)rr);
    MotorControllerGroup leftMotors = new MotorControllerGroup((MotorController)fl, (MotorController)rl);

    leftMotors.setInverted(true);
    db = new DifferentialDrive(rightMotors, leftMotors);
  }

  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> 
          System.out.println("hello world. I am Jessica.")
        );
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
