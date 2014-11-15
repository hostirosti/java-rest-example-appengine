package hostirosti;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class ApiInfo {
    private String api_prefix = Constants.API_PREFIX;
    private String api_version = Constants.API_VERSION;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ApiInfo))
            return false;
        if (obj == this)
            return true;

        ApiInfo apiInfo = (ApiInfo) obj;
        return new EqualsBuilder().
                append(api_prefix, apiInfo.api_prefix).
                append(api_version, apiInfo.api_version).
                isEquals();
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder(29, 83).
                append(api_prefix).
                append(api_version).
                toHashCode();
    }
}
