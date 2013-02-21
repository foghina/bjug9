# BJUG9

This app is a demo for the "Work with the OS, not against it" section of the ["Building Good Android Apps" talk][0] at [BJUG#9][1].

The purpose of this app is to demonstrate in a simple way how you can use features that the Android OS provides you with in order to create a better user experience. It does this by showing a simple `ListView`, allowing you to switch between four `ListAdapter`s, each one having 10,000 items:

1. `BadAdapter` is what would be your first attempt at writing a list adpater. It's bad because it creates a `View` object (by inflating a layout file) for every list item, not taking advantage of the provided `convertView`.
2. `GoodAdapter` uses the `convertView` object, thus greatly reducing the number of objects created by the adapter. This sensibly improves the performance of the app.
3. `AwesomeAdapter` implements a trick using the `setTag()` and `getTag()` methods present on the `View` object so that it can greatly reduce the number of calls to `findViewById()`, which is pretty expensive.
4. `TwoToneAdapter` shows that you don't need to throw these optimizations away when you're doing something more complicated, like having multiple view types in your adapter. All you need to do is implement a couple extra methods so that Android knows what your intentions are.

##  Building

If you're feeling adventurous, playing with the code is pretty straightforward. Install the [Android SDK][2] (if you haven't done so already) and it should be a simple matter of `File > Import > General > Existing Projects into Workspace`.

[0]: http://www.rvl.io/foghina/bjug9-building-good-android-apps/fullscreen
[1]: http://www.bjug.ro/editii/9.html
[2]: http://developer.android.com/sdk/index.html
