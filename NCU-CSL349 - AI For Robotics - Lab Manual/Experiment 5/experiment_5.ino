int led = 13;  // Change this if your LED is connected to a different pin

void setup() {
  pinMode(led, OUTPUT);
}

void loop() {
  digitalWrite(led, HIGH);  // Turn the LED on
  delay(1000);              // Wait for 1 second (1000 milliseconds)
  digitalWrite(led, LOW);   // Turn the LED off
  delay(1000);              // Wait for 1 second
}
