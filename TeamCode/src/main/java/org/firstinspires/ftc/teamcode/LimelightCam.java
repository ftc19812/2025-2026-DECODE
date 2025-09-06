package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.LLStatus;
import com.qualcomm.hardware.limelightvision.Limelight3A;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.List;

/*
Courtesy of Benny Nguyen, Software Lead of 23796, class of OA28
I don't know what I'm doing, if it wasn't obvious already.

And yes, I did make all of this by myself with no help whatsoever.
You can tell by the terrible code scattered across this. Might as well be considered
a war crime to be honest.

*/
public final class LimelightCam {

    public Limelight3A hardware;
    public Telemetry telemetry;

    // Initializes the variables necessary for the lime light camera.
    public LimelightCam(Limelight3A hardware, Telemetry telemetry){
        this.hardware = hardware;
        this.telemetry = telemetry;
    }

    public void telemetryStatus(LLStatus status) {
        telemetry.addData("Name", "%s",
                status.getName());
        telemetry.addData("LL", "Temp: %.1fC, CPU: %.1f%%, FPS: %d",
                status.getTemp(), status.getCpu(),(int)status.getFps());
        telemetry.addData("Pipeline", "Index: %d, Type: %s",
                status.getPipelineIndex(), status.getPipelineType());
    }
    public void telemetryStats(LLResult result) {
        if (result.isValid()) {
            telemetry.addData("tx", result.getTx());
            telemetry.addData("txnc", result.getTxNC());
            telemetry.addData("ty", result.getTy());
            telemetry.addData("tync", result.getTyNC());
        } else {
            telemetry.addData("Stats", "not found");
        }
    }
    public void telemetryBarcode(LLResult result) {
        if (result.isValid()) {
            List<LLResultTypes.BarcodeResult> barcodeResults = result.getBarcodeResults();
            for (LLResultTypes.BarcodeResult br : barcodeResults) {
                telemetry.addData("Barcode", "Data: %s", br.getData());
            }
        } else {
            telemetry.addData("Barcodes", "not found");
        }
    }
    public void telemetryLatency(LLResult result){
        if (result.isValid()) {
            double captureLatency = result.getCaptureLatency();
            double targetingLatency = result.getTargetingLatency();
            double parseLatency = result.getParseLatency();
            telemetry.addData("LL Latency", captureLatency + targetingLatency);
            telemetry.addData("Parse Latency", parseLatency);
            telemetry.addData("PythonOutput", java.util.Arrays.toString(result.getPythonOutput()));
        } else {
            telemetry.addData("Latency", "not found");
        }
    }
    public void telemetryClassifier(LLResult result) {
        if (result.isValid()) {
            List<LLResultTypes.ClassifierResult> classifierResults = result.getClassifierResults();
            for (LLResultTypes.ClassifierResult cr : classifierResults) {
                telemetry.addData("Classifier", "Class: %s, Confidence: %.2f", cr.getClassName(), cr.getConfidence());
            }
        } else {
            telemetry.addData("Classifer", "not found");
        }
    }
    // This is what we'll be using (Fiducials are April Tags... apparently...)
    public void telemetryFiducial(LLResult result) {
        if (result.isValid()) {
            List<LLResultTypes.FiducialResult> fiducialResults = result.getFiducialResults();
            for (LLResultTypes.FiducialResult fr : fiducialResults) {
                telemetry.addData("Fiducial", "ID: %d, Family: %s, X: %.2f, Y: %.2f", fr.getFiducialId(), fr.getFamily(), fr.getTargetXDegrees(), fr.getTargetYDegrees());
            }
        } else {
            telemetry.addData("Fiducial", "not found");
        }
    }
    public void telemetryColor(LLResult result) {
        if (result.isValid()) {
            List<LLResultTypes.ColorResult> colorResults = result.getColorResults();
            for (LLResultTypes.ColorResult cr : colorResults) {
                telemetry.addData("Color", "X: %.2f, Y: %.2f", cr.getTargetXDegrees(), cr.getTargetYDegrees());
            }
        } else {
            telemetry.addData("Color", "not found");
        }
    }
    public void telemetryDetector(LLResult result) {
        if (result.isValid()){
            List<LLResultTypes.DetectorResult> detectorResults = result.getDetectorResults();
            for (LLResultTypes.DetectorResult dr : detectorResults) {
                telemetry.addData("Detector", "Class: %s, Area: %.2f", dr.getClassName(), dr.getTargetArea());
            }
        } else {
            telemetry.addData("Detector", "not found");
        }
    }
}

/*
Fly, broken wings
I know you are still with me
All I need is a nudge to get me started
Fly, broken wings
To somewhere we can be free
Closer to our ideal
Teary-eyed
Once gentle soul
I watched as you rotted away
The mirror says that I still remember hope
You're doing what you love
Isn't that enough? Isn't that enough?
A genius, perfect job
Isn't that enough? Isn't that enough?
Again and again
You locked me down, I locked me down
We staked me to the ground
The soil gave me warmth
Please die, little dreams
Kill the camellias in me
Wouldn't it be easier to give in?
Why are these hands chasing dreams out of my reach?
Is my thirst for normalcy odd?
Fly, perfect wings
Where have you been hiding?
Bring me to the mind that got us started
Fly, perfect wings
Show them who I can be
For the one last time, if you will
That's all
*/
