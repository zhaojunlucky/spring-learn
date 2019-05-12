package com.magicworldz.springlearn.utils;

public class ObjectUtil {
    private ObjectUtil() {

    }

    @SuppressWarnings("unchecked")
    public static <T> boolean objEquals(T self, Object obj, ObjComparator<T> comparator) {
        if (self == obj) {
            return true;
        }

        if (obj == null || !obj.getClass().isAssignableFrom(self.getClass())
            || !self.getClass().isAssignableFrom(obj.getClass())) {
            return false;
        }
        return comparator.compare((T)obj);
    }

    @FunctionalInterface
    public interface ObjComparator<T> {
        boolean compare(T o);
    }
}
