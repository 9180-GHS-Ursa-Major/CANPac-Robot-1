package frc.robot.commands.Auto.Arm;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class Arm45FF extends Command {
    private final ArmSubsystem armSubsystem;

    public Arm45FF(ArmSubsystem armSubsystem) {
        this.armSubsystem = armSubsystem;
        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("Setting arm to 45 through feedforward...");
    }

    @Override
    public void execute() {
        armSubsystem.arm45();
    }

    @Override
    public void end(boolean interrupted) {
        armSubsystem.stop();
    }
}