public class PartyCreation {

    private int partyTank;
    private int partyHealer;
    private int partyDps;

    public PartyCreation(int partyTank, int partyHealer, int partyDps) {
        this.partyTank = partyTank;
        this.partyHealer = partyHealer;
        this.partyDps = partyDps;
    }

    // Completed Party : Getter
    public boolean partyCompleted() {

        boolean partyCompleted = true;
        if (partyDps < 3 || partyHealer < 1 || partyTank < 1) {
            partyCompleted = false;
        }

        return partyCompleted;
    }

    // Getters
    public int getPartyTank() {
        return partyTank;
    }

    public int getPartyHealer() {
        return partyHealer;
    }

    public int getPartyDps() {
        return partyDps;
    }

    // Setters

    public void updatePartyTank() {
        this.partyTank = partyTank - 1;
    }

    public void updatePartyHealer() {
        this.partyHealer = partyHealer - 1;
    }

    public void updatePartyDps() {
        this.partyDps = partyDps - 3;
    }
}
