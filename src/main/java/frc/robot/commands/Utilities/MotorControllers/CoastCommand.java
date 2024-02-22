package frc.robot.commands.Utilities.MotorControllers;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

public class CoastCommand extends Command {
    private final DrivetrainSubsystem drivetrainSubsystem;

    public CoastCommand(DrivetrainSubsystem drivetrainSubsystem) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void execute() {
        drivetrainSubsystem.setToCoast();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
