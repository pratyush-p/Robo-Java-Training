package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase{

    public SpeedController up, down;


    public Shooter(SpeedController up, SpeedController down){
        this.up = up;
        this.down = down;
    }

    public void moveshooter(double speed){
        up.set(speed);
        down.set(speed);
    }

    public void stop(){
        up.stopMotor();
        down.stopMotor();
    }
}
