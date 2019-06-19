package org.dhbw.mosbach.ai.cmd.services.validation;

import org.dhbw.mosbach.ai.cmd.db.UserDao;
import org.dhbw.mosbach.ai.cmd.model.User;
import org.dhbw.mosbach.ai.cmd.response.BadRequest;
import org.dhbw.mosbach.ai.cmd.response.Forbidden;
import org.dhbw.mosbach.ai.cmd.security.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class UserValidation {

    private Logger log = LoggerFactory.getLogger(UserValidation.class);

    @Inject
    private UserDao userDao;

    @Inject
    private Hashing hashing;

    public ValidationResult checkUsernameSpecified(String username) {
        if (username == null || username.isEmpty()) {
            return new ValidationResult(new BadRequest("Username was not specified"));
        }

        return ValidationResult.success("Username has been specified");
    }

    private ValidationResult checkUsernameExists(String username) {
        if (userDao.getUserByName(username) == null) {
            return new ValidationResult(new BadRequest("Username '%s' already exists", username));
        }

        return ValidationResult.success("Username does not exist yet");
    }

    public ValidationResult checkCredentialsCorrect(String username, String password) {
        if (checkUsernameExists(username).isInvalid()) {
            return new ValidationResult(new Forbidden("Invalid username or password"));
        }

        User user = userDao.getUserByName(username);
        if (!hashing.checkPassword(password, user.getPassword())) {
            return new ValidationResult(new Forbidden("Invalid username or password"));
        }

        return ValidationResult.success("");
    }
}