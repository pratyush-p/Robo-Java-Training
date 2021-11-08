// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.commands.MoveElevator;
//import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveIntake;
import frc.robot.commands.MovePulley;
import frc.robot.commands.MoveTransport;
import frc.robot.commands.ShootAuto;
import frc.robot.commands.MoveShooter;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
//import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pulley;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Transport;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static SpeedController leftTop, leftBottom, rightTop, rightBottom;
  public static SpeedControllerGroup left, right;

  public static DifferentialDrive drive;

  public static SpeedController intake_motor;
  public static SpeedController transport_motor;
  public static SpeedController pulley_motor;
  public static SpeedController shooter_up;
  public static SpeedController shooter_down;
  public static SpeedController elevator_right;
  public static SpeedController elevator_left;

  private static DigitalInput limitSwitch;
  private static Encoder elevatorLeftEnc, elevatorRightEnc;

  public static DriveTrain driveTrain;
  public static Intake intake;
  public static Transport transport;
  public static Pulley pulley;
  public static Shooter shooter;
  public static Elevator elevator;

  public static Joystick joy;

  //private static Encoder elevatorLeftEnc, elevatorRightEnc;


  public static Button intakeButton;
  public static Button transportButton;
  public static Button pulleyButton;
  public static Button shooterButton;
  public static Button intake2Button;
  public static Button elevatorButtonUp;
  public static Button elevatorButtonDown;
  public static Button shootautoButton;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    leftTop = new WPI_VictorSPX(Constants.LEFT_TOP_MOTOR);
    leftBottom = new WPI_VictorSPX(Constants.LEFT_BOTTOM_MOTOR);
    rightTop = new WPI_VictorSPX(Constants.RIGHT_TOP_MOTOR);
    rightBottom = new WPI_VictorSPX(Constants.RIGHT_BOTTOM_MOTOR);

    shooter_up = new WPI_VictorSPX(Constants.SHOOTER_MOTOR_TOP);
    shooter_down = new WPI_VictorSPX(Constants.SHOOTER_MOTOR_BOTTOM);
    shooter = new Shooter(shooter_up, shooter_down);

    elevator_right = new WPI_VictorSPX(Constants.ELEVATOR_MOTOR_RIGHT);
    elevator_left = new WPI_VictorSPX(Constants.ELEVATOR_MOTOR_LEFT);
    elevatorLeftEnc = new Encoder(Constants.ELEVATOR_LEFT_PORT_1, Constants.ELEVATOR_LEFT_PORT_2);
    elevatorRightEnc = new Encoder(Constants.ELEVATOR_RIGHT_PORT_1, Constants.ELEVATOR_RIGHT_PORT_2);
    elevator = new Elevator(elevator_left, elevator_right, limitSwitch, elevatorLeftEnc, elevatorRightEnc);
    limitSwitch = new DigitalInput(Constants.ELEVATOR_LIMIT);

    left = new SpeedControllerGroup(leftTop, leftBottom);
    right = new SpeedControllerGroup(rightTop, rightBottom);

    drive = new DifferentialDrive(left, right);

    driveTrain = new DriveTrain(left, right, drive);
    driveTrain.setDefaultCommand(new DriveWithJoystick());

    intake_motor = new WPI_VictorSPX(Constants.INTAKE_MOTOR);
    intake = new Intake(intake_motor);

    transport_motor = new WPI_VictorSPX(Constants.TRANSPORT_MOTOR);
    transport = new Transport(transport_motor);

    pulley_motor = new WPI_VictorSPX(Constants.PULLEY_MOTOR);
    pulley = new Pulley(pulley_motor);


    joy = new Joystick(0);




    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    intakeButton = new JoystickButton(joy, Constants.INTAKE_BUTTON);
    intake2Button = new JoystickButton(joy, Constants.INTAKE2_BUTTON);
    transportButton = new JoystickButton(joy, Constants.TRANSPORT_BUTTON);
    pulleyButton = new JoystickButton(joy, Constants.PULLEY_BUTTON);
    shooterButton = new JoystickButton(joy, Constants.SHOOTER_BUTTON);
    elevatorButtonUp = new JoystickButton(joy, Constants.ELEVATOR_BUTTON_UP);
    elevatorButtonDown = new JoystickButton(joy, Constants.ELEVATOR_BUTTON_DOWN);
    shootautoButton = new JoystickButton(joy, Constants.SHOOT_AUTO_BUTTON);
    intakeButton.whileHeld(new MoveIntake());
    intake2Button.whileHeld(new MoveIntake());
    transportButton.whileHeld(new MoveTransport());
    pulleyButton.whileHeld(new MovePulley());
    shooterButton.whileHeld(new MoveShooter());
    elevatorButtonUp.whileHeld(new MoveElevator(Constants.ELEVATOR_SPEED));
    elevatorButtonDown.whileHeld(new MoveElevator(-Constants.ELEVATOR_SPEED));
    shootautoButton.whileHeld(new ShootAuto());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }

  public static DriveTrain getDriveTrain(){return driveTrain;}
  public static Intake getIntake(){return intake;}
  public static Transport getTransport(){return transport;}
  public static Pulley getPulley(){return pulley;}
  public static Shooter getShooter(){return shooter;}
  public static Elevator getElevator() {return elevator;}
  public static Joystick getJoy(){return joy;}

}
