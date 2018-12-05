package models.validator;

import java.util.ArrayList;
import java.util.List;

import models.Category;
public class CategoryValidator {
    public static List<String> validate(Category c){
        List<String> errors = new ArrayList<String>();

        String name_error = _validateName(c.getName());
        if(!name_error.equals("")){
            errors.add(name_error);
        }
        String content_error = _validateContent(c.getContent());
        if(content_error.equals("")){
            errors.add(content_error);
        }
        return errors;
    }

    public static String _validateName(String name){
        if(name == null || name.equals("")){
            return "名称を入力してください。";
        }
        return "";
    }

    public static String _validateContent(String content){
        if(content == null || content.equals("")){
            return "内容を入力してください。";
        }
        return "";
    }
}
