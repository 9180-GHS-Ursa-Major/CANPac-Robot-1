package frc.robot.commands.Utilities.Sensors;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class ResetArmCoder extends Command {
    private final ArmSubsystem armSubsystem;

    public ResetArmCoder(ArmSubsystem armSubsystem) {
        this.armSubsystem = armSubsystem;
    }

    @Override
    public void initialize() {
        System.out.println("Zeroing...");
    }

    @Override
    public void execute() {
        armSubsystem.resetArmCoder();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
