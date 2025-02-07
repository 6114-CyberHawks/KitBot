// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.utils.LimelightHelpers;
//import constants
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.MotorIDs;

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

  public void RotateToTarget() {
    System.out.println("WORKING??????");
    int[] validIDs = {14};
    LimelightHelpers.SetFiducialIDFiltersOverride("Kitbot", validIDs);
    double KpAim = -0.1f;
    double KpDistance = -0.1f;
    double min_aim_command = 0.05f;

    // Get target coordinates from Limelight
    double tx = LimelightHelpers.getTX("Kitbot");
    double ty = LimelightHelpers.getTY("Kitbot");

    // Check if we should use the joystick input
    if (RobotContainer.m_driverController.getRawAxis(0) == 0) {
      double heading_error = -tx; // Error in heading
      double distance_error = -ty; // Error in distance
      double steering_adjust = 0.0f;
        System.out.println("hOW BOUT HERE???");
        System.out.println(tx); // code gets to here but doesnt go past the if statements
      // Calculate steering adjustment based on heading error
      if (tx > 1.0) {
        steering_adjust = KpAim * heading_error - min_aim_command;
        System.out.println("HERE");
      } else if (tx < -1.0) {
        steering_adjust = KpAim * heading_error + min_aim_command;
        System.out.println("THERE");
      }

      double distance_adjust = KpDistance * distance_error;

      // Calculate final motor speeds
      double left_command = steering_adjust + distance_adjust;  // Adjust left track
      double right_command = -steering_adjust + distance_adjust; // Adjust right track

      // Set the motor speeds using DifferentialDrive
      drive.tankDrive(left_command, right_command);
    }
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
