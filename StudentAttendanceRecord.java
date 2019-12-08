public class StudentAttendanceRecord {

    public boolean checkRecord(String s) {
        if (s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL")) {
            return true;
        }
        return false;
    }
}