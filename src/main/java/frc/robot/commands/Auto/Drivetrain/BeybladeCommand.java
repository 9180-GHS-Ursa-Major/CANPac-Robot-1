package frc.robot.commands.Auto.Drivetrain;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;

public class BeybladeCommand extends Command {
    private final DrivetrainSubsystem drivetrainSubsystem;

    public BeybladeCommand(DrivetrainSubsystem drivetrainSubsystem) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("Let it rip!");
    }

    @Override
    public void execute() {
        double spedRot = RobotContainer.joystick.getRawAxis(3);
        drivetrainSubsystem.arcadeDrive(0, spedRot);
    }
}
