package frc.robot.commands.Auto.Arm;



import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSubsystem;

public class SetArmAngleTo45 extends Command {
    private final ArmSubsystem armSubsystem;
    Timer timer = new Timer();

    public SetArmAngleTo45(ArmSubsystem armSubsystem) {
        this.armSubsystem = armSubsystem;
        addRequirements(armSubsystem);
        timer.reset();
    }

    @Override
    public void initialize() {
        System.out.println("Setting arm angle to 45 degrees");
    }

    @Override
    public void execute() {
        armSubsystem.armPosSet(Math.PI / 4);
    }

    @Override
    public boolean isFinished() {
        return armSubsystem.armAngle() >= (Math.PI / 4);
    }
}
