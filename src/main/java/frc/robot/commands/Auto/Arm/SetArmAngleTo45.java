package frc.robot.commands.Auto.Arm;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class SetArmAngleTo45 extends Command {
    private final ArmSubsystem armSubsystem;

    public SetArmAngleTo45(ArmSubsystem armSubsystem) {
        this.armSubsystem = armSubsystem;
        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("Setting arm angle to 45 degrees");
    }

    @Override
    public void execute() {
        armSubsystem.arm45();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
