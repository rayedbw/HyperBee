package net.therap.hyperbee.utils.constant;

/**
 * @author duity
 * @author rumman
 * @author rayed
 * @since 11/23/16.
 */

public interface Url {

    // User Constants
    String LOGIN_URL = "/login";
    String USER_DASHBOARD_URL = "/user/dashboard";

    // Activity Constant
    String ACTIVITY_ROOT_URL = "/activity";

    //Profile Constant
    String PROFILE_URL = "/profile";
    String PROFILE_EDIT_URL = "/edit";
    String CREATE_PROFILE_URL = "profile/createprofile";
    String USER_PROFILE_URL = "/user";
    String VIEW_PROFILE_URL = "profile/viewprofile";

    //Image Constants
    String PROFILE_IMAGE_URL = "/image/{imagePath}";
    String COVER_IMAGE_URL = "/cover/{coverImage}";

    //Stalk Therap Constant
    String SEARCH_URL = "/search";
    String PROFILE_SEARCH_URL = "profile/searchprofile";
    String STALK_PROFILE_URL = "/stalk/{username}";
    String PROFILE_STALK_URL = "profile/stalkprofile";

    String SUCCESS_VIEW = "success";

    //Resource Constants
    String RESOURCE_STYLE = "/css/";
    String RESOURCE_SCRIPT = "/js/";
    String RESOURCE_FONT = "/fonts/";
    String RESOURCE_IMAGES = "/images/";

    //Common Constants
    String DONE_URL = "/done";
    String DONE_VIEW = "done";

    //Buzz Constants
    String BUZZ_BASE_URL = "/buzz";
}
