package com.ss8_develop_feature_to_validate_song_information.controller;

import com.ss8_develop_feature_to_validate_song_information.dto.SongDto;
import com.ss8_develop_feature_to_validate_song_information.model.Song;
import com.ss8_develop_feature_to_validate_song_information.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 5)Pageable pageable,
                                 @RequestParam(defaultValue = "") String name){
        ModelAndView modelAndView = new ModelAndView("views/song/list");
        modelAndView.addObject("songs", songService.findByNameSong(pageable, name));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("views/song/create");
        modelAndView.addObject("songDto", new SongDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveSong(@Validated @ModelAttribute SongDto songDto,
                                 BindingResult bindingResult,
                                 @PageableDefault(value = 5) Pageable pageable,
                                 RedirectAttributes redirectAttributes
    ) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {

            ModelAndView modelAndView = new ModelAndView("views/song/create");
            return modelAndView;
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.save(song);
            ModelAndView modelAndView = new ModelAndView("redirect:/song");
            redirectAttributes.addFlashAttribute("message", "Add new succsessfuly");
            return modelAndView;
        }

    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id) {
        Optional<Song> song = songService.findById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song.get(), songDto);

        if (song.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("views/song/edit");
            modelAndView.addObject("songDto", songDto);
            return modelAndView;
        } else {
            return new ModelAndView("views/song/error.404");
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateSong(@Validated @ModelAttribute SongDto songDto,
                                   BindingResult bindingResult,
                                   @PageableDefault(value = 5) Pageable pageable,
                                   RedirectAttributes redirectAttributes
    ) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("views/song/edit");
            modelAndView.addObject("songs", songService.findAll());
            return modelAndView;
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.save(song);
            ModelAndView modelAndView = new ModelAndView("redirect:/song");
            redirectAttributes.addFlashAttribute("message", "Edit new succsessfully");
            return  modelAndView;
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Optional<Song> song = songService.findById(id);
        if (song.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("views/song/delete");
            modelAndView.addObject("song", song.get());
            return modelAndView;

        } else {
            return new ModelAndView("views/song/error.404");
        }
    }

    @PostMapping("/delete")
    public String deleteBlog(@ModelAttribute("song") Song song) {
        songService.remove(song.getId());
        return "redirect:/song";
    }


}
