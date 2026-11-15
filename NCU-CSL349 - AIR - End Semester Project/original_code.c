#include <Servo.h>
#include <AFMotor.h>
#include <SoftwareSerial.h>
#include <Arduino.h>
#include <Wire.h>

#define Echo A0
#define Trig A1
#define motor 10
#define Speed 170
#define spoint 103

char value;
int distance;
int Left;
int Right;
int L = 0;
int R = 0;
bool bypassObstacleAvoidance = false;
Servo servo;
AF_DCMotor M1(1);
AF_DCMotor M2(2);
AF_DCMotor M3(3);
AF_DCMotor M4(4);
SoftwareSerial voiceSerial(2, 3);

void setup() {
  Serial.begin(9600);
  voiceSerial.begin(9600);
  pinMode(Trig, OUTPUT);
  pinMode(Echo, INPUT);
  servo.attach(motor);
  M1.setSpeed(Speed);
  M2.setSpeed(Speed);
  M3.setSpeed(Speed);
  M4.setSpeed(Speed);
}

void loop() {
  Obstacle();
  Bluetoothcontrol();
  Voicecontrol();
}

void Obstacle() {
  if (!bypassObstacleAvoidance) {
    distance = ultrasonic();
    if (distance <= 12) {
      Stop();
      backward();
      delay(500);
      Stop();
      L = leftsee();
      servo.write(spoint);
      R = rightsee();
      servo.write(spoint);
      if (L < R) {
        right();
        delay(500);
        Stop();
      } else if (L > R) {
        left();
        delay(500);
        Stop();
      }
    } else {
      forward();
    }
  } else {

  }
}

int ultrasonic() {
  digitalWrite(Trig, LOW);
  delayMicroseconds(3);
  digitalWrite(Trig, HIGH);
  delayMicroseconds(5);
  digitalWrite(Trig, LOW);
  long t = pulseIn(Echo, HIGH);
  long cm = t / 29 / 2;
  return cm;
}

void forward() {
  M1.run(FORWARD);
  M2.run(FORWARD);
  M3.run(FORWARD);
  M4.run(FORWARD);
}

void backward() {
  M1.run(BACKWARD);
  M2.run(BACKWARD);
  M3.run(BACKWARD);
  M4.run(BACKWARD);
}

void right() {
  M1.run(BACKWARD);
  M2.run(BACKWARD);
  M3.run(FORWARD);
  M4.run(FORWARD);
}

void left() {
  M1.run(FORWARD);
  M2.run(FORWARD);
  M3.run(BACKWARD);
  M4.run(BACKWARD);
}

void Stop() {
  M1.run(RELEASE);
  M2.run(RELEASE);
  M3.run(RELEASE);
  M4.run(RELEASE);
}

int rightsee() {
  servo.write(60);
  delay(1000);
  Left = ultrasonic();
  return Left;
}

int leftsee() {
  servo.write(180);
  delay(1000);
  Right = ultrasonic();
  return Right;
}

void Bluetoothcontrol() {
  if (Serial.available() > 0) {
    value = Serial.read();
    Serial.println(value);
    if (value == 'U') {
      forward();
      bypassObstacleAvoidance = true;
    } else if (value == 'D') {
      backward();
      bypassObstacleAvoidance = true;
    } else if (value == 'L') {
      left();
      bypassObstacleAvoidance = true;
    } else if (value == 'R') {
      right();
      bypassObstacleAvoidance = true;
    } else if (value == 'S') {
      Stop();
      bypassObstacleAvoidance = true;
    } else {
      bypassObstacleAvoidance = false;
    }
  }
}

void Voicecontrol() {
  if (voiceSerial.available() > 0) {
    value = voiceSerial.read();
    Serial.println(value);
    if (value == 'F') {
      forward();
      bypassObstacleAvoidance = true;
    } else if (value == 'B') {
      backward();
      bypassObstacleAvoidance = true;
    } else if (value == 'L') {
      left();
      bypassObstacleAvoidance = true;
    } else if (value == 'R') {
      right();
      bypassObstacleAvoidance = true;
    } else if (value == 'S') {
      Stop();
      bypassObstacleAvoidance = true;
    } else {
      bypassObstacleAvoidance = false;
    }
  }
}
