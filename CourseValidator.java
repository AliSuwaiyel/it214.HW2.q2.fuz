class InvalidCourseCodeException extends Exception {
    public InvalidCourseCodeException(String message) {
        super(message);
    }
}

public class CourseValidator {

    public static void validateCourseCode(String courseCode) throws InvalidCourseCodeException {
        // Check for "beginner", "intermediate", or "advanced"
        if (courseCode.equals("beginner") || courseCode.equals("intermediate") || courseCode.equals("advanced")) {
            return;
        }

        // Check for "CS-XXX" where XXX is between 200 and 900
        if (courseCode.startsWith("CS-")) {
            String numberPart = courseCode.substring(3); // Get the part after "CS-"
            try {
                int number = Integer.parseInt(numberPart); // Convert to an integer
                if (number >= 200 && number <= 900) {
                    return; // Valid course code
                }
            } catch (NumberFormatException e) {
                // Not a valid number, let it fall through to the exception
            }
        }

        // If no condition is met, throw an exception
        throw new InvalidCourseCodeException("Invalid course code: " + courseCode);
    }
}
