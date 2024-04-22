// Define pin numbers for each LED
const int RED_LED_PIN = 9;
const int YELLOW_LED_PIN = 10;
const int GREEN_LED_PIN = 11;

// Define the duration of each light (in milliseconds)
const int GREEN_LIGHT_DURATION = 5000;  // Green light for 5 seconds
const int YELLOW_LIGHT_DURATION = 2000; // Yellow light for 2 seconds
const int RED_LIGHT_DURATION = 5000;    // Red light for 5 seconds

void setup()
{
    // Set LED pins as outputs
    pinMode(RED_LED_PIN, OUTPUT);
    pinMode(YELLOW_LED_PIN, OUTPUT);
    pinMode(GREEN_LED_PIN, OUTPUT);
}

void loop()
{
    // Sequence starts with green light
    digitalWrite(GREEN_LED_PIN, HIGH);
    delay(GREEN_LIGHT_DURATION);
    digitalWrite(GREEN_LED_PIN, LOW);

    // Then yellow light
    digitalWrite(YELLOW_LED_PIN, HIGH);
    delay(YELLOW_LIGHT_DURATION);
    digitalWrite(YELLOW_LED_PIN, LOW);

    // Followed by red light
    digitalWrite(RED_LED_PIN, HIGH);
    delay(RED_LIGHT_DURATION);

    // Yellow comes on briefly before green to signal readiness
    digitalWrite(RED_LED_PIN, LOW);
    digitalWrite(YELLOW_LED_PIN, HIGH);
    delay(1000); // 1 second
    digitalWrite(YELLOW_LED_PIN, LOW);

    // All lights off before starting the next cycle
}
