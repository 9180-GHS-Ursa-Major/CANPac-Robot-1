package frc.robot.commands.Auto.Arm;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class SetArmAngleTo45 extends Command {
    private final ArmSubsystem armSubsystem;

    public SetArmAngleTo45(ArmSubsystem m_armSubsystem) {
        this.armSubsystem = m_armSubsystem;
        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("Setting arm angle to 45 degrees");
    }

    @Override
    public void execute() {
        armSubsystem.armSet(Math.PI / 3);
    }

    @Override
    public boolean isFinished() {
        return armSubsystem.armAngle() >= (Math.PI / 3);
    }
}
