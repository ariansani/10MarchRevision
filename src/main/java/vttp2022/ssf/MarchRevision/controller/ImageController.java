package vttp2022.ssf.MarchRevision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp2022.ssf.MarchRevision.model.Image;
import vttp2022.ssf.MarchRevision.service.ImageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
@RequestMapping(path="/number")
public class ImageController {

    @Autowired
    private ImageService imgSvc;

    //Test this using Postman (url=http://localhost:8080/number/22)
    // "number":22
    @GetMapping("/{number}")
    public String getImageByNumber(@PathVariable(value="number")Integer number,Model model){
        
        Image result = imgSvc.getImageByNumber(number);

        if(result!=null){
            if (result.getNumber()>=0 && result.getNumber()<=30){
            model.addAttribute("imgRequest",result);
            return "validImage";
            }
            
        }
        model.addAttribute("invalidNumber",number);
        return "img_not_found";
    }
    
}
