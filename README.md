# Android Passcode Keypad View

A custom view with keyboard and character display to be used for authentication. 

The view has a bunch customisation options to make to look and work the way whichever needed.

## Demo
<img src="https://arjun-sna.github.io/raw/passcodeview_1.gif" width="250" />
<img src="https://arjun-sna.github.io/raw/passcodeview_2.gif" width="250" />

## Installation
--to be updated

## Usage
 Add the view in the layout file

 ```xml
 <in.arjsna.lib.PassCodeView
    android:id="@+id/pass_code_view"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:digits="4"
    app:digit_size="30.0dp"
    app:key_text_size="30.0sp"
    android:padding="25.0dp"
    app:empty_drawable="@drawable/empty_dot"
    app:filled_drawable="@drawable/filled_dot"/>

 ```

View attributes that can be included in xml are


`digits` - number of digits in passcode

`filled_drawable` - drawable to be show for filled digits

`empty_drawable` - drawable to be show for empty digits

`key_text_size` - size of text in keyboard's key

`digit_spacing` - horizontal space between each digit

`digit_vertical_padding` - vertical padding of digits

`divider_visible` - boolean to show or hide divider between digits and keyboard


Other customisations options available are

```java
PassCodeView passCodeView = (PassCodeView) findViewById(R.id.pass_code_view);
Typeface typeFace = Typeface.createFromAsset(getAssets(), "fonts/Font-Bold.ttf");

/**
 *Set TypeFace for the font in keys of keypad
 */
passCodeView.setTypeFace(typeFace);

/**
 * Set color for the keypad text
 * @param color - Resource id of the color to be set
 */
passCodeView.setKeyTextColor(getResources.getColor(R.color.black));

/**
 * Set size of keypad text
 * @param size - Text size value to be set
 */
passCodeView.setKeyTextSize(30);

/**
 * Reset the code to empty
 */
passCodeView.reset();

/**
 * Attach {@code TextChangeListener} to get notified on text changes
 * @param listener - {@Code TextChangeListener} object to be attached and notified
 */
passCodeView.setOnTextChangeListener(new PassCodeView.TextChangeListener() {
            @Override
            public void onTextChanged(String text) {
                Log.i("Passcode", "text");
            }
        }); 
```

License
=======

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License.
You may obtain a copy of the License in the LICENSE file, or at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

