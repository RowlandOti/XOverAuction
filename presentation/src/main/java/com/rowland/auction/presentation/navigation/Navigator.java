package com.rowland.auction.presentation.navigation;

import android.content.Context;
import android.content.Intent;

import com.rowland.auction.presentation.userfeature.view.activity.UserDetailsActivity;
import com.rowland.auction.presentation.userfeature.view.activity.UserListActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class used to navigate through the application.
 */
@Singleton
public class Navigator {

    @Inject
    public Navigator() {
        //empty
    }

    /**
     * Goes to the user list screen.
     *
     * @param context A Context needed to open the destiny activity.
     */
    public void navigateToUserList(Context context) {
        if (context != null) {
            Intent intentToLaunch = UserListActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }

    /**
     * Goes to the user details screen.
     *
     * @param context A Context needed to open the destiny activity.
     * @param userId  A User id.
     */
    public void navigateToUserDetails(Context context, int userId) {
        if (context != null) {
            Intent intentToLaunch = UserDetailsActivity.getCallingIntent(context, userId);
            context.startActivity(intentToLaunch);
        }
    }

    /**
     * Goes to the bid details screen.
     *
     * @param context A Context needed to open the destiny activity.
     * @param bidId   A User id.
     */
    public void navigateToBidDetails(Context context, int bidId) {

    }
}
