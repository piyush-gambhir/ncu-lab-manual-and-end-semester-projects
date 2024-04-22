#include <SoftwareSerial.h>

// Define pins for SoftwareSerial
const int RX_PIN = 0; // Set RX to pin 0
const int TX_PIN = 1; // Set TX to pin 1

// Initialize SoftwareSerial instance
SoftwareSerial BTSerial(RX_PIN, TX_PIN);

void setup()
{
    // Start communication with the computer
    Serial.begin(9600);
    // Start communication with the Bluetooth module
    BTSerial.begin(9600);

    // Print a startup message to the serial monitor
    Serial.println("Bluetooth Serial Communication Started");
}

void loop()
{
    // Check if there is data waiting in the serial monitor
    if (Serial.available())
    {
        char data = Serial.read(); // Read the incoming byte
        BTSerial.write(data);      // Send that byte via Bluetooth
        Serial.print("Sent: ");    // Optional: Echo that byte back to the serial monitor
        Serial.println(data);
    }

    // Check if there is data received from the Bluetooth module
    if (BTSerial.available())
    {
        char data = BTSerial.read(); // Read the incoming byte from Bluetooth
        Serial.write(data);          // Send that byte to the serial monitor
        Serial.print("Received: ");  // Optional: Indicate that a byte was received
        Serial.println(data);
    }
}
