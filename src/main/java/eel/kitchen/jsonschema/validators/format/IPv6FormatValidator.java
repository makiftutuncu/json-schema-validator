package eel.kitchen.jsonschema.validators.format;

import org.codehaus.jackson.JsonNode;

import java.net.Inet6Address;
import java.net.UnknownHostException;

public final class IPv6FormatValidator
    extends AbstractFormatValidator
{
    public IPv6FormatValidator(final JsonNode ignored)
    {
        super(ignored);
    }

    @Override
    public boolean validate(final JsonNode node)
    {
        validationErrors.clear();

        try {
            Inet6Address.getByName(node.getTextValue());
            return true;
        } catch (UnknownHostException e) {
            validationErrors.add("string is not a valid IPv6 address");
            return false;
        }
    }
}
