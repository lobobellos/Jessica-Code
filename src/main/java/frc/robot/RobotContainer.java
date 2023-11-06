// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;


public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveBase driveBase = new DriveBase();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController xboxController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    driveBase.setDefaultCommand(
      new RunCommand(
        ()->driveBase.drive(
          xboxController.getLeftY(),xboxController.getRightY(),
          xboxController.getLeftY(),-xboxController.getRightX()
        ),
        driveBase
        )
    );

    // Configure the trigger bindings
    configureBindings();
  }


  private void configureBindings() {

    xboxController.a().onTrue(
      new InstantCommand(
        ()->driveBase.toggleDrive(),
        driveBase
      )
    );


  }

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return new SequentialCommandGroup(
      new InstantCommand(()->driveBase.tankDrive(0.5, 0)),
      new WaitCommand(1),
      new InstantCommand(()->driveBase.tankDrive(0, 0))
    );
  }
}
