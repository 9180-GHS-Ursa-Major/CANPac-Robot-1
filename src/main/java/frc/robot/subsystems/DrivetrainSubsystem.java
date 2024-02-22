// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.EncoderConstants;

public class DrivetrainSubsystem extends SubsystemBase {

  CANSparkMax frontLeftMotor = new CANSparkMax(DriveConstants.kFLPort, MotorType.kBrushed);
  CANSparkMax backRightMotor = new CANSparkMax(DriveConstants.kBRPort, MotorType.kBrushed);
  CANSparkMax backLeftMotor = new CANSparkMax(DriveConstants.kBLPort, MotorType.kBrushed);
  CANSparkMax frontRightMotor = new CANSparkMax(DriveConstants.kFRPort, MotorType.kBrushed);

  DifferentialDrive drive = new DifferentialDrive(frontLeftMotor, frontRightMotor);

  Encoder encoder = new Encoder(EncoderConstants.kEncoderPort1, EncoderConstants.kEncoderPort2);

  Encoder enc2eb = new Encoder(EncoderConstants.kEncoder2Port1, EncoderConstants.kEncoder2Port2);

  ADXRS450_Gyro gyro = new ADXRS450_Gyro();

  Rotation2d gyroAngle = gyro.getRotation2d();

  DifferentialDriveOdometry odometry = new DifferentialDriveOdometry(gyro.getRotation2d(), encoder.getDistance() * -0.0254, enc2eb.getDistance() * -0.0254);

  private final Field2d field = new Field2d();

  DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(0.525);

  /** Creates a new ExampleSubsystem. */
  public DrivetrainSubsystem() {
    backLeftMotor.follow(frontLeftMotor);
    backRightMotor.follow(frontRightMotor);

    backLeftMotor.setInverted(true);
    frontLeftMotor.setInverted(true);

    encoder.setDistancePerPulse(EncoderConstants.distancePerPurlse);
    enc2eb.setDistancePerPulse(-EncoderConstants.distancePerPurlse);

    SmartDashboard.putData("Field", field);
  }

  public void arcadeDrive(double speed, double rot) {
    drive.arcadeDrive(speed, -rot);
  }

  public void setToCoast() {
    backLeftMotor.setIdleMode(IdleMode.kCoast);
    backRightMotor.setIdleMode(IdleMode.kCoast);
    frontLeftMotor.setIdleMode(IdleMode.kCoast);
    frontRightMotor.setIdleMode(IdleMode.kCoast);
  }

  public void setToBrake() {
    backLeftMotor.setIdleMode(IdleMode.kBrake);
    backRightMotor.setIdleMode(IdleMode.kBrake);
    frontLeftMotor.setIdleMode(IdleMode.kBrake);
    frontRightMotor.setIdleMode(IdleMode.kBrake);
  }

  public double distanceTravelled() {
    return encoder.getDistance();
  }

  public double enc2ebDistance() {
    return enc2eb.getDistance();
  }

  public double velocity() {
    return encoder.getRate();
  }

  public void resetEncoder1() {
    encoder.reset();
  }

  public void resetEncoder2() {
    enc2eb.reset();
  }

  public void resetAllEncoders() {
    encoder.reset();
    enc2eb.reset();
  }

  public Rotation2d rotation() {
    return gyro.getRotation2d();
  }

  public double rotation2() {
    return gyro.getAngle();
  }

  public void resetGyro() {
    gyro.reset();
  }

  public void calibrateGyro() {
    gyro.calibrate();
  }
  

  @Override
  public void periodic() {
    double distance = distanceTravelled();
    double speed = Math.abs(velocity());
    double rotation = rotation2();
    double enc2ebDistance = enc2ebDistance();
    
    SmartDashboard.putNumber("Enc2 DIstance", enc2ebDistance);
    SmartDashboard.putNumber("Distance", distance);
    SmartDashboard.putNumber("Speed", speed);
    SmartDashboard.putNumber("Rotation", rotation);

    Pose2d robotPose = odometry.update(rotation(), enc2eb.getDistance() * 0.254, encoder.getDistance() * 0.254);

    field.setRobotPose(robotPose);

  }



} //sssssssouppppppp
