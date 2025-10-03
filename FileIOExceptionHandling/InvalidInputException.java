public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }

    public static InvalidInputException invalidRating() {
        return new InvalidInputException("Rating must be one of the following: PG, G, PG-13, NR, R");
    }

    public static InvalidInputException invalidScore() {
        return new InvalidInputException("Score must be between 0 and 10");
    }

    public static InvalidInputException invalidDuration() {
        return new InvalidInputException("Duration must be between 0 and 300");
    }

    public static InvalidInputException invalidYear() {
        return new InvalidInputException("Year must be before 2024 and must have 4 digits");
    }
}
