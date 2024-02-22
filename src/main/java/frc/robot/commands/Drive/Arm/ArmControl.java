package frc.robot.commands.Drive.Arm;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ArmSubsystem;

public class ArmControl extends Command {
    private final ArmSubsystem armSubsystem;

    public ArmControl(ArmSubsystem armSubsystem) {
        this.armSubsystem = armSubsystem;
        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("Controlling arm...");
    }

    @Override
    public void execute() {
        double speed = RobotContainer.controller.getLeftY();
        armSubsystem.armControl(speed);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    
}
