package com.example.project_media_01.ContractInterface;

public interface Contract {
    interface View{
        //updateEditText(String title,String album,String artist , String path);


    }


    interface Presenter{
        void getAllAudio();
        //    @Override
        //    public ArrayList<MusicFiles> getSongsFromService() {
        //        model.getSongsFromService();
        //
        //        return null;
        //    }
        //
        //    @Override
        //    public void PreviousButtonClick() {
        //        model.playPreviousSong();
        //    }
        //
        void PlayPauseButtonClick();
//        ArrayList<MusicFiles> getSongsFromService();
//        void PreviousButtonClick();
//        void PlayPauseButtonClick();
//        void NextButtonClick();
        //updateSeekBar();

    }


    interface Model{
        void playPause();
//        void getSongsFromService();
//        void playPreviousSong();
//        void playNextSong();
//        void playPause();


    }
}
