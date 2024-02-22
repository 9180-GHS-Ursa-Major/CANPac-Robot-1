package frc.robot.commands.Utilities.Sensors;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

public class ResetGyro extends Command {
    private final DrivetrainSubsystem drivetrainSubsystem;

    public ResetGyro(DrivetrainSubsystem drivetrainSubsystem) {
        this.drivetrainSubsystem = drivetrainSubsystem;
    }

    @Override
    public void initialize() {
        System.out.println("Resetting gyro...");
    }

    @Override
    public void execute() {
        drivetrainSubsystem.resetGyro();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
