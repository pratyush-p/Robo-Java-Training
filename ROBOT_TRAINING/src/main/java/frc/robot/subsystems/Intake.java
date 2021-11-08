package frc.robot.subsystems;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{

    public SpeedController intake;

    public Intake(SpeedController intake){
        this.intake = intake;
    }

    public void moveIntake(double speed, double secondary_speed){
       
        if (RobotContainer.getJoy().getRawButton(Constants.INTAKE_BUTTON)) {
            intake.set(speed);
        } else if (RobotContainer.getJoy().getRawButton(Constants.INTAKE2_BUTTON)) {
            intake.set(secondary_speed);
        }
    }

    public void stop(){
        intake.stopMotor();
    }
}
