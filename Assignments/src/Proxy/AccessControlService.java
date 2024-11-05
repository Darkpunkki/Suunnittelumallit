package Proxy;

import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private final Set<String> permissions;

    private AccessControlService() {
        permissions = new HashSet<>();
    }

    public static synchronized AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void grantAccess(String documentId, String username) {
        System.out.println("AccessControlService: Granting access to user '" + username + "' for document '" + documentId + "'");
        permissions.add(username + ":" + documentId);
    }

    public boolean isAllowed(String documentId, String username) {
        System.out.println("AccessControlService: Checking if user '" + username + "' has access to document '" + documentId + "'");
        return permissions.contains(username + ":" + documentId);
    }
}
