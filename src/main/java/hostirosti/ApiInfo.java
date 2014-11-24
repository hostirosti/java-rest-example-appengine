package hostirosti;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * API Information object.
 * @author hostirosti
 */
public final class ApiInfo {
    /**
     * String mapping API_PREFIX from Constants.
     */
    private final String apiPrefix = Constants.API_PREFIX;

    /**
     * String mapping API_VERSION from Constants.
     */
    private final String apiVersion = Constants.API_VERSION;

    /**
     *
     * @param obj the reference object with which to compare
     * @return true if object is the same
     */
    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof ApiInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        ApiInfo apiInfo = (ApiInfo) obj;
        return new EqualsBuilder().
                append(apiPrefix, apiInfo.apiPrefix).
                append(apiVersion, apiInfo.apiVersion).
                isEquals();
    }

    /**
     *
     * @return hash code value for this object
     */
    @Override
    public int hashCode() {

        return new HashCodeBuilder(29, 83).
                append(apiPrefix).
                append(apiVersion).
                toHashCode();
    }
}
