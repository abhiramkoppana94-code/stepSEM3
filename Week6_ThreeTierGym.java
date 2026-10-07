class GymMember {
    private String memberId;
    private int monthlyFee;
    private int sessionsAttended;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4)
            throw new IllegalArgumentException();

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public void displayInfo() {
        System.out.println("Standard Member | Sessions: " + sessionsAttended);
    }
}

class PremiumMember extends GymMember {
    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public void displayInfo() {
        System.out.println("Premium Member | Trainer: " + trainerName +
                " | Sessions: " + getSessionsAttended());
    }
}

class EliteMember extends PremiumMember {
    private String lockerNumber;

    public EliteMember(String memberId, int monthlyFee, String trainerName,
                       String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    public void displayInfo() {
        System.out.println("Elite Member | Trainer: " + lockerNumber +
                " | Locker: " + lockerNumber +
                " | Sessions: " + getSessionsAttended());
    }
}

class GroupClassMember extends GymMember {
    private String className;

    public GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    public void displayInfo() {
        System.out.println("Group Class Member | Class: " + className +
                " | Sessions: " + getSessionsAttended());
    }
}

public class Week6_ThreeTierGym {

    static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember)
            return "Multilevel descendant (3 generations deep)";
        if (member instanceof GroupClassMember)
            return "Hierarchical sibling (independent branch)";
        return "Standard/Premium Member";
    }

    static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;

        for (GymMember m : members)
            total += m.getSessionsAttended();

        return total;
    }

    public static void main(String[] args) {
        PremiumMember p = new PremiumMember("MEM2", 2000, "Coach Riya");
        EliteMember e = new EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        GroupClassMember g = new GroupClassMember("MEM4", 1500, "Zumba");

        p.attendSession();
        p.attendSession();
        p.attendSession();

        e.attendSession();
        e.attendSession();

        g.attendSession();
        g.attendSession();
        g.attendSession();
        g.attendSession();

        p.displayInfo();
        e.displayInfo();
        g.displayInfo();

        System.out.println(classifyGeneration(e));
        System.out.println(classifyGeneration(g));

        GymMember[] members = {p, e, g};
        System.out.println(getTotalSessionsAttended(members));
    }
}