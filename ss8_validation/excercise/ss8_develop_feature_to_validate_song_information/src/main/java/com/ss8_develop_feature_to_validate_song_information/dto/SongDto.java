package com.ss8_develop_feature_to_validate_song_information.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongDto implements Validator {
    private int id;
    private String name;
    private String performing;
    private String songType;

    public SongDto() {
    }

    public SongDto(int id, String name, String performing, String songType) {
        this.id = id;
        this.name = name;
        this.performing = performing;
        this.songType = songType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerforming() {
        return performing;
    }

    public void setPerforming(String performing) {
        this.performing = performing;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;

        if (!songDto.name.matches("^[A-Za-zàáãạảăắ" +
                "ằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợù" +
                "úũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈ" +
                "ỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ ]{3,800}$")){
            errors.rejectValue("name","name.errors","tên bài hát không hợp lệ");
        }

        if (!songDto.performing.matches("^[A-Za-zàáãạảăắ" +
                "ằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợù" +
                "úũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈ" +
                "ỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ ]{3,800}$")){
            errors.rejectValue("performing","performing.errors","Tên nghệ sĩ biểu diễn không hợp lệ");
        }

        if (!songDto.songType.matches("^[A-Za-zàáãạảăắ" +
                "ằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợù" +
                "úũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈ" +
                "ỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ ]{3,800}$")){
            errors.rejectValue("songType","songType.errors","Tên loại bài hát không hợp lệ");
        }

    }
}
