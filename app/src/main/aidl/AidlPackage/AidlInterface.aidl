// AidlInterface.aidl
package AidlPackage;

// Declare any non-default types here with import statements

interface AidlInterface {
    int playNextSong();
    int playPreviousSong();
    void playPauseSong();
    //ArrayList<MusicFiles> getAllAudio();
    void getAllAudio();

}