package Proxy;

import java.util.Date;

public class DocumentProxy implements Document {
    private final ProtectedDocument protectedDocument;
    private final AccessControlService accessControlService;

    public DocumentProxy(ProtectedDocument protectedDocument) {
        this.protectedDocument = protectedDocument;
        this.accessControlService = AccessControlService.getInstance();
    }

    @Override
    public String getIdentifier() {
        return protectedDocument.getIdentifier();
    }

    @Override
    public Date getCreationDate() {
        return protectedDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        System.out.println("DocumentProxy: Checking access for user '" + user.getUsername() + "' to document '" + protectedDocument.getIdentifier() + "'");

        if (accessControlService.isAllowed(protectedDocument.getIdentifier(), user.getUsername())) {
            System.out.println("DocumentProxy: Access granted to '" + user.getUsername() + "'. Fetching content from ProtectedDocument.");
            return protectedDocument.getContent(user);
        } else {
            System.out.println("DocumentProxy: Access denied for user '" + user.getUsername() + "'");
            throw new AccessDeniedException("Access denied for user: " + user.getUsername());
        }
    }
}

