# CoolBool Java Component

This is a really stupid way to store an nondynamic array of booleans. It uses
slightly less memory than an actual array of booleans because the java vm really
stores booleans however it wants to. It's not very specific.

By design, after creating the array, every member is set to false.