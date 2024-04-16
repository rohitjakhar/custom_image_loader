## Setup
1. Install Android Studio Latest Version.
2. Clone Project in Android Studio.
3. Paste your unsplash api key in local.properties file i.e. ACCESS_KEY="your key here"
4. Hit Run Button.


## Architecture:
This Project Follow MVVM Archtitecture pattern.
Activity -> ViewModel -> Repo Interface -> Repo Impl -> DataSource.

## Custom Image Loader
Custom Image Loader Class is _AsyncImageLoader_ with Extension Function _loadImage_ with params.
Docs here: 
/**
 * Loads an image from the given [imageUrl] asynchronously into the ImageView.
 * @param imageUrl The URL of the image to load.
 * @param error Drawable to be displayed in case of an error loading the image. Defaults to null.
 * @param placeHolder Drawable to be displayed while the image is being loaded. Defaults to null.
 */

