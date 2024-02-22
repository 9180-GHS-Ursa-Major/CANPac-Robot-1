package frc.robot.commands.Utilities.Sensors;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

public class ResetAllEncoders extends Command {
    private final DrivetrainSubsystem drivetrainSubsystem;

    public ResetAllEncoders(DrivetrainSubsystem drivetrainSubsystem) {
        this.drivetrainSubsystem = drivetrainSubsystem;
    }

    @Override
    public void initialize() {
        System.out.println("Resetting encoder...");
    }

    @Override
    public void execute() {
        drivetrainSubsystem.resetAllEncoders();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
