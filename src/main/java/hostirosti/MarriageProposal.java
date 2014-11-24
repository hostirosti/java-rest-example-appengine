package hostirosti;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Marriage Proposal Statements for Demo
 */
public class MarriageProposal {

    /**
     * The ultimate question
     */
    private final String question = "Will you marry me?";

    /**
     * The ultimate answers from GitHub, JenkinsCI, GCP
     */
    private Map<String, String> answers = new HashMap<String, String>();


    /**
     * Initialize Marriage Proposal object and set hard-coded answers for
     * Demo.
     */
    public MarriageProposal() {
        answers.put("JenkinsCI", "I do!");
        answers.put("GitHub","Hmm,... ok I do!");
        answers.put("Google", "Is MAYBE an option?");
    }

    /**
     *
     * @param obj the reference object with which to compare
     * @return true if object is the same
     */
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof MarriageProposal)) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        MarriageProposal marriageProposal = (MarriageProposal) obj;
        return new EqualsBuilder().
                append(question, marriageProposal.question).
                append(answers, marriageProposal.answers).
                isEquals();
    }

    /**
     *
     * @return hash code value for this object
     */
    @Override
    public int hashCode() {

        return new HashCodeBuilder(33, 79).
                append(question).
                append(answers).
                toHashCode();
    }
}
