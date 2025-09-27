package org.firstinspires.ftc.teamcode.testfiles;

import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.roadrunnerstuff.MecanumDrive;
import org.firstinspires.ftc.teamcode.roadrunnerstuff.RRIntakeSample;

@Autonomous(name = "Roadrunner Test", group = "Test")
public class RoadrunnerSample extends LinearOpMode {
    Pose2d initialPos = new Pose2d(0,0,Math.toRadians(90));
    MecanumDrive drive = new MecanumDrive(hardwareMap, initialPos);
    RRIntakeSample intake = new RRIntakeSample(hardwareMap);





    @Override
    public void runOpMode() {
        // this is where the init goes
        TrajectoryActionBuilder traj1 = drive.actionBuilder(initialPos)
                .strafeToConstantHeading(new Vector2d(48,48));
        TrajectoryActionBuilder traj2 = drive.actionBuilder(initialPos)
                .lineToX(24)
                .waitSeconds(1)
                .lineToY(24)
                .waitSeconds(1)
                .lineToX(-24)
                .waitSeconds(1)
                .lineToY(-24);
        TrajectoryActionBuilder traj3 = drive.actionBuilder(initialPos)
                .strafeToConstantHeading(new Vector2d(-48,-48))
                .waitSeconds(1);

        boolean looped = false;
        while (opModeIsActive() && !looped) {
            looped = true;
            Actions.runBlocking(
                    new SequentialAction(
                            traj2.build(),
                            intake.setPowerRR(1.0),
                            traj1.build(),
                            traj3.build()
                    )
            );
        }
    }
}
