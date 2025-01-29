// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import Constants
import frc.robot.Constants.OperatorConstants;
import frc.robot.MotorIDs;

public class DriveTrain extends SubsystemBase {
  
  public static Spark LeftMotorFront;
  public static Spark LeftMotorRear;
  public static Spark RightMotorFront;
  public static Spark RightMotorRear;

  DifferentialDrive drive;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
  LeftMotorFront = new Spark(MotorIDs.LeftMotorFront);
  LeftMotorFront.setInverted(false);
  LeftMotorRear = new Spark(MotorIDs.LeftMotorRear);
  LeftMotorRear.setInverted(false);
  LeftMotorRear.addFollower(LeftMotorFront);
  
  
  RightMotorFront = new Spark(MotorIDs.RigthMotorFront);
  RightMotorFront.setInverted(false);
  RightMotorRear = new Spark(MotorIDs.RigthMotorRear);
  RightMotorRear.setInverted(false);
  RightMotorRear.addFollower(RightMotorFront);


  drive = new DifferentialDrive(LeftMotorRear, RightMotorRear);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveWithJoysticks(XboxController controller, double speed) {
    drive.arcadeDrive(controller.getRawAxis(OperatorConstants.XboxLeft_Y_Axis)*speed, controller.getRawAxis(OperatorConstants.XboxLeft_X_Axis)*speed);
  }
  public void driveForward(double speed){
    drive.tankDrive(speed, speed);
  }
  public void stop() {
    drive.stopMotor();
  }
}
