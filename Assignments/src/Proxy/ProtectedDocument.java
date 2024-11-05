package Proxy;

import java.util.Date;

public class ProtectedDocument implements Document {
    private final String identifier;
    private final Date creationDate;
    private final String content;

    public ProtectedDocument(String identifier, String content) {
        this.identifier = identifier;
        this.creationDate = new Date();
        this.content = content;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return content;
    }
}
