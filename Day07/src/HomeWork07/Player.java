package HomeWork07;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;


@Setter
@Getter
public class Player {
    private String name;

    public Player(){
        this.setName("千千静听");
    }
    public Music info(Scanner scanner){
        System.out.println("请输入音乐名:");
        String nameM = scanner.next();
        System.out.println("请输入播放时长:");
        int time = scanner.nextInt();
        System.out.println("请输入歌手名");
        String singer = scanner.next();
        Music music = new Music(nameM,time,singer);
        return music;
    }


    public void play(Music music){
        System.out.println("正在播放------->"+music.getName()+"  时长:"+music.getTime()+"  歌手:"+music.getSinger());


    }



}
