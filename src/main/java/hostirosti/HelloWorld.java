package hostirosti;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class HelloWorld {
    private String helloWorld = "Hello World! :)";

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof HelloWorld))
            return false;
        if (obj == this)
            return true;

        HelloWorld helloWorldObj = (HelloWorld) obj;
        return new EqualsBuilder().
                append(helloWorld, helloWorldObj.helloWorld).
                isEquals();
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder(27, 87).
                append(helloWorld).
                toHashCode();
    }
}
