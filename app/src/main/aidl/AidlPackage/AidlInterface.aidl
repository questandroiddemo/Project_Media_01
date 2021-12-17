// AidlInterface.aidl
package AidlPackage;

// Declare any non-default types here with import statements

interface AidlInterface {
    int playNextSong();
    int playPreviousSong();
    void playPauseSong();
    //ArrayList<MusicFiles> getAllAudio();
    List<String> getAllAudio();
    String getAlbum(int position);
    String getArtist(int position);
    void playSong(int position);


}