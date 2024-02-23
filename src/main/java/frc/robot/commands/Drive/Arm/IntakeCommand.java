package frc.robot.commands.Drive.Arm;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeOuttakeSubsystem;

public class IntakeCommand extends Command {
    private final IntakeOuttakeSubsystem intakeOuttakeSubsystem;
    Timer timer = new Timer();
    
    public IntakeCommand(IntakeOuttakeSubsystem intakeOuttakeSubsystem) {
        this.intakeOuttakeSubsystem = intakeOuttakeSubsystem;
        addRequirements(intakeOuttakeSubsystem);
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
        System.out.println("Starting intake...");
    }

    @Override
    public void execute() {
        double speed = 0.5;
        
        if (timer.get() < 2) {
            intakeOuttakeSubsystem.setMotorSpeed(speed);
    }
}

    @Override
    public void end(boolean interrupted) {
        intakeOuttakeSubsystem.stopIntakeMotor();
        timer.stop();
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= 2;
}
}
