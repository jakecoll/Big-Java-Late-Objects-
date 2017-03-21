package _03objects.P8_10;

/**
 * Created by jakecoll on 10/16/16.
 */
public class VotingMachine {

    private int nTotalVotesForDem;
    private int nTotalVotesForEvil;

    /**
     * Constructs a voting machine object with initial votes totals at 0.
     */
    public VotingMachine() {

        nTotalVotesForDem = 0;
        nTotalVotesForEvil = 0;

    }

    /**
     * method resets vote totals to 0.
     */
    public void resetVotingMachine()
    {
        nTotalVotesForDem = 0;
        nTotalVotesForEvil = 0;
    }

    /**
     * method adds one vote to Democrat total when called on object.
     */
    public void voteDem()
    {
        nTotalVotesForDem = nTotalVotesForDem + 1;
    }

    /**
     * methods add ones vote for Republics a/k/a the party of evil when called.
     */
    public void voteEvil()
    {
        nTotalVotesForEvil = nTotalVotesForEvil + 1;
    }

    /**
     * accessor method returns vote total as a string.
     * @return
     */
    public String getResults()
    {
        String strResults = "Total votes for Democrats: " + nTotalVotesForDem + "\n"
                            + "Total votes for Evil: " + nTotalVotesForEvil + "\n";
        if (nTotalVotesForDem > nTotalVotesForEvil)
        {
            strResults += "Democrats Win!";
        }
        else if (nTotalVotesForEvil > nTotalVotesForDem)
        {
            strResults += "Evil Prevails!";
        }

        else if (nTotalVotesForDem == nTotalVotesForEvil)
        {
            strResults += "It's a tie! Thanks a lot Florida!";
        }

        return strResults;
    }

    /**
     * main method for testing it out.
     * @param args
     */
    public static void main(String[] args) {
        VotingMachine votingMachine = new VotingMachine();
        votingMachine.voteDem();
        votingMachine.voteEvil();
        votingMachine.resetVotingMachine();
        votingMachine.voteEvil();
        votingMachine.voteDem();
        votingMachine.voteDem();

        System.out.println(votingMachine.getResults());
    }
}
