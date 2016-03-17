package socialapp.com.socialapp.AppViews;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import socialapp.com.socialapp.Activities.BaseActivity;
import socialapp.com.socialapp.Activities.ContactsActivity;
import socialapp.com.socialapp.Activities.MainActivity;
import socialapp.com.socialapp.Activities.ProfileActivity;
import socialapp.com.socialapp.Activities.SendMessagesActivity;
import socialapp.com.socialapp.R;
import socialapp.com.socialapp.Utilities.HelperClass;
import socialapp.com.socialapp.infrastructure.User;


public class MainNavDrawer extends NavDrawer {

    private final TextView displayNameText;
    private final ImageView avatarImage;
    HelperClass hc;


    public MainNavDrawer(BaseActivity activity) {
        super(activity);
        hc = new HelperClass(activity);

        addItem(new ActivityNavDrawerItem(MainActivity.class, "Inbox", null, R.drawable.ic_action_unread, R.id.include_main_nav_drawer_topItems));
        addItem(new ActivityNavDrawerItem(SendMessagesActivity.class, "Sent Messages", null, R.drawable.ic_action_send_now, R.id.include_main_nav_drawer_topItems));
        addItem(new ActivityNavDrawerItem(ContactsActivity.class, "Contacts", null, R.drawable.ic_action_group, R.id.include_main_nav_drawer_topItems));
        addItem(new ActivityNavDrawerItem(ProfileActivity.class, "Profile", null, R.drawable.ic_action_group, R.id.include_main_nav_drawer_topItems));

        addItem(new BasicNavDrawerItem("Logout", null, R.drawable.ic_action_backspace, R.id.include_main_nav_drawer_bottomItems) {
            @Override
            public void onClick(View v) {
                super.onClick(v);
                hc.tmsg("You are logged out");

            }
        });


        displayNameText = (TextView) navDrawerView.findViewById(R.id.include_main_nav_drawer_displayName);
        avatarImage = (ImageView) navDrawerView.findViewById(R.id.include_main_nav_drawer_avatar);

        User loggedInUser = activity.getSocialAppApplication().getAuth().getUser();
        displayNameText.setText(loggedInUser.getDisplayName());

        //Todo : change avatar image to avatar uri from loggedInUser

    }


}
