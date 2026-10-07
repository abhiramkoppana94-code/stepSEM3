class LibraryMember {

    private static int memberCounter = 100;
    private static int membersEnrolled = 0;

    private final String memberNumber;

    private int borrowLimit;
    private int booksBorrowed;

    public LibraryMember(int borrowLimit) {
        memberCounter++;
        memberNumber = "LIB-" + memberCounter;
        membersEnrolled++;

        this.borrowLimit = borrowLimit;
        booksBorrowed = 0;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public void borrowBook(String genre) {
        System.out.println("Genre: " + genre);
        borrowBook();
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public static boolean isValidRenewalCode(String code) {

        if (code == null || code.length() != 4) {
            return false;
        }

        if (code.charAt(0) != 'R') {
            return false;
        }

        if (!Character.isDigit(code.charAt(1))) {
            return false;
        }

        if (!Character.isDigit(code.charAt(2))) {
            return false;
        }

        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }

        return true;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }
}

class FacultyMember extends LibraryMember {

    private String department;

    public FacultyMember(int borrowLimit, String department) {
        super(borrowLimit);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

public class Week6Question5 {

    public static String processNightlyAudit(LibraryMember[] members) {

        StringBuilder result = new StringBuilder();

        for (LibraryMember member : members) {

            if (member == null) {
                continue;
            }

            if (member instanceof FacultyMember) {
                FacultyMember faculty = (FacultyMember) member;

                result.append("Faculty: ")
                      .append(faculty.getDepartment())
                      .append(" | Books: ")
                      .append(faculty.getBooksBorrowed())
                      .append(" | ");
            } else {
                result.append("Member: ")
                      .append(member.getMemberNumber())
                      .append(" | Books: ")
                      .append(member.getBooksBorrowed())
                      .append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        LibraryMember m1 = new LibraryMember(3);

        System.out.println(m1.getMemberNumber());
        System.out.println(LibraryMember.getMembersEnrolled());

        System.out.println(
            LibraryMember.isValidRenewalCode("R12A")
        );

        System.out.println(
            LibraryMember.isValidRenewalCode("R1A")
        );

        System.out.println(
            LibraryMember.isValidRenewalCode("X12A")
        );

        m1.borrowBook();
        m1.borrowBook("Fiction");

        System.out.println(m1.getBooksBorrowed());

        FacultyMember faculty =
                new FacultyMember(5, "Physics");

        LibraryMember[] members = {
            m1,
            faculty,
            null
        };

        System.out.println(
            LibraryMember.processNightlyAudit(members)
        );
    }
}