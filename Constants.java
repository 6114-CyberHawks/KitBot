// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static int kDriverControllerPort = 0;
    public static final int XboxLeft_Y_Axis = 0;
    public static final int XboxLeft_X_Axis = 5;
  }

  public static class MotorIDs {
    //Motor Spark Identities
    public static final int LeftMotorFront = 3;
    public static final int LeftMotorRear = 4;
    public static final int RigthMotorFront = 1;
    public static final int RigthMotorRear = 2;
  }

  public static class RobotConstants {
    public static final double DriveTrainSpeed = 0.6;
    public static final double DriveForwardTime = 0;
    public static final double AutoSpeed = .7;
  } 

}
