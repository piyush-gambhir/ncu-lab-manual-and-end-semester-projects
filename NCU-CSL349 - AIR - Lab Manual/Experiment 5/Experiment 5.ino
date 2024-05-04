// Setup the built-in LED pin as an output.
void setup()
{
    pinMode(LED_BUILTIN, OUTPUT);
}

// The loop function runs continuously.
void loop()
{
    digitalWrite(LED_BUILTIN, HIGH); // Turn on the LED
    delay(1000);                     // Wait for one second
    digitalWrite(LED_BUILTIN, LOW);  // Turn off the LED
    delay(1000);                     // Wait for another second
}
