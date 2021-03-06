package org.dhbw.mosbach.ai.cmd.services.payload;

/**
 * @author 6694964
 * @version 1.2
 */
public abstract class PayloadParameters {

    private PayloadParameters() {
    }

    public static final String USERNAME = "username";

    public static final String PASSWORD = "password";

    public static final String EMAIL = "email";

    public static final String DOCUMENT_NAME = "documentName";

    public static final String DOCUMENT_ID = "documentId";

    public static final String COLLABORATOR_ID = "collaboratorId";

    public static final String COLLABORATOR_USERNAME = "collaboratorUsername";

    public static final String NEW_OWNER_NAME = "newOwnerName";
}
