package frc.robot.subsystems;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LimelightConstants;

public class LimelightSubsystem extends SubsystemBase {
    
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    NetworkTableEntry tid = table.getEntry("tid");

    public LimelightSubsystem() {}


    public double xValue() {
        return tx.getDouble(0);
    }

    public double yValue() {
        return ty.getDouble(0);
    }

    public double areaValue() {
        return ta.getDouble(0);
    }

    public double idValue() {
        return tid.getDouble(0);
    }

    public double distanceToGoal() {
        double angleToGoalDegrees = LimelightConstants.limelightAngleDegrees + yValue();
        double angleToGoalRadians = Units.degreesToRadians(angleToGoalDegrees);
        double distanceFromLimelightToGoalInches = (LimelightConstants.goalHeightInches - LimelightConstants.limelightLensHeightInches) / Math.tan(angleToGoalRadians);
        return distanceFromLimelightToGoalInches;
    }

    @Override
    public void periodic() {
        double x = xValue();
        double y = yValue();
        double area = areaValue();
        double id = idValue();
        
        SmartDashboard.putNumber("X", x);
        SmartDashboard.putNumber("Y", y);
        SmartDashboard.putNumber("Area", area);
        SmartDashboard.putNumber("ID", id);
    }
}
