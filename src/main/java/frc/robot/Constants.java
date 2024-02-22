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
    public static final int kDriverControllerPort = 0;
  }

  public static class DriveConstants {
    public static final int kFLPort = 1;
    public static final int kFRPort = 2;
    public static final int kBLPort = 3;
    public static final int kBRPort = 4;
  }

  public static class EncoderConstants {
    public static final int kEncoderPort1 = 0;
    public static final int kEncoderPort2 = 1;
    public static final int kEncoder2Port1 = 4;
    public static final int kEncoder2Port2 = 5;

    public static final double wheelDiameterInches = 6;
    public static final double encoderResolution = 2048.0;
    public static final double wheelCircumference = Math.PI * wheelDiameterInches;
    public static final double distancePerPurlse = wheelCircumference / encoderResolution;
  }

  public static class LimelightConstants {
    public static final double limelightAngleDegrees = 40.5;
    public static final double limelightLensHeightInches = 10.6875;
    public static final double goalHeightInches = 51.875;
  }

  public static class ArmConstants {
    public static final int kArmPort1 = 5;
    public static final int kArmPort2 = 8;
    public static final int kEncoderPort = 8;

    
    public static final double encoderResolution = 2048.0;
    public static final double armDPR = -2 * Math.PI;
  }

  public static class ArmPIDConstants {
    public static double kS = 0;
    public static double kG = 0;
    public static double kV = 0;
    public static double kA = 0;

  }
}
