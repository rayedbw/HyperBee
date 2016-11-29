package net.therap.hyperbee.service;

import net.therap.hyperbee.domain.Profile;

/**
 * @author duity
 * @since 11/22/16.
 */
public interface ProfileService {

    public Profile findProfileById(int id);

    public String saveProfileForUser(Profile profile, int userId);
}
