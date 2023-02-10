// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public class DriveBase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private WPI_TalonSRX fl = new WPI_TalonSRX(constants.db.fl);
  private WPI_TalonSRX fr = new WPI_TalonSRX(constants.db.fr);
  private WPI_TalonSRX rl = new WPI_TalonSRX(constants.db.rl);
  private WPI_TalonSRX rr = new WPI_TalonSRX(constants.db.rr);

  DifferentialDrive db;

  boolean isTankDrive = true;

  public DriveBase() {

    fl.setNeutralMode(NeutralMode.Coast);
    fr.setNeutralMode(NeutralMode.Coast);
    rl.setNeutralMode(NeutralMode.Coast);
    rr.setNeutralMode(NeutralMode.Coast);


    MotorControllerGroup rightMotors = new MotorControllerGroup(fr,rr);
    MotorControllerGroup leftMotors = new MotorControllerGroup(fl,rl);

    leftMotors.setInverted(true);
    db = new DifferentialDrive(rightMotors, leftMotors);

    addChild("leftMotors", leftMotors);
    addChild("rightMotors", rightMotors);
  }

  public void toggleDrive(){
    isTankDrive = isTankDrive ? false : true;
  }

  public void drive(double lSpeed,double rSpeed,double speed,double rotation){
    if(isTankDrive){
      tankDrive(lSpeed, rSpeed);
    }else{
      arcadeDrive(speed, rotation);
    }
  }

  public void arcadeDrive(double speed,double rotation){
    db.arcadeDrive(speed, rotation);
  }

  public void tankDrive(double lSpeed,double rSpeed){
    db.tankDrive(rSpeed,lSpeed );
  }
}
