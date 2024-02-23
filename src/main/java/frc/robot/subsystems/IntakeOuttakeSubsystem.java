package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeOuttakeSubsystem extends SubsystemBase {
    private final VictorSP intakeVictorSP = new VictorSP(9);
    
    public IntakeOuttakeSubsystem() {
        
    }

    public void setMotorSpeed(double speed) {
        intakeVictorSP.set(speed);
    }

    public void stopIntakeMotor() {
        intakeVictorSP.stopMotor();
    }


}
