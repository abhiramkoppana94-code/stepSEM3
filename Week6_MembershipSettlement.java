class GymMember {
    private static int counter = 2000;
    private static int membersEnrolled = 0;

    private final String membershipNumber;
    private int monthlyFee;
    private int feesPaid;

    public GymMember(int monthlyFee) {
        counter++;
        membershipNumber = "GYM-" + counter;
        membersEnrolled++;
        this.monthlyFee = monthlyFee;
    }

    public void payFee(int amount) {
        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        System.out.println("Payment Mode: " + mode);
        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4)
            return false;

        return code.charAt(0) == 'G'
            && Character.isDigit(code.charAt(1))
            && Character.isDigit(code.charAt(2))
            && Character.isUpperCase(code.charAt(3));
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }

    public static String processWeeklyCheckIn(GymMember[] members) {
        int processed = 0, skipped = 0;
        int group = 0, individual = 0;

        for (GymMember m : members) {
            if (m == null) {
                skipped++;
                continue;
            }

            processed++;

            if (m instanceof GroupClassMember)
                group++;
            else
                individual++;
        }

        return processed + " processed | " + skipped + " null skipped | "
                + group + " group | " + individual + " individual";
    }
}

class GroupClassMember extends GymMember {
    private String className;

    public GroupClassMember(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }
}

public class Week6_MembershipSettlement {
    public static void main(String[] args) {

        GymMember m1 = new GymMember(1000);

        System.out.println("Membership: GYM-2001");
        System.out.println(GymMember.getMembersEnrolled());

        System.out.println(GymMember.isValidReferralCode("G45B"));
        System.out.println(GymMember.isValidReferralCode("G4B"));
        System.out.println(GymMember.isValidReferralCode("X45B"));

        m1.payFee(500);
        m1.payFee(500, "UPI");
        System.out.println(m1.getFeesPaid());

        GymMember[] members = {
            new GroupClassMember(1500, "Zumba"),
            null,
            new GymMember(1000)
        };

        System.out.println(GymMember.processWeeklyCheckIn(members));
    }
}