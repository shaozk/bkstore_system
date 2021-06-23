package utils;

/**
 * @author shaozk
 */
public interface Constants {

    String BOOK_COVER = "default.png";


    interface User {
        String ROLE_ADMIN = "role_admin";
        String ROLE_NORMAL = "role_normal";
        String DEFAULT_AVATAR = "https://cdn.sunofbeaches.com/images/default_avatar.png";
        String DEFAULT_STATE = "1";
        String COOKIE_KEY_TOKEN = "k_blog_token";
    }

    interface Setting {
        String HAS_MANAGER_ACCOUNT_STATE = "has_manager_account_state";
        String WEB_SIZE_TITLE = "web_size_title";
        String WEB_SIZE_DESCRIPTION = "web_size_description";
        String WEB_SIZE_KEYWORDS = "web_size_keywords";
        String WEB_SIZE_VIEW_COUNT = "web_size_view_count";
    }

}
