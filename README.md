# android-BlankSpace
This is an android popup library "BlankSpace" by [Battle Entertainment](https://www.battleent.com/) <br>

![gif](https://user-images.githubusercontent.com/24237865/32733834-b21b19ac-c8d3-11e7-8a27-3e0ff3dff48a.gif)

## Download
#### Gradle
```java
dependencies {
    compile 'com.github.battleent:BlankSpace:1.0.1'
}
```

## What is BlankSpace?
We always write too many XML codes just showing "no-result" or "try to reconnect" screens.<br>
Then we can't avoid two section screen(main is visible, no-result is gone) in xml.<br>
That makes we sometimes little confused.

![screenshot577818857](https://user-images.githubusercontent.com/24237865/32729759-2eba403e-c8c8-11e7-9cec-e2635d336131.png)
![screenshot1589102281](https://user-images.githubusercontent.com/24237865/32729761-2f1141d6-c8c8-11e7-8365-358ac7c2cf0c.png)

In below case we will get confused because it's not intuitive.</br></br>
![screenshot43552780](https://user-images.githubusercontent.com/24237865/32730298-f69067d6-c8c9-11e7-84fb-e6e3acc4a7c7.png)

## Usage
You can use just like a popup.

```java
blankSpace = new BlankSpace(getBaseContext(), R.layout.layout_not_found);
blankSpace.setLifecycleOwner(this);
blankSpace.setAnimation(BlankSpaceAnimation.FADE_IN);

@Override
public void onClick(View view) {
    View layout = findViewById(R.id.mainlayout);
    blankSpace.show(layout, 0, 20); // layout, xOff, yOff
}
```

## Avoid Memory leak issue
Dialog, PopupWindow and etc.. have memory leak issue if not dismissed before activity or fragment are destroyed.<br>
But Lifecycles are now also integrated with the Support Library since Architecture Components 1.0 Stable released.<br>
So you can solve memory leak issue so easily.
```java
public class MainActivity extends AppCompatActivity implements LifecycleOwner {
--- skip ---
blankSpace.setLifecycleOwner(this);
```
when MainActivity destroyed, BlankSpace destroyed too.


# License
```xml
MIT License

Copyright (c) 2017 Battle Entertainment

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
