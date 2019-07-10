package at.tomtasche.reader.background;

import android.net.Uri;

public interface FileLoader {

    enum LoaderType {
        ODF,
        PDF,
        FIREBASE,
        SAVE,
        RAW
    }

    public void initialize(FileLoaderListener listener);

    public void loadAsync(Uri uri, String fileType, String password, boolean limit, boolean translatable);

    public void loadSync(Uri uri, String fileType, String password, boolean limit, boolean translatable);

    public boolean isLoading();

    public double getProgress();

    public void close();


    public interface FileLoaderListener {

        public void onSuccess(LoaderType loaderType, Document document, String fileType);

        public void onError(LoaderType loaderType, Throwable throwable, String fileType);
    }
}
