package models.validator;

import java.util.ArrayList;
import java.util.List;

import models.Hanrei;

public class HanreiValidator {
    public static List<String> validate(Hanrei h){
        List<String> errors = new ArrayList<String>();



        String name_error = _validateName(h.getName());
        if(!name_error.equals("")){
            errors.add(name_error);
        }

        String content_error = _validateContent(h.getContent());
        if(!content_error.equals("")){
            errors.add(content_error);
        }

        String year_error = _validateYear(h.getYear());
        if(!year_error.equals("")){
            errors.add(year_error);
        }

        String url_error = _validateUrl(h.getUrl());
        if(!url_error.equals("")){
            errors.add(url_error);
        }
        return errors;
    }


    private static String _validateName(String name){
        if(name == null || name.equals("")){
            return "名称を入力してください";
        }
        return "";
    }
    private static String _validateContent(String content){
        if(content == null || content.equals("")){
            return "内容を入力してください。";
        }
        return "";
    }
    public static String _validateYear(String year){
        if(year == null || year.equals("")){
            return "年月日を入力してください。";
        }
        return "";
    }
    private static String _validateUrl(String url){
        if(url == null || url.equals("")){
            return "urlを入力してください";
        }
        return "";
    }

}
