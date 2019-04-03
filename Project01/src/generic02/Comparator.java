package generic02;
/**
 * 接口中泛型字母只能使用在方法中，不能使用在全局常量上
 * @author 979739537
 *
 * @param <T>
 */
public interface Comparator<T> {
	void compare(T t);
}
