// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;



public class DriveBase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  CANSparkMax fl = new CANSparkMax(3, MotorType.kBrushed);
  CANSparkMax fr = new CANSparkMax(2, MotorType.kBrushed);
  CANSparkMax rl = new CANSparkMax(4, MotorType.kBrushed);
  CANSparkMax rr = new CANSparkMax(1, MotorType.kBrushed);

  DifferentialDrive db;

  
  public DriveBase() {

    MotorControllerGroup rightMotors = new MotorControllerGroup(fr, rr);
    MotorControllerGroup leftMotors = new MotorControllerGroup(fl, rl);

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

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void arcadeDrive(double speed,double rotation){
    db.arcadeDrive(speed, rotation);
  }

  public void tankDrive(double lSpeed,double rSpeed){
    db.tankDrive(rSpeed,lSpeed );
  }
}
