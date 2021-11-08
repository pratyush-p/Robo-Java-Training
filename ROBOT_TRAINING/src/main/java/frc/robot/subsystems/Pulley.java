package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pulley extends SubsystemBase{

    public SpeedController pulley;

    public Pulley(SpeedController pulley){
        this.pulley = pulley;
    }

    public void movePulley(double speed){
        pulley.set(speed);
    }

    public void stop(){
        pulley.stopMotor();
    }
}
