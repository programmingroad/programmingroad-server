package com.programmingroad.blog.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: baoqi.liu
 * @create: 2019/12/10 11:14
 * @description:
 * @version: 1.0
 **/
public class BeanValidateUtil {

    /**
     * java query 数据校验
     * 参数符合要求,返回 null,否则返回错误原因
     *
     * @param target 目标 query
     * @param <T>
     * @return
     */
    public static <T> String validate(T target) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(target);
        Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
        while (iterator.hasNext()) {
            ConstraintViolation<T> error = iterator.next();
            StringBuffer buffer = new StringBuffer().append("[")
                    .append(error.getPropertyPath().toString()).append("]")
                    .append(error.getMessage());
            return buffer.toString();
        }
        return null;
    }

}
