package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeOuttakeSubsystem extends SubsystemBase {
    private final VictorSP intakeVictorSP = new VictorSP(IntakeConstants.intakeMotorPort);
    private final VictorSP secondVictorSP = new VictorSP(IntakeConstants.intakeMotorPort2);
    
    public IntakeOuttakeSubsystem() {
        intakeVictorSP.setInverted(false);
        secondVictorSP.setInverted(false);
    }

    public void setMotorSpeed(double speed) {
        intakeVictorSP.set(-speed);
        secondVictorSP.set(speed);
    }

    public void stopIntakeMotor() {
        intakeVictorSP.stopMotor();
        secondVictorSP.stopMotor();
    }


}
