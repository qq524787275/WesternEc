package com.wethis.module_base.permission;

/**
 * Created by hefuyi on 2016/11/6.
 */

public interface PermissionCallback {

    void permissionGranted();

    void permissionRefused();
}
