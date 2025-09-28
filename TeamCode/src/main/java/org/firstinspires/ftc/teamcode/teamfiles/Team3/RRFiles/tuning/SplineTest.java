package org.firstinspires.ftc.teamcode.teamfiles.Team3.RRFiles.tuning;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.teamfiles.Team3.RRFiles.drivelocalizers.Team3MecanumDrive;
import org.firstinspires.ftc.teamcode.teamfiles.Team3.RRFiles.drivelocalizers.TankDrive;

public final class SplineTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d beginPose = new Pose2d(0, 0, 0);
        if (TuningOpModes.DRIVE_CLASS.equals(Team3MecanumDrive.class)) {
            Team3MecanumDrive drive = new Team3MecanumDrive(hardwareMap, beginPose);

            waitForStart();

            Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .splineTo(new Vector2d(30, 30), Math.PI / 2)
                        .splineTo(new Vector2d(0, 60), Math.PI)
                        .build());
        } else if (TuningOpModes.DRIVE_CLASS.equals(TankDrive.class)) {
            TankDrive drive = new TankDrive(hardwareMap, beginPose);

            waitForStart();

            Actions.runBlocking(
                    drive.actionBuilder(beginPose)
                            .splineTo(new Vector2d(30, 30), Math.PI / 2)
                            .splineTo(new Vector2d(0, 60), Math.PI)
                            .build());
        } else {
            throw new RuntimeException();
        }
    }
}
