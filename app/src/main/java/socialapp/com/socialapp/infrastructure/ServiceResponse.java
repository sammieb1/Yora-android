package socialapp.com.socialapp.infrastructure;


import android.app.Activity;
import android.content.Context;
import android.util.Log;
import java.util.HashMap;

import socialapp.com.socialapp.Utilities.HelperClass;

public class ServiceResponse {

    private static final String TAG = "ServiceResponse";
    HelperClass hc;

    private String operationError;
    private HashMap<String, String> propertyError;
    private boolean isCritical;


    public ServiceResponse() {
        propertyError = new HashMap<>();
    }

    public ServiceResponse(String operationError) {
        this.operationError = operationError;
    }

    public ServiceResponse(String operationError, boolean isCritical) {
        this.operationError = operationError;
        this.isCritical = isCritical;
    }

    public String getOperationError() {
        return operationError;
    }

    public void setOperationError(String operationError) {
        this.operationError = operationError;
    }

    public boolean isCritical() {
        return isCritical;
    }

    public void setCritical(boolean critical) {
        isCritical = critical;
    }


    public void setPropertyError(String property, String error) {
        propertyError.put(property, error);
    }

    public String getPropertyError(String property) {
        return propertyError.get(property);
    }


    public boolean didSucceed() {
        return (operationError == null || operationError.isEmpty()) && (propertyError.size() == 0);
    }

    public void showErrorToast(Context context) {

        if (context == null || operationError == null || operationError.isEmpty())
            return;

        try {
            hc = new HelperClass((Activity) context);
            hc.tmsg(operationError);
        } catch (Exception e) {
            Log.e(TAG, "Can't Create error Toast", e);
        }
    }


}
