package hostirosti;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author hostirosti
 */
public final class HelloWorld {
    /**
     * String containing "Hello World! :)".
     */
    private String helloWorld = "Hello Googlers! :)";

    /**
     *
     * @param obj the reference object with which to compare
     * @return true if object is the same
     */
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof HelloWorld)) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        HelloWorld helloWorldObj = (HelloWorld) obj;
        return new EqualsBuilder().
                append(helloWorld, helloWorldObj.helloWorld).
                isEquals();
    }

    /**
     *
     * @return hash code value for this object
     */
    @Override
    public int hashCode() {

        return new HashCodeBuilder(27, 87).
                append(helloWorld).
                toHashCode();
    }
}
