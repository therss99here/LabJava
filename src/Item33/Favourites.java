package Item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** Favorites class that allows
 its clients to store and retrieve a favorite instance of arbitrarily many types. The
 Class object for the type will play the part of the parameterized key. The reason
 this works is that class Class is generic. The type of a class literal is not simply
 Class, but Class<T>. For example, String.class is of type Class<String>, and
 Integer.class is of type Class<Integer>. When a class literal is passed among
 methods to communicate both compile-time and runtime type information, it is
 called a type token
 **/
public class Favourites {
    private Map<Class<?>,Object> favourites = new HashMap<>();
    public <T> void putFavourites(Class<T> type, T instance){
        favourites.put(Objects.requireNonNull(type),type.cast(instance));  // ensuring for invariance in instances at runtime type safety
    }
    public <T> T getFavourites(Class<T> type){
        return type.cast(favourites.get(type));  // The cast method is the dynamic analogue of Java’s cast operator. It simply checks that its argument is an instance of the type represented by the Class object.
    }

    // Driver Cde Typesafe heterogeneous container pattern -
    public static void main(String[] args) {
        Favourites f = new Favourites();
        f.putFavourites(String.class, "Java uses");
        f.putFavourites(Integer.class, 0xcafebabe);
        f.putFavourites(Class.class, Favourites.class);

        String favoriteString = f.getFavourites(String.class);
        int favoriteInteger = f.getFavourites(Integer.class);
        Class<?> favoriteClass = f.getFavourites(Class.class);
        System.out.printf("%s %x %s%n", favoriteString,
                favoriteInteger, favoriteClass.getName());
    }
}
