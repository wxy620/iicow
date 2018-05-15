package iicow.cc.example.util;

import java.util.Objects;
import java.util.function.Function;

/**
 * 
 * UncheckedFunction<T, R>:function<T,R>的抛出异常版本,使它匹配抛出异常的函数
 * Try对UncheckedFunction处理的工具类
 * @author niko
 * @version $Id: Try.java, v 0.1 2018年5月15日 下午1:41:44 niko Exp $
 */
public class Try {
    
    public static <T, R> Function<T, R> of(UncheckedFunction<T, R> mapper) {
        Objects.requireNonNull(mapper);
        return t -> {
            try {
                return mapper.apply(t);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    public static <T, R> Function<T, R> of(UncheckedFunction<T, R> mapper, R defaultR) {
        Objects.requireNonNull(mapper);
        return t -> {
            try {
                return mapper.apply(t);
            } catch (Exception ex) {
                //TODO logger
                return defaultR;
            }
        };
    }

    @FunctionalInterface
    public static interface UncheckedFunction<T, R> {

        R apply(T t) throws Exception;
    }
}