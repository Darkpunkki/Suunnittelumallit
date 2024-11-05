package Proxy;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, Document> documents = new HashMap<>();

    public void addDocument(String identifier, String content, boolean isProtected, AccessControlService accessControlService, User user) {
        if (isProtected) {
            ProtectedDocument protectedDocument = new ProtectedDocument(identifier, content);
            DocumentProxy proxy = new DocumentProxy(protectedDocument);
            documents.put(identifier, proxy);
            accessControlService.grantAccess(identifier, user.getUsername());
        } else {
            documents.put(identifier, new ProtectedDocument(identifier, content));
        }
    }

    public Document getDocument(String identifier) {
        return documents.get(identifier);
    }
}
