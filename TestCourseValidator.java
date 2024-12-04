public class TestCourseValidator {
    public static void main(String[] args) {
        String[] testCases = {
            "beginner",
            "intermediate",
            "advanced",
            "CS-200",
            "CS-899",
            "CS-900",
            "expert",  // Invalid
            "CS-199",  // Invalid
            "CS-901",  // Invalid
            "CS-xyz"   // Invalid
        };

        for (String testCase : testCases) {
            try {
                CourseValidator.validateCourseCode(testCase);
                System.out.println("Valid: " + testCase);
            } catch (InvalidCourseCodeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
