#include <Servo.h>
#include <AFMotor.h>
#include <SoftwareSerial.h>
#include <Arduino.h>
#include <Wire.h>

#define ECHO_PIN A0
#define TRIG_PIN A1
#define MOTOR_PIN 10
#define MOTOR_SPEED 170
#define SERVO_CENTER 103

Servo steeringServo;
AF_DCMotor motors[4] = {AF_DCMotor(1), AF_DCMotor(2), AF_DCMotor(3), AF_DCMotor(4)};
SoftwareSerial voiceSerial(2, 3);

bool isObstacleAvoidanceEnabled = true;
char command;

void setup() {
  Serial.begin(9600);
  voiceSerial.begin(9600);
  pinMode(TRIG_PIN, OUTPUT);
  pinMode(ECHO_PIN, INPUT);
  steeringServo.attach(MOTOR_PIN);
  for (auto& motor : motors) {
    motor.setSpeed(MOTOR_SPEED);
  }
}

void loop() {
  handleObstacle();
  handleBluetoothCommands();
  handleVoiceCommands();
}

void handleObstacle() {
  if (isObstacleAvoidanceEnabled) {
    int distance = measureDistance();
    if (distance <= 12) {
      performObstacleAvoidance();
    } else {
      moveForward();
    }
  }
}

int measureDistance() {
  digitalWrite(TRIG_PIN, LOW);
  delayMicroseconds(2);
  digitalWrite(TRIG_PIN, HIGH);
  delayMicroseconds(10);
  digitalWrite(TRIG_PIN, LOW);
  long duration = pulseIn(ECHO_PIN, HIGH);
  return duration / 58;
}

void moveForward() {
  for (auto& motor : motors) {
    motor.run(FORWARD);
  }
}

void moveBackward() {
  for (auto& motor : motors) {
    motor.run(BACKWARD);
  }
}

void turnRight() {

}

void turnLeft() {

}

void stopAllMotors() {
  for (auto& motor : motors) {
    motor.run(RELEASE);
  }
}

void performObstacleAvoidance() {
  stopAllMotors();
  moveBackward();
  delay(500);
  stopAllMotors();
  int leftDistance = measureDistanceAtAngle(180);
  int rightDistance = measureDistanceAtAngle(0);
  if (leftDistance > rightDistance) {
    turnLeft();
  } else {
    turnRight();
  }
  delay(500);
  stopAllMotors();
}

int measureDistanceAtAngle(int angle) {
  steeringServo.write(angle);
  delay(200);
  return measureDistance();
}

void handleBluetoothCommands() {
  if (Serial.available()) {
    command = Serial.read();
    executeCommand(command);
  }
}

void handleVoiceCommands() {
  if (voiceSerial.available()) {
    command = voiceSerial.read();
    executeCommand(command);
  }
}

void executeCommand(char cmd) {
  isObstacleAvoidanceEnabled = false;
  switch (cmd) {
    case 'F': moveForward(); break;
    case 'B': moveBackward(); break;
    case 'L': turnLeft(); break;
    case 'R': turnRight(); break;
    case 'S': stopAllMotors(); break;
    default: isObstacleAvoidanceEnabled = true;
  }
}
