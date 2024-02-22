// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Auto.Arm.ResetArm;
import frc.robot.commands.Auto.Arm.SetArmAngleTo45;
import frc.robot.commands.Auto.Drivetrain.BeybladeCommand;
import frc.robot.commands.Drive.Arm.ArmControl;
import frc.robot.commands.Drive.Drivetrain.DriveWithJoystickCommand;
import frc.robot.commands.Utilities.MotorControllers.BrakeCommand;
import frc.robot.commands.Utilities.MotorControllers.CoastCommand;
import frc.robot.commands.Utilities.Sensors.ResetAllEncoders;
import frc.robot.commands.Utilities.Sensors.ResetArmCoder;
import frc.robot.commands.Utilities.Sensors.ResetGyro;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DrivetrainSubsystem m_exampleSubsystem = new DrivetrainSubsystem();
  private final ArmSubsystem armSubsystem = new ArmSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  public final static CommandJoystick joystick = new CommandJoystick(OperatorConstants.kDriverControllerPort);
  public final static CommandXboxController controller = new CommandXboxController(1);

  //Commands
  private final DriveWithJoystickCommand driveWithJoystickCommand = new DriveWithJoystickCommand(m_exampleSubsystem);
  private final BrakeCommand brakeCommand = new BrakeCommand(m_exampleSubsystem);
  private final CoastCommand coastCommand = new CoastCommand(m_exampleSubsystem);
  private final ResetAllEncoders resetEncoderOne = new ResetAllEncoders(m_exampleSubsystem);
  private final BeybladeCommand beybladeCommand = new BeybladeCommand(m_exampleSubsystem);
  private final ResetGyro resetGyro = new ResetGyro(m_exampleSubsystem);

  //Arm
  private final ArmControl armControl = new ArmControl(armSubsystem);
  private final ResetArmCoder armCoder = new ResetArmCoder(armSubsystem);
  private final SetArmAngleTo45 setArmAngleTo45 = new SetArmAngleTo45(armSubsystem);
  private final ResetArm resetArm = new ResetArm(armSubsystem);

  //Trigger
  Trigger coastTrigger = new Trigger(joystick.button(8));
  Trigger brakeTrigger = new Trigger(joystick.button(7));
  Trigger encoder1ResetTrigger = new Trigger(joystick.button(11));
  Trigger beybladeTrigger = new Trigger(joystick.button(12));
  Trigger gyroResetTrigger = new Trigger(joystick.button(4));
  Trigger everythingResetTrigger = new Trigger(joystick.button(2));
  Trigger armCoderResetTrigger = new Trigger(joystick.button(6));

  //Arms
  Trigger arm45SetTrigger = new Trigger(joystick.povDown());
  Trigger armResetTrigger = new Trigger(joystick.povLeft());
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    m_exampleSubsystem.setDefaultCommand(driveWithJoystickCommand);
    armSubsystem.setDefaultCommand(armControl);
    coastTrigger.onTrue(coastCommand);
    brakeTrigger.onTrue(brakeCommand);
    encoder1ResetTrigger.onTrue(resetEncoderOne);
    beybladeTrigger.whileTrue(beybladeCommand);
    gyroResetTrigger.onTrue(resetGyro);
    everythingResetTrigger.onTrue(resetGyro.alongWith(resetEncoderOne));
    armCoderResetTrigger.onTrue(armCoder);
    arm45SetTrigger.onTrue(setArmAngleTo45);
    armResetTrigger.onTrue(resetArm);
;  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Commands.print("No command");
  }
}
