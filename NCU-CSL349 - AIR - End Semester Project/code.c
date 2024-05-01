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
SoftwareSerial voiceSerial(2, 3); // RX, TX

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
  return duration / 58; // Convert duration to distance
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
  // Implementation similar to moveForward, but with direction changes for turning
}

void turnLeft() {
  // Implementation similar to moveForward, but with direction changes for turning
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
  delay(200); // Shorter delay for faster response
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
  isObstacleAvoidanceEnabled = false; // Disable obstacle avoidance when receiving any command
  switch (cmd) {
    case 'F': moveForward(); break;
    case 'B': moveBackward(); break;
    case 'L': turnLeft(); break;
    case 'R': turnRight(); break;
    case 'S': stopAllMotors(); break;
    default: isObstacleAvoidanceEnabled = true; // Enable obstacle avoidance on invalid command
  }
}
