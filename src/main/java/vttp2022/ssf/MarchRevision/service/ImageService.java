package vttp2022.ssf.MarchRevision.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import vttp2022.ssf.MarchRevision.model.Image;

@Service
public class ImageService {
    
    private Map<Integer,Image> imgs = new HashMap<>();
    
    public ImageService(){
        for(int i=0;i<=30;i++){
            Image img = new Image();
            img.setImageFileName("number"+i+".jpg");
            img.setNumber(i);
            newImg(img);
        }
    }

    public void newImg(final Image img) {
        imgs.put(img.getNumber(),img);
    }

    public Image getImageByNumber(Integer number){
        return imgs.get(number);
    }
}
