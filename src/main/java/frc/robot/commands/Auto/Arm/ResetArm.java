package frc.robot.commands.Auto.Arm;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class ResetArm extends Command {
    private final ArmSubsystem armSubsystem;
    double angle = 1.60570291;

    public ResetArm(ArmSubsystem m_armSubsystem) {
        this.armSubsystem = m_armSubsystem;
        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("Restting arm...");
    }

    @Override
    public void execute() {
        armSubsystem.armSet(angle);
    }

    @Override
    public boolean isFinished() {
        return angle == armSubsystem.armAngle();
    }
}
