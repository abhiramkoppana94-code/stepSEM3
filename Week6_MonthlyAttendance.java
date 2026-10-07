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
        System.out.print("Standard | Sessions: " + sessionsAttended);
    }
}

class PremiumMember extends GymMember {
    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    public void displayInfo() {
        System.out.print("Premium | Trainer: " + trainerName +
                " | Sessions: " + getSessionsAttended());
    }
}

public class Week6_MonthlyAttendance {

    static String batchPrint(GymMember[] members) {
        StringBuilder result = new StringBuilder();

        for (GymMember member : members) {
            member.displayInfo();

            if (member instanceof PremiumMember) {
                PremiumMember p = (PremiumMember) member;
                result.append("Premium | Trainer: ")
                      .append(p.getTrainerName())
                      .append(" | Sessions: ")
                      .append(p.getSessionsAttended())
                      .append(" [Trainer via downcast: ")
                      .append(p.getTrainerName())
                      .append("] | ");
            } else {
                result.append("Standard | Sessions: ")
                      .append(member.getSessionsAttended())
                      .append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        GymMember[] members = {
            new GymMember("MEM6", 1000),
            new PremiumMember("MEM7", 2000, "Coach Riya")
        };

        System.out.println(batchPrint(members));
    }
}