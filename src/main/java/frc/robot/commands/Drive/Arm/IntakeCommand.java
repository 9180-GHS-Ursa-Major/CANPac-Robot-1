package frc.robot.commands.Drive.Arm;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.IntakeConstants;
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

        
        if (timer.get() < IntakeConstants.intakeTime) {
            intakeOuttakeSubsystem.setMotorSpeed(IntakeConstants.intakeSpeed);
    }
}

    @Override
    public void end(boolean interrupted) {
        intakeOuttakeSubsystem.stopIntakeMotor();
        timer.stop();
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= IntakeConstants.intakeTime;
}
}
