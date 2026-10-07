class LibraryMember {
    private String memberId;
    private int borrowLimit;
    private int booksBorrowed;

    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().isEmpty()
                || memberId.length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        booksBorrowed = 0;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public void displayInfo() {
        System.out.print(
            "General | Books: " + booksBorrowed
        );
    }
}

class StudentMember extends LibraryMember {

    private String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public void displayInfo() {
        System.out.print(
            "Student | Course: " + course
            + " | Books: " + getBooksBorrowed()
        );
    }
}

public class Week6Question4 {

    public static String batchPrint(LibraryMember[] members) {

        StringBuilder report = new StringBuilder();

        for (LibraryMember member : members) {

            member.displayInfo();

            if (member instanceof StudentMember) {
                StudentMember student = (StudentMember) member;

                report.append(
                    student.getCourse()
                );
            }

            report.append(" | ");
        }

        return report.toString();
    }

    public static void main(String[] args) {

        LibraryMember[] members = {
            new LibraryMember("LB5", 3),
            new StudentMember("STU6", 3, "ECE")
        };

        System.out.println(batchPrint(members));
    }
}