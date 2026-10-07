class GymMember {
    private String memberId;
    private int monthlyFee;
    private int[] lateFeeHistory = new int[10];
    private int feeCount = 0;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4)
            throw new IllegalArgumentException();

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    protected void chargeLateFee(int amount) {
        lateFeeHistory[feeCount++] = amount;
    }

    public int[] getLateFeeHistory() {
        int[] copy = new int[feeCount];

        for (int i = 0; i < feeCount; i++)
            copy[i] = lateFeeHistory[i];

        return copy;
    }

    public int getTotalLateFees() {
        int total = 0;

        for (int i = 0; i < feeCount; i++)
            total += lateFeeHistory[i];

        return total;
    }
}

class PremiumMember extends GymMember {
    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }
}

public class Week6_PremiumLoyalty {
    public static void main(String[] args) {
        PremiumMember p = new PremiumMember("MEM5", 2000, "Coach Riya");

        p.chargeLateFee(200);

        System.out.println(p.getTotalLateFees());

        int[] history = p.getLateFeeHistory();
        history[0] = 999;

        System.out.println(p.getLateFeeHistory()[0]);
    }
}